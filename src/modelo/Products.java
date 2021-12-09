package modelo;


public class Products {
    
    private int id_product;
    private String code_product;
    private String description_product;
    private int quantity;
    private double purchase_price;
    private double sale_price;
    private int id_provider;
    private int id_category;
    private String status_product;
    private String name_provider;
    private String name_category;

    public Products() {
    }

    public Products(int id_product, String code_product, String description_product, int quantity, double purchase_price, double sale_price, int id_provider, int id_category, String status_product, String name_provider, String name_category) {
        this.id_product = id_product;
        this.code_product = code_product;
        this.description_product = description_product;
        this.quantity = quantity;
        this.purchase_price = purchase_price;
        this.sale_price = sale_price;
        this.id_provider = id_provider;
        this.id_category = id_category;
        this.status_product = status_product;
        this.name_provider = name_provider;
        this.name_category = name_category;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
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

    public String getName_provider() {
        return name_provider;
    }

    public void setName_provider(String name_provider) {
        this.name_provider = name_provider;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    

    
    
    
}
