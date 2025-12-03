/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.analytics;
//Rijurik_Saha_002525961
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.workQueue.WorkRequest;
import util.enums.Status;
import util.enums.IssueType;
import util.enums.Priority;
import java.util.*;

/**
 *
 * @author RIO
 */
public class Analytics {
//Rijurik_Saha_002525961
    private Organization organization;
    private Enterprise enterprise;
    private Date startDate;
    private Date endDate;

    public Analytics() {
        // Default to last 30 days
        this.endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -30);
        this.startDate = cal.getTime();
    }

    public Analytics(Organization org) {
        this();
        this.organization = org;
    }

    public Analytics(Enterprise enterprise) {
        this();
        this.enterprise = enterprise;
    }

    // Calculate total requests
    public int getTotalRequests() {
        int total = 0;
        if (organization != null) {
            total = organization.getWorkQueue().getWorkRequests().size();
        } else if (enterprise != null) {
            for (Organization org : enterprise.getOrganizations()) {
                total += org.getWorkQueue().getWorkRequests().size();
            }
        }
        return total;
    }

    // Calculate requests by status
    public Map<Status, Integer> getRequestsByStatus() {
        Map<Status, Integer> statusMap = new HashMap<>();
        List<WorkRequest> requests = getAllRequests();

        for (WorkRequest request : requests) {
            statusMap.put(request.getStatus(),
                    statusMap.getOrDefault(request.getStatus(), 0) + 1);
        }
        return statusMap;
    }

    // Calculate requests by issue type
    public Map<IssueType, Integer> getRequestsByIssueType() {
        Map<IssueType, Integer> typeMap = new HashMap<>();
        List<WorkRequest> requests = getAllRequests();

        for (WorkRequest request : requests) {
            typeMap.put(request.getIssueType(),
                    typeMap.getOrDefault(request.getIssueType(), 0) + 1);
        }
        return typeMap;
    }

    // Calculate requests by priority
    public Map<Priority, Integer> getRequestsByPriority() {
        Map<Priority, Integer> priorityMap = new HashMap<>();
        List<WorkRequest> requests = getAllRequests();

        for (WorkRequest request : requests) {
            priorityMap.put(request.getPriority(),
                    priorityMap.getOrDefault(request.getPriority(), 0) + 1);
        }
        return priorityMap;
    }

    // Calculate average resolution time
    public double getAverageResolutionTime() {
        List<WorkRequest> completedRequests = new ArrayList<>();
        for (WorkRequest request : getAllRequests()) {
            if (request.getStatus() == Status.COMPLETED
                    && request.getResolveDate() != null) {
                completedRequests.add(request);
            }
        }

        if (completedRequests.isEmpty()) {
            return 0;
        }

        long totalTime = 0;
        for (WorkRequest request : completedRequests) {
            long time = request.getResolveDate().getTime()
                    - request.getRequestDate().getTime();
            totalTime += time;
        }

        // Return average in hours
        return (totalTime / completedRequests.size()) / (1000.0 * 60 * 60);
    }

    // Get completion rate
    public double getCompletionRate() {
        int total = getTotalRequests();
        if (total == 0) {
            return 0;
        }

        int completed = 0;
        for (WorkRequest request : getAllRequests()) {
            if (request.getStatus() == Status.COMPLETED
                    || request.getStatus() == Status.CLOSED) {
                completed++;
            }
        }

        return (completed * 100.0) / total;
    }

    // Helper method to get all requests
    private List<WorkRequest> getAllRequests() {
        List<WorkRequest> allRequests = new ArrayList<>();

        if (organization != null) {
            allRequests.addAll(organization.getWorkQueue().getWorkRequests());
        } else if (enterprise != null) {
            for (Organization org : enterprise.getOrganizations()) {
                allRequests.addAll(org.getWorkQueue().getWorkRequests());
            }
        }

        return filterByDateRange(allRequests);
    }

    // Filter requests by date range
    private List<WorkRequest> filterByDateRange(List<WorkRequest> requests) {
        List<WorkRequest> filtered = new ArrayList<>();
        for (WorkRequest request : requests) {
            if (request.getRequestDate().after(startDate)
                    && request.getRequestDate().before(endDate)) {
                filtered.add(request);
            }
        }
        return filtered;
    }

    // Getters and Setters
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
