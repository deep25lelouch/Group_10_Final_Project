package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;
import ui.worker.WorkerDashboardJPanel;

public class ElectricianRole extends Role {

    public ElectricianRole() {
        super(RoleType.ELECTRICIAN);
    }

    @Override
    public JPanel createWorkArea(
        JPanel userProcessContainer,
        UserAccount account,
        Organization organization,
        Enterprise enterprise,
        EcoSystem system
    ) {
        return new WorkerDashboardJPanel(userProcessContainer, system, account);
    }
}
