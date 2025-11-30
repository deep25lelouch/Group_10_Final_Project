/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.enums;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public enum IssueType {

    POTHOLE("Pothole"),
    STREET_LIGHT("Street Light"),
    WATER_LEAK("Water Leak"),
    POWER_OUTAGE("Power Outage"),
    GARBAGE_OVERFLOW("Garbage Overflow"),
    BLOCKED_DRAIN("Blocked Drain"),
    TREE_HAZARD("Tree Hazard"),
    GRAFFITI("Graffiti"),
    NOISE_COMPLAINT("Noise Complaint"),
    ENVIRONMENTAL_HAZARD("Environmental Hazard"),
    OTHER("Other");

    private String value;

    IssueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
