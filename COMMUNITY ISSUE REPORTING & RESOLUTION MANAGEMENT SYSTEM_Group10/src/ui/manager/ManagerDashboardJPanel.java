/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import util.enums.IssueType;

/**
 *
 * @author RIO
 */
public class ManagerDashboardJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerDashboardJPanel
     */
   private javax.swing.JPanel userProcessContainer;
    private model.ecosystem.EcoSystem ecoSystem;
    private model.userAccount.UserAccount userAccount;
    private model.enterprise.Enterprise enterprise;

    public ManagerDashboardJPanel(javax.swing.JPanel userProcessContainer, model.ecosystem.EcoSystem ecoSystem, model.userAccount.UserAccount account, model.enterprise.Enterprise enterprise) {
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.userAccount = account;
        this.enterprise = enterprise;
        initComponents();
        loadAnalytics();
        populateChart();
    }
    private void loadAnalytics() {
    if (enterprise == null) {
        try {
            enterprise = ecoSystem.getNetworks().get(0).getEnterprises().get(0);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error: No enterprise found!", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    try {
        model.analytics.Analytics analytics = new model.analytics.Analytics(enterprise);
        
        int totalRequests = analytics.getTotalRequests();
        double completionRate = analytics.getCompletionRate();
        double avgResolutionTime = analytics.getAverageResolutionTime();
        
        java.util.Map<util.enums.Status, Integer> statusMap = analytics.getRequestsByStatus();
        
        int pending = statusMap.getOrDefault(util.enums.Status.NEW, 0) + 
                      statusMap.getOrDefault(util.enums.Status.ASSIGNED, 0) +
                      statusMap.getOrDefault(util.enums.Status.PENDING, 0);
        int inProgress = statusMap.getOrDefault(util.enums.Status.IN_PROGRESS, 0);
        int completed = statusMap.getOrDefault(util.enums.Status.COMPLETED, 0) +
                        statusMap.getOrDefault(util.enums.Status.CLOSED, 0);
        
        lblTotalRequests.setText("Total Requests: " + totalRequests);
        lblCompletionRate.setText(String.format("Completion Rate: %.1f%%", completionRate));
        lblAvgResolutionTime.setText(String.format("Avg Resolution Time: %.1f hrs", avgResolutionTime));
        lblPendingRequests.setText("Pending: " + pending);
        lblInProgress.setText("In Progress: " + inProgress);
        lblCompleted.setText("Completed: " + completed);
        
        lblTotalRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompletionRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvgResolutionTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendingRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompleted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error loading analytics: " + e.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
private void populateChart() {
    // 1. Create the Dataset
    DefaultPieDataset dataset = new DefaultPieDataset();
    
    try {
        model.analytics.Analytics analytics = new model.analytics.Analytics(enterprise);
        Map<IssueType, Integer> typeMap = analytics.getRequestsByIssueType();

        // Populate dataset
        for (IssueType type : typeMap.keySet()) {
            int count = typeMap.get(type);
            if (count > 0) {
                dataset.setValue(type.getValue(), count);
            }
        }
        
        // 2. Create the Chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Issue Type Distribution",  // Chart Title
            dataset,                    // Dataset
            true,                       // Include Legend
            true,
            false
        );

        // 3. Customize Styling
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setOutlineVisible(false);
        
        // 4. Add Chart to the UI Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // FORCE Layout to BorderLayout to ensure it displays
        pnlChart.setLayout(new java.awt.BorderLayout());
        
        pnlChart.removeAll(); 
        pnlChart.add(chartPanel, BorderLayout.CENTER);
        pnlChart.validate();
        pnlChart.repaint();
        
    } catch (Exception e) {
        System.out.println("Error creating chart: " + e.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        lblTotalRequests = new javax.swing.JLabel();
        lblCompletionRate = new javax.swing.JLabel();
        lblAvgResolutionTime = new javax.swing.JLabel();
        lblPendingRequests = new javax.swing.JLabel();
        lblInProgress = new javax.swing.JLabel();
        lblCompleted = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        btnViewDetails = new javax.swing.JButton();
        btnGenerateReport = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlChart = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitle.setText("Manager Dashboard - Enterprise Analytics");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblTitle)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        lblTotalRequests.setText("Total Requests: 0");

        lblCompletionRate.setText("Completion Rate : 0%");

        lblAvgResolutionTime.setText("Avg Resolution Time: 0 hrs");

        lblPendingRequests.setText("Pending : 0");

        lblInProgress.setText("In Progress : 0");

        lblCompleted.setText("Completed : 0");

        btnViewDetails.setText("View Request Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnViewDetails)
                .addGap(74, 74, 74)
                .addComponent(btnGenerateReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(30, 30, 30))
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails)
                    .addComponent(btnGenerateReport)
                    .addComponent(btnRefresh))
                .addGap(33, 33, 33)
                .addComponent(btnLogout)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlChart.setPreferredSize(new java.awt.Dimension(400, 300));
        pnlChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addComponent(pnlChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalRequests)
                            .addComponent(lblPendingRequests))
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lblCompletionRate))
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(lblInProgress)))
                        .addGap(49, 49, 49)
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addComponent(lblCompleted)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addComponent(lblAvgResolutionTime)
                                .addGap(0, 167, Short.MAX_VALUE))))))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRequests)
                    .addComponent(lblCompletionRate)
                    .addComponent(lblAvgResolutionTime))
                .addGap(53, 53, 53)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPendingRequests)
                    .addComponent(lblInProgress)
                    .addComponent(lblCompleted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
 if (enterprise == null) {
        try {
            enterprise = ecoSystem.getNetworks().get(0).getEnterprises().get(0);
        } catch (Exception e) {
            return;
        }
    }
    
    StringBuilder details = new StringBuilder();
    details.append("ENTERPRISE: ").append(enterprise.getName()).append("\n");
    details.append("Type: ").append(enterprise.getEnterpriseType().getValue()).append("\n\n");
    details.append("ORGANIZATIONS:\n");
    details.append("=====================================\n");
    
    for (model.organization.Organization org : enterprise.getOrganizations()) {
        int orgRequests = org.getWorkQueue().getWorkRequests().size();
        int orgUsers = org.getUserAccounts().size();
        
        details.append("\n").append(org.getName()).append("\n");
        details.append("  Type: ").append(org.getOrganizationType().getValue()).append("\n");
        details.append("  Work Requests: ").append(orgRequests).append("\n");
        details.append("  Staff: ").append(orgUsers).append("\n");
    }
    
    javax.swing.JTextArea textArea = new javax.swing.JTextArea(details.toString());
    textArea.setEditable(false);
    textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
    
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
    scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
    
    javax.swing.JOptionPane.showMessageDialog(this, 
        scrollPane, 
        "Enterprise Details", 
        javax.swing.JOptionPane.INFORMATION_MESSAGE);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
 if (enterprise == null) {
        try {
            enterprise = ecoSystem.getNetworks().get(0).getEnterprises().get(0);
        } catch (Exception e) {
            return;
        }
    }
    
    try {
        model.analytics.Analytics analytics = new model.analytics.Analytics(enterprise);
        model.analytics.AnalyticsReport report = new model.analytics.AnalyticsReport(analytics, 
            "Enterprise Analytics Report - " + enterprise.getName());
        
        String summary = report.getSummary();
        
        StringBuilder fullReport = new StringBuilder(summary);
        fullReport.append("\n\nDETAILED BREAKDOWN:\n");
        fullReport.append("=====================================\n\n");
        
        fullReport.append("BY STATUS:\n");
        java.util.Map<util.enums.Status, Integer> statusMap = analytics.getRequestsByStatus();
        for (util.enums.Status status : statusMap.keySet()) {
            fullReport.append("  ").append(status.getValue()).append(": ")
                     .append(statusMap.get(status)).append("\n");
        }
        
        fullReport.append("\nBY ISSUE TYPE:\n");
        java.util.Map<util.enums.IssueType, Integer> typeMap = analytics.getRequestsByIssueType();
        for (util.enums.IssueType type : typeMap.keySet()) {
            fullReport.append("  ").append(type.getValue()).append(": ")
                     .append(typeMap.get(type)).append("\n");
        }
        
        fullReport.append("\nBY PRIORITY:\n");
        java.util.Map<util.enums.Priority, Integer> priorityMap = analytics.getRequestsByPriority();
        for (util.enums.Priority priority : priorityMap.keySet()) {
            fullReport.append("  ").append(priority.getValue()).append(": ")
                     .append(priorityMap.get(priority)).append("\n");
        }
        
        javax.swing.JTextArea textArea = new javax.swing.JTextArea(fullReport.toString());
        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 500));
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            scrollPane, 
            "Analytics Report - " + report.getReportId(), 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error generating report: " + e.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
      
        
loadAnalytics();
populateChart();
    javax.swing.JOptionPane.showMessageDialog(this, 
        "Analytics refreshed!", 
        "Success", 
        javax.swing.JOptionPane.INFORMATION_MESSAGE);// TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
 int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
        "Are you sure you want to logout?",
        "Confirm Logout",
        javax.swing.JOptionPane.YES_NO_OPTION);
    
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        userProcessContainer.removeAll();
        
        ui.login.LoginJPanel loginPanel = new ui.login.LoginJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add(loginPanel, "Login");
        
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.show(userProcessContainer, "Login");
        
        userProcessContainer.revalidate();
        userProcessContainer.repaint();
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel lblAvgResolutionTime;
    private javax.swing.JLabel lblCompleted;
    private javax.swing.JLabel lblCompletionRate;
    private javax.swing.JLabel lblInProgress;
    private javax.swing.JLabel lblPendingRequests;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalRequests;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables


}
