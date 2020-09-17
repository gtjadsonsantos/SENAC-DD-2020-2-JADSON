package br.com.jadson.views.exercicio2;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import br.com.jadson.components.ModalPessoaCadastro;


public class PessoaScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JMenuBar menubar;
    private JMenuItem menuItemCadastrar;
    private JMenuItem menuItemBuscar;
    private JMenuItem menuItemAtualizar;
    private JMenuItem menuItemExcluir;
    private JMenuItem menuItemVoltar;
    private ActionListener almenuItemCadastrar;
    private ActionListener almenuItemBuscar;
    private ActionListener almenuItemAtualizar;
    private ActionListener almenuItemExcluir;
    private ActionListener almenuItemVoltar;
    private ModalPessoaCadastro modalPessoaCadastro;
    private JMenu menu;
    private  static final int WIDTH = 800;
    private  static final int HEIGHT = 600;
     

    public PessoaScreen() {
        this.build();
    }

    private void build() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        

        panel = new JPanel();
        menubar = new JMenuBar();
        menu = new JMenu("Menu");  
        modalPessoaCadastro = new ModalPessoaCadastro();

        panel.setBounds(0, 0, WIDTH, HEIGHT);
        

        menuItemCadastrar = new JMenuItem("Cadastrar");
        menuItemBuscar = new JMenuItem("Buscar");
        menuItemAtualizar = new JMenuItem("Atualizar");
        menuItemExcluir = new JMenuItem("Excluir");
        menuItemVoltar = new JMenuItem("Voltar");
        
        
        menu.add(menuItemCadastrar);
        menu.add(menuItemBuscar);
        menu.add(menuItemAtualizar);
        menu.add(menuItemExcluir);
        menu.add(menuItemVoltar);


        almenuItemCadastrar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                modalPessoaCadastro.setBounds(2, 0, 400, 300);
                modalPessoaCadastro.setVisible(true);
                panel.add(modalPessoaCadastro);
            }

        };
        almenuItemBuscar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // EXECUTA AÇÃO DISTINTA
            }

        };
        almenuItemAtualizar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // EXECUTA AÇÃO DISTINTA
            }

        };
        almenuItemExcluir = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // EXECUTA AÇÃO DISTINTA
            }

        };
        almenuItemVoltar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PessoaScreen();
            }

        };

        menuItemCadastrar.addActionListener(almenuItemCadastrar);
        menuItemBuscar.addActionListener(almenuItemBuscar);
        menuItemAtualizar.addActionListener(almenuItemAtualizar);
        menuItemExcluir.addActionListener(almenuItemExcluir);
        menuItemVoltar.addActionListener(almenuItemVoltar);

        menubar.add(menu);

        panel.setBackground(new Color(224, 224, 173));

        panel.setLayout(null);

        this.setJMenuBar(menubar);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new PessoaScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
