package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import ui.citizen.CitizenDashboardJPanel;
import util.enums.RoleType;

public class CitizenRole extends Role {

    public CitizenRole() {
        super(RoleType.CITIZEN);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        // You already confirmed this one works like this
        return new CitizenDashboardJPanel(userProcessContainer, system, account);
    }
}
