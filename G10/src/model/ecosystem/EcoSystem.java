/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ecosystem;
//Rijurik_Saha_002525961
import model.network.Network;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */
public class EcoSystem {
//Rijurik_Saha_002525961
    
    
    private static EcoSystem instance;
    private String name;
    private List<Network> networks;

    private EcoSystem() {
        this.name = "Boston Municipal Services";
        this.networks = new ArrayList<>();
    }

    public static EcoSystem getInstance() {
        if (instance == null) {
            instance = new EcoSystem();
        }
        return instance;
    }

    public Network createAndAddNetwork(String name) {
        Network network = new Network(name);
        networks.add(network);
        return network;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Network> getNetworks() {
        return networks;
    }
    public void addUserAccount(model.userAccount.UserAccount ua) {
    userAccounts.add(ua);
}

private List<model.userAccount.UserAccount> userAccounts = new ArrayList<>();
public List<model.userAccount.UserAccount> getUserAccounts() {
    return userAccounts;
}

}
