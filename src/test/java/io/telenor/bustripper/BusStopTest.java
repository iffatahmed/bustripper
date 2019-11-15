package io.telenor.bustripper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class BusStopTest {

    @Test
    public void testBusStop() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BusStop[] stops = mapper.readValue(BusStopTest.class.getResource("busstop.json"), BusStop[].class);

        System.out.println("Got stop: " + stops);

        assertNotNull(stops);
        assertEquals(1, stops.length);
        assertEquals(3, stops[0].getLines().length);
    }
}
