package com.fannog.proyectocliente;

import com.fannog.proyectocliente.ui.analista.MenuAnalista;
import com.fannog.proyectocliente.ui.login.Login;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Color;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 10);
            UIManager.put("TextComponent.arc", 10);
            UIManager.put("OptionPane.yesButtonText", "Si");
            UIManager.put("OptionPane.noButtonText", "No");

            Color color = UIManager.getColor("ProgressBar.foreground");
            FlatSVGIcon.ColorFilter.getInstance().add(Color.BLACK, color);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MenuAnalista().setVisible(true);
        });

    }
}
