/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import BOs.FabricaBOs;
import BOs.ProyectoBO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Entidades.*;
import interfaces.IDoctorBO;
import interfaces.ILineaInvestigacionBO;
import interfaces.INoDoctorBO;
import interfaces.IProgramaBO;
import interfaces.IProyectoBO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class FrmRegistrarProyecto extends javax.swing.JFrame {
    DefaultListModel modeloListaInt = new DefaultListModel();
    DefaultListModel modeloListaLinea = new DefaultListModel();
    
    IProyectoBO proyectoBO ;
    IDoctorBO doctorBO;
    INoDoctorBO noDoctorBO;
    ILineaInvestigacionBO lineaInvBO;
    IProgramaBO programaBO; 
    
    /**
     * Creates new form frmRegistrarProyecto
     */
    public FrmRegistrarProyecto() {
        initComponents();
        proyectoBO=FabricaBOs.createProyectoBO();
        doctorBO=FabricaBOs.createDoctorBO();
        noDoctorBO=FabricaBOs.createNoDoctorBO();
        programaBO=FabricaBOs.createProgramaBO();
        lineaInvBO=FabricaBOs.createLineaInvBO();
        
        
        
        consultarProfesores();
        consultarLineasInvestigacion();
        consultarProgramas();
        
        
        lstLinInv.setModel(modeloListaLinea);
        lstIntegrantes.setModel(modeloListaInt);
    }
    
    public void consultarProfesores(){
        List<Profesor> listDoctor = doctorBO.consultarTodos();
        List<Profesor> listProfesor = noDoctorBO.consultarTodos();
        
        List<Profesor> list = new ArrayList();

        if(listDoctor.size() > 0){
            for(int d = 0; d < listDoctor.size(); d++){
                list.add(listDoctor.get(d));
            }
        }
        
        if(listProfesor.size() > 0){
            for(int p = 0; p < listProfesor.size(); p++){
                list.add(listProfesor.get(p));
            }
        }
        
        
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
        List<LineaInvestigacion> listLinInv = lineaInvBO.consultarTodos();
        
        List<LineaInvestigacion> list = new ArrayList();
        
        if(listLinInv.size() > 0){
            for(int p = 0; p < listLinInv.size(); p++){
                list.add(listLinInv.get(p));
            }
        }
        
        
        DefaultTableModel model = (DefaultTableModel) tblLineasInv.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[1];
        for(int i=0; i <list.size();i++){
            rowData[0]=list.get(i).getNombre();
            model.addRow(rowData);
        }
    }
    
    public void consultarProgramas(){
        List<Programa> listPrograma = programaBO.consultarTodos();
        
        List<Programa> list = new ArrayList();
        
        if(listPrograma.size() > 0){
            for(int p = 0; p < listPrograma.size(); p++){
                list.add(listPrograma.get(p));
            }
        }
        
        
        DefaultTableModel model = (DefaultTableModel) tblProgInv.getModel();
        int rowCount = model.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
        Object rowData[]=new Object[1];
        for(int i=0; i <list.size();i++){
            rowData[0]=list.get(i).getNombre();
            model.addRow(rowData);
        }
    }
    
    private boolean validarVacio(){
        
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
        //Pasar los txt a variables
        String  nombre=txtNombreProyecto.getText().trim();
        String  acronimo=txtAcronimo.getText().trim();
        String  fechaInicio=txtFechaInicio.getText().trim();
        String  fechaFin=txtFechaFin.getText().trim();
        String  presupuesto=txtPresupuesto.getText().trim();
        String  descripcion=txtDescripcion.getText().trim();
        
        //Validar fecha inicio
        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            //Comprobación de la fecha
            formatoFecha.parse(fechaInicio);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha Inicio debe estar en el formato dd/mm/aaaa");
            return false;
        }
        
        //Validar fecha fin
        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            //Comprobación de la fecha
            formatoFecha.parse(fechaFin);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha final debe estar en el formato dd/mm/aaaa");
            return false;
        }
        
        if(modeloListaInt.getSize()<2){
            JOptionPane.showMessageDialog(this, "Debe haber al menos 2 integrantes");
            return false;
        }
        
        return true;
        
        
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
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
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
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProfesores = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrograma = new javax.swing.JTextField();
        btnAgregarLinea = new javax.swing.JButton();
        btnEliminarLinea = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstLinInv = new javax.swing.JList<>();

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

        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });
        txtFechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaInicioKeyTyped(evt);
            }
        });

        txtFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinActionPerformed(evt);
            }
        });
        txtFechaFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaFinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaFinKeyTyped(evt);
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Programa de investigación");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del proyecto");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Acrónimo del proyecto");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha inicio");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fecha fin");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Presupuesto");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Descripción");

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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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

        jLabel9.setText("Profesores");

        jLabel10.setText("Lineas de investigación");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txtNombreProyecto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAcronimo)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPresupuesto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(98, 98, 98))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel9))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAgregarLinea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarLinea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarIntegrante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarIntegrante, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAcronimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarIntegrante)
                        .addComponent(btnEliminarIntegrante)
                        .addComponent(btnAgregarLinea)
                        .addComponent(btnEliminarLinea))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(btnCancelar)
                        .addComponent(btnLimpiar)))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAcronimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcronimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcronimoActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void txtPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresupuestoActionPerformed

    private void btnEliminarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntegranteActionPerformed
        if(tblProfesores.getSelectedRow()!=-1){
            int fila= tblProfesores.getSelectedRow();
            String valor=tblProfesores.getValueAt(fila,0).toString();
            borrarElementoLista(valor);
        }else JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún profesor");
    }//GEN-LAST:event_btnEliminarIntegranteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(validarVacio() && validarFormatos()){
            
            List<Profesor> pTemp = new ArrayList();
            
            for(int i = 0; i < modeloListaInt.getSize(); i++){
                pTemp.add((Profesor) modeloListaInt.get(i));
            }
            
            
            Proyecto p = new Proyecto();
            p.setNombre(txtNombreProyecto.getText());
            p.setAcronimo(txtAcronimo.getText());
            //p.setCodigo("1");
            //p.setDesarrolloFinanza("aa");
            p.setDescripcionObjeto(txtDescripcion.getText());
            p.setFechaInicio(new Date(txtFechaInicio.getText()));
            p.setFechaFin(new Date(txtFechaFin.getText()));
            p.setPresupuesto(Integer.parseInt(txtPresupuesto.getText()));
            p.setProfesores(pTemp);
            p.setProgramaInvestigacion(txtPrograma.getText());
            //p.setLineaInvestigacion("e");
            
            proyectoBO.agregarProyecto(p);
            
            
            JOptionPane.showMessageDialog(this, "Se agregó el proyecto");
            btnLimpiarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Pasar los txt a variables
        txtPrograma.setText("");
        txtNombreProyecto.setText("");
        txtAcronimo.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        txtPresupuesto.setText("");
        txtDescripcion.setText("");
        modeloListaInt.clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void borrarElementoLista(String valor){
        if(modeloListaInt.contains(valor))modeloListaInt.removeElement(valor);
        else JOptionPane.showMessageDialog(this, "El profesor seleccionado NO está en la lista de integrantes");
    }
    
    private boolean agregarElementoListaIntegrantes(Profesor v){
//        for(int i=0;0 < modeloListaInt.size();i++){
//            Profesor temp = (Profesor) modeloListaInt.get(i);
//            if(temp.getNombre().equals(v.getNombre()) && temp.getApellidos().equals(v.getApellidos())){
//                JOptionPane.showMessageDialog(this, "El profesor seleccionado ya esta en la lista");
//                return false;
//            }
//        }    
            
        modeloListaInt.addElement(v);
        return true;
    }
    
    private void btnAgregarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntegranteActionPerformed
        if(tblProfesores.getSelectedRow()!=-1){
            int fila= tblProfesores.getSelectedRow();
            
            Profesor v = (Profesor) tblProfesores.getValueAt(fila,0);
            agregarElementoListaIntegrantes(v);
        }else JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún profesor");
        
    }//GEN-LAST:event_btnAgregarIntegranteActionPerformed

    private void txtNombreProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProyectoKeyTyped
        if(!Character.isLetter(evt.getKeyChar()))
            if(evt.getKeyChar()!=KeyEvent.VK_SPACE)
                evt.consume();
    }//GEN-LAST:event_txtNombreProyectoKeyTyped

    private void txtFechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicioKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
        if(txtFechaInicio.getText().length()>=10)
            evt.consume();
    }//GEN-LAST:event_txtFechaInicioKeyTyped

    private void txtAcronimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcronimoKeyTyped
        if(!Character.isLetter(evt.getKeyChar()))
            if(!Character.isDigit(evt.getKeyChar()))
                evt.consume();
        
    }//GEN-LAST:event_txtAcronimoKeyTyped
