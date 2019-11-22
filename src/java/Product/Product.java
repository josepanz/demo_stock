
package Product;

public class Product {
    private int id; 
    private String code,description, alternative_code;
    private int measured_unit_id;
    private String creation_date;

    public Product() {
    }

    public Product(int id, String code, String description,String alternative_code, int measured_unit_id, String creation_date) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.measured_unit_id = measured_unit_id;
        this.creation_date = creation_date;
        this.alternative_code = alternative_code;
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

    public String getAlternative_code() {
        return alternative_code;
    }

    public void setAlternative_code(String alternative_code) {
        this.alternative_code = alternative_code;
    }

    public int getMeasured_unit_id() {
        return measured_unit_id;
    }

    public void setMeasured_unit_id(int measured_unit_id) {
        this.measured_unit_id = measured_unit_id;
    }



    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
    
    
    
}
