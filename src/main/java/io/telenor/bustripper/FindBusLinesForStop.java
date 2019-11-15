package io.telenor.bustripper;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FINDS a busline for stop ID
 * http://reisapi.ruter.no/StopVisit/GetDepartures/2190021?datetime=2016-11-22T12:10:00
 */
public class FindBusLinesForStop implements Runnable {

    private static final String SEARCH_URL = "https://reisapi.ruter.no/StopVisit/GetDepartures/%s?datetime=%s";

    private static SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss");
    private Client client;
    private String stopId;
    private TripsCallback listener;
    private boolean last;

    public FindBusLinesForStop(String stopId, TripsCallback callback, boolean last) {
        this.stopId = stopId;
        this.listener = callback;
        this.last = last;
    }

    public void run() {

        String formattedDate = formatter.format(new Date());
        int count=0;
        //String formattedDate = formatter.format(new Date());
//https://reisapi.ruter.no/StopVisit/GetDepartures/2190021?datetime=2019-09-30T23:59:59

        ClientConfig configuration = new ClientConfig();

        client = ClientBuilder.newClient(configuration);

        String target = String.format(SEARCH_URL, stopId, formattedDate);
//        target=target+"&transporttypes=2&linenames=450";
        Invocation.Builder invocationBuilder = client
                .target(target)
                .request(MediaType.APPLICATION_JSON);



        final AsyncInvoker asyncInvoker = invocationBuilder.async();
System.out.println(target);

//System.out.println("set " + asyncInvoker.get(new BusTripsCallBack(target, listener, last)));
        asyncInvoker.get(new BusTripsCallBack(target, listener, last));

    }


}
