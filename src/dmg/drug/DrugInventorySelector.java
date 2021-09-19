/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.drug;

import dmg.drug.OnSetDrug;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DrugInventorySelector extends javax.swing.JFrame {

    DrugInDao ddao = new DrugInDaoImpl();
    DefaultTableModel dtm;
    private OnSetDrugIn onSetDrugIn;
    private List<DrugIn> drugIns;

    public DrugInventorySelector() {
        initComponents();
        setLocationRelativeTo(null);
        this.dtm = (DefaultTableModel) drugTable.getModel();
        reloadDrugTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tfSearchbox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        comboOrderColumn = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboAscDesc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(186, 209, 239));

        drugTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Drug Name", "Buy Price", "Sale Price", "Quantity", "Batch No", "Company Name", "Entry Date", "Expired Date", "Mfg Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drugTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(drugTable);
        if (drugTable.getColumnModel().getColumnCount() > 0) {
            drugTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButton1.setBackground(new java.awt.Color(68, 92, 124));
        jButton1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select");
        jButton1.setMaximumSize(new java.awt.Dimension(120, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(120, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfSearchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSearchboxKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchboxKeyReleased(evt);
            }
        });

        jLabel1.setText("Search");

        jButton2.setBackground(new java.awt.Color(255, 92, 124));
        jButton2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.setMaximumSize(new java.awt.Dimension(120, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(120, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboOrderColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expired Date", "Drug Name", "Company Name", "Quantity" }));
        comboOrderColumn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboOrderColumnItemStateChanged(evt);
            }
        });

        jLabel2.setText("Order By");

        comboAscDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ascending", "descending" }));
        comboAscDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAscDescItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboOrderColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAscDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(comboOrderColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboAscDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DrugIn drugin = drugIns.get(drugTable.getSelectedRow());
        String sQuantity = JOptionPane.showInputDialog("Enter Quantity");
        try{
           int qty = Integer.parseInt(sQuantity);       
       
        if (qty <= drugin.getQuantity()) {
            drugin.setQuantity(qty);
            onSetDrugIn.SetDrugIn(drugin);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Please select less or equal to available quantity");
        }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfSearchboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchboxKeyTyped
      
    }//GEN-LAST:event_tfSearchboxKeyTyped

    private void tfSearchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchboxKeyReleased
  reloadDrugTable();
    }//GEN-LAST:event_tfSearchboxKeyReleased

    private void comboAscDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAscDescItemStateChanged
        reloadDrugTable();
    }//GEN-LAST:event_comboAscDescItemStateChanged

    private void comboOrderColumnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOrderColumnItemStateChanged
        reloadDrugTable();
    }//GEN-LAST:event_comboOrderColumnItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrugInventorySelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrugInventorySelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrugInventorySelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrugInventorySelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrugInventorySelector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAscDesc;
    private javax.swing.JComboBox<String> comboOrderColumn;
    private javax.swing.JTable drugTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfSearchbox;
    // End of variables declaration//GEN-END:variables

    private void reloadDrugTable() {
        String q = tfSearchbox.getText();

        removeRows();
        String orderClause = "order by ";
        switch (comboOrderColumn.getSelectedIndex()) {
            case 0:
                orderClause += "expdate ";
                break;
            case 1:
                orderClause += "drugid ";
                break;
            case 2:
                orderClause += "companyid ";
                break;
            case 3:
                orderClause += "quantity ";
                break;
        }
        if (comboAscDesc.getSelectedIndex() == 1) {
            orderClause += "desc";
        } else {
            orderClause += "asc";
        }

        drugIns = ddao.getDrugInventoryList(q, orderClause);
        drugIns.stream().map((c) -> c.toSelectorModel()).forEachOrdered((rowData) -> {
            dtm.addRow(rowData);
        });

    }

    public void setListener(OnSetDrugIn onSetDrugIn) {
        this.onSetDrugIn = onSetDrugIn;
    }

    private void removeRows() {
        int count = dtm.getRowCount();
        for (int i = 0; i < count; i++) {
            dtm.removeRow(0);
        }
    }

}
