package br.com.jadson.components;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import br.com.jadson.views.exercicio2.PessoaScreen;

public class ModalPessoaCadastro extends JPanel   {
    private static final long serialVersionUID = 1L;
    private JLabel JLName;
    private JLabel JLSexo;
    private JLabel JLCpf;
    private JLabel JLtipo;
    private JLabel JLIntituicao;

    private JTextField JTFName;
    private JTextField JTFSexo;
    private JTextField JTFCpf;
    private JTextField JTFtipo;
    private JTextField JTFIntituicao;

   public ModalPessoaCadastro(){
        JLName = new JLabel("Name");
        JLSexo = new JLabel("Sexo");
        JLCpf = new JLabel("Cpf");
        JLtipo = new JLabel("Tipo");
        JLIntituicao = new JLabel("Instituicao");



       // JTFName.setBounds(100, 150, 200, 30);
       // JTFSexo.setBounds(100, 160, 200, 30);
       // JTFCpf.setBounds(100, 170, 200, 30);
       // JTFtipo.setBounds(100, 180, 200, 30);
       // JTFIntituicao.setBounds(100, 190, 200, 30);
        //
       // this.add(JTFName);
       // this.add(JTFSexo);
       // this.add(JTFCpf);
       // this.add(JTFtipo);
       // this.add(JTFIntituicao);

        this.add(JLName);
        this.add(JLSexo);
        this.add(JLCpf);
        this.add(JLtipo);
        this.add(JLIntituicao);
    }

    
}

