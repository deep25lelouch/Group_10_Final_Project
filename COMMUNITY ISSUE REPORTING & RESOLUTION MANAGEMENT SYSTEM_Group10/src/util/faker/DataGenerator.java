/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.faker;
//Rijurik_Saha_002525961
import com.github.javafaker.Faker;
import model.ecosystem.EcoSystem;
import model.enterprise.Enterprise;
import model.location.Location;
import model.network.Network;
import model.organization.Organization;
import model.person.Person;
import model.role.*;
import model.userAccount.UserAccount;
import model.workQueue.WorkRequest;
import util.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author RIO
 */

//Rijurik_Saha_002525961
public class DataGenerator {

    private static Faker faker = new Faker();
    private static Random random = new Random();

    public static void populateEcoSystem(EcoSystem ecoSystem) {
    // 1. Create Network
    Network network = ecoSystem.createAndAddNetwork("Boston Services Network");

    // 2. Create Enterprises
    Enterprise publicWorks = network.createAndAddEnterprise("Public Works", Enterprise.EnterpriseType.PUBLIC_WORKS);
    Enterprise utilities = network.createAndAddEnterprise("Boston Utilities", Enterprise.EnterpriseType.UTILITIES);
    Enterprise publicSafety = network.createAndAddEnterprise("Public Safety & Environment", Enterprise.EnterpriseType.PUBLIC_SAFETY_ENVIRONMENT);
    Enterprise emergency = network.createAndAddEnterprise("Emergency Management", Enterprise.EnterpriseType.EMERGENCY_MANAGEMENT);
    
    // NEW: The Home for Citizens
    Enterprise residentEnt = network.createAndAddEnterprise("Resident Services", Enterprise.EnterpriseType.RESIDENT_SERVICES);

    // 3. Create Organizations
    Organization roadMaintenance = publicWorks.createAndAddOrganization("Road Maintenance", Organization.OrganizationType.ROAD_MAINTENANCE);
    Organization streetLighting = publicWorks.createAndAddOrganization("Street Lighting", Organization.OrganizationType.STREET_LIGHTING);
    Organization waterServices = utilities.createAndAddOrganization("Water Services", Organization.OrganizationType.WATER_SERVICES);
    Organization electricalServices = utilities.createAndAddOrganization("Electrical Services", Organization.OrganizationType.ELECTRICAL_SERVICES);
    Organization wasteMgmt = publicSafety.createAndAddOrganization("Waste Management", Organization.OrganizationType.WASTE_MANAGEMENT);
    Organization envHealth = publicSafety.createAndAddOrganization("Environmental Health", Organization.OrganizationType.ENVIRONMENTAL_HEALTH);
    Organization emergencyResponse = emergency.createAndAddOrganization("Emergency Response", Organization.OrganizationType.EMERGENCY_RESPONSE);
    Organization safetyCoord = emergency.createAndAddOrganization("Safety Coordination", Organization.OrganizationType.SAFETY_COORDINATION);
    
    // NEW: The Organization for Citizens
    Organization residentOrg = residentEnt.createAndAddOrganization("Residents Association", Organization.OrganizationType.SAFETY_COORDINATION); // Using Safety Coord type as placeholder or add a new CITIZEN type if preferred

    // 4. Generate Users for each Organization (Workers)
    generateUsersForOrganization(roadMaintenance, new RoadTechnicianRole(), 5);
    generateUsersForOrganization(streetLighting, new StreetLightingTechnicianRole(), 4);
    generateUsersForOrganization(waterServices, new PlumberRole(), 5);
    generateUsersForOrganization(electricalServices, new ElectricianRole(), 4);
    generateUsersForOrganization(wasteMgmt, new WasteWorkerRole(), 6);
    generateUsersForOrganization(envHealth, new HealthInspectorRole(), 3);

    // 5. Generate Supervisors and Managers
    generateSupervisor(publicWorks);
    generateSupervisor(utilities);
    generateSupervisor(publicSafety);
    generateSupervisor(emergency);
    generateManager(utilities);
    generateEmergencyCoordinator(emergency);

    // 6. Generate Citizens (Now in the correct Organization!)
    generateUsersForOrganization(residentOrg, new CitizenRole(), 10);

    // 7. Generate Sample Work Requests
    generateWorkRequests(roadMaintenance, 15);
    generateWorkRequests(waterServices, 10);
    generateWorkRequests(electricalServices, 8);

    // 8. Create Admin Users (THE MISSING PIECE)
    createCorrectAdminUsers(network, publicWorks, roadMaintenance);
    
    // Print logic
    printGeneratedUsers(network);
}
    

