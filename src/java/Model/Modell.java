
package Model;

/**
 *
 * @author NITRO 5
 */
public class Modell {
    int id;
    String descripcion;
    int brand_id;
    String year;

    public Modell() {
    }

    public Modell(int id, String descripcion, int brand_id, String year) {
        this.id = id;
        this.descripcion = descripcion;
        this.brand_id = brand_id;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
