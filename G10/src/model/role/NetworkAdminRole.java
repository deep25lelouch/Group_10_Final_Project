package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import ui.admin.AdminDashboardJPanel;
import util.enums.RoleType;

public class NetworkAdminRole extends Role {

    public NetworkAdminRole() {
        super(RoleType.NETWORK_ADMIN);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        return new AdminDashboardJPanel(userProcessContainer, system, account, "NETWORK");
    }
}
