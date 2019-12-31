
package Country;


public class Country {
    private int id; 
    private String code,description;
    private String creation_date;

    public Country() {
    }

    public Country(int id, String code, String description,  String creation_date) {
        this.id = id;
        this.code = code;
        this.description = description;
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

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
    
}
