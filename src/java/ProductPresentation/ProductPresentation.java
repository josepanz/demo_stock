
package ProductPresentation;

public class ProductPresentation {
    int id;
    String presentation_code,presentation_name;
    int product_family_id,product_brand_id, product_id;
    String creation_date;
    boolean enable;
    String barcode;
    int cost;

    public ProductPresentation() {
    }

    
    public ProductPresentation(int id, String presentation_code, String presentation_name, int product_family_id, int product_brand_id, int product_id, String creation_date, boolean enable, String barcode, int cost) {
        this.id = id;
        this.presentation_code = presentation_code;
        this.presentation_name = presentation_name;
        this.product_family_id = product_family_id;
        this.product_brand_id = product_brand_id;
        this.product_id = product_id;
        this.creation_date = creation_date;
        this.enable = enable;
        this.barcode = barcode;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPresentation_code() {
        return presentation_code;
    }

    public void setPresentation_code(String presentation_code) {
        this.presentation_code = presentation_code;
    }

    public String getPresentation_name() {
        return presentation_name;
    }

    public void setPresentation_name(String presentation_name) {
        this.presentation_name = presentation_name;
    }

    public int getProduct_family_id() {
        return product_family_id;
    }

    public void setProduct_family_id(int product_family_id) {
        this.product_family_id = product_family_id;
    }

    public int getProduct_brand_id() {
        return product_brand_id;
    }

    public void setProduct_brand_id(int product_brand_id) {
        this.product_brand_id = product_brand_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
