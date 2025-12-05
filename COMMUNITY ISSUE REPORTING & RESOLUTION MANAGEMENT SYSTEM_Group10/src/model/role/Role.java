package model.role;

import javax.swing.JPanel;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;
import util.enums.RoleType;

public abstract class Role {

    private RoleType roleType;

    public Role(RoleType type) {
        this.roleType = type;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
                                          UserAccount account,
                                          Organization organization,
                                          Enterprise enterprise,
                                          EcoSystem system);

    @Override
    public String toString() {
        return roleType.getValue();
    }
}
