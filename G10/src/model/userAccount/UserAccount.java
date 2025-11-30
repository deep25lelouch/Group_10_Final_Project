/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userAccount;
//Rijurik_Saha_002525961
import model.person.Person;
import model.role.Role;
import model.workQueue.WorkQueue;

/**
 *
 * @author RIO
 */
//Rijurik_Saha_002525961
public class UserAccount {

    private String username;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private boolean isActive;

    public UserAccount() {
        this.workQueue = new WorkQueue();
        this.isActive = true;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
