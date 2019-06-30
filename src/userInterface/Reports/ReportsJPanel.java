/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Reports;

import Business.EcoSystem;
import javax.swing.JPanel;
import Business.Analytics.networkAnalyticsFuns;
import Business.Network.Network;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author imperio2494
 */
public class ReportsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportsJPanel
     */
    
    private EcoSystem system;
    private JPanel userProcessContainer;
    public ReportsJPanel(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        this.system=system;
        this.userProcessContainer=userProcessContainer;
        populateNetworkCB();
        populateReportType();
        populateEmployeeCountGraph(null);
        Color color = new Color(211, 247, 255);
        this.setBackground(color);
            }
       
    
    private void populateEmployeeCountGraph(String networkSelected){

HashMap<String,HashMap<String,Integer>> datamap=(new networkAnalyticsFuns(system)).getUsersInNetWorkByOrganization(networkSelected);
         DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for(String ent:datamap.keySet()){
            for(String org:datamap.get(ent).keySet()){
        dataset.addValue(datamap.get(ent).get(org),org,ent);
        String top=(networkSelected==null)?"":" in "+networkSelected;
        barGraph(dataset,"Workforce"+top,"Enterprises","Employee Count");
                }
             }
            }
    private void populateAllocatedBudgetGraph(String networkSelected){

        DefaultCategoryDataset dataset=(new networkAnalyticsFuns(system)).getAllocatedBudgetByOrganization(networkSelected);
         
            barGraph(dataset,"Allocated Funds By Origanization","Origanizations","Total Allocated Funds");
    }
    
    private void organizationBudgetAllocationGraph(String networkSelected){

        DefaultPieDataset dataset=(new networkAnalyticsFuns(system)).getTotalBudgetdistributionByOrganization(networkSelected);
         
            pieChart(dataset,"Allocated Funds By Origanization");
    }
    
    private void FraudRequestsGraph(String networkSelected){

        DefaultPieDataset dataset=(new networkAnalyticsFuns(system)).getTotalFraudByOrganization(networkSelected);
         
            pieChart(dataset,"Allocated Funds By Origanization");
    }
    private void populateNetworkCB(){
        networkCB.removeAllItems();
        for(Network n:system.getNetworkList())
        {networkCB.addItem(n.getName().toString());}
        
    
    }
    
    private void populateReportType(){
    
    reportTypeCB.addItem("Employees");
    
    reportTypeCB.addItem("Allocated Budget");
    
    reportTypeCB.addItem("Organization Budget Allocation");
    
    reportTypeCB.addItem("Fraud Requests");
    
    }
    
    
    private void barGraph(DefaultCategoryDataset dataset,String tHeader,String bHeader,String lHeader){

        JFreeChart chart = ChartFactory.createBarChart3D(
        tHeader, // Title
        bHeader, // x-axis Label
        lHeader, // y-axis Label
        dataset, // Dataset
        PlotOrientation.VERTICAL, // Plot Orientation
        true, // Show Legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
     );
        plotJPanel.removeAll();
        plotJPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        plotJPanel.add(CP,BorderLayout.CENTER);
        plotJPanel.validate();
    }
    
        private void pieChart(DefaultPieDataset dataset,String tHeader){

        JFreeChart chart = ChartFactory.createPieChart3D(
        tHeader, // Title
        dataset, // Dataset
        true, // Show Legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
     );
        plotJPanel.removeAll();
        plotJPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        plotJPanel.add(CP,BorderLayout.CENTER);
        plotJPanel.validate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        networkCB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        plotJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        reportTypeCB = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        networkCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkCBActionPerformed(evt);
            }
        });

        jLabel1.setText("Network : ");

        javax.swing.GroupLayout plotJPanelLayout = new javax.swing.GroupLayout(plotJPanel);
        plotJPanel.setLayout(plotJPanelLayout);
        plotJPanelLayout.setHorizontalGroup(
            plotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        plotJPanelLayout.setVerticalGroup(
            plotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        jLabel2.setText("Type : ");

        reportTypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTypeCBActionPerformed(evt);
            }
        });

        backBtn.setText("back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(plotJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(networkCB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reportTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(reportTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plotJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkCBActionPerformed
//         TODO add your handling code here:
        try{
        if(reportTypeCB.getSelectedItem().toString()=="Employees")
            populateEmployeeCountGraph(networkCB.getSelectedItem().toString());
       
        else if(reportTypeCB.getSelectedItem().toString()=="Allocated Budget"){
            populateAllocatedBudgetGraph(networkCB.getSelectedItem().toString());
        }
        else if(reportTypeCB.getSelectedItem().toString()=="Organization Budget Allocation"){
            organizationBudgetAllocationGraph(networkCB.getSelectedItem().toString());
        }
        else if(reportTypeCB.getSelectedItem().toString()=="Fraud Requests"){
            organizationBudgetAllocationGraph(networkCB.getSelectedItem().toString());
        }
        }
        catch(Exception e){
//     populateEmployeeCountGraph(networkCB.getSelectedItem().toString());
    }
        finally{}
            
    }//GEN-LAST:event_networkCBActionPerformed

    private void reportTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTypeCBActionPerformed
        try{
        if(reportTypeCB.getSelectedItem().toString()=="Employees")
            populateEmployeeCountGraph(networkCB.getSelectedItem().toString());
        
        else if(reportTypeCB.getSelectedItem().toString()=="Allocated Budget"){
            populateAllocatedBudgetGraph(networkCB.getSelectedItem().toString());
        }
        else if(reportTypeCB.getSelectedItem().toString()=="Organization Budget Allocation"){
            organizationBudgetAllocationGraph(networkCB.getSelectedItem().toString());
        }
        else if(reportTypeCB.getSelectedItem().toString()=="Fraud Requests"){
            organizationBudgetAllocationGraph(networkCB.getSelectedItem().toString());
        }
        }
        catch(Exception e){
//     populateEmployeeCountGraph(networkCB.getSelectedItem().toString());
    }
        finally{}
    }//GEN-LAST:event_reportTypeCBActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> networkCB;
    private javax.swing.JPanel plotJPanel;
    private javax.swing.JComboBox<String> reportTypeCB;
    // End of variables declaration//GEN-END:variables
}