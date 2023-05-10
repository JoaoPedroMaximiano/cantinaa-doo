package utilies;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utilities {

    public static void ativa(boolean ativa, JPanel painel) {
        for (Component componente : painel.getComponents()) {
            if (!(componente instanceof JButton)) continue;
            componente.setEnabled(((JButton) componente).getActionCommand() == "0" ? ativa : !ativa);
        }
    }
    
    public static void limpaCompenentes(boolean ativa, JPanel painel) {
        for (Component componente : painel.getComponents()) {
            if (componente instanceof JFormattedTextField) ((JFormattedTextField) componente).setText("");
            if (componente instanceof JTextField) ((JTextField) componente).setText("");
            if (componente instanceof JTextArea) ((JTextArea) componente).setText("");
            if (componente instanceof JComboBox) ((JComboBox) componente).setSelectedIndex(-1);
            componente.setEnabled(ativa);
        }
    }
    
}
