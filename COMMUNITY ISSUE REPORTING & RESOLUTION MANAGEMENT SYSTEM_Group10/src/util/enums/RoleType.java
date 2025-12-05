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
    PUBLIC_WORKS_SUPERVISOR("Public Works Supervisor"),
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
        return this == SYSTEM_ADMIN ||
               this == NETWORK_ADMIN ||
               this == PUBLIC_WORKS_ENTERPRISE_ADMIN ||
               this == UTILITIES_ENTERPRISE_ADMIN ||
               this == SAFETY_ENVIRONMENT_ENTERPRISE_ADMIN ||
               this == EMERGENCY_MANAGEMENT_ENTERPRISE_ADMIN ||
               this == ROAD_MAINTENANCE_ADMIN ||
               this == STREET_LIGHTING_ADMIN ||
               this == WATER_SERVICES_ADMIN ||
               this == ELECTRICAL_SERVICES_ADMIN ||
               this == WASTE_MANAGEMENT_ADMIN ||
               this == ENVIRONMENTAL_HEALTH_ADMIN ||
               this == EMERGENCY_RESPONSE_ADMIN ||
               this == SAFETY_COORDINATION_ADMIN;
    }
}
