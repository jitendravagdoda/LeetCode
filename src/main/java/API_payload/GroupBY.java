package API_payload;

public class GroupBY {
    String heading;
    String dimensionName;
    String groupType;
    String details;
    String fieldName;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        if(fieldName==null)
        return "{" +
                "\n\"heading\":\"" + heading + '\"' +
                ",\n\"dimensionName\":\"" + dimensionName + '\"' +
                ",\n\"groupType\":\"" + groupType + '\"' +
                "\n}";
        else
            return "{" +
                    "\n\"heading\":\"" + heading + '\"' +
                    ",\n\"dimensionName\":\"" + dimensionName + '\"' +
                    ",\n\"groupType\":\"" + groupType + '\"' +
                    ",\n\"details\":{" +
                    "\n\"fieldName\":\"" + fieldName + '\"' +
                    "\n}}";
    }
}
