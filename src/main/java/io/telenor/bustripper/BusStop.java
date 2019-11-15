package io.telenor.bustripper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusStop {

    public static class Line {
        private  int id;
        private String name;
        private int transportation;
        private String lineColour;

        public Line() {}

        @JsonProperty("ID")
        public int getId() {
            return id;
        }

        @JsonProperty("ID")
        public void setID(int id) {
            this.id = id;
        }

        @JsonProperty("Name")
        public String getName() {
            return name;
        }

        @JsonProperty("Name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("Transportation")
        public int getTransportation() {
            return transportation;
        }

        @JsonProperty("Transportation")
        public void setTransportation(int transporttation) {
            this.transportation = transporttation;
        }

        @JsonProperty("LineColour")
        public String getLineColour() {
            return lineColour;
        }

        @JsonProperty("LineColour")
        public void setLineColour(String lineColour) {
            this.lineColour = lineColour;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", transportation=" + transportation +
                    ", lineColour='" + lineColour + '\'' +
                    '}';
        }
    }
    private Line[] lines;
    private int x;
    private int y;
    private String zone;
    private String shortName;
    private boolean isHub;
    private String id;
    private String Name;
    private String district;
    private String placeType;

    public BusStop() {}

    @JsonProperty("Lines")
    public Line[] getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    @JsonProperty("X")
    public int getX() {
        return x;
    }

    @JsonProperty("X")
    public void setX(int x) {
        this.x = x;
    }

    @JsonProperty("Y")
    public int getY() {
        return y;
    }

    @JsonProperty("Y")
    public void setY(int y) {
        this.y = y;
    }

    @JsonProperty("Zone")
    public String getZone() {
        return zone;
    }

    @JsonProperty("Zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonProperty("ShortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("ShortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("IsHub")
    public boolean isHub() {
        return isHub;
    }

    @JsonProperty("IsHub")
    public void setHub(boolean hub) {
        isHub = hub;
    }

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    @JsonProperty("District")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("District")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("PlaceType")
    public String getPlaceType() {
        return placeType;
    }

    @JsonProperty("PlaceType")
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "lines=" + Arrays.toString(lines) +
                ", x=" + x +
                ", y=" + y +
                ", zone='" + zone + '\'' +
                ", shortName='" + shortName + '\'' +
                ", isHub=" + isHub +
                ", id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", district='" + district + '\'' +
                ", placeType='" + placeType + '\'' +
                '}';
    }
}
