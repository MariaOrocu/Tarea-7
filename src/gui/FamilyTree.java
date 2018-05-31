package gui;

import Business.PersonBusiness;
import Domain.Person;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom.JDOMException;

/**
 *
 * @author Marco
 */
public class FamilyTree extends javax.swing.JFrame {

    private DefaultTableModel modeloDeMiJTable;
    private JTable jTable;
    String n = "";
    String e = "";
    public FamilyTree() {
        super("Family Tree");
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.jTable = new JTable();
        this.modeloDeMiJTable = new DefaultTableModel();
  
        this.modeloDeMiJTable.addColumn("Cédula");
        this.modeloDeMiJTable.addColumn("Nomnbe");
        this.modeloDeMiJTable.addColumn("Primer Apellido");
        this.modeloDeMiJTable.addColumn("Segundo Apellido");
        this.modeloDeMiJTable.addColumn("Edad");
        this.modeloDeMiJTable.addColumn("Nacionalidad");
        this.modeloDeMiJTable.addColumn("Cédula del padre");

        this.jTable.setBounds(10, 150, 800, 300);

        Object[] line = new Object[7];
        line[0] = "Father";
        line[1] = "Son";
        line[2] = "Grandchild";
        line[3] = "Great-grandson";
        line[4] = "Great-grandson";
        line[5] = "...";
        line[6] = "...";
        
        this.modeloDeMiJTable.addRow(line);
        this.jTable.setModel(this.modeloDeMiJTable);
        this.add(this.jTable);
    }

   private void search() {

       if (!this.jtxtAtributo.getText().equals("")) {
            try {
                int cont = 1;
                while (this.modeloDeMiJTable.getRowCount() > 1) {
                    this.modeloDeMiJTable.removeRow(cont);
                }//Fin del while.
            } catch (Exception e) {
            }//Fin del try-catch.
            
            try {
                PersonBusiness pBusiness = new PersonBusiness("Persona.xml");
                Person persona[] = pBusiness.getPerson();
                
                for (int i = 0; i < persona.length; i++) {
                    if (jtxtAtributo.getText().equalsIgnoreCase(persona[i].getFatherId())) {
                        n = persona[i].getName();
                     
                    }
                }
                for (int i = 0; i < persona.length; i++) {
                    if (persona[i].getId().equalsIgnoreCase(this.jtxtAtributo.getText())
                            || persona[i].getName().equalsIgnoreCase(this.jtxtAtributo.getText())) {
                        Object[] linea = new Object[7];
                        linea[0] = persona[i].getName();
                        linea[1] = n;
                  
                        this.modeloDeMiJTable.addRow(linea);
                    }
                }//Fin del for i que recorre todos los videos insertados.
               
            } catch (JDOMException ex) {
            } catch (IOException ex) {
            }//Fin del try-catch-catch.
        }//Si no se escribió nada dentro del campo de texto, no se hará nada.
    }//Fin del método buscar.

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlMember = new javax.swing.JLabel();
        jbRefresh = new javax.swing.JButton();
        jtxtAtributo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlMember.setText("Member");

        jbRefresh.setText("Refresh");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMember, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jtxtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbRefresh)
                .addContainerGap(501, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMember, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRefresh)
                    .addComponent(jtxtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(474, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
search();
    }//GEN-LAST:event_jbRefreshActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FamilyTree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbRefresh;
    private javax.swing.JLabel jlMember;
    private javax.swing.JTextField jtxtAtributo;
    // End of variables declaration//GEN-END:variables
}
