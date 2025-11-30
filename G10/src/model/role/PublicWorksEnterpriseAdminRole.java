package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import ui.admin.AdminDashboardJPanel;
import util.enums.RoleType;

public class PublicWorksEnterpriseAdminRole extends Role {

    public PublicWorksEnterpriseAdminRole() {
        super(RoleType.PUBLIC_WORKS_ENTERPRISE_ADMIN);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        return new AdminDashboardJPanel(userProcessContainer, system, account, "ENTERPRISE");
    }
}
