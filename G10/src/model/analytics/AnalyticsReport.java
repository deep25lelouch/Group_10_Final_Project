/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.analytics;
//Rijurik_Saha_002525961
import java.util.Date;
import java.util.Map;
import util.enums.*;

/**
 *
 * @author RIO
 */
public class AnalyticsReport {
//Rijurik_Saha_002525961
    private String reportId;
    private String title;
    private Date generatedDate;
    private Analytics analytics;

    // Report data
    private int totalRequests;
    private Map<Status, Integer> requestsByStatus;
    private Map<IssueType, Integer> requestsByIssueType;
    private Map<Priority, Integer> requestsByPriority;
    private double averageResolutionTime;
    private double completionRate;

    public AnalyticsReport(Analytics analytics, String title) {
        this.reportId = "RPT-" + System.currentTimeMillis();
        this.title = title;
        this.generatedDate = new Date();
        this.analytics = analytics;
        generateReport();
    }

    private void generateReport() {
        this.totalRequests = analytics.getTotalRequests();
        this.requestsByStatus = analytics.getRequestsByStatus();
        this.requestsByIssueType = analytics.getRequestsByIssueType();
        this.requestsByPriority = analytics.getRequestsByPriority();
        this.averageResolutionTime = analytics.getAverageResolutionTime();
        this.completionRate = analytics.getCompletionRate();
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Analytics Report: ").append(title).append("\n");
        summary.append("Generated: ").append(generatedDate).append("\n");
        summary.append("=====================================\n");
        summary.append("Total Requests: ").append(totalRequests).append("\n");
        summary.append("Completion Rate: ").append(String.format("%.2f%%", completionRate)).append("\n");
        summary.append("Avg Resolution Time: ").append(String.format("%.2f hours", averageResolutionTime)).append("\n");
        return summary.toString();
    }

    // Getters
    public String getReportId() {
        return reportId;
    }

    public String getTitle() {
        return title;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public Map<Status, Integer> getRequestsByStatus() {
        return requestsByStatus;
    }

    public Map<IssueType, Integer> getRequestsByIssueType() {
        return requestsByIssueType;
    }

    public Map<Priority, Integer> getRequestsByPriority() {
        return requestsByPriority;
    }

    public double getAverageResolutionTime() {
        return averageResolutionTime;
    }

    public double getCompletionRate() {
        return completionRate;
    }
}
