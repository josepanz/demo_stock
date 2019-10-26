
package ProductFamily;

import Country.*;


public class ProductFamily {
    private int id; 
    private String code,description;
    private String creation_date;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public ProductFamily() {
    }

    public ProductFamily(int id, String code, String description,  String creation_date, boolean  active) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.creation_date = creation_date;
        this.active = active;
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
