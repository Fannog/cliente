package com.fannog.proyectocliente;

import com.fannog.proyectocliente.ui.login.Login;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.StyleContext;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 10);
            UIManager.put("TextComponent.arc", 10);
            UIManager.put("OptionPane.yesButtonText", "Si");
            UIManager.put("OptionPane.noButtonText", "No");

            Font font = StyleContext.getDefaultStyleContext().getFont("Source Sans Pro", Font.PLAIN, 16);
            UIManager.put("defaultFont", font);

            Color svgColor = UIManager.getColor("ProgressBar.foreground");
            FlatSVGIcon.ColorFilter.getInstance().add(Color.BLACK, svgColor);

            Color rowColor = UIManager.getColor("ComboBox.background");
            UIManager.put("Table.alternateRowColor", rowColor);
        } catch (UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });

    }
}
