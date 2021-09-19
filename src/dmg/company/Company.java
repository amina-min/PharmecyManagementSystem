/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.company;

import java.io.Serializable;

/**
 *
 * @author b
 */
public class Company implements Serializable {

    private int id;
    private String name;
    private String email;
    private String address;
    private String contact;

    public Company(int id, String name, String email, String address, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
    }

    public Company(String name, String email, String address, String contact) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
    }

    public Company() {

    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", contact=" + contact + '}';
    }

    public Object[] toObject() {
        return new Object[]{
            id,
            name,
            email,
            address,
            contact
        };
    }

}
