
package modelo;


public class Provider {
    
    private int id_provider;
    private String ruc_provider;
    private String name_provider;
    private String phone_provider;
    private String email_provider;
    private String address_provider;
    private String status_provider;

    public Provider() {
    }

    public Provider(int id_provider, String ruc_provider, String name_provider, String phone_provider, String email_provider, String address_provider, String status_provider) {
        this.id_provider = id_provider;
        this.ruc_provider = ruc_provider;
        this.name_provider = name_provider;
        this.phone_provider = phone_provider;
        this.email_provider = email_provider;
        this.address_provider = address_provider;
        this.status_provider = status_provider;
    }

    
    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public String getRuc_provider() {
        return ruc_provider;
    }

    public void setRuc_provider(String ruc_provider) {
        this.ruc_provider = ruc_provider;
    }

    public String getName_provider() {
        return name_provider;
    }

    public void setName_provider(String name_provider) {
        this.name_provider = name_provider;
    }

    public String getPhone_provider() {
        return phone_provider;
    }

    public void setPhone_provider(String phone_provider) {
        this.phone_provider = phone_provider;
    }

    public String getEmail_provider() {
        return email_provider;
    }

    public void setEmail_provider(String email_provider) {
        this.email_provider = email_provider;
    }

    public String getAddress_provider() {
        return address_provider;
    }

    public void setAddress_provider(String address_provider) {
        this.address_provider = address_provider;
    }

    public String getStatus_provider() {
        return status_provider;
    }

    public void setStatus_provider(String status_provider) {
        this.status_provider = status_provider;
    }
    
    
    

    
}