    private static void generateUsersForOrganization(Organization org, Role role, int count) {
        for (int i = 0; i < count; i++) {
            Person person = org.getPersonDirectory().createAndAddPerson(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().cellPhone()
            );
            person.setAddress(faker.address().streetAddress());

            UserAccount account = new UserAccount();
            account.setUsername(person.getFirstName().toLowerCase() + "."
                    + person.getLastName().toLowerCase());
            account.setPassword("Password123!"); // Default password
            account.setPerson(person);
            account.setRole(role);

            org.getUserAccounts().add(account);
        }
    }

    private static void generateSupervisor(Enterprise enterprise) {
        Organization org = enterprise.getOrganizations().get(0);
        Person person = org.getPersonDirectory().createAndAddPerson(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone()
        );

        UserAccount account = new UserAccount();
        account.setUsername("supervisor." + enterprise.getName().replaceAll(" ", "").toLowerCase());
        account.setPassword("Supervisor123!");
        account.setPerson(person);
        account.setRole(new PublicWorksSupervisorRole());

        org.getUserAccounts().add(account);
    }

    private static void generateManager(Enterprise enterprise) {
        Organization org = enterprise.getOrganizations().get(0);
        Person person = org.getPersonDirectory().createAndAddPerson(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone()
        );

        UserAccount account = new UserAccount();
        account.setUsername("manager." + enterprise.getName().replaceAll(" ", "").toLowerCase());
        account.setPassword("Manager123!");
        account.setPerson(person);
        account.setRole(new UtilitiesManagerRole());

        org.getUserAccounts().add(account);
    }

    private static void generateEmergencyCoordinator(Enterprise enterprise) {
        Organization org = enterprise.getOrganizations().get(0);
        Person person = org.getPersonDirectory().createAndAddPerson(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone()
        );

        UserAccount account = new UserAccount();
        account.setUsername("emergency.coordinator");
        account.setPassword("Emergency123!");
        account.setPerson(person);
        account.setRole(new EmergencyCoordinatorRole());

        org.getUserAccounts().add(account);
    }

