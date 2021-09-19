/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;
 
  import java.util.List;

 
public interface DrugInDao {   
    DrugIn getDrugIn(int id) ;
    void addDrugIn(DrugIn drug);
    void deleteDrugIn(int id);
    void updateDrugIn(DrugIn drug); 
    public List<DrugIn> getDrugInList(String q);     
    public List<DrugIn> getDrugInventoryList(String q, String orderClause);    
    public int getNextBillId();
    public String getDrugCount();
    public String getCompanyCount();
    public List<DrugIn> getDrugExpiringList(int aftermonth, String orderClause);
    public List<DrugIn> getDrugExpiredList();
    public int getDrugExpiringCount(int aftermonth);
    public int getDrugExpiredCount();
    public int getOutOfStockCount();
    public int getLimitedStock(int lessthanCount) ;

    
}
