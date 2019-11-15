package io.telenor.bustripper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Callback from Jersey when bustrips are there.
 */
public class BusTripsCallBack implements InvocationCallback<Response> {
    ObjectMapper mapper = new ObjectMapper();
    String url;
    private TripsCallback listener;
    private boolean last;

    public BusTripsCallBack(String url, TripsCallback callback, boolean last) {
        this.url = url;
        this.listener = callback;
        this.last = last;
        
                
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public void completed(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        String content = response.readEntity(String.class);
                            System.out.println("Step 3 ");

//System.out.println(content);
        try {
            BusTrip[] trips = mapper.readValue(content, BusTrip[].class);
            System.out.println("Step 4 ");


            HashSet set = new HashSet(Arrays.asList(trips));
                System.out.println("Step 5 ");

           
            if(!set.isEmpty()){
                System.out.println("Step 6 ");
                listener.gotTrips(set, last);
            }

        } catch (IOException e) {
            if(last) {
                System.out.println("Step 7 ");

                listener.failedGettingTrips(e);
            }
        }

    }

    public void failed(Throwable throwable) {
                            System.out.println("Step 8 ");

        listener.failedGettingTrips((IOException) throwable);
    }
}
