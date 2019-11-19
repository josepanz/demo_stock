
package Model;

/**
 *
 * @author NITRO 5
 */
public class Modell {
    int id;
    String description;
    int brand_id;
    String year;

    public Modell() {
    }

    public Modell(int id, String description, int brand_id, String year) {
        this.id = id;
        this.description = description;
        this.brand_id = brand_id;
        this.year = year;
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

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
