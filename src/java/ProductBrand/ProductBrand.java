/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductBrand;

/**
 *
 * @author Juan Cristaldo
 */
public class ProductBrand {
    private int id;
    private String code,name;
    private boolean active;
    private String creation_date;

    public ProductBrand() {
    }

    public ProductBrand(int id, String code, String name, boolean active, String creation_date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
    
    
    
}


