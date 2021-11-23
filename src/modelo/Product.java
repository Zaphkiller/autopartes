
package modelo;


public class Product {
    
    private int id_product;
    private String code_product;
    private String description_product;
    private Double purchase_price;
    private Double sale_price;
    private int quantity;
    private int id_provider;
    private int id_category;
    private String status_product;

    public Product() {
    }

    public Product(int id_product, String code_product, String description_product, Double purchase_price, Double sale_price, int quantity, int id_provider, int id_category, String status_product) {
        this.id_product = id_product;
        this.code_product = code_product;
        this.description_product = description_product;
        this.purchase_price = purchase_price;
        this.sale_price = sale_price;
        this.quantity = quantity;
        this.id_provider = id_provider;
        this.id_category = id_category;
        this.status_product = status_product;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getCode_product() {
        return code_product;
    }

    public void setCode_product(String code_product) {
        this.code_product = code_product;
    }

    public String getDescription_product() {
        return description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Double getSale_price() {
        return sale_price;
    }

    public void setSale_price(Double sale_price) {
        this.sale_price = sale_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getStatus_product() {
        return status_product;
    }

    public void setStatus_product(String status_product) {
        this.status_product = status_product;
    }
    
    

 

    
    
    
    
}
