/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;

import dmg.company.*;
  import java.util.List;

/**
 *
 * @author b
 */
public interface DrugDao {   
    Drug getDrug(int id) ;
    void addDrug(Drug drug);
    void deleteDrug(int id);
    void updateDrug(Drug drug); 
    public List<Drug> getDrugList(String q);     
}
