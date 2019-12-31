
package Departament;

public class Departament {
    private int id; 
    private String code,description;
    private int country_id;
    private String creation_date;

    public Departament() {
    }

    public Departament(int id, String code, String description, int country_id, String creation_date) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.country_id = country_id;
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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
    
}
