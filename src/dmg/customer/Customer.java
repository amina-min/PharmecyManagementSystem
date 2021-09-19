/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.customer;

/**
 *
 * @author b
 */
public class Customer {
    private int id;
    private String name;
    private String contact;
    private String email;
    private String address;

    public Customer(int id, String name, String contact, String email, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public Customer(String name, String contact, String email, String address) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", address=" + address + '}';
    }
    
    
    
}
