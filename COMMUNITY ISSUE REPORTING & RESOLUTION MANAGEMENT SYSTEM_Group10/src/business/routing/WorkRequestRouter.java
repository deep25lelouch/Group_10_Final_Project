/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.routing;
//Rijurik_Saha_002525961
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.workQueue.WorkRequest;
import util.enums.IssueType;
import java.util.List;

/**
 *
 * @author RIO
 */
public class WorkRequestRouter {
//Rijurik_Saha_002525961
    public static Organization routeToOrganization(WorkRequest request, Enterprise enterprise) {
        IssueType issueType = request.getIssueType();
        List<Organization> organizations = enterprise.getOrganizations();

        // First check if it's an emergency - route to emergency response
        if (request.getPriority() == util.enums.Priority.EMERGENCY) {
            for (Organization org : organizations) {
                if (org.getOrganizationType() == Organization.OrganizationType.EMERGENCY_RESPONSE) {
                    return org;
                }
            }
        }

        // Then route based on issue type
        for (Organization org : organizations) {
            if (canHandleIssue(org, issueType)) {
                return org;
            }
        }
        return null;
    }

    private static boolean canHandleIssue(Organization org, IssueType issueType) {
        switch (org.getOrganizationType()) {
            case ROAD_MAINTENANCE:
                return issueType == IssueType.POTHOLE
                        || issueType == IssueType.BLOCKED_DRAIN;

            case STREET_LIGHTING:
                return issueType == IssueType.STREET_LIGHT;

            case WATER_SERVICES:
                return issueType == IssueType.WATER_LEAK;

            case ELECTRICAL_SERVICES:
                return issueType == IssueType.POWER_OUTAGE;

            case WASTE_MANAGEMENT:
                return issueType == IssueType.GARBAGE_OVERFLOW;

            case ENVIRONMENTAL_HEALTH:
                return issueType == IssueType.ENVIRONMENTAL_HAZARD
                        || issueType == IssueType.NOISE_COMPLAINT;

            case EMERGENCY_RESPONSE:
                // Emergency Response handles all emergency priority issues
                return true; // Will be filtered by priority in the main routing method

            case SAFETY_COORDINATION:
                return issueType == IssueType.TREE_HAZARD;

            default:
                return false;
        }
    }

    public static Enterprise routeToEnterprise(WorkRequest request, model.network.Network network) {
        IssueType issueType = request.getIssueType();
        List<Enterprise> enterprises = network.getEnterprises();

        for (Enterprise enterprise : enterprises) {
            if (canEnterpriseHandle(enterprise, issueType)) {
                return enterprise;
            }
        }
        return null;
    }

    private static boolean canEnterpriseHandle(Enterprise enterprise, IssueType issueType) {
        switch (enterprise.getEnterpriseType()) {
            case PUBLIC_WORKS:
                return issueType == IssueType.POTHOLE
                        || issueType == IssueType.STREET_LIGHT
                        || issueType == IssueType.BLOCKED_DRAIN;

            case UTILITIES:
                return issueType == IssueType.WATER_LEAK
                        || issueType == IssueType.POWER_OUTAGE;

            case PUBLIC_SAFETY_ENVIRONMENT:
                return issueType == IssueType.GARBAGE_OVERFLOW
                        || issueType == IssueType.ENVIRONMENTAL_HAZARD
                        || issueType == IssueType.NOISE_COMPLAINT
                        || issueType == IssueType.GRAFFITI;

            case EMERGENCY_MANAGEMENT:
                return issueType == IssueType.TREE_HAZARD;

            default:
                return false;
        }
    }

    public static boolean isHighPriority(WorkRequest request) {
        return request.getPriority() == util.enums.Priority.CRITICAL
                || request.getPriority() == util.enums.Priority.EMERGENCY;
    }

    public static boolean requiresCrossOrganizationWork(WorkRequest request) {
        // Water leak might need road work
        if (request.getIssueType() == IssueType.WATER_LEAK
                && request.getDescription().toLowerCase().contains("road")) {
            return true;
        }
        // Tree hazard might need electrical services
        if (request.getIssueType() == IssueType.TREE_HAZARD
                && request.getDescription().toLowerCase().contains("power line")) {
            return true;
        }
        return false;
    }
}
