package com.mycompany.studentmanagement;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nxquan
 */
public class MainScreen extends javax.swing.JFrame {

    List<Student> list = new ArrayList<>();
    DefaultTableModel defaultTableModel;
    String avatarURL = "./src/main/java/com/mycompany/studentmanagement/avatar.png";
    String dataPath = "./src/main/java/com/mycompany/studentmanagement/data.bin";
    String oldId;

    public MainScreen() throws ClassNotFoundException {
        initComponents();
        createStudentTable();
        loadData();
    }

    private void createStudentTable() {
        defaultTableModel = new DefaultTableModel();
        studentTable.setModel(defaultTableModel);
        //Add columns dynamically
        defaultTableModel.addColumn("Pos");
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Math");
        defaultTableModel.addColumn("Physics");
        defaultTableModel.addColumn("Chemistry");
        defaultTableModel.addColumn("English");
        defaultTableModel.addColumn("History");
        defaultTableModel.addColumn("Geometry");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("Note");

        //Set width for important columns
        studentTable.getColumnModel().getColumn(0).setMinWidth(10);
        studentTable.getColumnModel().getColumn(1).setMinWidth(100);
        studentTable.getColumnModel().getColumn(2).setMinWidth(100);

        //Set selection mode
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        avatarBtn.setIcon(new ImageIcon(avatarURL));
        
        addSorterTable();
    }

