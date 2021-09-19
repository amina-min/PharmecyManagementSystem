package dmg.drug;

import dmg.service.DBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugOutDaoImpl implements DrugOutDao {

    public static Object lastMsg = "";

    Connection conn = DBConnector.getConnection();

    @Override
    public void addDrugOut(DrugOut drugOut) {
        System.out.println("adding to drugout");
        try {
            String sql = "insert into drugout("
                    + "drugid,buyprice,saleprice,quantity,inventoryid,customerid,companyid,saledate,expdate,mfgdate) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, drugOut.getDrugid());
            ps.setDouble(2, drugOut.getBuyprice());
            ps.setDouble(3, drugOut.getSaleprice());
            ps.setInt(4, drugOut.getQuantity());
            ps.setInt(5, drugOut.getInventoryid());
            ps.setInt(6, drugOut.getCustomerid());
            ps.setInt(7, drugOut.getCompanyid());
            ps.setDate(8, drugOut.getSaleDate());
            ps.setDate(9, drugOut.getExpdate());
            ps.setDate(10, drugOut.getMfgdate());
            ps.execute();

            String sqll = "UPDATE druginventory SET quantity = quantity - ? WHERE id = ?";
            PreparedStatement pss = conn.prepareStatement(sqll);
            pss.setInt(1, drugOut.getQuantity());
            pss.setInt(2, drugOut.getInventoryid());            
            pss.execute();
            
            System.out.println("Added Successfully");
            lastMsg = "Drug sold Successfully";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
    }

    @Override
    public void deleteDrugOut(int id) {

    }

    @Override
    public void updateDrugOut(DrugOut drug) {

    }

    @Override
    public List<DrugOut> getDrugOutList(String q) {
        String wildcard = "%" + q + "%";
        List<DrugOut> cList = new ArrayList<DrugOut>();
        String sql = "select * from drugout where invoiceid like ? or companyid like ? or drugid like ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
            ps.setString(3, wildcard);
     
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DrugOut drugOut = new DrugOut(
                        rs.getInt("invoiceid"),
                        rs.getInt("drugid"),
                        rs.getDouble("buyprice"),
                        rs.getDouble("saleprice"),
                        rs.getInt("quantity"),
                        rs.getInt("batchno"),
                        rs.getInt("customerid"),
                        rs.getInt("companyid"),
                        rs.getDate("entrydate"),
                        rs.getDate("expdate"),
                        rs.getDate("mfgdate")
                );
                cList.add(drugOut);
           
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return cList;

    }

    @Override
    public DrugOut getDrugOut(int id) {

        DrugOut drugOut = null;
        String sql = "select * from drugout where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            
            ResultSet rs = ps.executeQuery();
            rs.next();
            drugOut = new DrugOut(
                    rs.getInt("invoiceid"),
                    rs.getInt("drugid"),
                    rs.getDouble("buyprice"),
                    rs.getDouble("saleprice"),
                    rs.getInt("quantity"),
                    rs.getInt("batchno"),
                    rs.getInt("customerid"),
                    rs.getInt("companyid"),
                    rs.getDate("entrydate"),
                    rs.getDate("expdate"),
                    rs.getDate("mfgdate")
            );

   
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return drugOut;

    }

    @Override
    public Double getTotalSale(Date from, Date to) {

        double totalSale = 0;
        String sql = "select sum(quantity * saleprice) from drugout where saledate >= ? and saledate<= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);

            
            ResultSet rs = ps.executeQuery();
            rs.next();

            totalSale = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return totalSale;

    }

    @Override
    public Double getTotalExpense(Date from, Date to) {

        double totalSale = 0;
        String sql = "select sum(quantity * buyprice) from drugin where entrydate >= ? and entrydate<= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);

            
            ResultSet rs = ps.executeQuery();
            rs.next();

            totalSale = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return totalSale;

    }

    @Override
    public Double getTotalProfit(Date from, Date to) {

        double totalSale = 0;
        String sql = "select (sum(quantity * saleprice) - sum(quantity * buyprice)) from drugout where saledate >= ? and saledate<= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);

            
            ResultSet rs = ps.executeQuery();
            rs.next();

            totalSale = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return totalSale;

    }

}
