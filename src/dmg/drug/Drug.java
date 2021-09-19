package dmg.drug;

import dmg.company.Company;
import dmg.company.CompanyDao;
import dmg.company.CompanyDaoImpl;
import java.io.Serializable;
import java.sql.Date;
import java.util.stream.Stream;

public class Drug implements Serializable {

    private int id;
    private String name;
    private double buyprice;
    private double saleprice;
    private int companyid;

    public Drug(int id, String name, double buyprice, double saleprice, int companyid) {
        this.id = id;
        this.name = name;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.companyid = companyid;
    }

    public Drug(String name, double buyprice, double saleprice, int companyid) {
        this.name = name;
        this.buyprice = buyprice;
        this.saleprice = saleprice;
        this.companyid = companyid;
    }

   

 
    public Object[] toObject() {
        return new Object[]{
            id,
            name,
            buyprice,
            saleprice,
            getCompany(companyid),
     
        };
    }

    public static Company  getCompany(int companyid) {
        CompanyDao cd = new CompanyDaoImpl();
        Company company = cd.getCompany(companyid);
        return company;

    }

    public static Drug getDrug(int drugid) {
        DrugDao cd = new DrugDaoImpl();
        Drug drug = cd.getDrug(drugid);
        return drug;

    }

    public Object[] toSelectorModel() {
        return new Object[]{
            id,
            name,
            buyprice,
            saleprice,
            getCompany(companyid).getName(),
        };
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

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    @Override
    public String toString() {
        return "Drug{" + "id=" + id + ", name=" + name + ", buyprice=" + buyprice + ", saleprice=" + saleprice + ", companyid=" + companyid + '}';
    }
    
    
}
