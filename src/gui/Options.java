package gui;

import Business.PersonBusiness;
import Domain.Person;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom.JDOMException;

/**
 *
 * @author Marco
 */
public class Options extends javax.swing.JFrame {

    private final JTable jTable;
    private final DefaultTableModel modeloDeMiJTable;

    public Options() {
        initComponents();
        this.setLocationRelativeTo(null);
        //**********CREACION DEL JTABLE**********
        this.jTable = new JTable();
        this.modeloDeMiJTable = new DefaultTableModel();

        this.modeloDeMiJTable.addColumn("Cédula");
        this.modeloDeMiJTable.addColumn("Nombre");
        this.modeloDeMiJTable.addColumn("Primer Apellido");
        this.modeloDeMiJTable.addColumn("Segundo Apellido");
        this.modeloDeMiJTable.addColumn("Años");
        this.modeloDeMiJTable.addColumn("Pais");
        this.modeloDeMiJTable.addColumn("Cédula del Padre");

        this.jTable.setBounds(10, 200, 900, 200);
        Object[] linea = new Object[7];
        linea[0] = "Cedula";
        linea[1] = "Nombre";
        linea[2] = "Primer Apellido";
        linea[3] = "Segundo Apellido";
        linea[4] = "Años";
        linea[5] = "Pais";
        linea[6] = "Cedula del Padre";

        this.modeloDeMiJTable.addRow(linea);
        this.jTable.setModel(this.modeloDeMiJTable);
        this.add(this.jTable);

        jtxtCedula.setEditable(false);
        jtxtNombre.setEditable(false);
        jtxtPrimerApellido.setEditable(false);
        jtxtSegundoApellido.setEditable(false);
        jtxtFecha.setEditable(false);
        jtxtPais.setEditable(false);
        jtxtCedulaPadre.setEditable(false);
    }

    private void eliminarPersona() {
        if (this.jTable.getSelectedRows().length > 0) {
            try {
                PersonBusiness pBusiness = new PersonBusiness("Persona.xml");
                int filaSeleccionada = this.jTable.getSelectedRow();
                String nombreSeleccionado = this.modeloDeMiJTable.getValueAt(filaSeleccionada, 0).toString();
                pBusiness.deletePerson(nombreSeleccionado);
                this.modeloDeMiJTable.removeRow(filaSeleccionada);
            } catch (JDOMException ex) {
            } catch (IOException ex) {
            }//Fin del try-catch-catch.
        }//Si no se escribió nada dentro del campo de texto, no se hará nada.
    }//Fin del método eliminarPersona.

    private void buscar() {
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
                    if (persona[i].getId().equalsIgnoreCase(this.jtxtAtributo.getText())
                            || persona[i].getName().equalsIgnoreCase(this.jtxtAtributo.getText())) {
                        Object[] linea = new Object[7];
                        linea[0] = persona[i].getId();
                        linea[1] = persona[i].getName();
                        linea[2] = persona[i].getFirstSurname();
                        linea[3] = persona[i].getSecondSurname();
                        linea[4] = persona[i].getBirthdate();
                        linea[5] = persona[i].getCountry();
                        linea[6] = persona[i].getFatherId();

                        this.modeloDeMiJTable.addRow(linea);
                    }
                }//Fin del for i que recorre todos los videos insertados.
            } catch (JDOMException ex) {
            } catch (IOException ex) {
            }//Fin del try-catch-catch.
        }//Si no se escribió nada dentro del campo de texto, no se hará nada.
    }//Fin del método buscar.

    private void actualizar() {
        try {
            String nuevaCedula = jtxtCedula.getText();
            String nuevoNombre = jtxtNombre.getText();
            String nuevoPrimerApellido = jtxtPrimerApellido.getText();
            String nuevoSegundoApellido = jtxtSegundoApellido.getText();
            String nuevaFecha = jtxtFecha.getText();
            String nuevoPais = jtxtPais.getText();
            String nuevaCedulaPadre = jtxtCedulaPadre.getText();

            PersonBusiness pBusiness = new PersonBusiness("Persona.xml");
            int filaSeleccionada = this.jTable.getSelectedRow();
            String personaSeleccionada
                    = this.modeloDeMiJTable.getValueAt(filaSeleccionada, 0).toString();
            pBusiness.modifyData(personaSeleccionada,
                    new Person(
                            nuevaCedula,
                            nuevoNombre,
                            nuevoPrimerApellido,
                            nuevoSegundoApellido,
                            nuevaFecha,
                            nuevoPais,
                            nuevaCedulaPadre
                    ));

            this.modeloDeMiJTable.removeRow(filaSeleccionada);
            Object[] linea = new Object[7];
            linea[0] = nuevaCedula;
            linea[1] = nuevoNombre;
            linea[2] = nuevoPrimerApellido;
            linea[3] = nuevoSegundoApellido;
            linea[4] = nuevaFecha;
            linea[5] = nuevoPais;
            linea[6] = nuevaCedulaPadre;
            
            this.modeloDeMiJTable.addRow(linea);
        } catch (Exception e) {
        }//Fin del try-catch.
    }//Fin del método actualizar.

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtxtAtributo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanelInfo = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtPrimerApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtSegundoApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtPais = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtCedulaPadre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Search and select the person");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanelInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Father Id");

        jLabel2.setText("Update Person");

        jLabel3.setText("Id");

        jLabel4.setText("Name");

        jLabel5.setText("First Surname");

        jLabel6.setText("Second Surname");

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Birthday");

        jLabel9.setText("Country");

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelInfoLayout.createSequentialGroup()
                            .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtCedula)
                                .addComponent(jtxtNombre)
                                .addComponent(jtxtPrimerApellido)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jtxtSegundoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInfoLayout.createSequentialGroup()
                            .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtxtPais)
                                .addComponent(jtxtCedulaPadre)
                                .addComponent(jtxtFecha, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCedulaPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminarPersona();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jtxtCedula.setEditable(true);
        jtxtNombre.setEditable(true);
        jtxtPrimerApellido.setEditable(true);
        jtxtSegundoApellido.setEditable(true);
        jtxtFecha.setEditable(true);
        jtxtPais.setEditable(true);
        jtxtCedulaPadre.setEditable(true);
        jPanelInfo.setBackground(Color.gray);
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     actualizar();
    }//GEN-LAST:event_jButton4ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Options().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JTextField jtxtAtributo;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCedulaPadre;
    private javax.swing.JTextField jtxtFecha;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPais;
    private javax.swing.JTextField jtxtPrimerApellido;
    private javax.swing.JTextField jtxtSegundoApellido;
    // End of variables declaration//GEN-END:variables
}
