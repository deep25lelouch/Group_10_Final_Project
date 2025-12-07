package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;
import ui.supervisor.SupervisorDashboardJPanel;

public class EmergencySupervisorRole extends Role {

    public EmergencySupervisorRole() {
        super(RoleType.EMERGENCY_SUPERVISOR);
    }
    //resolved admin issues
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new SupervisorDashboardJPanel(userProcessContainer, system, account, enterprise);
    }
}
