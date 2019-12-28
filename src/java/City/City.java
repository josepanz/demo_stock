
package City;
public class City {
    private int id; 
    private String code,description;
    private int departament_id;
    private String creation_date;

    public City() {
    }

    public City(int id, String code, String description, int departament_id, String creation_date) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.departament_id = departament_id;
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(int departament_id) {
        this.departament_id = departament_id;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
    
    
    
}
