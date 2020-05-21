package API_payload;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Payload {
    String reportingEngine;
    String report;
    JSONArray filters;
    List<Projections> projections;
    List<GroupBY> groups;

    Payload()
    {
        projections=new ArrayList<Projections>();
        groups=new ArrayList<GroupBY>();
    }

    public String getReportingEngine() {
        return reportingEngine;
    }

    public void setReportingEngine(String reportingEngine) {
        this.reportingEngine = reportingEngine;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public JSONArray getFilters() {
        return filters;
    }

    public void setFilters(JSONArray filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"reportingEngine\":\"" + reportingEngine + '\"' +
                ",\n \"report\":\"" + report +"\""+
                ",\n \"startTime\":" + "1535103983001" +
                ",\n \"endTime\":" + "1537782383000" +
                ",\n \"timeZone\":\"" + "UTC" + '\"' +
                ",\n \"page\":" + "0" +
                ",\n \"pageSize\":" + "100";
               //  ",\n \"filters\":" + filters;
    }
}
