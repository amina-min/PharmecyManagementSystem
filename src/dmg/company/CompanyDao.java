/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.company;

  import java.util.List;

/**
 *
 * @author b
 */
public interface CompanyDao {
    Company getCompany(int id) ;
    void addCompany(Company company);
    void deleteCompany(int id);
    void updateCompany(Company user);
  

    List<Company>getCompanyList(String q);
     
}
