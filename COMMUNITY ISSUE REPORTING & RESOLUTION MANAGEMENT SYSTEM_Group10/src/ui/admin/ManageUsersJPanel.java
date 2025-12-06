/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.admin;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.ecosystem.EcoSystem;

/**
 *
 * @author RIO
 */
public class ManageUsersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUsersJPanel
     */
    private JPanel workArea;
    private EcoSystem ecoSystem;
       private javax.swing.JPanel userProcessContainer;
       private javax.swing.table.DefaultTableModel tableModel;
    
    
    
   public ManageUsersJPanel(JPanel workArea, EcoSystem ecoSystem) {
    this.workArea = workArea;
    this.ecoSystem = ecoSystem;
    initComponents();
    
    setupTable();
    loadOrganizations();
    loadRoles();
    loadUsers();
    setupPasswordListener();
    
}
   
   private void setupTable() {
    tableModel = (DefaultTableModel) tblUsers.getModel();
    tblUsers.setRowHeight(25);
    tblUsers.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
}

private void loadOrganizations() {
    cmbOrganization.removeAllItems();
    try {
        for (model.network.Network network : ecoSystem.getNetworks()) {
            for (model.enterprise.Enterprise enterprise : network.getEnterprises()) {
                for (model.organization.Organization org : enterprise.getOrganizations()) {
                    cmbOrganization.addItem(org.getName());
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadRoles() {
    cmbRole.removeAllItems();
    for (util.enums.RoleType roleType : util.enums.RoleType.values()) {
        cmbRole.addItem(roleType.getValue());
    }
}

private void loadUsers() {
    tableModel.setRowCount(0);
    try {
        for (model.network.Network network : ecoSystem.getNetworks()) {
            for (model.enterprise.Enterprise enterprise : network.getEnterprises()) {
                for (model.organization.Organization org : enterprise.getOrganizations()) {
                    for (model.userAccount.UserAccount account : org.getUserAccounts()) {
                        Object[] row = {
                            account.getUsername(),
                            account.getPerson() != null ? account.getPerson().getFullName() : "N/A",
                            account.getRole() != null ? account.getRole().toString() : "N/A",
                            account.getPerson() != null ? account.getPerson().getEmail() : "N/A",
                            account.isActive() ? "Active" : "Inactive"
                        };
                        tableModel.addRow(row);
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void setupPasswordListener() {
    txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            String password = new String(txtPassword.getPassword());
            String strength = business.validation.ValidationHelper.getPasswordStrength(password);
            lblPasswordStrength.setText("Password Strength: " + strength);
            if ("Strong".equals(strength)) {
                lblPasswordStrength.setForeground(new java.awt.Color(0, 128, 0));
            } else if ("Medium".equals(strength)) {
                lblPasswordStrength.setForeground(new java.awt.Color(255, 140, 0));
            } else {
                lblPasswordStrength.setForeground(java.awt.Color.RED);
            }
        }
    });
}

private void clearForm() {
    txtFirstName.setText("");
    txtLastName.setText("");
    txtEmail.setText("");
    txtPhone.setText("");
    txtUsername.setText("");
    txtPassword.setText("");
    txtConfirmPassword.setText("");
    lblPasswordStrength.setText("Password Strength:");
    lblPasswordStrength.setForeground(java.awt.Color.BLACK);
    if (cmbOrganization.getItemCount() > 0) cmbOrganization.setSelectedIndex(0);
    if (cmbRole.getItemCount() > 0) cmbRole.setSelectedIndex(0);
}

private model.role.Role createRoleFromName(String roleName) {
    for (util.enums.RoleType roleType : util.enums.RoleType.values()) {
        if (roleType.getValue().equals(roleName)) {
            switch (roleType) {
                case CITIZEN: return new model.role.CitizenRole();
                case ROAD_TECHNICIAN: return new model.role.RoadTechnicianRole();
                case STREET_LIGHTING_TECHNICIAN: return new model.role.StreetLightingTechnicianRole();
                case PLUMBER: return new model.role.PlumberRole();
                case ELECTRICIAN: return new model.role.ElectricianRole();
                case WASTE_WORKER: return new model.role.WasteWorkerRole();
                case HEALTH_INSPECTOR: return new model.role.HealthInspectorRole();
                case PUBLIC_WORKS_SUPERVISOR: return new model.role.PublicWorksSupervisorRole();
                case UTILITIES_MANAGER: return new model.role.UtilitiesManagerRole();
                case EMERGENCY_COORDINATOR: return new model.role.EmergencyCoordinatorRole();
                case SYSTEM_ADMIN: return new model.role.SystemAdminRole();
                case NETWORK_ADMIN: return new model.role.NetworkAdminRole();
                case PUBLIC_WORKS_ENTERPRISE_ADMIN: return new model.role.PublicWorksEnterpriseAdminRole();
                case UTILITIES_ENTERPRISE_ADMIN: return new model.role.UtilitiesEnterpriseAdminRole();
                case SAFETY_ENVIRONMENT_ENTERPRISE_ADMIN: return new model.role.SafetyEnvironmentEnterpriseAdminRole();
                case EMERGENCY_MANAGEMENT_ENTERPRISE_ADMIN: return new model.role.EmergencyManagementEnterpriseAdminRole();
                case ROAD_MAINTENANCE_ADMIN: return new model.role.RoadMaintenanceAdminRole();
                case STREET_LIGHTING_ADMIN: return new model.role.StreetLightingAdminRole();
                case WATER_SERVICES_ADMIN: return new model.role.WaterServicesAdminRole();
                case ELECTRICAL_SERVICES_ADMIN: return new model.role.ElectricalServicesAdminRole();
                case WASTE_MANAGEMENT_ADMIN: return new model.role.WasteManagementAdminRole();
                case ENVIRONMENTAL_HEALTH_ADMIN: return new model.role.EnvironmentalHealthAdminRole();
                case EMERGENCY_RESPONSE_ADMIN: return new model.role.EmergencyResponseAdminRole();
                case SAFETY_COORDINATION_ADMIN: return new model.role.SafetyCoordinationAdminRole();
                default: return new model.role.CitizenRole();
            }
        }
    }
    return new model.role.CitizenRole();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        spiltPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        formPanel = new javax.swing.JPanel();
        lblFormTitle = new javax.swing.JLabel();
        lblOrganization = new javax.swing.JLabel();
        cmbOrganization = new javax.swing.JComboBox<>();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblPasswordStrength = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCreateUser = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        bottomPanel = new javax.swing.JPanel();
        btnDeleteUser = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitle.setText("Manage Users");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(lblTitle)
                .addContainerGap(396, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        spiltPane.setDividerLocation(450);

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Name", "Role", "Email", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblUsers);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        spiltPane.setLeftComponent(jPanel1);

        lblFormTitle.setText("Create New User");

        lblOrganization.setText("Organization");

        lblFirstName.setText("First Name:");

        lblLastName.setText("Last Name:");

        lblEmail.setText("Email:");

        lblPhone.setText("Phone:");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        lblConfirmPassword.setText("Confirm Password:");

        lblRole.setText("Role");

        lblPasswordStrength.setText("Password Strength:");

        btnCreateUser.setText("Create User");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnClearForm.setText("Clear");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFirstName)
                                .addComponent(lblLastName)
                                .addComponent(lblEmail)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(lblOrganization)
                            .addGap(3, 3, 3)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFormTitle)
                                .addGroup(formPanelLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFirstName)
                                        .addComponent(cmbOrganization, 0, 97, Short.MAX_VALUE)
                                        .addComponent(txtLastName)
                                        .addComponent(txtEmail)
                                        .addComponent(txtPhone))))))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnCreateUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClearForm))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(lblConfirmPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                    .addComponent(lblPhone)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUsername)
                                            .addComponent(lblPassword))
                                        .addGap(42, 42, 42)
                                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                            .addComponent(txtPassword)))
                                    .addComponent(lblPasswordStrength))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(125, 125, 125))
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRole)
                .addGap(84, 84, 84)
                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addComponent(lblFormTitle)
                .addGap(10, 10, 10)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrganization, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(lblPasswordStrength)
                        .addGap(18, 18, 18)
                        .addComponent(lblRole)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateUser)
                            .addComponent(btnClearForm))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        spiltPane.setRightComponent(formPanel);

        add(spiltPane, java.awt.BorderLayout.CENTER);

        btnDeleteUser.setText("Delete Selected User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnDeleteUser)
                .addGap(37, 37, 37)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteUser)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addGap(34, 34, 34))
        );

        add(bottomPanel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed

 String firstName = txtFirstName.getText().trim();
    String lastName = txtLastName.getText().trim();
    String email = txtEmail.getText().trim();
    String phone = txtPhone.getText().trim();
    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword());
    String confirmPassword = new String(txtConfirmPassword.getPassword());
    
    if (!business.validation.ValidationHelper.isValidName(firstName)) {
        JOptionPane.showMessageDialog(this, "Invalid first name (min 2 characters)!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!business.validation.ValidationHelper.isValidName(lastName)) {
        JOptionPane.showMessageDialog(this, "Invalid last name!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!business.validation.ValidationHelper.isValidEmail(email)) {
        JOptionPane.showMessageDialog(this, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!business.validation.ValidationHelper.isValidPhone(phone)) {
        JOptionPane.showMessageDialog(this, "Invalid phone (format: 123-456-7890)!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (username.isEmpty() || username.length() < 4) {
        JOptionPane.showMessageDialog(this, "Username must be 4+ characters!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!business.validation.ValidationHelper.isValidPassword(password)) {
        JOptionPane.showMessageDialog(this, 
            "Password must have 8+ chars, uppercase, lowercase, digit, special char!", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords don't match!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        String selectedOrgName = (String) cmbOrganization.getSelectedItem();
        model.organization.Organization selectedOrg = null;
        
        for (model.network.Network network : ecoSystem.getNetworks()) {
            for (model.enterprise.Enterprise enterprise : network.getEnterprises()) {
                for (model.organization.Organization org : enterprise.getOrganizations()) {
                    if (org.getName().equals(selectedOrgName)) {
                        selectedOrg = org;
                        break;
                    }
                }
                if (selectedOrg != null) break;
            }
            if (selectedOrg != null) break;
        }
        
        if (selectedOrg == null) {
            JOptionPane.showMessageDialog(this, "Organization not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        model.person.Person person = selectedOrg.getPersonDirectory()
                                     .createAndAddPerson(firstName, lastName, email, phone);
        
        model.userAccount.UserAccount newAccount = new model.userAccount.UserAccount();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setPerson(person);
        
        String selectedRoleName = (String) cmbRole.getSelectedItem();
        model.role.Role role = createRoleFromName(selectedRoleName);
        newAccount.setRole(role);
        
        selectedOrg.getUserAccounts().add(newAccount);
        
        JOptionPane.showMessageDialog(this, 
            "User created!\nUsername: " + username, 
            "Success", JOptionPane.INFORMATION_MESSAGE);
        
        clearForm();
        loadUsers();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
 clearForm();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
  int selectedRow = tblUsers.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user!", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String username = (String) tableModel.getValueAt(selectedRow, 0);
    
    int confirm = JOptionPane.showConfirmDialog(this,
        "Delete user: " + username + "?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            boolean deleted = false;
            
            outerLoop:
            for (model.network.Network network : ecoSystem.getNetworks()) {
                for (model.enterprise.Enterprise enterprise : network.getEnterprises()) {
                    for (model.organization.Organization org : enterprise.getOrganizations()) {
                        model.userAccount.UserAccount toDelete = null;
                        for (model.userAccount.UserAccount account : org.getUserAccounts()) {
                            if (account.getUsername().equals(username)) {
                                toDelete = account;
                                break;
                            }
                        }
                        if (toDelete != null) {
                            org.getUserAccounts().remove(toDelete);
                            deleted = true;
                            break outerLoop;
                        }
                    }
                }
            }
            
            if (deleted) {
                JOptionPane.showMessageDialog(this, "User deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadUsers();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
loadUsers();
    JOptionPane.showMessageDialog(this, "Refreshed!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
workArea.remove(this);
    CardLayout layout = (CardLayout) workArea.getLayout();
    layout.previous(workArea);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbOrganization;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFormTitle;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordStrength;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSplitPane spiltPane;
    private javax.swing.JTable tblUsers;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables


}
