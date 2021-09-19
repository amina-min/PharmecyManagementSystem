/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.service;

import dmg.model.DrugModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b
 */
public interface DaoInterface {
    void add(DrugModel drug);
    void delete(int id);
    void update(DrugModel drug);
    void sale(DrugModel drug);
   List<DrugModel> getDrugList();
    
}
