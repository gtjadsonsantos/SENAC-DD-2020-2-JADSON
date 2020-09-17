package br.com.jadson.views.exercicio2;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import br.com.jadson.components.Sidebar;


public class HomeScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private Sidebar sidebar;
    private  static final int WIDTH = 800;
    private  static final int HEIGHT = 600;

    public HomeScreen() {
        this.build();
    }

    private void build() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        sidebar = new Sidebar();
        sidebar.setBounds(0, 0, 200, 600);
       


        panel.add(sidebar);

        panel.setBackground(new Color(224, 224, 173));

        panel.setLayout(null);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);
    }


    public static void main(final String[] args) {
        new HomeScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
