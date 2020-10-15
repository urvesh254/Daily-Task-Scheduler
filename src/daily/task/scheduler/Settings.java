/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily.task.scheduler;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author urvesh
 */
public class Settings extends JFrame
{

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Preferences preference=new Preferences();
    private DbOperations dbOperation=new DbOperations();
    private String selectedDay="SUNDAY";
    private ImageIcon icon;
    
    /**
     * Creates new form MainFrame
     */
    public Settings() {
        preference.changeUI();//Change the UI of the Program
        initComponents();
        refreshTable(); // Set Database data
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DTS-icon.png")));
        setLocationRelativeTo(null); // Open Middel of the screen.
    }
    
    public Settings(String selectedDay){
        preference.changeUI();//Change the UI of the Program
        initComponents();
        this.selectedDay=selectedDay;
        paintLabel(getLabel(selectedDay));
        refreshTable();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DTS-icon.png")));
        setLocationRelativeTo(null); // Open Middel of the screen.
        setVisible(true);
    }
    
    private JLabel getLabel(String day){
        if(labelSunday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelSunday;
        if(labelMonday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelMonday;
        if(labelTuesday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelTuesday;
        if(labelWednesday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelWednesday;
        if(labelThursday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelThursday;
        if(labelFriday.getText().toLowerCase().equals(day.toLowerCase()))
            return labelFriday;
        else
            return labelSaturday;
    }
    
    private void refreshTable() {
        try {
//            String query = "select id as \"Sr. No\",tasks as \"Tasks\",from_time as \"From\",to_time as \"To\" from Test";
            jTable.setModel(dbOperation.convert(jTable,selectedDay));
            preference.tablePreference(jTable);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something Wrong.");
        }
    }

    private void clearData() {
        tfSrNo.setText("");
        tfTask.setText("");
        fromHour.setSelectedIndex(0);
        fromMinute.setSelectedIndex(0);
        toHour.setSelectedIndex(0);
        toMinute.setSelectedIndex(0);
    }

    void setSelectedValue() {
        int row = jTable.getSelectedRow();
        tfSrNo.setText(jTable.getValueAt(row, 0).toString());
        tfTask.setText(jTable.getValueAt(row, 1).toString());
        Object str[]=jTable.getValueAt(row, 2).toString().split(":");
        fromHour.setSelectedItem(str[0]);
        fromMinute.setSelectedItem(str[1]);
        str=jTable.getValueAt(row, 3).toString().split(":");
        toHour.setSelectedItem(str[0]);
        toMinute.setSelectedItem(str[1]);
    }

    private void updateData() {
        try{
            String from=fromHour.getSelectedItem().toString()+":"+fromMinute.getSelectedItem().toString();
            String to=toHour.getSelectedItem().toString()+":"+toMinute.getSelectedItem().toString();
            dbOperation.updateData(tfSrNo.getText(),tfTask.getText(),from,to,selectedDay);
            refreshTable();
            clearData();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data is in invalid form");   
        }
    }

    private void deleteData() {
        try{
            dbOperation.deleteData(tfSrNo.getText(),selectedDay);
            refreshTable();
            clearData();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data is in invalid form");   
        }
    }

    private void addData() {
        try{
            String from=fromHour.getSelectedItem().toString()+":"+fromMinute.getSelectedItem().toString();
            String to=toHour.getSelectedItem().toString()+":"+toMinute.getSelectedItem().toString();
            dbOperation.addData(tfTask.getText(), from, to, selectedDay);
            refreshTable();
            clearData();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data is in invalid form");   
        }
    }
    
    private void paintLabel(JLabel day){
        labelSunday.setForeground(new Color(102,102,102));
        labelSunday.setBackground(new Color(204,255,0));
        labelMonday.setForeground(new Color(102,102,102));
        labelMonday.setBackground(new Color(204,255,0));
        labelTuesday.setForeground(new Color(102,102,102));
        labelTuesday.setBackground(new Color(204,255,0));
        labelWednesday.setForeground(new Color(102,102,102));
        labelWednesday.setBackground(new Color(204,255,0));
        labelThursday.setForeground(new Color(102,102,102));
        labelThursday.setBackground(new Color(204,255,0));
        labelFriday.setForeground(new Color(102,102,102));
        labelFriday.setBackground(new Color(204,255,0));
        labelSaturday.setForeground(new Color(102,102,102));
        labelSaturday.setBackground(new Color(204,255,0));
        
        day.setForeground(Color.black);
        day.setBackground(new Color(142,178,0));
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleBar = new javax.swing.JPanel();
        labelHome = new javax.swing.JLabel();
        DaysName = new javax.swing.JPanel();
        labelMonday = new javax.swing.JLabel();
        labelSunday = new javax.swing.JLabel();
        labelWednesday = new javax.swing.JLabel();
        labelTuesday = new javax.swing.JLabel();
        labelFriday = new javax.swing.JLabel();
        labelSaturday = new javax.swing.JLabel();
        labelThursday = new javax.swing.JLabel();
        deleteCurrentDay = new javax.swing.JLabel();
        deleteAll = new javax.swing.JLabel();
        labelTo = new javax.swing.JPanel();
        labelSrNo = new javax.swing.JLabel();
        tfSrNo = new javax.swing.JTextField();
        labelTask = new javax.swing.JLabel();
        tfTask = new javax.swing.JTextField();
        labelFrom = new javax.swing.JLabel();
        labelSrNo3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        toHour = new javax.swing.JComboBox<>();
        fromHour = new javax.swing.JComboBox<>();
        toMinute = new javax.swing.JComboBox<>();
        fromMinute = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Datatabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daily Task Scheduler");
        setIconImage(Toolkit.getDefaultToolkit().getImage("/Images/DTS-icon.png"));
        setMinimumSize(new java.awt.Dimension(1402, 755));
        setSize(new java.awt.Dimension(1402, 755));

        TitleBar.setBackground(new java.awt.Color(204, 255, 0));
        TitleBar.setLayout(new java.awt.BorderLayout());

        labelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-home-page-85.png"))); // NOI18N
        labelHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 1));
        labelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHomeMouseClicked(evt);
            }
        });
        TitleBar.add(labelHome, java.awt.BorderLayout.LINE_START);

        DaysName.setBackground(new java.awt.Color(204, 255, 0));

        labelMonday.setBackground(new java.awt.Color(204, 255, 0));
        labelMonday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelMonday.setText("Monday");
        labelMonday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelMonday.setOpaque(true);
        labelMonday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMondayMouseClicked(evt);
            }
        });

        labelSunday.setBackground(new java.awt.Color(142, 178, 0));
        labelSunday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelSunday.setText("Sunday");
        labelSunday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelSunday.setOpaque(true);
        labelSunday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSundayMouseClicked(evt);
            }
        });

        labelWednesday.setBackground(new java.awt.Color(204, 255, 0));
        labelWednesday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelWednesday.setText("Wednesday");
        labelWednesday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelWednesday.setOpaque(true);
        labelWednesday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelWednesdayMouseClicked(evt);
            }
        });

        labelTuesday.setBackground(new java.awt.Color(204, 255, 0));
        labelTuesday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelTuesday.setText("Tuesday");
        labelTuesday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelTuesday.setOpaque(true);
        labelTuesday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTuesdayMouseClicked(evt);
            }
        });

        labelFriday.setBackground(new java.awt.Color(204, 255, 0));
        labelFriday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelFriday.setText("Friday");
        labelFriday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelFriday.setOpaque(true);
        labelFriday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFridayMouseClicked(evt);
            }
        });

        labelSaturday.setBackground(new java.awt.Color(204, 255, 0));
        labelSaturday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelSaturday.setText("Saturday");
        labelSaturday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelSaturday.setOpaque(true);
        labelSaturday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSaturdayMouseClicked(evt);
            }
        });

        labelThursday.setBackground(new java.awt.Color(204, 255, 0));
        labelThursday.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelThursday.setText("Thursday");
        labelThursday.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 1, 5));
        labelThursday.setOpaque(true);
        labelThursday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelThursdayMouseClicked(evt);
            }
        });

        deleteCurrentDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-delete-document-70.png"))); // NOI18N
        deleteCurrentDay.setToolTipText("Delete selected day tasks");
        deleteCurrentDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCurrentDayMouseClicked(evt);
            }
        });

        deleteAll.setForeground(java.awt.Color.red);
        deleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-delete-database-70-red.png"))); // NOI18N
        deleteAll.setToolTipText("Delete all days tasks");
        deleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAllMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DaysNameLayout = new javax.swing.GroupLayout(DaysName);
        DaysName.setLayout(DaysNameLayout);
        DaysNameLayout.setHorizontalGroup(
            DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DaysNameLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelSunday)
                .addGap(18, 18, 18)
                .addComponent(labelMonday)
                .addGap(18, 18, 18)
                .addComponent(labelTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelWednesday)
                .addGap(18, 18, 18)
                .addComponent(labelThursday)
                .addGap(18, 18, 18)
                .addComponent(labelFriday)
                .addGap(18, 18, 18)
                .addComponent(labelSaturday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(deleteCurrentDay)
                .addGap(102, 102, 102))
            .addGroup(DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DaysNameLayout.createSequentialGroup()
                    .addContainerGap(1226, Short.MAX_VALUE)
                    .addComponent(deleteAll)
                    .addGap(17, 17, 17)))
        );
        DaysNameLayout.setVerticalGroup(
            DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DaysNameLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelSunday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMonday)
                            .addComponent(labelWednesday)
                            .addComponent(labelTuesday)
                            .addComponent(labelFriday)
                            .addComponent(labelSaturday)
                            .addComponent(labelThursday)))
                    .addComponent(deleteCurrentDay, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(DaysNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DaysNameLayout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(deleteAll)
                    .addGap(3, 3, 3)))
        );

        TitleBar.add(DaysName, java.awt.BorderLayout.CENTER);

        getContentPane().add(TitleBar, java.awt.BorderLayout.PAGE_START);

        labelTo.setBackground(new java.awt.Color(76, 117, 237));
        labelTo.setName(""); // NOI18N

        labelSrNo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelSrNo.setText("Sr. No :");

        tfSrNo.setEditable(false);
        tfSrNo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        labelTask.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelTask.setText("Task    :");

        tfTask.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        labelFrom.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelFrom.setText("From   :");

        labelSrNo3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelSrNo3.setText("To        :");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setFocusTraversalPolicyProvider(true);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusTraversalPolicyProvider(true);
        btnDelete.setMaximumSize(new java.awt.Dimension(155, 57));
        btnDelete.setMinimumSize(new java.awt.Dimension(155, 57));
        btnDelete.setPreferredSize(new java.awt.Dimension(155, 57));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setFocusTraversalPolicyProvider(true);
        btnAdd.setMaximumSize(new java.awt.Dimension(155, 57));
        btnAdd.setMinimumSize(new java.awt.Dimension(155, 57));
        btnAdd.setPreferredSize(new java.awt.Dimension(155, 57));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        toHour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        toHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        fromHour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fromHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        toMinute.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        toMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        fromMinute.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fromMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel1.setText("Min");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel2.setText("Hr");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel3.setText("Hr");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setText("Min");

        javax.swing.GroupLayout labelToLayout = new javax.swing.GroupLayout(labelTo);
        labelTo.setLayout(labelToLayout);
        labelToLayout.setHorizontalGroup(
            labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelToLayout.createSequentialGroup()
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labelToLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSrNo)
                            .addComponent(labelTask)
                            .addComponent(labelFrom)
                            .addComponent(labelSrNo3))
                        .addGap(18, 18, 18)
                        .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSrNo, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(labelToLayout.createSequentialGroup()
                                .addComponent(toHour, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(labelToLayout.createSequentialGroup()
                                .addComponent(fromHour, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addGroup(labelToLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(labelToLayout.createSequentialGroup()
                                .addComponent(toMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(labelToLayout.createSequentialGroup()
                                .addComponent(fromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(labelToLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(labelToLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(62, 62, 62))
        );
        labelToLayout.setVerticalGroup(
            labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelToLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSrNo)
                    .addComponent(labelSrNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTask)
                    .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFrom)
                    .addComponent(fromHour, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSrNo3)
                    .addComponent(toHour, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toMinute)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(labelToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );

        getContentPane().add(labelTo, java.awt.BorderLayout.LINE_START);

        Datatabel.setBackground(new java.awt.Color(204, 255, 0));

        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable.setNextFocusableComponent(tfTask);
        jTable.setRowHeight(30);
        jTable.setRowMargin(2);
        jTable.setSelectionBackground(new java.awt.Color(85, 242, 73));
        jTable.setSurrendersFocusOnKeystroke(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout DatatabelLayout = new javax.swing.GroupLayout(Datatabel);
        Datatabel.setLayout(DatatabelLayout);
        DatatabelLayout.setHorizontalGroup(
            DatatabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatatabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        DatatabelLayout.setVerticalGroup(
            DatatabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatatabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Datatabel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomeMouseClicked
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_labelHomeMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addData();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void labelSundayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSundayMouseClicked
        // TODO add your handling code here:
        selectedDay="SUNDAY";
        paintLabel(labelSunday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelSundayMouseClicked

    private void labelMondayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMondayMouseClicked
        // TODO add your handling code here:
        selectedDay="MONDAY";
        paintLabel(labelMonday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelMondayMouseClicked

    private void labelTuesdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTuesdayMouseClicked
        // TODO add your handling code here:
        selectedDay="TUESDAY";
        paintLabel(labelTuesday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelTuesdayMouseClicked

    private void labelWednesdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelWednesdayMouseClicked
        // TODO add your handling code here:
        selectedDay="WEDNESDAY";
        paintLabel(labelWednesday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelWednesdayMouseClicked

    private void labelThursdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelThursdayMouseClicked
        // TODO add your handling code here:
        selectedDay="THURSDAY";
        paintLabel(labelThursday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelThursdayMouseClicked

    private void labelFridayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFridayMouseClicked
        // TODO add your handling code here:
        selectedDay="FRIDAY";
        paintLabel(labelFriday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelFridayMouseClicked

    private void labelSaturdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSaturdayMouseClicked
        // TODO add your handling code here:
        selectedDay="SATURDAY";
        paintLabel(labelSaturday);
        refreshTable();
        clearData();
    }//GEN-LAST:event_labelSaturdayMouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        setSelectedValue();
    }//GEN-LAST:event_jTableMouseClicked

    private void deleteCurrentDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCurrentDayMouseClicked
        // TODO add your handling code here:
        icon = new ImageIcon(getClass().getResource("/Images/warning-icon.png"));
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to delete "+selectedDay.toUpperCase()+" tasks?", "Confirm Messagebox",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,icon);
        if(option == 0){
            dbOperation.deleteRowsFromTable(selectedDay);
            icon = new ImageIcon(getClass().getResource("/Images/icons8-ok-50.png"));
            JOptionPane.showMessageDialog(null, selectedDay.toUpperCase()+" tasks deleted successfully.", "Information Messagebox", JOptionPane.INFORMATION_MESSAGE, icon);
            refreshTable();
            clearData();
        }
    }//GEN-LAST:event_deleteCurrentDayMouseClicked

    private void deleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAllMouseClicked
        // TODO add your handling code here:
        icon = new ImageIcon(getClass().getResource("/Images/warning-icon.png"));
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to delete all the tasks?", "Confirm Messagebox",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,icon);
        if(option == 0){
            dbOperation.deleteAllTableData();
            icon = new ImageIcon(getClass().getResource("/Images/icons8-ok-50.png"));
            JOptionPane.showMessageDialog(null, "All tasks are deleted successfully.", "Information Messagebox", JOptionPane.INFORMATION_MESSAGE, icon);
            refreshTable();
            clearData();
        }
    }//GEN-LAST:event_deleteAllMouseClicked

    
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
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                   new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Datatabel;
    private javax.swing.JPanel DaysName;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel deleteAll;
    private javax.swing.JLabel deleteCurrentDay;
    private javax.swing.JComboBox<String> fromHour;
    private javax.swing.JComboBox<String> fromMinute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel labelFriday;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelMonday;
    private javax.swing.JLabel labelSaturday;
    private javax.swing.JLabel labelSrNo;
    private javax.swing.JLabel labelSrNo3;
    private javax.swing.JLabel labelSunday;
    private javax.swing.JLabel labelTask;
    private javax.swing.JLabel labelThursday;
    private javax.swing.JPanel labelTo;
    private javax.swing.JLabel labelTuesday;
    private javax.swing.JLabel labelWednesday;
    private javax.swing.JTextField tfSrNo;
    private javax.swing.JTextField tfTask;
    private javax.swing.JComboBox<String> toHour;
    private javax.swing.JComboBox<String> toMinute;
    // End of variables declaration//GEN-END:variables

}