    private static List<Person> generateCitizens(int count) {
        List<Person> citizens = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Person citizen = new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().cellPhone()
            );
            citizen.setAddress(faker.address().streetAddress());
            citizens.add(citizen);
        }
        return citizens;
    }

    private static void generateWorkRequests(Organization org, int count) {
        IssueType[] issueTypes = IssueType.values();
        Priority[] priorities = Priority.values();
        Status[] statuses = {Status.NEW, Status.ASSIGNED, Status.IN_PROGRESS};

        for (int i = 0; i < count; i++) {
            WorkRequest request = new WorkRequest();
            request.setIssueType(issueTypes[random.nextInt(issueTypes.length)]);
            request.setPriority(priorities[random.nextInt(priorities.length)]);
            request.setStatus(statuses[random.nextInt(statuses.length)]);
            request.setDescription(generateIssueDescription(request.getIssueType()));
            request.setLocation(generateRandomLocation());
            request.setCitizenId("CIT-" + faker.number().digits(6));

            org.getWorkQueue().addWorkRequest(request);
        }
    }

    private static String generateIssueDescription(IssueType type) {
        switch (type) {
            case POTHOLE:
                return "Large pothole on " + faker.address().streetName()
                        + " causing traffic hazard. Approximately "
                        + faker.number().numberBetween(2, 10) + " inches deep.";
            case STREET_LIGHT:
                return "Street light not working at " + faker.address().streetAddress()
                        + ". Area is completely dark at night.";
            case WATER_LEAK:
                return "Water leak detected near " + faker.address().streetName()
                        + ". Water pooling on sidewalk.";
            case POWER_OUTAGE:
                return "Power outage affecting " + faker.number().numberBetween(5, 50)
                        + " houses on " + faker.address().streetName();
            case GARBAGE_OVERFLOW:
                return "Garbage bins overflowing at " + faker.address().streetAddress()
                        + ". Attracting pests.";
            default:
                return "Issue reported at " + faker.address().streetAddress()
                        + ". Requires immediate attention.";
        }
    }
    private static void generateCitizenAccounts(EcoSystem ecoSystem, int count) {
    // Get first organization to store citizen accounts
    Organization org = ecoSystem.getNetworks().get(0)
                      .getEnterprises().get(0)
                      .getOrganizations().get(0);
    
    for (int i = 0; i < count; i++) {
        Person citizen = org.getPersonDirectory().createAndAddPerson(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.phoneNumber().cellPhone()
        );
        citizen.setAddress(faker.address().streetAddress());
        
        UserAccount account = new UserAccount();
        account.setUsername("citizen" + (i + 1));
        account.setPassword("Password123!");
        account.setPerson(citizen);
        account.setRole(new model.role.CitizenRole());
        
        org.getUserAccounts().add(account);
        ecoSystem.addUserAccount(account); // If this method exists
    }
}

    private static Location generateRandomLocation() {
        Location location = new Location();
        location.setStreet(faker.address().streetAddress());
        location.setZipCode(faker.address().zipCode());
        location.setLandmark("Near " + faker.company().name());
        location.setLatitude(42.3601 + (random.nextDouble() - 0.5) * 0.1);
        location.setLongitude(-71.0589 + (random.nextDouble() - 0.5) * 0.1);
        return location;
    }

    private static void createAdminUsers(Network network) {
        // System Admin
        Organization org = network.getEnterprises().get(0).getOrganizations().get(0);
        Person sysAdmin = org.getPersonDirectory().createAndAddPerson(
                "System", "Admin", "sysadmin@boston.gov", "617-555-0001"
        );
        UserAccount sysAdminAccount = new UserAccount();
        sysAdminAccount.setUsername("sysadmin");
        sysAdminAccount.setPassword("Admin123!");
        sysAdminAccount.setPerson(sysAdmin);
        sysAdminAccount.setRole(new SystemAdminRole());
        org.getUserAccounts().add(sysAdminAccount);

        // Network Admin
        Person netAdmin = org.getPersonDirectory().createAndAddPerson(
                "Network", "Admin", "netadmin@boston.gov", "617-555-0002"
        );
        UserAccount netAdminAccount = new UserAccount();
        netAdminAccount.setUsername("netadmin");
        netAdminAccount.setPassword("Admin123!");
        netAdminAccount.setPerson(netAdmin);
        netAdminAccount.setRole(new NetworkAdminRole());
        org.getUserAccounts().add(netAdminAccount);
    }
    private static void createCorrectAdminUsers(Network network, Enterprise sampleEnterprise, Organization sampleOrg) {
    // A. System Admin (Global) - We place him in the first org just for storage, but his Role gives him global access
    Organization storageOrg = network.getEnterprises().get(0).getOrganizations().get(0);
    
    UserAccount sysAdmin = new UserAccount();
    sysAdmin.setUsername("sysadmin");
    sysAdmin.setPassword("Admin123!");
    sysAdmin.setRole(new SystemAdminRole());
    sysAdmin.setPerson(new Person("System", "Admin", "sys@sys.com", "000"));
    storageOrg.getUserAccounts().add(sysAdmin);

    // B. Network Admin (Manages Boston)
    UserAccount netAdmin = new UserAccount();
    netAdmin.setUsername("netadmin");
    netAdmin.setPassword("Admin123!");
    netAdmin.setRole(new NetworkAdminRole());
    netAdmin.setPerson(new Person("Network", "Admin", "net@sys.com", "000"));
    storageOrg.getUserAccounts().add(netAdmin);

    // C. Enterprise Admin (Manages Public Works) - Stored inside Public Works
    Organization pwStorage = sampleEnterprise.getOrganizations().get(0);
    UserAccount entAdmin = new UserAccount();
    entAdmin.setUsername("admin.publicworks");
    entAdmin.setPassword("Admin123!");
    entAdmin.setRole(new PublicWorksEnterpriseAdminRole());
    entAdmin.setPerson(new Person("PW", "Admin", "pw@sys.com", "000"));
    pwStorage.getUserAccounts().add(entAdmin);

    // D. Organization Admin (Manages Road Maintenance) - Stored inside Road Maintenance
    UserAccount orgAdmin = new UserAccount();
    orgAdmin.setUsername("admin.road");
    orgAdmin.setPassword("Admin123!");
    orgAdmin.setRole(new RoadMaintenanceAdminRole());
    orgAdmin.setPerson(new Person("Road", "Admin", "road@sys.com", "000"));
    sampleOrg.getUserAccounts().add(orgAdmin);
}
    private static void printAllCredentials() {
        System.out.println("\n========================================");
        System.out.println("GENERATED USER CREDENTIALS FOR TESTING");
        System.out.println("========================================\n");

        System.out.println("DEFAULT PASSWORDS FOR ALL USERS:");
        System.out.println("---------------------------------");
        System.out.println("Workers: Password123!");
        System.out.println("Supervisors: Supervisor123!");
        System.out.println("Managers: Manager123!");
        System.out.println("Emergency: Emergency123!");
        System.out.println("Admins: Admin123!");
        System.out.println("\n---------------------------------\n");

        System.out.println("SPECIAL ACCOUNTS:");
        System.out.println("---------------------------------");
        System.out.println("System Admin -> Username: sysadmin | Password: Admin123!");
        System.out.println("Network Admin -> Username: netadmin | Password: Admin123!");
        System.out.println("Public Works Supervisor -> Username: supervisor.publicworksdepartment | Password: Supervisor123!");
        System.out.println("Utilities Manager -> Username: manager.bostonutilities | Password: Manager123!");
        System.out.println("Emergency Coordinator -> Username: emergency.coordinator | Password: Emergency123!");

        System.out.println("\n========================================");
        System.out.println("ALL GENERATED USERS:");
        System.out.println("========================================\n");
    }

    private static void printGeneratedUsers(Network network) {
        System.out.println("\n========================================");
        System.out.println("GENERATED USER CREDENTIALS FOR TESTING");
        System.out.println("========================================\n");

        System.out.println("QUICK LOGIN CREDENTIALS:");
        System.out.println("---------------------------------");
        System.out.println("System Admin -> Username: sysadmin | Password: Admin123!");
        System.out.println("Network Admin -> Username: netadmin | Password: Admin123!");
        System.out.println("Supervisor -> Username: supervisor.publicworksdepartment | Password: Supervisor123!");
        System.out.println("Manager -> Username: manager.bostonutilities | Password: Manager123!");
        System.out.println("Emergency -> Username: emergency.coordinator | Password: Emergency123!");
        System.out.println("---------------------------------\n");

        int userCount = 1;

        System.out.println("ALL GENERATED USERS BY DEPARTMENT:");
        System.out.println("===================================");

        for (Enterprise enterprise : network.getEnterprises()) {
            System.out.println("\n------ " + enterprise.getName() + " ------");

            for (Organization org : enterprise.getOrganizations()) {
                if (!org.getUserAccounts().isEmpty()) {
                    System.out.println("\n  Organization: " + org.getName());
                    System.out.println("  --------------------------");

                    for (UserAccount account : org.getUserAccounts()) {
                        System.out.println("  " + userCount + ". Username: " + account.getUsername()
                                + " | Password: " + account.getPassword()
                                + " | Role: " + account.getRole().toString());
                        userCount++;
                    }
                }
            }
        }

        System.out.println("\n========================================");
        System.out.println("Total Users Generated: " + (userCount - 1));
        System.out.println("========================================\n");

        // Also print some sample work requests
        System.out.println("SAMPLE WORK REQUESTS GENERATED:");
        System.out.println("---------------------------------");
        int requestCount = 0;
        for (Enterprise enterprise : network.getEnterprises()) {
            for (Organization org : enterprise.getOrganizations()) {
                requestCount += org.getWorkQueue().getWorkRequests().size();
            }
        }
        System.out.println("Total Work Requests Created: " + requestCount);
        System.out.println("---------------------------------\n");
    }
}
