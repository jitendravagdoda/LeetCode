package API_payload;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JSONtoAPI {
    public static void main(String[] args) {

        Payload payload=new Payload();
        StringBuffer sb=new StringBuffer();

        JSONParser parser = new JSONParser();
       JSONObject t;
        try {
            Object obj = parser.parse(new FileReader(
                    "/Users/jitendravagdoda/Documents/testtest/src/main/java/API_payload/test.json"));
            JSONObject jsonObject= (JSONObject) obj;

            payload.reportingEngine=(String)jsonObject.get("reportingEngine");
            payload.report= (String) jsonObject.get("report");
            payload.filters= (JSONArray) jsonObject.get("filters");
          //  System.out.println(payload.filters.toJSONString());
            for (int i = 0; i <payload.filters.size() ; i++) {
                JSONObject test= (JSONObject) payload.filters.get(i);
                test.put("dimensionName",test.get("field"));
                System.out.println(test.get("dimensionName"));
                test.remove("field");

            }
            sb.append(payload.toString()+",");
            sb.append("\n \"groupBys\":[");
            GroupBY gp;

            JSONArray groupBys= (JSONArray) jsonObject.get("groupBys");

             t= (JSONObject) groupBys.get(0);
             while(t.get("childrenGroupBys")!=null){
                 gp=new GroupBY();
                 gp.setHeading((String) t.get("field"));
                 gp.setDimensionName((String) t.get("field"));
                 System.out.println(t.get("field"));
                 gp.setGroupType((String) t.get("groupType"));
                 if(((String) t.get("field")).contains("CUSTOM_PROPERTY") || ((String) t.get("field")).equalsIgnoreCase("INBOUND_CUSTOM_PROPERTY")) {
                     JSONObject temp = (JSONObject) t.get("details");


                     gp.setFieldName((String) temp.get("fieldName"));

                     System.out.println(temp.get("fieldName"));

                 }
                 sb.append("\n"+gp.toString()+",");

                  if(t.containsKey("childrenGroupBys")){
                 groupBys= (JSONArray) t.get("childrenGroupBys");
                 t= (JSONObject) groupBys.get(0);
                 }

            }
              gp=new GroupBY();
            gp.setHeading((String) t.get("field"));
            gp.setDimensionName((String) t.get("field"));
            gp.setGroupType((String) t.get("groupType"));
            System.out.println(t.get("field"));
            sb.append("\n"+gp.toString()+"],");

            System.out.println("===========================");

            JSONArray projections= (JSONArray) t.get("projections");
            Projections temp;
            sb.append("\n \"projections\":[");
            for (int i=0;i<projections.size();i++){
                t=(JSONObject)projections.get(i);
                temp=new Projections();
                temp.setHeading((String) t.get("measurement"));
                System.out.println(t.get("measurement"));
                temp.setMeasurementName((String) t.get("measurement"));
               temp.setAggregateFunction((String) t.get("aggregateFunction"));
               sb.append("\n"+temp.toString()+",");
            }
            sb.append("\n]\n}");
            System.out.println(sb.toString());

            }catch (Exception exception){
            System.out.println(exception);


        }

    }
}
