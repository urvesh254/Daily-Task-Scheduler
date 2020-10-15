/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily.task.scheduler;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author urvesh
 */
public class Preferences
{
    public void changeUI(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public void tablePreference(JTable jTable){
        // Change Header.
        JTableHeader tj=jTable.getTableHeader();
        tj.setFont(new Font("Segoe UI",Font.BOLD,26));
        tj.setOpaque(false);
        tj.setBackground(new Color(32,136,203));
        tj.setForeground(new Color(255,255,255));
        
        // Column Center align.
        DefaultTableCellRenderer renderer=(DefaultTableCellRenderer)tj.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        // Cell Alignment
        DefaultTableCellRenderer cellRenderer=new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        jTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        jTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        jTable.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        
        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable.setRowHeight(30);
        jTable.setRowMargin(2);
        jTable.setSelectionBackground(new java.awt.Color(102, 255, 51));
        jTable.setSurrendersFocusOnKeystroke(true);
        

    }
}
