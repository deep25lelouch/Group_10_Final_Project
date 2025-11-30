/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.workQueue;
//Rijurik_Saha_002525961
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public class WorkQueue {

    private List<WorkRequest> workRequests;

    public WorkQueue() {
        this.workRequests = new ArrayList<>();
    }

    public void addWorkRequest(WorkRequest request) {
        workRequests.add(request);
    }

    public void removeWorkRequest(WorkRequest request) {
        workRequests.remove(request);
    }

    public List<WorkRequest> getWorkRequests() {
        return workRequests;
    }
}
