package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;
import ui.emergency.EmergencyCoordinatorJPanel;

public class EmergencyCoordinatorRole extends Role {

    public EmergencyCoordinatorRole() {
        super(RoleType.EMERGENCY_COORDINATOR);
    }

 @Override
public JPanel createWorkArea(
        JPanel userProcessContainer,
        UserAccount account,
        Organization organization,
        Enterprise enterprise,
        EcoSystem system
) {
    return new EmergencyCoordinatorJPanel(userProcessContainer, system, account, enterprise);
}

}