    private void addSorterTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(defaultTableModel);
        studentTable.setRowSorter(sorter);
    }

    private void loadData() throws ClassNotFoundException {
        try {
            FileInputStream ifs = new FileInputStream(dataPath);
            ObjectInputStream objIn = new ObjectInputStream(ifs);
            while (true) {
                Student obj;
                try {
                    obj = (Student) objIn.readObject();
                    list.add((Student) obj);

                    defaultTableModel.addRow(new Object[]{list.size(),
                        obj.getId(), obj.getName(), obj.getScore(0),
                        obj.getScore(1), obj.getScore(2), obj.getScore(3),
                        obj.getScore(4), obj.getScore(5), obj.getAddress(),
                        obj.getNotes()});

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        addressInput = new javax.swing.JTextField();
        noteInput = new javax.swing.JTextField();
        mathPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mathLabel = new javax.swing.JLabel();
        mathInput = new javax.swing.JTextField();
        physicsLabel = new javax.swing.JLabel();
        chemistryLabel = new javax.swing.JLabel();
        physicsInput = new javax.swing.JTextField();
        chemistryInput = new javax.swing.JTextField();
        englishLabel = new javax.swing.JLabel();
        englishInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        historyLabel = new javax.swing.JLabel();
        historyInput = new javax.swing.JTextField();
        geometryLabel = new javax.swing.JLabel();
        geometryInput = new javax.swing.JTextField();
        avatarBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        importBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Screen");
        setBackground(new java.awt.Color(153, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mainPanel.setBackground(new java.awt.Color(204, 255, 255));

        idLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        idLabel.setText("Student ID");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        nameLabel.setLabelFor(nameInput);
        nameLabel.setText("Name");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addressLabel.setLabelFor(addressInput);
        addressLabel.setText("Address");

        noteLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        noteLabel.setLabelFor(noteInput);
        noteLabel.setText("Note");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Scores");

        mathLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mathLabel.setLabelFor(mathInput);
        mathLabel.setText("Math");

        mathInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mathInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mathInputKeyPressed(evt);
            }
        });

        physicsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        physicsLabel.setLabelFor(physicsInput);
        physicsLabel.setText("Physics");

        chemistryLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chemistryLabel.setLabelFor(chemistryInput);
        chemistryLabel.setText("Chemistry");

        physicsInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        physicsInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                physicsInputKeyPressed(evt);
            }
        });

        chemistryInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        chemistryInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chemistryInputKeyPressed(evt);
            }
        });

        englishLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        englishLabel.setLabelFor(englishInput);
        englishLabel.setText("English");

        englishInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        englishInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                englishInputKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        historyLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        historyLabel.setLabelFor(historyInput);
        historyLabel.setText("History");

        historyInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                historyInputKeyPressed(evt);
            }
        });

        geometryLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        geometryLabel.setLabelFor(geometryInput);
        geometryLabel.setText("Geometry");

        geometryInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                geometryInputKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout mathPanelLayout = new javax.swing.GroupLayout(mathPanel);
        mathPanel.setLayout(mathPanelLayout);
        mathPanelLayout.setHorizontalGroup(
            mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mathPanelLayout.createSequentialGroup()
                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mathPanelLayout.createSequentialGroup()
                        .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chemistryLabel)
                            .addComponent(mathLabel)
                            .addComponent(physicsLabel))
                        .addGap(10, 10, 10)
                        .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mathInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chemistryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(physicsInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(englishLabel)
                            .addComponent(historyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(geometryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mathPanelLayout.createSequentialGroup()
                                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(historyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(geometryInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(mathPanelLayout.createSequentialGroup()
                                .addComponent(englishInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(mathPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel6)))
                .addGap(120, 120, 120))
        );
        mathPanelLayout.setVerticalGroup(
            mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mathInput)
                        .addComponent(englishLabel)
                        .addComponent(englishInput)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(physicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(physicsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(historyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(historyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(geometryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chemistryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chemistryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(geometryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        avatarBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarBtn.setText("Avatar");
        avatarBtn.setToolTipText("Choose your avatar!");
        avatarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        avatarBtn.setPreferredSize(new java.awt.Dimension(100, 100));
        avatarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(idLabel)
                            .addComponent(addressLabel)
                            .addComponent(noteLabel))
                        .addGap(20, 20, 20)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addressInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(nameInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(noteInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(mathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avatarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(avatarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Student Management Systems");

        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBtn.setText("Add new");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        importBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        importBtn.setText("Import");
        importBtn.setActionCommand("");
        importBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBtnActionPerformed(evt);
            }
        });

        exportBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exportBtn.setText("Export");
        exportBtn.setActionCommand("");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentTable);

        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setText("Save*");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(saveBtn)
                        .addGap(42, 42, 42)
                        .addComponent(addBtn)
                        .addGap(50, 50, 50)
                        .addComponent(editBtn)
                        .addGap(50, 50, 50)
                        .addComponent(deleteBtn)
                        .addGap(50, 50, 50)
                        .addComponent(importBtn)
                        .addGap(50, 50, 50)
                        .addComponent(exportBtn))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(importBtn)
                    .addComponent(exportBtn)
                    .addComponent(saveBtn))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        //Checking
        String id = idInput.getText();
        String name = nameInput.getText();
        String address = addressInput.getText();
        String notes = noteInput.getText();
        String scores[] = {mathInput.getText(), physicsInput.getText(),
            chemistryInput.getText(), englishInput.getText(),
            historyInput.getText(), geometryInput.getText()};

        float _scores[] = new float[6];
        int i = 0;
        for (String score : scores) {
            float temp;
            if (score.length() == 0) {
                temp = 0;
            } else {
                temp = Float.parseFloat(score);
            }
            _scores[i++] = temp;
        }
        if (id.equals("")
                || name.equals("")
                || address.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter important fields of form!",
                    "Notifications", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean isExist = false;
            for (Student s : list) {
                if (s.getId().equals(idInput.getText())) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                list.add(new Student(id, name, avatarURL, _scores, address, notes));
                defaultTableModel.addRow(new Object[]{list.size(),
                    id, name, _scores[0],
                    _scores[1], _scores[2], _scores[3],
                    _scores[4], _scores[5], address,
                    notes});
                this.setTitle("Main Screen*");
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "The Id of student is exist!", "Notifications", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (studentTable.getSelectedRowCount() == 1) {
            String id = idInput.getText();
            String name = nameInput.getText();
            String address = addressInput.getText();
            String notes = noteInput.getText();
            String scores[] = {mathInput.getText(), physicsInput.getText(),
                chemistryInput.getText(), englishInput.getText(),
                historyInput.getText(), geometryInput.getText()};

            float _scores[] = new float[6];
            int i = 0;
            for (String score : scores) {
                float temp;
                if (score.length() == 0) {
                    temp = 0;
                } else {
                    temp = Float.parseFloat(score);
                }
                _scores[i++] = temp;
            }

            if (id.equals("")
                    || name.equals("")
                    || address.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter important fields of form!",
                        "Notifications", JOptionPane.WARNING_MESSAGE);
            } else {
                boolean isExist = false;
                if (!id.equals(oldId)) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getId().equals(id)) {
                            isExist = true;
                            break;
                        }
                    }
                }

                if (!isExist) {
                    int opt = JOptionPane.showConfirmDialog(this,
                            "Do you really want to edit student " + name,
                            "Confimations",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (opt == JOptionPane.YES_OPTION) {
                        //Edit behind data
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).getId().equals(id)) {
                                list.set(j, new Student(id, name, avatarURL, _scores, address, notes));
                                break;
                            }
                        }

                        //Change UI
                        int row = studentTable.getSelectedRow();
                        defaultTableModel.setValueAt(id, row, 1);
                        defaultTableModel.setValueAt(name, row, 2);
                        defaultTableModel.setValueAt(_scores[0], row, 3);
                        defaultTableModel.setValueAt(_scores[1], row, 4);
                        defaultTableModel.setValueAt(_scores[2], row, 5);
                        defaultTableModel.setValueAt(_scores[3], row, 6);
                        defaultTableModel.setValueAt(_scores[4], row, 7);
                        defaultTableModel.setValueAt(_scores[5], row, 8);
                        defaultTableModel.setValueAt(address, row, 9);
                        defaultTableModel.setValueAt(notes, row, 10);
                        resetForm();
                        this.setTitle("Main Screen*");

                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "The Id of student is exist!",
                            "Notifications",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Plase select one student for updating",
                    "Notifications",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (studentTable.getSelectedRowCount() == 1) {
            String deletedId = (String) studentTable.getValueAt(studentTable.getSelectedRow(), 1);
            int deteletdIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(deletedId)) {
                    deteletdIndex = i;
                    break;
                }
            }

            int opt = JOptionPane.showConfirmDialog(this,
                    "Do you really want to delete student " + list.get(deteletdIndex).getName() + " ?",
                    "Comfirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (opt == JOptionPane.YES_OPTION) {
                list.remove(deteletdIndex);
                //Updating table
                int rowCount = defaultTableModel.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    defaultTableModel.removeRow(i);
                }
                int pos = 1;
                for (Student obj : list) {
                    defaultTableModel.addRow(new Object[]{pos,
                        obj.getId(), obj.getName(), obj.getScore(0),
                        obj.getScore(1), obj.getScore(2), obj.getScore(3),
                        obj.getScore(4), obj.getScore(5), obj.getAddress(),
                        obj.getNotes()});
                    
                    pos++;
                }
                this.setTitle("Main Screen*");
                resetForm();
            }
        } else {
            if (studentTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "The list of student is empty",
                        "Warnings", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Plese choose one student to deleting!",
                        "Warnings", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser dialog = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
        
        dialog.setFileFilter(filter);
        
        int opt = dialog.showOpenDialog(this);
        
        if(opt == JFileChooser.APPROVE_OPTION) {
            File file = dialog.getSelectedFile();
            try {
                FileReader readerFile = new FileReader(file);
                CSVReader readerCSV = new CSVReader(readerFile);
                String record[];
                //Reading header
                readerCSV.readNext();
                
                //Reading the remaining records
                list.clear();
                
                while((record = readerCSV.readNext()) != null) {
                    list.add(Student.parser(record));
                }
                int rowCount = defaultTableModel.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    defaultTableModel.removeRow(i);
                }
                
                int j = 1;
                for (Student student : list) {
                    defaultTableModel.addRow(new Object[]{j,
                        student.getId(), student.getName(), student.getScore(0),
                        student.getScore(1), student.getScore(2), student.getScore(3),
                        student.getScore(4), student.getScore(5), student.getAddress(),
                        student.getNotes()});
                    j++;
                }
                JOptionPane.showMessageDialog(this, 
                        "Import successfully", "Info", 
                        JOptionPane.INFORMATION_MESSAGE);
                
                this.setTitle("Main Screen*");
            }catch(IOException ex) {
                System.out.println(ex);
            }
        }
        
    }//GEN-LAST:event_importBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser saveDialog = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
            saveDialog.setFileFilter(filter);

            int opt = saveDialog.showSaveDialog(this);

            if (opt == JFileChooser.APPROVE_OPTION) {
                File file = saveDialog.getSelectedFile();
                if (!file.getName().contains(".csv")) {
                    // filename is OK as-is
                    file = new File(file.getAbsolutePath() + ".csv"); 
                }
                
                FileWriter wtFile = new FileWriter(file.getAbsoluteFile());
                CSVWriter wt = new CSVWriter(wtFile);
                String header[] = {"id", "name", "avatar", "math", "physics", "chemitry", "english", "history", "geometry", "address", "notes"};
                wt.writeNext(header);

                for (Student s : list) {
                    String[] rawData = s.convertArrayString();
                    wt.writeNext(rawData);
                }

                wt.close();
                JOptionPane.showMessageDialog(this,
                        "Save successfully!",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException ex) {

            System.out.println(ex);
        }


    }//GEN-LAST:event_exportBtnActionPerformed

    private void avatarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarBtnMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int opt = fileChooser.showDialog(this, "Select file");
        if (opt == JFileChooser.APPROVE_OPTION) {
            try {
                avatarURL = fileChooser.getSelectedFile().getAbsolutePath();
                avatarURL = avatarURL.replace("\\", "/");
                
                BufferedImage img = ImageIO.read(new File(avatarURL));
                Image dimg = img.getScaledInstance(avatarBtn.getWidth(), avatarBtn.getHeight(),
                        Image.SCALE_SMOOTH);
                avatarBtn.setIcon(new ImageIcon(dimg));

            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_avatarBtnMouseClicked

    private void mathInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mathInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            mathInput.setEditable(true);
        } else {
            mathInput.setEditable(false);
        }
    }//GEN-LAST:event_mathInputKeyPressed

    private void physicsInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_physicsInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            physicsInput.setEditable(true);
        } else {
            physicsInput.setEditable(false);
        }
    }//GEN-LAST:event_physicsInputKeyPressed

    private void chemistryInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chemistryInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            chemistryInput.setEditable(true);
        } else {
            chemistryInput.setEditable(false);
        }
    }//GEN-LAST:event_chemistryInputKeyPressed

    private void englishInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_englishInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            englishInput.setEditable(true);
        } else {
            englishInput.setEditable(false);
        }
    }//GEN-LAST:event_englishInputKeyPressed

    private void historyInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historyInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            historyInput.setEditable(true);
        } else {
            historyInput.setEditable(false);
        }
    }//GEN-LAST:event_historyInputKeyPressed

    private void geometryInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_geometryInputKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == 8 || evt.getKeyCode() == 46) {
            geometryInput.setEditable(true);
        } else {
            geometryInput.setEditable(false);
        }
    }//GEN-LAST:event_geometryInputKeyPressed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        if (studentTable.getSelectedRowCount() == 1) {
            String chosenId = (String) studentTable.getValueAt(studentTable.getSelectedRow(), 1);
            int chosenIndex = 0;
            oldId = chosenId;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(chosenId)) {
                    chosenIndex = i;
                    break;
                }
            }

            idInput.setText(list.get(chosenIndex).getId());
            nameInput.setText(list.get(chosenIndex).getName());
            addressInput.setText(list.get(chosenIndex).getAddress());
            noteInput.setText(list.get(chosenIndex).getNotes());

            mathInput.setText(Float.toString(list.get(chosenIndex).getScore(0)));
            physicsInput.setText(Float.toString(list.get(chosenIndex).getScore(1)));
            chemistryInput.setText(Float.toString(list.get(chosenIndex).getScore(2)));
            englishInput.setText(Float.toString(list.get(chosenIndex).getScore(3)));
            historyInput.setText(Float.toString(list.get(chosenIndex).getScore(4)));
            geometryInput.setText(Float.toString(list.get(chosenIndex).getScore(5)));

            try {
                avatarURL = list.get(chosenIndex).getUrlAvatar();
                BufferedImage img = ImageIO.read(new File(avatarURL));
                Image dimg = img.getScaledInstance(avatarBtn.getWidth(), avatarBtn.getHeight(),
                        Image.SCALE_SMOOTH);
                avatarBtn.setIcon(new ImageIcon(dimg));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            if (studentTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "The list of student is empty",
                        "Warnings", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Plese choose one student to updating!",
                        "Warnings", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_studentTableMouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        // TODO add your handling code here:
        studentTable.setValueAt(evt, ERROR, NORMAL);


    }//GEN-LAST:event_editBtnMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        //Save data into binary file
        try {
            FileOutputStream ofs = new FileOutputStream(dataPath);
            ObjectOutputStream objOut = new ObjectOutputStream(ofs);
            for (Student s : list) {
                objOut.writeObject(s);
            }
            objOut.close();
            this.setTitle("Main Screen");

            JOptionPane.showMessageDialog(this,
                    "Save succefullly!", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void resetForm() {
        String zeroString = Float.toString(0);
        idInput.setText("");
        nameInput.setText("");
        addressInput.setText("");
        noteInput.setText("");
        mathInput.setText(zeroString);
        physicsInput.setText(zeroString);
        chemistryInput.setText(zeroString);
        englishInput.setText(zeroString);
        historyInput.setText(zeroString);
        geometryInput.setText(zeroString);

        avatarURL = "./src/main/java/com/mycompany/studentmanagement/avatar.png";
        avatarBtn.setIcon(new ImageIcon(avatarURL));
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainScreen().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel avatarBtn;
    private javax.swing.JTextField chemistryInput;
    private javax.swing.JLabel chemistryLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField englishInput;
    private javax.swing.JLabel englishLabel;
    private javax.swing.JButton exportBtn;
    private javax.swing.JTextField geometryInput;
    private javax.swing.JLabel geometryLabel;
    private javax.swing.JTextField historyInput;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton importBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField mathInput;
    private javax.swing.JLabel mathLabel;
    private javax.swing.JPanel mathPanel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField noteInput;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JTextField physicsInput;
    private javax.swing.JLabel physicsLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
