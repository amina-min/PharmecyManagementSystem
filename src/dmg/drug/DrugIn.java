/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;
import java.util.stream.Stream;

/**
 *
 * @author b
 */
public class DrugIn implements Serializable {

    private int billid;
    private int drugid;
    private double buyprice;
    private double saleprice;
    private int quantity;
    private int batchno;
    private int companyid;
    private Date entrydate;
    private Date expdate;
    private Date mfgdate;

    public DrugIn(int billid, int drugid, double buyprice, double saleprice, int quantity, int batchno, int companyid, Date entrydate, Date expdate, Date mfgdate) {
        this.billid = billid;
        this.drugid = drugid;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.batchno = batchno;
        this.companyid = companyid;
        this.entrydate = entrydate;
        this.expdate = expdate;
        this.mfgdate = mfgdate;
    }

    public DrugIn(int drugid, double buyprice, double saleprice, int quantity, int batchno, int companyid, Date entrydate, Date expdate, Date mfgdate) {
        this.drugid = drugid;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.batchno = batchno;
        this.companyid = companyid;
        this.entrydate = entrydate;
        this.expdate = expdate;
        this.mfgdate = mfgdate;
    }

    public Date getMfgdate() {
        return mfgdate;
    }

    public void setMfgdate(Date mfgdate) {
        this.mfgdate = mfgdate;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
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

    public double getTotal() {
        return saleprice * quantity;
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

    public int getBatchno() {
        return batchno;
    }

    public void setBatchno(int batchno) {
        this.batchno = batchno;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    @Override
    public String toString() {
        return "DrugIn{" + "billid=" + billid + ", drugid=" + drugid + ", buyprice=" + buyprice + ", saleprice=" + saleprice + ", quantity=" + quantity + ", batchno=" + batchno + ", companyid=" + companyid + ", entrydate=" + entrydate + ", expdate=" + expdate + ", mfgdate=" + mfgdate + '}';

    }

    public Object[] toSelectorModel() {
        return new Object[]{
            billid,
            Drug.getDrug(drugid).getName(),
            buyprice, saleprice, quantity, batchno, Drug.getCompany(companyid).getName(), entrydate, expdate, mfgdate

        };
    }

    public Object[] toInventoryModel() {
        return new Object[]{
            billid,
            Drug.getDrug(drugid).getName(), Drug.getCompany(companyid).getName(),
            buyprice, saleprice, quantity, batchno, entrydate, mfgdate, expdate

        };
    }

    public Object[] toInvoiceModel(int serial) {
        return new Object[]{
            serial,
            Drug.getDrug(drugid).getName(), Drug.getCompany(companyid).getName(), quantity, saleprice,
            (saleprice * quantity), expdate, batchno
        };
    }

    public DrugOut toDrugOut(int customerid, Date saledate) {
        return new DrugOut(drugid, buyprice, saleprice, quantity, billid, customerid, companyid, saledate, expdate, mfgdate);
    }

}
