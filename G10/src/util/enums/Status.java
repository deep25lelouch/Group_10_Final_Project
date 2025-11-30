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
public enum Status {
    NEW("New"),
    ASSIGNED("Assigned"),
    IN_PROGRESS("In Progress"),
    ESCALATED("Escalated"),
    PENDING("Pending"),
    COMPLETED("Completed"),
    CLOSED("Closed"),
    CANCELLED("Cancelled");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
