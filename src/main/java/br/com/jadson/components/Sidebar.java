package br.com.jadson.components;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import br.com.jadson.views.exercicio2.PessoaScreen;

public class Sidebar extends JPanel  {
    private static final long serialVersionUID = 1L;
    private JButton pessoas;
    private JButton vacinas;
    private JButton notas;
    private ActionListener alPessoas;
    private ActionListener alVacinas;
    private ActionListener alNotas;
    
   public Sidebar(){
        this.setBackground(new Color(51,153,255));
        

        pessoas = new JButton("Pessoas");
        vacinas = new JButton("Vacinas");
        notas = new JButton("Notas");

        pessoas.setBounds(0, 140, 200, 40);
        vacinas.setBounds(0, 190, 200, 40);
        notas.setBounds(0, 240, 200, 40);

        vacinas.setBackground(new Color(175,238,238));
        notas.setBackground(new Color(175,238,238));
        pessoas.setBackground(new Color(175,238,238));

        pessoas.setBorderPainted(false);
        vacinas.setBorderPainted(false);
        notas.setBorderPainted(false);


        alPessoas = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PessoaScreen();
            }

        };
         alVacinas = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //EXECUTA A TELA DO MENU VACINA

            }

        };
        alNotas = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //EXECUTA A TELA DO MENU VACINA

            }

        };
        

        pessoas.addActionListener(alPessoas);
        vacinas.addActionListener(alVacinas);
        notas.addActionListener(alNotas);
        

        this.add(pessoas);
        this.add(vacinas);
        this.add(notas);

        this.setLayout(null);
        this.setVisible(true);
    }

    
}
