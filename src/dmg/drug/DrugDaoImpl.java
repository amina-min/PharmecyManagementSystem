/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;

import dmg.service.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDaoImpl implements DrugDao {

    public static Object lastMsg = "";

    Connection conn = DBConnector.getConnection();

    @Override
    public void addDrug(Drug drug) {
        try {
            String sql = "insert into druglist(name,buyprice,saleprice,companyid) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, drug.getName());
            ps.setDouble(2, drug.getBuyprice());
            ps.setDouble(3, drug.getSaleprice());
            ps.setInt(4, drug.getCompanyid());
            ps.execute();

            System.out.println("Added Successfully");
            lastMsg = "Added Successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
    }

    @Override
    public void deleteDrug(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDrug(Drug drug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Drug> getDrugList(String q) {
        String wildcard = "%" + q + "%";
        List<Drug> cList = new ArrayList<Drug>();
        String sql = "select * from druglist where name like ? or companyid like ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
    
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("companyid")
                );
                cList.add(drug);
             
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return cList;

    }

    @Override
    public Drug getDrug(int id) {

        Drug drug = null;
        String sql = "select * from druglist where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            
            ResultSet rs = ps.executeQuery();
            rs.next();
            drug = new Drug(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("buyprice"),
                    rs.getDouble("saleprice"),
                    rs.getInt("companyid")
            );

         
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return drug;

    }

}
