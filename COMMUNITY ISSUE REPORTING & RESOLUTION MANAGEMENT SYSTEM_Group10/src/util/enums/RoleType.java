package util.enums;

//Rijurik_Saha_002525961

public enum RoleType {

    // Operational Roles
    CITIZEN("Citizen"),
    ROAD_TECHNICIAN("Road Technician"),
    STREET_LIGHTING_TECHNICIAN("Street Lighting Technician"),
    PLUMBER("Plumber"),
    ELECTRICIAN("Electrician"),
    WASTE_WORKER("Waste Worker"),
    HEALTH_INSPECTOR("Health Inspector"),
    
    // Supervisors (The Dispatchers)
    PUBLIC_WORKS_SUPERVISOR("Public Works Supervisor"),
    UTILITIES_SUPERVISOR("Utilities Supervisor"),           // <--- NEW
    PUBLIC_SAFETY_SUPERVISOR("Public Safety Supervisor"),   // <--- NEW
    EMERGENCY_SUPERVISOR("Emergency Supervisor"),           // <--- NEW

    // Managers/Coordinators (High Level)
    UTILITIES_MANAGER("Utilities Manager"),
    EMERGENCY_COORDINATOR("Emergency Coordinator"),

    // System-level Admins
    SYSTEM_ADMIN("System Administrator"),
    NETWORK_ADMIN("Network Administrator"),

    // Enterprise Admins (4)
    PUBLIC_WORKS_ENTERPRISE_ADMIN("Public Works Enterprise Admin"),
    UTILITIES_ENTERPRISE_ADMIN("Utilities Enterprise Admin"),
    SAFETY_ENVIRONMENT_ENTERPRISE_ADMIN("Safety & Environment Enterprise Admin"),
    EMERGENCY_MANAGEMENT_ENTERPRISE_ADMIN("Emergency Management Enterprise Admin"),

    // Organization Admins (8)
    ROAD_MAINTENANCE_ADMIN("Road Maintenance Admin"),
    STREET_LIGHTING_ADMIN("Street Lighting Admin"),
    WATER_SERVICES_ADMIN("Water Services Admin"),
    ELECTRICAL_SERVICES_ADMIN("Electrical Services Admin"),
    WASTE_MANAGEMENT_ADMIN("Waste Management Admin"),
    ENVIRONMENTAL_HEALTH_ADMIN("Environmental Health Admin"),
    EMERGENCY_RESPONSE_ADMIN("Emergency Response Admin"),
    SAFETY_COORDINATION_ADMIN("Safety Coordination Admin");

    

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isAdmin() {
        return this.name().endsWith("_ADMIN");
    }
}