//12/12/
    private void txtFechaInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicioKeyReleased
        if(txtFechaInicio.getText().length()==2 || txtFechaInicio.getText().length()==5)
            txtFechaInicio.setText(txtFechaInicio.getText()+"/");
    }//GEN-LAST:event_txtFechaInicioKeyReleased

    private void txtFechaFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinKeyReleased
        if(txtFechaFin.getText().length()==2 || txtFechaFin.getText().length()==5)
            txtFechaFin.setText(txtFechaFin.getText()+"/");
    }//GEN-LAST:event_txtFechaFinKeyReleased

    private void txtFechaFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
        if(txtFechaFin.getText().length()>=10)
            evt.consume();
    }//GEN-LAST:event_txtFechaFinKeyTyped

    private void txtPresupuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresupuestoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_txtPresupuestoKeyTyped

    private void txtProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProgramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProgramaActionPerformed

    private boolean agregarElementoListaLinea(LineaInvestigacion linea){            
        modeloListaLinea.addElement(linea);
        return true;
    }
    
    private void btnAgregarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLineaActionPerformed
        if(tblLineasInv.getSelectedRow()!=-1){
            int fila= tblLineasInv.getSelectedRow();
            
            LineaInvestigacion linea = (LineaInvestigacion) tblLineasInv.getValueAt(fila,0);
            agregarElementoListaLinea(linea);
        }else JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún profesor");
    }//GEN-LAST:event_btnAgregarLineaActionPerformed

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarLineaActionPerformed

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
    private javax.swing.JButton btnAgregarIntegrante;
    private javax.swing.JButton btnAgregarLinea;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarIntegrante;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> lstIntegrantes;
    private javax.swing.JList<String> lstLinInv;
    private javax.swing.JTable tblLineasInv;
    private javax.swing.JTable tblProfesores;
    private javax.swing.JTable tblProgInv;
    private javax.swing.JTextField txtAcronimo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtPresupuesto;
    private javax.swing.JTextField txtPrograma;
    // End of variables declaration//GEN-END:variables
}
