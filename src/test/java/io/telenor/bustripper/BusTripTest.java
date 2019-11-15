package io.telenor.bustripper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class BusTripTest {


    @Test
    public void testBusTrip() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BusTrip[] trips = mapper.readValue(BusStopTest.class.getResource("stopvisits.json"), BusTrip[].class);

        System.out.println("Got trips: " + Arrays.toString(trips));

        assertNotNull(trips);
        assertEquals(68, trips.length);

        assertEquals("31", trips[0].getLineRef());
        assertEquals("Snarøya", trips[0].getOriginName());
        assertEquals("Grorud T", trips[0].getDestinationName());

    }
}
