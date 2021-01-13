package clases;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class registroAlumnos extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        Connection conectar = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }

    public void formatearTxt() {
        txtApellidoMaterno.setText(null);
        txtApellidoPaterno.setText(null);
        txtNombre.setText(null);
        txtNumControl.setText(null);
        txtSemestre.setText(null);
        txtSexo.setText(null);
        txtFechaNac.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtCorreo1.setText(null);
    }

    public registroAlumnos() {
        initComponents();
        btnGenerarReporte.setBackground(new Color(0, 102, 102));
        this.setLocationRelativeTo(null);
        MostrarTabla();
    }

    public void MostrarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaRegistros.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            getConection();
            String sql = "SELECT numcontrol_alumno,nombre_alumno,apellidop_alumno,apellidom_alumno,semestre_alumno,fechanac_alumno,correo_alumno,telefono_alumno,sexo_alumno,direccion_alumno FROM alumnos";
            ps = getConection().prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCoulumnas = rsMd.getColumnCount();

            modelo.addColumn("N. Control");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Semestre");
            modelo.addColumn("Fecha Nacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Sexo");
            modelo.addColumn("Dirección");

            while (rs.next()) {
                Object[] filas = new Object[cantidadCoulumnas];
                for (int i = 0; i < cantidadCoulumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNumControl = new javax.swing.JTextField();
        btnGenerarReporte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSemestre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();
        btnRegistrar1 = new javax.swing.JButton();
        txtCorreo1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtBuscarNum = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtNumControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 300, -1));

        btnGenerarReporte.setBackground(new java.awt.Color(0, 102, 102));
        btnGenerarReporte.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 120, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Numero de Control:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, -1));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Apellido Paterno:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, -1));
        jPanel1.add(txtSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 300, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Semestre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Sexo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, -1));
        jPanel1.add(txtSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 300, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Correo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 300, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Dirección:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 120, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 300, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Teléfono:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 120, -1));
        jPanel1.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 300, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 120, -1));
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 300, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Apellido Materno");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 120, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 300, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Nombre:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 120, -1));

        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N. Control", "Nombre", "Apellido Paterno", "Apellido Materno", "Semestre", "Fecha Nacimiento", "Correo", "Teléfono", "Sexo", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaRegistros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 690, 120));

        btnRegistrar1.setBackground(new java.awt.Color(0, 102, 102));
        btnRegistrar1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar1.setText("Registrar");
        btnRegistrar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegistrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 110, 30));
        jPanel1.add(txtCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 300, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Alumnos Registrados");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, -1));

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));
        jPanel1.add(txtBuscarNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Numero de Control:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, -1));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro Alumnos");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Instituto Tecnológico Superior de El Mante");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        // TODO add your handling code here:
        Connection conectar = null;

        try {
            conectar = getConection();
            ps = conectar.prepareStatement("INSERT INTO alumnos (numcontrol_alumno,nombre_alumno,apellidop_alumno,apellidom_alumno,semestre_alumno,fechanac_alumno,correo_alumno,telefono_alumno,sexo_alumno,direccion_alumno) VALUES (?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, txtNumControl.getText());
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtApellidoPaterno.getText());
            ps.setString(4, txtApellidoMaterno.getText());
            ps.setInt(5, Integer.parseInt(txtSemestre.getText()));
            ps.setString(6, txtFechaNac.getText());
            ps.setString(7, txtCorreo1.getText());
            ps.setString(8, txtTelefono.getText());
            ps.setString(9, txtSexo.getText());
            ps.setString(10, txtDireccion.getText());

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Alumno registrado correctamente");
                MostrarTabla();
                formatearTxt();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
            conectar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnRegistrar1ActionPerformed


    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

        try {
            conectar con = new conectar();
            Connection conn = con.conexion();

            JasperReport reporte = null;

            String path = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Generacion_De_Reportes\\src\\reportes\\ReporteAlumnos.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(registroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        try {

            con = getConection();
            String sqlC = "SELECT * FROM alumnos WHERE numcontrol_alumno = ?";
            ps.setString(1, txtBuscarNum.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                txtNumControl.setText(rs.getNString("numcontrol_alumno"));
            }else{
            JOptionPane.showMessageDialog(null, "No existe ese numero de control");
            }

        } catch (Exception e) {
            System.err.println(e);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    conectar cc = new conectar();
    Connection cn = cc.conexion();

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRegistros;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscarNum;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumControl;
    private javax.swing.JTextField txtSemestre;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
