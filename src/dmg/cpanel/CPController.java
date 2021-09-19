
package dmg.cpanel;

import CustomUI.Themes;
import dmg.company.AddCompany;
import dmg.company.CompanySelector;
import dmg.cpanel.ControlPanel;
import dmg.drug.DrugSelector;
import dmg.company.OnSetCompany;
import dmg.drug.AddDrugs;
import dmg.drug.DrugIn;
import dmg.drug.DrugInDao;
import dmg.drug.DrugInDaoImpl;
import dmg.drug.DrugInventorySelector;
import dmg.drug.DrugOutDao;
import dmg.drug.DrugOutDaoImpl;
import dmg.drug.OnSetDrug;
import dmg.drug.OnSetDrugIn;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class CPController {

   static DrugInDao daoDrugIn = new DrugInDaoImpl();
   static DrugOutDao daoDrugOut = new DrugOutDaoImpl();
    
    public static JLabel activeMenu = null;
    public static JLabel headerTitle;
    

    public static void entered(MouseEvent evt) {
       evt.getComponent().getParent().setBackground(Themes.getMenuHoverBg());;
        
        int x = evt.getComponent().getBounds().x += 2;
        evt.getComponent().setLocation(x, evt.getComponent().getLocation().y);
        
    }

    public static void clicked(MouseEvent lbClicked, JPanel selectedFrame) {
       for (Component c : lbClicked.getComponent().getParent().getParent().getComponents()) {
            c.setBackground(Themes.getMenuUnselectedBg());
        }
        
        lbClicked.getComponent().getParent().setBackground(Themes.getMenuSelectedBg());
        activeMenu = (JLabel) lbClicked.getComponent();
       
        for (Component c : selectedFrame.getParent().getComponents()) {
            c.setVisible(false);
        }
        selectedFrame.setVisible(true);

        JLabel jl = (JLabel) lbClicked.getComponent();
        headerTitle.setText(jl.getText().trim());
        
    }

    public static void exited(MouseEvent evt) {
        JPanel exitedPanlel = (JPanel) evt.getComponent().getParent();
        exitedPanlel.setBackground(Themes.getMenuUnselectedBg());
        activeMenu.getParent().setBackground(Themes.getMenuSelectedBg());

        int x = evt.getComponent().getBounds().x -= 2;
        evt.getComponent().setLocation(x, evt.getComponent().getLocation().y);

    }

    public static void setTheme(JPanel leftPanel, JPanel rightPanel, JLabel lbDashboard) {
        leftPanel.setBackground(Themes.getLeftPanelColor());
        for (Component c : leftPanel.getComponents()) {
            c.setBackground(Themes.getLeftPanelColor());
        }

        lbDashboard.getParent().setBackground(Themes.getMenuSelectedBg());

    }

    public static void addCompany() {
        
        AddCompany ac = new AddCompany();
        ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ac.setLocationRelativeTo(null);
        ac.setAlwaysOnTop(true);
        ac.setTitle("Add Company");
        ac.setVisible(true);
    }
 
    public static void companySelect(OnSetCompany onSetCompany) {
        CompanySelector cs = new CompanySelector();
        cs.setTitle("Select Company");
        cs.setLocationRelativeTo(null);
        cs.setListener(onSetCompany);
        cs.setAlwaysOnTop(true);
        cs.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cs.setVisible(true);
    }

    public static void drugSelect(OnSetDrug onSetDrug) {
        
        DrugSelector cs = new DrugSelector();
        cs.setTitle("Select Drug");
        cs.setLocationRelativeTo(null);
        cs.setListener(onSetDrug);
        cs.setAlwaysOnTop(true);
        cs.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cs.setVisible(true);
    }

    static void addDrug() {

        AddDrugs ac = new AddDrugs();
        ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ac.setLocationRelativeTo(null);
        ac.setAlwaysOnTop(true);
        ac.setTitle("Add Drug");
        ac.setVisible(true);
    }

    public static void addCompany(OnSetCompany onSetCompany) {
        AddCompany cs = new AddCompany();
        cs.setTitle("Select Company");
        cs.setLocationRelativeTo(null);
        cs.setListener(onSetCompany);
        cs.setAlwaysOnTop(true);
        cs.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cs.setVisible(true);
    }

    public static void addDrugIn(DrugIn drugin) {
             daoDrugIn.addDrugIn(drugin); 
    }

    public static void AddToInvoice(OnSetDrugIn onSetDrugIn) {
        DrugInventorySelector dinventory = new DrugInventorySelector();
        dinventory.setTitle("Select Drug from inventory");
        dinventory.setListener(onSetDrugIn);
        dinventory.setVisible(true);
    }
 
    public static void removeRows(DefaultTableModel dtm) {
        int count = dtm.getRowCount();
        for (int i = 0; i < count; i++) {
            dtm.removeRow(0);
        }
    }

    static void addDrugOut(DrugIn d, int cid, Date saledate) {        
        daoDrugOut.addDrugOut(d.toDrugOut( cid,  saledate));
    }
    
 
   

}
