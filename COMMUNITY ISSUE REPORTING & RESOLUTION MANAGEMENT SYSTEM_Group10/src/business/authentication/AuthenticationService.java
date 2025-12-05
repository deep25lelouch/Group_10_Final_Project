package business.authentication;

import model.ecosystem.EcoSystem;
import model.network.Network;
import model.enterprise.Enterprise;
import model.organization.Organization;
import model.userAccount.UserAccount;

public class AuthenticationService {

    public static UserAccount authenticate(EcoSystem system, String username, String password) {

        // Loop: Network → Enterprise → Organization → UserAccount
        for (Network network : system.getNetworks()) {

            for (Enterprise enterprise : network.getEnterprises()) {

                for (Organization org : enterprise.getOrganizations()) {

                    for (UserAccount ua : org.getUserAccounts()) {

                        if (matches(ua, username, password)) {
                            return ua;   // FOUND
                        }
                    }
                }
            }
        }

        return null; // Not found
    }

    private static boolean matches(UserAccount ua, String username, String password) {
        return ua.getUsername().equalsIgnoreCase(username)
                && ua.getPassword().equals(password)
                && ua.isActive();
    }
}
