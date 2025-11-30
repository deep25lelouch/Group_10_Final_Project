/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.organization;
//Rijurik_Saha_002525961
import model.enterprise.Enterprise;
import model.role.Role;
import model.userAccount.UserAccount;
import model.workQueue.WorkQueue;
import model.person.PersonDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */
public class Organization {
//Rijurik_Saha_002525961
    private String name;
    private OrganizationType organizationType;
    private Enterprise parentEnterprise;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private List<Role> roles;
    private List<UserAccount> userAccounts;

    public enum OrganizationType {
        ROAD_MAINTENANCE("Road Maintenance"),
        STREET_LIGHTING("Street Lighting"),
        WATER_SERVICES("Water Services"),
        ELECTRICAL_SERVICES("Electrical Services"),
        WASTE_MANAGEMENT("Waste Management"),
        ENVIRONMENTAL_HEALTH("Environmental Health"),
        EMERGENCY_RESPONSE("Emergency Response"),
        SAFETY_COORDINATION("Safety Coordination");

        private String value;

        OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name, OrganizationType type, Enterprise enterprise) {
        this.name = name;
        this.organizationType = type;
        this.parentEnterprise = enterprise;
        this.workQueue = new WorkQueue();
        this.personDirectory = new PersonDirectory();
        this.roles = new ArrayList<>();
        this.userAccounts = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public Enterprise getParentEnterprise() {
        return parentEnterprise;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
