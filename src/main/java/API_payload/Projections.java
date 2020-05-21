package API_payload;

public class Projections {
    String heading;
    String measurementName;
    String aggregateFunction;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
    }

    public String getAggregateFunction() {
        return aggregateFunction;
    }

    public void setAggregateFunction(String aggregateFunction) {
        this.aggregateFunction = aggregateFunction;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"heading\":\"" + heading + '\"' +
                ",\n\"measurementName\":\"" + measurementName + '\"' +
                ",\n\"aggregateFunction\":\"" + aggregateFunction + '\"' +
                "\n}";
    }
}
