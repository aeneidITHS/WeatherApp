package com.example.weatherapp.Bussiness.WeatherSMHI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "coordinates"
})
public class Geometry {

        @JsonProperty("type")
        private String type;
        @JsonProperty("coordinates")
        private List<List<Double>> coordinates;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("coordinates")
        public List<List<Double>> getCoordinates() {
            return coordinates;
        }

        @JsonProperty("coordinates")
        public void setCoordinates(List<List<Double>> coordinates) {
            this.coordinates = coordinates;
        }

    }
