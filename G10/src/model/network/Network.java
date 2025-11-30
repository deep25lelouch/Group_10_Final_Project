/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.network;
//Rijurik_Saha_002525961
import model.enterprise.Enterprise;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */
public class Network {
//Rijurik_Saha_002525961
    private String name;
    private List<Enterprise> enterprises;

    public Network(String name) {
        this.name = name;
        this.enterprises = new ArrayList<>();
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = new Enterprise(name, type);
        enterprises.add(enterprise);
        return enterprise;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enterprise> getEnterprises() {
        return enterprises;
    }
}
