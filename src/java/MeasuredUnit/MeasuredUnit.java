package MeasuredUnit;

public class MeasuredUnit {

    int id;
    String description;
    String creation_date;

    public MeasuredUnit() {
    }

    public MeasuredUnit(int id, String description, String creation_date) {
        this.id = id;
        this.description = description;
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

   
}
