/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.main;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author RIO
 */
public abstract class BaseJPanel extends JPanel {

    protected JPanel userProcessContainer;
    protected CardLayout cardLayout;

    public BaseJPanel(JPanel userProcessContainer) {
        this.userProcessContainer = userProcessContainer;
        this.cardLayout = (CardLayout) userProcessContainer.getLayout();
        initComponents();
        setupLayout();
    }

    protected abstract void initComponents();

    protected abstract void setupLayout();

    protected void navigateTo(JPanel panel, String panelName) {
        userProcessContainer.add(panelName, panel);
        cardLayout.show(userProcessContainer, panelName);
    }

    protected void navigateBack() {
        userProcessContainer.remove(this);
        cardLayout.previous(userProcessContainer);
    }
}
