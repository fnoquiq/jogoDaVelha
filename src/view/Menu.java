package view;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private JFrame frame;

    public void run() {

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("JOGO DA VELHA");
        this.frame.setVisible(true);
        this.frame.setSize(500,500);
        this.frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        this.frame.add(panel, );

        panel.setBorder(
                BorderFactory.createTitledBorder("Métricas - (Atualizado a cada 10 segundos)")
        );

    }

}
