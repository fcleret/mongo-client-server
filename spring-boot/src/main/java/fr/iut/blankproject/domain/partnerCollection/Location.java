package fr.iut.blankproject.domain.partnerCollection;

import java.util.List;

public class Location {

    private String type;
        public String getType() { return type; }
        public void setType(String value) { type = value; }

    private List<Double> coordinates;
        public List<Double> getCoordinates() { return coordinates; }
        public void setCoordinates(List<Double> value) { coordinates = value; }
}
