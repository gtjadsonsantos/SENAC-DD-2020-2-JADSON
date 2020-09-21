package br.com.jadson.views.exercicio2;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jadson.controllers.exercicio2.ControllerPessoa;
import br.com.jadson.models.vo.exercicio2.PessoaVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriaPessoaScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    public PessoaVO pessoa;
    private JLabel JLnome;
    private JLabel JLsexo;
    private JLabel Jcpf;
    private JLabel JLtipo;
    private JLabel JLinstituicao;

    private JButton cadastrar;
    private JTextField JTnome;
    private JTextField JTsexo;
    private JTextField JTcpf;
    private JComboBox Comboboxtipo;
    private JTextField JTinstituicao;

    private ActionListener Albutton;
    private ActionListener Alcomboboxtipo;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public CriaPessoaScreen() {
        this.build();
    }

    private void build() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        JLnome = new JLabel("Nome");
        JLsexo = new JLabel("Sexo (M|F)");
        Jcpf = new JLabel("Cpf");
        JLtipo = new JLabel("Tipo:");
        JLinstituicao = new JLabel("Instituicao");
        cadastrar = new JButton("Salvar/Cadastrar");
        JTnome = new JTextField(40);
        JTsexo = new JTextField(1);
        JTcpf = new JTextField(11);
        JTinstituicao = new JTextField(30);
        JTinstituicao.setVisible(false);

        String country[] = { "pesquisador", "voluntario" };


        Comboboxtipo = new JComboBox(country);

        Comboboxtipo.setBounds(150, 210, 200, 30);

        JLnome.setBounds(10, 20, 100, 30);
        JLsexo.setBounds(10, 70, 100, 30);
        Jcpf.setBounds(10, 120, 100, 30);
        JLtipo.setBounds(10, 190, 100, 50);
        JLinstituicao.setBounds(10, 290, 100, 30);
        cadastrar.setBounds(300, 400, 200, 40);

        JTnome.setBounds(90, 20, 100, 30);
        JTsexo.setBounds(90, 70, 100, 30);
        JTcpf.setBounds(90, 120, 100, 30);
        JTinstituicao.setBounds(150, 290, 200, 30);

        Albutton = new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                cadastrarPessoa();

            }

        };

        Alcomboboxtipo = new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                if (Comboboxtipo.getItemAt(Comboboxtipo.getSelectedIndex()).equals("pesquisador")) {
                    JTinstituicao.setVisible(true);
                }
            }

        };

        cadastrar.addActionListener(Albutton);
        Comboboxtipo.addActionListener(Alcomboboxtipo);
        panel.setBackground(new Color(224, 224, 173));

        panel.setLayout(null);

        this.add(panel);

        panel.add(JLnome);
        panel.add(JLsexo);
        panel.add(Jcpf);
        panel.add(JLtipo);
        panel.add(JLinstituicao);
        panel.add(Comboboxtipo);

        panel.add(JTnome);
        panel.add(JTsexo);
        panel.add(JTcpf);
        panel.add(JTinstituicao);

        panel.add(cadastrar);

        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new CriaPessoaScreen();

    }

    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(null, e.getActionCommand());

    }

    private void cadastrarPessoa() {

        final PessoaVO pessoa = new PessoaVO();
        final ControllerPessoa controllerPessoa = new ControllerPessoa();

        pessoa.setCpf(this.JTcpf.getText());
        pessoa.setInstituicao(this.JTinstituicao.getText());
        pessoa.setSexo(this.JTsexo.getText().charAt(0));
        pessoa.setTipo("" + Comboboxtipo.getItemAt(Comboboxtipo.getSelectedIndex()));
        pessoa.setNome(JTnome.getText());

        if (controllerPessoa.cadastrar(pessoa)) {
            JOptionPane.showMessageDialog(null, "Pessoas cadastrar com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a pessoa");
        }

    }

}
