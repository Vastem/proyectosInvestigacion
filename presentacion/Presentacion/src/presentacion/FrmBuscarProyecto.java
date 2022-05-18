/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import BOs.NegocioFachada;
import Entidades.LineaInvestigacion;
import Entidades.Programa;
import Entidades.Proyecto;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vastem.
 */
public class FrmBuscarProyecto extends javax.swing.JFrame {
    NegocioFachada negFac;
    DefaultTableModel modeloProg;
    DefaultTableModel modeloProy;
    
    /**
     * Creates new form PantallaProyectos
     */
    public FrmBuscarProyecto() {
        initComponents();
        negFac=new NegocioFachada();
        dateInicio.setEnabled(false);
        dateFinal.setEnabled(false);
        txtCampoBuscar.setVisible(true);
        setModeloProyecto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCampoBuscar = new javax.swing.JTextField();
        fInicio = new javax.swing.JLabel();
        fFinal = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        proyecto = new javax.swing.JLabel();
        opcionComboBox = new javax.swing.JComboBox<>();
        dateInicio = new com.github.lgooddatepicker.components.DatePicker();
        dateFinal = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar proyecto");
        setResizable(false);

        jLabel1.setText("Buscar Proyecto");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        fInicio.setText("Fecha inicio:");
        fInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        fFinal.setText("Fecha finalización:");
        fFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botonBuscar.setText("Buscar");
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Acrónimo ", "Programa", "Fecha inicio", "Fecha fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tbl);

        proyecto.setText("Proyectos");
        proyecto.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N

        opcionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Acronimo", "Programa de Investigacion", "Periodo", "Todos" }));
        opcionComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opcionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionComboBoxActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(693, 693, 693)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonVolver))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(opcionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(fInicio)
                .addGap(166, 166, 166)
                .addComponent(fFinal))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtCampoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(dateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(proyecto))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(botonVolver)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fInicio)
                            .addComponent(fFinal))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtCampoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(proyecto)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setModeloProyecto(){
        tbl.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"Código", "Nombre", "Acrónimo ", "Programa", "Fecha inicio", "Fecha fin"}
        ) {boolean[] canEdit = new boolean [] {false, false, false, false, false, false};public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex]; }});
        tbl.setRowSelectionAllowed(true);
    }
    
    private void setModeloPrograma(){
        tbl.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"Nombre"}) 
        {boolean[] canEdit = new boolean [] {false};public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex]; }});
        tbl.setRowSelectionAllowed(true);
    }
    
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(validarVacio() && validarFormatos()){
            setTablaProyectos();
        }
        if(opcionComboBox.getSelectedItem()== "Programa de Investigacion"){
            botonBuscar.setEnabled(false);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private boolean validarVacio(){
        
        if(opcionComboBox.getSelectedItem()== "Codigo"){
            if(txtCampoBuscar.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Texto vacio");
            return false;
            }
        }
        else if(opcionComboBox.getSelectedItem()== "Nombre"){
            if(txtCampoBuscar.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Texto vacio");
            return false;
            }
        }
        else if(opcionComboBox.getSelectedItem()== "Acronimo"){
            if(txtCampoBuscar.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Texto vacio");
            return false;
            }
        }
        else if(opcionComboBox.getSelectedItem()=="Periodo"){
            if(dateInicio.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese la fecha inicial del proyecto");
            return false;
            }
            //Validar que se ingrese la fecha de fin del proyecto
            if(dateFinal.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese la fecha final del proyecto");
                return false;
            }
        }

        return true;
    }
    
    private boolean validarFormatos(){
        if(opcionComboBox.getSelectedItem()== "Periodo"){
            Calendar fechaInicio= Calendar.getInstance();
            fechaInicio.set(dateInicio.getDate().getYear(), dateInicio.getDate().getMonthValue()-1, dateInicio.getDate().getDayOfMonth(),0,0,0);
            Calendar fechaFin= Calendar.getInstance();
            fechaFin.set(dateFinal.getDate().getYear(), dateFinal.getDate().getMonthValue()-1, dateFinal.getDate().getDayOfMonth(),0,0,0);
            
            if(fechaInicio.compareTo(fechaFin)>=0){
                JOptionPane.showMessageDialog(this, "Ingrese un periodo de fechas válido");
                return false;
            }
        }
        
        if(opcionComboBox.getSelectedItem()== "Codigo"){
            if(negFac.consultarProyectoCodigo(txtCampoBuscar.getText()) != null){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "No se encontró el proyecto");
                return false;
            }
        }
        
        if(opcionComboBox.getSelectedItem()== "Nombre"){
            if(negFac.consultarProyectoNombre(txtCampoBuscar.getText()) != null){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "No se encontró el proyecto");
                return false;
            }
        }
        
        if(opcionComboBox.getSelectedItem()== "Acronimo"){
            if(negFac.consultarProyectoAcronimo(txtCampoBuscar.getText()) != null){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "No se encontró el proyecto");
                return false;
            }
        }

        return true;
    }
    
    private void opcionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionComboBoxActionPerformed
        /*
        Codigo
        Nombre
        Acronimo
        Programa de Investigacion
        */
        
        if(opcionComboBox.getSelectedItem()== "Codigo"){
            proyecto.setText("Proyectos");
            txtCampoBuscar.setText("");
            dateInicio.setEnabled(false);
            dateFinal.setEnabled(false);
            txtCampoBuscar.setVisible(true);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            setModeloProyecto();
            clear();
        }
        if(opcionComboBox.getSelectedItem()== "Nombre"){
            proyecto.setText("Proyectos");
            txtCampoBuscar.setText("");
            dateInicio.setEnabled(false);
            dateFinal.setEnabled(false);
            txtCampoBuscar.setVisible(true);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            setModeloProyecto();
            clear();
        }
        if(opcionComboBox.getSelectedItem()== "Acronimo"){
            proyecto.setText("Proyectos");
            txtCampoBuscar.setText("");
            dateInicio.setEnabled(false);
            dateFinal.setEnabled(false);
            txtCampoBuscar.setVisible(true);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            setModeloProyecto();
            clear();
        }
        if(opcionComboBox.getSelectedItem()== "Programa de Investigacion"){
            proyecto.setText("Programas de Investigación");
            dateInicio.setEnabled(false);
            dateFinal.setEnabled(false);
            txtCampoBuscar.setVisible(false);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            setModeloPrograma();
            setTablaProgramas();
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
        if(opcionComboBox.getSelectedItem()== "Periodo"){
            proyecto.setText("Proyectos");
            dateInicio.setEnabled(true);
            dateFinal.setEnabled(true);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtCampoBuscar.setVisible(false);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            setModeloProyecto();
            clear();
        }
        if(opcionComboBox.getSelectedItem()== "Todos"){
            proyecto.setText("Proyectos");
            dateInicio.setEnabled(false);
            dateFinal.setEnabled(false);
            txtCampoBuscar.setVisible(false);
            botonBuscar.setEnabled(true);
            dateInicio.clear();
            dateFinal.clear();
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            setModeloProyecto();
            clear();
            setTablaProyectos();
        }
    }//GEN-LAST:event_opcionComboBoxActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tbl.getSelectedRow()>= 0){
            
            String cdg = (String) tbl.getValueAt(tbl.getSelectedRow(),0);
            Proyecto p;
            ArrayList l = (ArrayList) negFac.consultarProyectoCodigo(cdg);
            
            p = (Proyecto) l.get(0);
            FrmRegistrarProyecto edicion=new FrmRegistrarProyecto(p);
            edicion.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccionar proyecto");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tbl.getSelectedRow()>= 0){
            
            String cdg = (String) tbl.getValueAt(tbl.getSelectedRow(),0);
            Proyecto p;
            ArrayList l = (ArrayList) negFac.consultarProyectoCodigo(cdg);
            
            p = (Proyecto) l.get(0);
            
            if(JOptionPane.showOptionDialog(null, "¿Quieres eliminar el proyecto?", "eliminar proyecto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si","No"}, "Eliminar")==0){
                negFac.eliminarProyecto(p);
            }
            
            List<Proyecto> list = negFac.consultarTodosProyectos();
            actualizarTabla(list);
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccionar proyecto");
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void setTablaProgramas(){
        List<Programa> list = negFac.consultarTodosProgramas();
        
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[1];
        for(int i=0; i <list.size();i++){
            rowData[0]=list.get(i);
            model.addRow(rowData);
        }
    }
    
    public void setTablaProyectos(){
        List<Proyecto> list = null;
        
        switch(opcionComboBox.getSelectedIndex()){
            case 0:
                list = negFac.consultarProyectoCodigo(txtCampoBuscar.getText());
                break;
            case 1:
                list = negFac.consultarProyectoNombre(txtCampoBuscar.getText());
                break;
            case 2:
                list = negFac.consultarProyectoAcronimo(txtCampoBuscar.getText());
                break;
            case 3:
                int fila= tbl.getSelectedRow();
                Programa v = (Programa) tbl.getValueAt(fila,0);
                clear();
                
                setModeloProyecto();
                list = negFac.consultarProyectoPrograma(v.getNombre());
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
                break;
            case 4:
                Calendar fechaInicio= Calendar.getInstance();
                fechaInicio.set(dateInicio.getDate().getYear(), dateInicio.getDate().getMonthValue()-1, dateInicio.getDate().getDayOfMonth()-1,0,0,0);
                Calendar fechaFin= Calendar.getInstance();
                fechaFin.set(dateFinal.getDate().getYear(), dateFinal.getDate().getMonthValue()-1, dateFinal.getDate().getDayOfMonth(),0,0,0);

                list = negFac.consultarFechas(fechaInicio.getTime(), fechaFin.getTime());
                break;
            case 5:
                list = negFac.consultarTodosProyectos();
                break;
        }

        if(list == null){
            JOptionPane.showMessageDialog(this, "No se ha encontrado nada");
            return;
        }
        
        actualizarTabla(list);
    }
    
    public void actualizarTabla(List<Proyecto> list){
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[6];
        for(int i=0; i <list.size();i++){
            rowData[0]=list.get(i).getCodigo();
            rowData[1]=list.get(i).getNombre();
            rowData[2]=list.get(i).getAcronimo();
            rowData[3]=list.get(i).getProgramaInvestigacion().getNombre();
            rowData[4]=list.get(i).getFechaInicio().toLocaleString();
            rowData[5]=list.get(i).getFechaFin().toLocaleString();
            model.addRow(rowData);
        }
    }
    
    public void clear(){
        proyecto.setText("Proyectos");
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
    }
    
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
            java.util.logging.Logger.getLogger(FrmRegistrarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private com.github.lgooddatepicker.components.DatePicker dateFinal;
    private com.github.lgooddatepicker.components.DatePicker dateInicio;
    private javax.swing.JLabel fFinal;
    private javax.swing.JLabel fInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> opcionComboBox;
    private javax.swing.JLabel proyecto;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtCampoBuscar;
    // End of variables declaration//GEN-END:variables
}
