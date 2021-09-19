/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.service;

import dmg.model.DrugModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 

/**
 *
 * @author b
 */
public class DaoImpl implements DaoInterface {

    Connection conn = DBConnector.getConnection();

    @Override
    public void add(DrugModel drug) {
        try {
            String sql = "insert into drugs values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, drug.getId());
            ps.setString(2, drug.getName());
            ps.setDouble(3, drug.getPrice());
            ps.setInt(4, drug.getQuantity());
            ps.setString(5, drug.getCompany());
            ps.execute();
            System.out.println("Added Successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from drugs where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("deleted succesfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(DrugModel drug) {
        delete(drug.getId());
        add(drug);
    }

    @Override
    public List<DrugModel> getDrugList() {
        List<DrugModel> dList = new ArrayList<DrugModel>();
        String sql = "select * from drugs";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugModel drug = new DrugModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
                dList.add(drug);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dList;
    }

    @Override
    public void sale(DrugModel drug) {
        delete(drug.getId());
        add(drug);
    }

}
