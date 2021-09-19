 
package dmg.model;

import java.io.Serializable;

 
public class DrugModel implements Serializable{
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String company;

    public DrugModel(int id, String name, double price, int quantity, String company) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Drug{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", company=" + company + '}';
    }
    
    
}
