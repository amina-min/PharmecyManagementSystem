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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrugInDaoImpl implements DrugInDao {

    public static Object lastMsg = "";

    Connection conn = DBConnector.getConnection();

    @Override
    public void addDrugIn(DrugIn drugIn) {
        try {
            String sql = "insert into drugin(drugid,buyprice,saleprice,quantity,batchno,companyid,entrydate,expdate,mfgdate) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, drugIn.getDrugid());
            ps.setDouble(2, drugIn.getBuyprice());
            ps.setDouble(3, drugIn.getSaleprice());
            ps.setInt(4, drugIn.getQuantity());
            ps.setInt(5, drugIn.getBatchno());
            ps.setInt(6, drugIn.getCompanyid());
            ps.setDate(7, drugIn.getEntrydate());
            ps.setDate(8, drugIn.getExpdate());
            ps.setDate(9, drugIn.getMfgdate());
            ps.execute();

            addDrugInventory(drugIn);

            System.out.println("Added Successfully");
            lastMsg = "Added Successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
    }

    public void addDrugInventory(DrugIn drugIn) {
        try {
            String sql = "insert into druginventory(drugid,buyprice,saleprice,quantity,batchno,companyid,entrydate,expdate,mfgdate) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, drugIn.getDrugid());
            ps.setDouble(2, drugIn.getBuyprice());
            ps.setDouble(3, drugIn.getSaleprice());
            ps.setInt(4, drugIn.getQuantity());
            ps.setInt(5, drugIn.getBatchno());
            ps.setInt(6, drugIn.getCompanyid());
            ps.setDate(7, drugIn.getEntrydate());
            ps.setDate(8, drugIn.getExpdate());
            ps.setDate(9, drugIn.getMfgdate());
            ps.execute();

            System.out.println("Added Successfully");
            lastMsg = "Added Successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
    }

    @Override
    public void deleteDrugIn(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDrugIn(DrugIn drug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DrugIn> getDrugInList(String q) {
        String wildcard = "%" + q + "%";
        List<DrugIn> cList = new ArrayList<DrugIn>();
        String sql = "select * from drugin where billid like ? or companyid like ? or drugid like ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
            ps.setString(3, wildcard);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugIn drug = new DrugIn(
                        rs.getInt("billid"),
                        rs.getInt("drugid"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("quantity"),
                        rs.getInt("batchno"),
                        rs.getInt("companyid"),
                        rs.getDate("entrydate"),
                        rs.getDate("expdate"),
                        rs.getDate("mfgdate")
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
    public List<DrugIn> getDrugInventoryList(String q, String orderClause) {
        String wildcard = "%" + q + "%";
        List<DrugIn> cList = new ArrayList<DrugIn>();
        String sql = "select * from druginventory "
                + "where drugid in (select id from druglist where name like ?) "
                + "or companyid in (select id from companies where name like ?) "
                + orderClause;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
//            ps.setString(3, wildcard);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugIn drug = new DrugIn(
                        rs.getInt("id"),
                        rs.getInt("drugid"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("quantity"),
                        rs.getInt("batchno"),
                        rs.getInt("companyid"),
                        rs.getDate("entrydate"),
                        rs.getDate("expdate"),
                        rs.getDate("mfgdate")
                );
                cList.add(drug);
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return cList;

    }

    @Override
    public List<DrugIn> getDrugExpiringList(int aftermonth, String orderClause) {

        List<DrugIn> cList = new ArrayList<DrugIn>();
        String sql = " SELECT * FROM druginventory where expdate > now() and expdate < DATE_ADD(NOW(),INTERVAL ? MONTH) "
                + orderClause;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aftermonth);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugIn drug = new DrugIn(
                        rs.getInt("id"),
                        rs.getInt("drugid"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("quantity"),
                        rs.getInt("batchno"),
                        rs.getInt("companyid"),
                        rs.getDate("entrydate"),
                        rs.getDate("expdate"),
                        rs.getDate("mfgdate")
                );
                cList.add(drug);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return cList;

    }

    @Override
    public List<DrugIn> getDrugExpiredList() {

        List<DrugIn> cList = new ArrayList<DrugIn>();
        String sql = " SELECT * FROM druginventory where expdate < now() and quantity > 0 ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
          

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugIn drug = new DrugIn(
                        rs.getInt("id"),
                        rs.getInt("drugid"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("quantity"),
                        rs.getInt("batchno"),
                        rs.getInt("companyid"),
                        rs.getDate("entrydate"),
                        rs.getDate("expdate"),
                        rs.getDate("mfgdate")
                );
                cList.add(drug);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return cList;

    }

    @Override
    public int getDrugExpiringCount(int aftermonth) {
        int count = 0;
        String sql = " SELECT count(*) FROM druginventory where expdate > now() and expdate < DATE_ADD(NOW(),INTERVAL ? MONTH)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aftermonth);

            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
    @Override
    public int getDrugExpiredCount() {
        int count = 0;
        String sql = " SELECT count(*) FROM druginventory where expdate < now() and quantity > 0";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
    @Override
    public int getOutOfStockCount() {
        int count = 0;
        String sql = "select count(*) from (SELECT drugid, sum(quantity) FROM druginventory group by drugid having sum(quantity) = 0) as derived";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
    @Override
    public int getLimitedStock(int lessthanCount) {
        int count = 0;
        String sql = "select count(*) from (SELECT drugid, sum(quantity) FROM druginventory group by drugid having sum(quantity) < ? and sum(quantity) > 0) as derived";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, lessthanCount);
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }

    @Override
    public DrugIn getDrugIn(int id) {

        DrugIn drugIn = null;
        String sql = "select * from drugin where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            drugIn = new DrugIn(
                    rs.getInt("billid"),
                    rs.getInt("drugid"),
                    rs.getDouble("buyprice"),
                    rs.getDouble("saleprice"),
                    rs.getInt("quantity"),
                    rs.getInt("batchno"),
                    rs.getInt("companyid"),
                    rs.getDate("entrydate"),
                    rs.getDate("expdate"),
                    rs.getDate("mfgdate")
            );

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return drugIn;

    }

    @Override
    public int getNextBillId() {
        int lastBillId = 0;
        try {
            String sql = "SELECT billid FROM drugin ORDER BY billid DESC LIMIT 1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();
            lastBillId = rs.getInt("billid");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        return lastBillId + 1;
    }

    @Override
    public String getDrugCount() {
        int totalDrug = 0;
        try {
            String sql = "SELECT sum(quantity) FROM druginventory";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            totalDrug = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        return String.valueOf(totalDrug);
    }

    @Override
    public String getCompanyCount() {
        int totalCompanies = 0;
        try {
            String sql = "SELECT count(*) FROM companies";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            totalCompanies = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        return String.valueOf(totalCompanies);
    }

}
