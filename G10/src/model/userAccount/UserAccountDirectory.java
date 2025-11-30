package model.userAccount;
//Rijurik_Saha_002525961

import java.util.ArrayList;
import java.util.List;
import model.person.Person;
import model.role.Role;

public class UserAccountDirectory {

    private List<UserAccount> userAccountList;

    public UserAccountDirectory() {
        this.userAccountList = new ArrayList<>();
    }

    public UserAccount createUserAccount(String username, String password, Person person, Role role) {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);

        userAccountList.add(userAccount);
        return userAccount;
    }

    public UserAccount authenticate(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username) &&
                ua.getPassword().equals(password) &&
                ua.isActive()) {
                return ua;
            }
        }
        return null;
    }

    public List<UserAccount> getUserAccountList() {
        return userAccountList;
    }
}
