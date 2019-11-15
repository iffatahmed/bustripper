package io.telenor.bustripper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.HashSet;
import java.util.Set;

public class Main {


        /**
         * Waits for bustrip results and print the 10 first results sorted by time.
        **/
        private static class BustripWaiter implements TripsCallback {
            private boolean done = false;
            private Set<BusTrip> allTrips = new HashSet<BusTrip>();
            private static int maxtrips = 10;

            @Override
            public synchronized void gotTrips(Set<BusTrip> trips, boolean done) {
                allTrips.addAll(trips);

                if(done || allTrips.size() >= maxtrips) {
                    if (allTrips.isEmpty()) {
                        System.out.println("No trips found!");
                    }
                    trips.stream().sorted(
                            (e1, e2) -> e1.getExpectedArrivalTime().compareTo(e2.getExpectedArrivalTime())
                    ).limit(maxtrips).forEach(t -> System.out.println(t));
                    

                    this.done = true;
                    
                    notify();
                }
            }

            @Override
            public synchronized void failedGettingTrips(IOException io) {
                System.out.println("Failed getting trips. " + io.getMessage());
                this.done = true;
                notify();
            }

            public synchronized boolean waitForCompletion() throws InterruptedException{
                while(!done) {
                    wait();
                }
                return done;
            }
        }

        private static class InputGatherer implements Runnable {
            public void run() {
                System.out.println("Welcome to the bus line lookup tool. Add a search phrase to look up a bus stop.");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                //InputStreamReader isr = new InputStreamReader(System.in,StandardCharsets.UTF_16);
                //BufferedReader in = new BufferedReader(isr);
                //BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(System.in)));

                boolean done = true;

                while(done) {
                    System.out.print("\n> ");
                    
                    try {
//                        String searchterm = in.readLine();
                        String searchterm = new String(in.readLine().getBytes(),"UTF-8");
                    

                       searchterm = searchterm.replaceAll("[^a-zA-ZÅåØøÆœ0-9\\s+]", " ");
                        System.out.println("\n string length " + searchterm.length());

                        if(searchterm.length()==0 || (searchterm.charAt(0)=='q' && searchterm.length()==1)) {
                           System.out.println("\n ending... " + searchterm);
                            done=false;
                            System.exit(0);
                        }
                        System.out.println("Looking up " + searchterm);
                        BustripWaiter waiter = new BustripWaiter();
                        new Thread(new FindBusStop(waiter, searchterm)).start();
                        waiter.waitForCompletion();
                    }
                    catch(IOException io) {
                        done = false;
                    }
                    catch(InterruptedException uh) {
                        done = false;
                    }
                } 

            }
        }




        public static void main(String[] args) {
            new Thread(new InputGatherer()).start();
        }
    }
