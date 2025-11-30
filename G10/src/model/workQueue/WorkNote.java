/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.workQueue;
//Rijurik_Saha_002525961
import model.userAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public class WorkNote {

    private String note;
    private Date timestamp;
    private UserAccount author;

    public WorkNote(String note, UserAccount author) {
        this.note = note;
        this.author = author;
        this.timestamp = new Date();
    }

    // Getters and Setters
    public String getNote() {
        return note;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public UserAccount getAuthor() {
        return author;
    }
}
