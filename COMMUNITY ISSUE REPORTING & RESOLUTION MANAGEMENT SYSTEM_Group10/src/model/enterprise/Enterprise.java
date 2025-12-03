/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enterprise;
//Rijurik_Saha_002525961
import model.organization.Organization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */
public class Enterprise {
//Rijurik_Saha_002525961
    private String name;
    private EnterpriseType enterpriseType;
    private List<Organization> organizations;

    public enum EnterpriseType {
        PUBLIC_WORKS("Public Works"),
        UTILITIES("Utilities"),
        PUBLIC_SAFETY_ENVIRONMENT("Public Safety & Environment"),
        EMERGENCY_MANAGEMENT("Emergency Management");

        private String value;

        EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Enterprise(String name, EnterpriseType type) {
        this.name = name;
        this.enterpriseType = type;
        this.organizations = new ArrayList<>();
    }

    public Organization createAndAddOrganization(String name, Organization.OrganizationType type) {
        Organization org = new Organization(name, type, this);
        organizations.add(org);
        return org;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }
}
