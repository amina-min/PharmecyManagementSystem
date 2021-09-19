/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;

import java.sql.Date;

/**
 *
 * @author b
 */
public class DrugOut {
    private int invoiceid;
    private int drugid;
    private double buyprice;
    private double saleprice;
    private int quantity;
    private int inventoryid;
    private int customerid;
    private int companyid;
    private Date saleDate;
    private Date expdate;
    private Date mfgdate;

    public DrugOut(int invoiceid, int drugid, double buyprice, double saleprice, int quantity, int inventoryid, int customerid, int companyid, Date saleDate, Date expdate, Date mfgdate) {
        this.invoiceid = invoiceid;
        this.drugid = drugid;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.inventoryid = inventoryid;
        this.customerid = customerid;
        this.companyid = companyid;
        this.saleDate = saleDate;
        this.expdate = expdate;
        this.mfgdate = mfgdate;
    }

    public DrugOut(int drugid, double buyprice, double saleprice, int quantity, int inventoryid, int customerid, int companyid, Date saleDate, Date expdate, Date mfgdate) {
        this.drugid = drugid;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.inventoryid = inventoryid;
        this.customerid = customerid;
        this.companyid = companyid;
        this.saleDate = saleDate;
        this.expdate = expdate;
        this.mfgdate = mfgdate;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(int inventoryid) {
        this.inventoryid = inventoryid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public Date getMfgdate() {
        return mfgdate;
    }

    public void setMfgdate(Date mfgdate) {
        this.mfgdate = mfgdate;
    }

    @Override
    public String toString() {
        return "DrugOut{" + "invoiceid=" + invoiceid + ", drugid=" + drugid + ", buyprice=" + buyprice + ", saleprice=" + saleprice + ", quantity=" + quantity + ", inventoryid=" + inventoryid + ", customerid=" + customerid + ", companyid=" + companyid + ", saleDate=" + saleDate + ", expdate=" + expdate + ", mfgdate=" + mfgdate + '}';
    }
 
    
}
