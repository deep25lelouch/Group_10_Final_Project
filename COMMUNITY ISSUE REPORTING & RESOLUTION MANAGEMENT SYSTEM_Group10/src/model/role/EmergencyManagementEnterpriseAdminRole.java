package model.role;
//Rijurik_Saha_002525961

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import ui.admin.AdminDashboardJPanel;
import util.enums.RoleType;
public class EmergencyManagementEnterpriseAdminRole extends Role {
    public EmergencyManagementEnterpriseAdminRole() { super(RoleType.EMERGENCY_MANAGEMENT_ENTERPRISE_ADMIN); }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        return new AdminDashboardJPanel(userProcessContainer, system, account, "ENTERPRISE");
    }
}
