package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;
import ui.supervisor.SupervisorDashboardJPanel;

public class PublicWorksSupervisorRole extends Role {

    public PublicWorksSupervisorRole() {
        super(RoleType.PUBLIC_WORKS_SUPERVISOR);
    }

   @Override
public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             EcoSystem system) {

    return new SupervisorDashboardJPanel(userProcessContainer, system, account, organization);
}
}
