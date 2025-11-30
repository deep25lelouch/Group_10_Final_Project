package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;
import ui.manager.ManagerDashboardJPanel;

public class HealthInspectorRole extends Role {

    public HealthInspectorRole() {
        super(RoleType.HEALTH_INSPECTOR);
    }

   @Override
public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             EcoSystem system) {

    return new ManagerDashboardJPanel(userProcessContainer, system, account, enterprise);
}
}
