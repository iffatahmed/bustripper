package io.telenor.bustripper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusTrip {


    /**
     * Holding JSON LineRef, OriginName, DestinationName,
     *
     },
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MonitoredVehicleJourney {

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class MonitoredCall {
            
            private String expectedArrivalTime;
            private String visitNumber;

            @JsonProperty("ExpectedArrivalTime")
            public String getExpectedArrivalTime() {
                return expectedArrivalTime;
            }

            @JsonProperty("ExpectedArrivalTime")
            public void setExpectedArrivalTime(String expectedArrivalTime) {
                this.expectedArrivalTime = expectedArrivalTime;
            }

            @JsonProperty("VisitNumber")
            public String getVisitNumber() {
                return visitNumber;
            }

            @JsonProperty("VisitNumber")
            public void setVisitNumber(String visitNumber) {
                this.visitNumber = visitNumber;
            }
        }

        private String lineRef;
        private String originName;
        private String destinationName;

        private MonitoredCall monitoredCall;

        public MonitoredVehicleJourney() {}

        @JsonProperty("LineRef")
        public String getLineRef() {
            return lineRef;
        }

        @JsonProperty("LineRef")
        public void setLineRef(String lineRef) {
            this.lineRef = lineRef;
        }

        @JsonProperty("OriginName")
        public String getOriginName() {
            return originName;
        }

        @JsonProperty("OriginName")
        public void setOriginName(String originName) {
            this.originName = originName;
        }

        @JsonProperty("DestinationName")
        public String getDestinationName() {
            return destinationName;
        }

        @JsonProperty("DestinationName")
        public void setDestinationName(String destinationName) {
            this.destinationName = destinationName;
        }

        @JsonProperty("MonitoredCall")
        public MonitoredCall getMonitoredCall() {
            return monitoredCall;
        }

        @JsonProperty("MonitoredCall")
        public void setMonitoredCall(MonitoredCall monitoredCall) {
            this.monitoredCall = monitoredCall;
        }
    }

    @JsonProperty("MonitoredVehicleJourney")
    private MonitoredVehicleJourney monitoredVehicleJourney;


    @JsonIgnore
    public String getLineRef() {
        return monitoredVehicleJourney.getLineRef();
    }

    @JsonIgnore
    public String getOriginName() {
        return monitoredVehicleJourney.getOriginName();
    }

    @JsonIgnore
    public String getDestinationName() {
        return monitoredVehicleJourney.getDestinationName();
    }

    @JsonIgnore
    public String getExpectedArrivalTime() {
        return monitoredVehicleJourney.getMonitoredCall().getExpectedArrivalTime();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getLineRef()).append(" ")
                .append(getOriginName()).append(" -> ")
                .append(getDestinationName()).append(' ')
                .append(getExpectedArrivalTime());

                
        return builder.toString();
    }

    @Override
    public int hashCode() {

        return toString().hashCode();
    }
}
