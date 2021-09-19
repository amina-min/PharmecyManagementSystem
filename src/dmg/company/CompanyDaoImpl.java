/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.company;

import dmg.company.CompanyDao;
import dmg.service.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    Connection conn = DBConnector.getConnection();

    @Override
    public Company getCompany(int id) {
        Company company = null;
        String sql = "select * from companies where id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            company = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
return company;
    }

    @Override
    public void addCompany(Company company) {
        try {
            String sql = "insert into companies(name,address,email,contactno) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, company.getName());
            ps.setString(2, company.getAddress());
            ps.setString(3, company.getEmail());
            ps.setString(4, company.getContact());
            ps.execute();
            System.out.println("Added Successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteCompany(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCompany(Company user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getCompanyList(String q) {
        String wildcard = "%" + q + "%";
        List<Company> cList = new ArrayList<Company>();
        String sql = "select * from companies where name like ? or address like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                cList.add(company);
                System.out.println(company);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cList;

    }

}
