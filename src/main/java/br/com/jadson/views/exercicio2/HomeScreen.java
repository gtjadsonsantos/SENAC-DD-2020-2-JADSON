package br.com.jadson.views.exercicio2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton pessoas;
    private JButton vacinas;
    private JLabel title;
    private ActionListener alPessoas;
    private ActionListener alVacinas;

    public HomeScreen() {
        this.build();
    }

    private void build() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        pessoas = new JButton("Pessoas");
        vacinas = new JButton("Vacinas");
        title = new JLabel("HOSPITAL");

        pessoas.setBounds(200, 300, 200, 30);
        vacinas.setBounds(200, 250, 200, 30);
        title.setBounds(260, 70, 200, 30);

        pessoas.setBorderPainted(false);
        vacinas.setBorderPainted(false);

        ActionListener alPessoas = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //EXECUTA A TELA DO MENU PESSOA
            }

        };
        ActionListener alVacinas = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //EXECUTA A TELA DO MENU VACINA

            }

        };

        pessoas.addActionListener(alPessoas);
        vacinas.addActionListener(alVacinas);

        panel.add(pessoas);
        panel.add(vacinas);
        panel.add(title);

        panel.setBackground(new Color(224, 224, 173));

        panel.setLayout(null);
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new HomeScreen();
    }

}
