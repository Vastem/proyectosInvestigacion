/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;


import BOs.NegocioFachada;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Entidades.*;
import interfaces.INegocioFachada;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class FrmRegistrarProyecto extends javax.swing.JFrame {
    DefaultListModel modeloListaInt = new DefaultListModel();
    DefaultListModel modeloListaLinea = new DefaultListModel();
    
    INegocioFachada negFac;
    List<ProfesorProyecto> integrantes;
    Proyecto proyecto;
    Programa prog = null;
    
    boolean editar = false;
    
    /**
     * Creates new form frmRegistrarProyecto
     */
    public FrmRegistrarProyecto() {
        initComponents();
        negFac=new NegocioFachada();
        integrantes=new ArrayList();
        proyecto=new Proyecto();
        
        consultarProfesores();
        consultarLineasInvestigacion();
        consultarProgramas();
        
        editar = false;
        
        lstLinInv.setModel(modeloListaLinea);
        lstIntegrantes.setModel(modeloListaInt);
    }
    
    public FrmRegistrarProyecto(Proyecto p){
        this.editar = true;
        initComponents();
        negFac=new NegocioFachada();
        integrantes=new ArrayList();
        proyecto=new Proyecto();
        lstLinInv.setModel(modeloListaLinea);
        lstIntegrantes.setModel(modeloListaInt);
        
        consultarProfesores();
        consultarLineasInvestigacion();
        consultarProgramas();
        
        edicion(p);
    }
    
    public void edicion(Proyecto p){
        rellenarEdicion(p);
        
        rProyecto.setText("Editar proyecto");
        txtCodigo.setEnabled(false);
        btnLimpiar.setVisible(false);
        
    }
    
    public void rellenarEdicion(Proyecto p){
        txtCodigo.setText(p.getCodigo());
        txtPrograma.setText(p.getProgramaInvestigacion().getNombre());
        this.prog = p.getProgramaInvestigacion();
        txtNombreProyecto.setText(p.getNombre());
        txtAcronimo.setText(p.getAcronimo());
        
        for(int e = 0; e < cboInvestigadores.getItemCount(); e++){
            if(cboInvestigadores.getItemAt(e).getNombre().equalsIgnoreCase(p.getInvestigadorPrincipal().getNombre()) &&
               cboInvestigadores.getItemAt(e).getApellidos().equalsIgnoreCase(p.getInvestigadorPrincipal().getApellidos()))
            {
                cboInvestigadores.setSelectedIndex(e);
            }
        }
        
        txtFechaInicio.setDate(convertToLocalDateViaInstant(p.getFechaInicio()));
        txtFechaFin.setDate(convertToLocalDateViaInstant(p.getFechaFin()));
        txtPresupuesto.setText(String.valueOf(p.getPresupuesto()));
        txtDescripcion.setText(p.getDescripcionObjeto());
        
        for(int e = 0; e < p.getLineasInvestigacion().size(); e++){
            modeloListaLinea.addElement(p.getLineasInvestigacion().get(e));
        }
        
        for(int a = 0; a < p.getProfesoresProyecto().size(); a++){
            modeloListaInt.addElement(p.getProfesoresProyecto().get(a).getProfesor());
            integrantes.add(p.getProfesoresProyecto().get(a));
        }
    }
    
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
    
    public void llenarCboInvestigadores(List<Profesor> doctores){
        cboInvestigadores.addItem(new Profesor("Seleccione un doctor",""));
        
        for (Profesor doctor : doctores) {
            cboInvestigadores.addItem(doctor);
        }
    }
    public void consultarProfesores(){
        List<Profesor> listDoctor = negFac.consultarTodosDoc();
        List<Profesor> listProfesor = negFac.consultarTodosNoDoc();
        
        //Llenar el combobox con los doctores que se acaban de consultar
        llenarCboInvestigadores(listDoctor);
        
        List<Profesor> list = new ArrayList();

        list.addAll(listDoctor);
        list.addAll(listProfesor);
        
        DefaultTableModel model = (DefaultTableModel) tblProfesores.getModel();
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
    
    public void consultarLineasInvestigacion(){
        List<LineaInvestigacion> listLinInv = negFac.consultarTodosLinInv();
        
        DefaultTableModel model = (DefaultTableModel) tblLineasInv.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[1];
        for(int i=0; i <listLinInv.size();i++){
            rowData[0]=listLinInv.get(i);
            model.addRow(rowData);
        }
    }
    
    public void consultarProgramas(){
        List<Programa> listPrograma = negFac.consultarTodosProgramas();
        
        DefaultTableModel model = (DefaultTableModel) tblProgInv.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[1];
        for(int i=0; i <listPrograma.size();i++){
            rowData[0]=listPrograma.get(i);
            model.addRow(rowData);
        }
    }
    
    private boolean validarVacio(){
        
        if(txtCodigo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Código vacio");
            return false;
        }
        
        if(txtPrograma.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Programa vacio");
            return false;
        }
        
        //Validar que se ingrese el nombre del proyecto
        if(txtNombreProyecto.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del proyecto");
            return false;
        }
        //Validar que se ingrese el acronimo del proyecto
        if(txtAcronimo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el acrónimo del proyecto");
            return false;
        }
        //Validar que seleccione un investigador principal
        if(cboInvestigadores.getSelectedIndex()<=0){
           JOptionPane.showMessageDialog(this, "Seleccione el investigador principal");
            return false;
        }
        //Validar que se ingrese la fecha de inicio del proyecto
        if(txtFechaInicio.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese la fecha inicial del proyecto");
            return false;
        }
        //Validar que se ingrese la fecha de fin del proyecto
        if(txtFechaFin.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese la fecha final del proyecto");
            return false;
        }
        //Validar que se ingrese el presupuesto del proyecto
        if(txtPresupuesto.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el presupuesto del proyecto");
            return false;
        }
        //Validar que se ingrese la descripción del proyecto
        if(txtDescripcion.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese la descripción del proyecto");
            return false;
        }
        return true;
        
    }
    
    private boolean validarFormatos(){
                
        Calendar fechaInicio= Calendar.getInstance();
        fechaInicio.set(txtFechaInicio.getDate().getYear(), txtFechaInicio.getDate().getMonthValue()-1, txtFechaInicio.getDate().getDayOfMonth(),0,0,0);
        Calendar fechaFin= Calendar.getInstance();
        fechaFin.set(txtFechaFin.getDate().getYear(), txtFechaFin.getDate().getMonthValue()-1, txtFechaFin.getDate().getDayOfMonth(),0,0,0);
        
        
        if(fechaInicio.compareTo(fechaFin)>=0){
            JOptionPane.showMessageDialog(this, "Ingrese un periodo de fechas válido");
            return false;
        }
        if(modeloListaLinea.getSize()<1){
            JOptionPane.showMessageDialog(this, "Agregue al menos una línea de investigación");
            return false;
        }
        
        if(modeloListaInt.getSize()<2){
            JOptionPane.showMessageDialog(this, "Debe haber al menos 2 integrantes");
            return false;
        }
        
        return true;
        
        
    }
    
    private boolean validarFechasIntegrantes(){
                
        Calendar fechaInicio= Calendar.getInstance();
        fechaInicio.set(txtFechaInicioInt.getDate().getYear(), txtFechaInicioInt.getDate().getMonthValue()-1, txtFechaInicioInt.getDate().getDayOfMonth(),0,0,0);
        Calendar fechaFin= Calendar.getInstance();
        fechaFin.set(txtFechaFinInt.getDate().getYear(), txtFechaFinInt.getDate().getMonthValue()-1, txtFechaFinInt.getDate().getDayOfMonth(),0,0,0);
        
        return fechaInicio.compareTo(fechaFin)<0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLineasInv = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProgInv = new javax.swing.JTable();
        txtNombreProyecto = new javax.swing.JTextField();
        txtAcronimo = new javax.swing.JTextField();
        txtPresupuesto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstIntegrantes = new javax.swing.JList<>();
        btnAgregarIntegrante = new javax.swing.JButton();
        btnEliminarIntegrante = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProfesores = new javax.swing.JTable();
        txtPrograma = new javax.swing.JTextField();
        btnAgregarLinea = new javax.swing.JButton();
        btnEliminarLinea = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstLinInv = new javax.swing.JList<>();
        cboInvestigadores = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFechaFinInt = new com.github.lgooddatepicker.components.DatePicker();
        txtFechaFin = new com.github.lgooddatepicker.components.DatePicker();
        txtFechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        txtFechaInicioInt = new com.github.lgooddatepicker.components.DatePicker();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        botonVolver2 = new javax.swing.JButton();
        rProyecto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblLineasInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lineas de investigación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLineasInv);

        tblProgInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Programa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProgInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProgInvMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblProgInv);

        txtNombreProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProyectoKeyTyped(evt);
            }
        });

        txtAcronimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcronimoActionPerformed(evt);
            }
        });
        txtAcronimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcronimoKeyTyped(evt);
            }
        });

        txtPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresupuestoActionPerformed(evt);
            }
        });
        txtPresupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresupuestoKeyTyped(evt);
            }
        });

        jLabel1.setText("Programa de investigación");
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel3.setText("Nombre del proyecto");
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel4.setText("Acrónimo del proyecto");
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel5.setText("Fecha inicio");
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel6.setText("Fecha fin");
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel7.setText("Presupuesto");
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel8.setText("Descripción");
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane4.setViewportView(txtDescripcion);

        lstIntegrantes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstIntegrantes.setEnabled(false);
        jScrollPane5.setViewportView(lstIntegrantes);

        btnAgregarIntegrante.setText("Agregar Integrante");
        btnAgregarIntegrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIntegranteActionPerformed(evt);
            }
        });

        btnEliminarIntegrante.setText("Eliminar Integrante");
        btnEliminarIntegrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIntegranteActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profesor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProfesores);

        txtPrograma.setEditable(false);
        txtPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProgramaActionPerformed(evt);
            }
        });

        btnAgregarLinea.setText("Agregar Linea");
        btnAgregarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLineaActionPerformed(evt);
            }
        });

        btnEliminarLinea.setText("Eliminar Linea");
        btnEliminarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLineaActionPerformed(evt);
            }
        });

        lstLinInv.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstLinInv.setEnabled(false);
        jScrollPane7.setViewportView(lstLinInv);

        cboInvestigadores.setModel(new javax.swing.DefaultComboBoxModel<>());

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel2.setText("Código del proyecto");
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel11.setText("Investigador principal");
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel13.setText("Fecha inicio");
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel14.setText("Fecha fin");
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        botonVolver2.setText("Volver");
        botonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolver2ActionPerformed(evt);
            }
        });

        rProyecto.setText("Registrar Proyecto");
        rProyecto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaFinInt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(344, 344, 344)
                                        .addComponent(txtFechaInicioInt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(317, 317, 317)
                                        .addComponent(jLabel14))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAcronimo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cboInvestigadores, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarLinea)
                                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEliminarLinea))))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(293, 293, 293)
                        .addComponent(btnAgregarIntegrante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarIntegrante)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rProyecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver2)
                    .addComponent(rProyecto))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAcronimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cboInvestigadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarLinea)
                            .addComponent(btnAgregarLinea)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(4, 4, 4)
                                .addComponent(txtFechaInicioInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(txtFechaFinInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarIntegrante)
                            .addComponent(btnEliminarIntegrante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAcronimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcronimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcronimoActionPerformed

    private void txtPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresupuestoActionPerformed

    private void btnEliminarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntegranteActionPerformed
        if(tblProfesores.getSelectedRow()!=-1){
            int fila= tblProfesores.getSelectedRow();
            Profesor valor=(Profesor) tblProfesores.getValueAt(fila,0);
            borrarElementoListaInt(valor);
        }else JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún profesor");
    }//GEN-LAST:event_btnEliminarIntegranteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(validarVacio() && validarFormatos()){
            if(editar==false){
                List<LineaInvestigacion> ListaLineaInv=new ArrayList();
            
                for(int i = 0; i < modeloListaLinea.getSize(); i++){
                    ListaLineaInv.add((LineaInvestigacion) modeloListaLinea.get(i));
                }

                Calendar fechaInicio= Calendar.getInstance();
                fechaInicio.set(txtFechaInicio.getDate().getYear(), txtFechaInicio.getDate().getMonthValue()-1, txtFechaInicio.getDate().getDayOfMonth(),0,0,0);
                Calendar fechaFin= Calendar.getInstance();
                fechaFin.set(txtFechaFin.getDate().getYear(), txtFechaFin.getDate().getMonthValue()-1, txtFechaFin.getDate().getDayOfMonth(),0,0,0);

                proyecto.setCodigo(txtCodigo.getText());
                proyecto.setNombre(txtNombreProyecto.getText());
                proyecto.setAcronimo(txtAcronimo.getText());
                proyecto.setPresupuesto(Float.parseFloat(txtPresupuesto.getText()));
                proyecto.setProgramaInvestigacion((Programa) tblProgInv.getValueAt(tblProgInv.getSelectedRow(), 0));
                proyecto.setFechaInicio(fechaInicio.getTime());
                proyecto.setFechaFin(fechaFin.getTime());
                proyecto.setDescripcionObjeto(txtDescripcion.getText());
                proyecto.setProfesoresProyecto(integrantes);
                proyecto.setInvestigadorPrincipal((Doctor) cboInvestigadores.getSelectedItem());
                System.out.println(ListaLineaInv.get(0).getCodigo());
                proyecto.setLineasInvestigacion(ListaLineaInv);

                negFac.agregarProyecto(proyecto);
                btnLimpiarActionPerformed(evt);
            }
            else{
                List<LineaInvestigacion> ListaLineaInv=new ArrayList();
            
                for(int i = 0; i < modeloListaLinea.getSize(); i++){
                    ListaLineaInv.add((LineaInvestigacion) modeloListaLinea.get(i));
                }
                
                

                Calendar fechaInicio= Calendar.getInstance();
                fechaInicio.set(txtFechaInicio.getDate().getYear(), txtFechaInicio.getDate().getMonthValue()-1, txtFechaInicio.getDate().getDayOfMonth(),0,0,0);
                Calendar fechaFin= Calendar.getInstance();
                fechaFin.set(txtFechaFin.getDate().getYear(), txtFechaFin.getDate().getMonthValue()-1, txtFechaFin.getDate().getDayOfMonth(),0,0,0);

                proyecto.setCodigo(txtCodigo.getText());
                proyecto.setNombre(txtNombreProyecto.getText());
                proyecto.setAcronimo(txtAcronimo.getText());
                proyecto.setPresupuesto(Float.parseFloat(txtPresupuesto.getText()));

                if(tblProgInv.getSelectedRow() == -1){
                    proyecto.setProgramaInvestigacion(this.prog);
                }
                else{
                    proyecto.setProgramaInvestigacion((Programa) tblProgInv.getValueAt(tblProgInv.getSelectedRow(), 0));
                }
                proyecto.setFechaInicio(fechaInicio.getTime());
                proyecto.setFechaFin(fechaFin.getTime());
                proyecto.setDescripcionObjeto(txtDescripcion.getText());
                proyecto.setProfesoresProyecto(integrantes);
                proyecto.setInvestigadorPrincipal((Doctor) cboInvestigadores.getSelectedItem());
                System.out.println(ListaLineaInv.get(0).getCodigo());
                proyecto.setLineasInvestigacion(ListaLineaInv);

                if(JOptionPane.showOptionDialog(null, "¿Quieres actualizar el proyecto?", "actualizar proyecto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si","No"}, "Actualizar")==0){
                    negFac.actualizarProyecto(proyecto);
                }
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Pasar los txt a variables
        txtCodigo.setText("");
        txtPrograma.setText("");
        txtNombreProyecto.setText("");
        txtAcronimo.setText("");
        cboInvestigadores.setSelectedIndex(0);
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        txtPresupuesto.setText("");
        txtDescripcion.setText("");
        modeloListaLinea.clear();
        modeloListaInt.clear();
        tblLineasInv.clearSelection();
        tblProfesores.clearSelection();
        tblProgInv.clearSelection();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void borrarElementoListaInt(Profesor valor){
        if(modeloListaInt.contains(valor)){
            modeloListaInt.removeElement(valor);
            integrantes.remove(new ProfesorProyecto(valor));
            return;
        }
         
        for(int e = 0; e < modeloListaInt.getSize(); e++){
            Profesor prof = (Profesor) modeloListaInt.get(e);
            if(prof.getNombre().equalsIgnoreCase(valor.getNombre()) && prof.getApellidos().equalsIgnoreCase(valor.getApellidos())){
                modeloListaInt.remove(e);
                for(int i = 0; i < integrantes.size(); i++){
                    if(integrantes.get(i).getProfesor().getNombre().equalsIgnoreCase(prof.getNombre()) && integrantes.get(i).getProfesor().getApellidos().equalsIgnoreCase(prof.getApellidos())){
                        integrantes.remove(i);
                    }
                }
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "El profesor seleccionado NO está en la lista de integrantes");
    }
    
    private boolean agregarElementoListaIntegrantes(Profesor v){  
        if(modeloListaInt.contains(v)){
            JOptionPane.showMessageDialog(this, "El profesor seleccionado ya esta en la lista");
            return false;
        }
        
        //Agregar profesorProyecto a la lista
        Calendar fechaInicio= Calendar.getInstance();
        fechaInicio.set(txtFechaInicioInt.getDate().getYear(), txtFechaInicioInt.getDate().getMonthValue()-1, txtFechaInicioInt.getDate().getDayOfMonth(),0,0,0);
        Calendar fechaFin= Calendar.getInstance();
        fechaFin.set(txtFechaFinInt.getDate().getYear(), txtFechaFinInt.getDate().getMonthValue()-1, txtFechaFinInt.getDate().getDayOfMonth(),0,0,0);
        
        ProfesorProyecto profProy = new ProfesorProyecto(v,fechaInicio.getTime() , fechaFin.getTime());
        
        modeloListaInt.addElement(v);
        integrantes.add(profProy);
        
        txtFechaInicioInt.setText("");
        txtFechaFinInt.setText("");
        
        return true;
    }
    
    private void btnAgregarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntegranteActionPerformed
        if(tblProfesores.getSelectedRow()!=-1){
            if(txtFechaInicioInt.getText().isEmpty() || txtFechaFinInt.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "No se ha seleccionado la fecha para el integrante");
                return;
            }
            if(!validarFechasIntegrantes()){
                JOptionPane.showMessageDialog(this, "Ingrese un rango de fechas válido");
                return;
            }
            int fila= tblProfesores.getSelectedRow();
            
            //Agregar y mostrar elemento a la lista de integrantes
            Profesor v = (Profesor) tblProfesores.getValueAt(fila,0);

            agregarElementoListaIntegrantes(v);
            
        }else JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún profesor");
        
    }//GEN-LAST:event_btnAgregarIntegranteActionPerformed

    private void txtNombreProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProyectoKeyTyped
        if(!Character.isLetter(evt.getKeyChar()))
            if(evt.getKeyChar()!=KeyEvent.VK_SPACE)
                evt.consume();
    }//GEN-LAST:event_txtNombreProyectoKeyTyped

    private void txtAcronimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcronimoKeyTyped
        if(!Character.isLetter(evt.getKeyChar()))
            if(!Character.isDigit(evt.getKeyChar()))
                evt.consume();
        
    }//GEN-LAST:event_txtAcronimoKeyTyped

    private void txtPresupuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresupuestoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_txtPresupuestoKeyTyped

    private void txtProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProgramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProgramaActionPerformed

    private void borrarElementoListaLinea(LineaInvestigacion valor){
        if(modeloListaLinea.contains(valor)){
           modeloListaLinea.removeElement(valor);
            return;
        }
         
        for(int e = 0; e < modeloListaLinea.getSize(); e++){
            LineaInvestigacion lin = (LineaInvestigacion) modeloListaLinea.get(e);
            if(lin.getCodigo().equalsIgnoreCase(valor.getCodigo())){
                modeloListaLinea.remove(e);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "La línea de investigación seleccionada NO está en la lista");
    }
    
    private boolean agregarElementoListaLinea(LineaInvestigacion linea){  
        if(modeloListaLinea.contains(linea)){
            JOptionPane.showMessageDialog(this, "La línea de investigación seleccionada ya está en la lista");
            return false;
        }
        modeloListaLinea.addElement(linea);
        return true;
    }
    
    private void btnAgregarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLineaActionPerformed
        if(tblLineasInv.getSelectedRow()!=-1){
            int fila= tblLineasInv.getSelectedRow();
            
            LineaInvestigacion linea = (LineaInvestigacion) tblLineasInv.getValueAt(fila,0);
            agregarElementoListaLinea(linea);
        }else 
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna Linea de Investigación");
    }//GEN-LAST:event_btnAgregarLineaActionPerformed

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLineaActionPerformed
        if(tblLineasInv.getSelectedRow()!=-1){
            int fila= tblLineasInv.getSelectedRow();
            LineaInvestigacion linea = (LineaInvestigacion) tblLineasInv.getValueAt(fila,0);
            borrarElementoListaLinea(linea);
        }else
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna Linea de Investigación");
    }//GEN-LAST:event_btnEliminarLineaActionPerformed

    private void tblProgInvMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProgInvMouseReleased
        if(tblProgInv.getSelectedRow()!=-1){
            int fila=tblProgInv.getSelectedRow();
            txtPrograma.setText(tblProgInv.getValueAt(fila, 0).toString());
        }
    }//GEN-LAST:event_tblProgInvMouseReleased

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void botonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolver2ActionPerformed
        if(editar == true){
            dispose(); 
        }else{
            FrmMenu menu = new FrmMenu();
            menu.setVisible(true);
            dispose(); 
        }
        
       
    }//GEN-LAST:event_botonVolver2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistrarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver2;
    private javax.swing.JButton btnAgregarIntegrante;
    private javax.swing.JButton btnAgregarLinea;
    private javax.swing.JButton btnEliminarIntegrante;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    /*
    private javax.swing.JComboBox<String> cboInvestigadores;
    */
    private javax.swing.JComboBox<Profesor> cboInvestigadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> lstIntegrantes;
    private javax.swing.JList<String> lstLinInv;
    private javax.swing.JLabel rProyecto;
    private javax.swing.JTable tblLineasInv;
    private javax.swing.JTable tblProfesores;
    private javax.swing.JTable tblProgInv;
    private javax.swing.JTextField txtAcronimo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private com.github.lgooddatepicker.components.DatePicker txtFechaFin;
    private com.github.lgooddatepicker.components.DatePicker txtFechaFinInt;
    private com.github.lgooddatepicker.components.DatePicker txtFechaInicio;
    private com.github.lgooddatepicker.components.DatePicker txtFechaInicioInt;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtPresupuesto;
    private javax.swing.JTextField txtPrograma;
    // End of variables declaration//GEN-END:variables
}
