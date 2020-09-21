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
import br.com.jadson.controllers.exercicio2.ControllerVacina;
import br.com.jadson.models.vo.exercicio2.PessoaVO;
import br.com.jadson.models.vo.exercicio2.VacinaVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CriaVacinasScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel panel;
    public PessoaVO pessoa;

    private JLabel JLnome;
    private JLabel JLnomepesquisador;
    private JComboBox JCnomepesquisador;
    private JLabel JLpais_origem;
    private JLabel JLestado_pesquisa;
    private JLabel JLDT_inicio_pesquisa;
    private JButton cadastrar;

    private VacinaVO vacinaVO;
    private JTextField JTnome;
    private JTextField JTpais_origem;
    private JComboBox JCestado_pesquisa;
    private JTextField JTDT_inicio_pesquisa;
    DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");




    private ActionListener Albutton;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public CriaVacinasScreen() {
        this.build();
    }

    private void build() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);

        panel = new JPanel();

        JLnome = new JLabel("Nome");
        JLnomepesquisador = new JLabel("Nome pesquisador");
        JLpais_origem = new JLabel("Pais Origem");
        JLestado_pesquisa = new JLabel("Estado da pesquisa:");
        JLDT_inicio_pesquisa = new JLabel("DT inicio Pesquisa");
        cadastrar = new JButton("Salvar/Cadastrar");
        vacinaVO = new VacinaVO();


        JTnome = new JTextField(40);
        JTpais_origem = new JTextField(49);
        JTDT_inicio_pesquisa = new JTextField(40);

        String[] estado_pesquisas = {"inicial", "testes", "aplicação em massa"};

        JCestado_pesquisa = new JComboBox(estado_pesquisas);


        ControllerPessoa controllerPessoa = new ControllerPessoa();
        pessoa = new PessoaVO();
        
        pessoa.setTipo("pesquisador");

        ArrayList<PessoaVO> listPesquisadores = controllerPessoa.buscarByTipo(pessoa);        


        JCnomepesquisador = new JComboBox();

        for (int i = 0; i < listPesquisadores.size(); i++) {
    
        JCnomepesquisador.addItem(listPesquisadores.get(i).getNome());

        }

        Albutton = new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e)  {
                
                LocalDate dtInicioPesquisa = LocalDate.parse(JTDT_inicio_pesquisa.getText(), dataFormatter);
                vacinaVO.setDtInicioPesquisa(dtInicioPesquisa);
                vacinaVO.setNomeVacina(JTnome.getText());
                vacinaVO.setEst_pesquisa(""+JCestado_pesquisa.getItemAt(JCestado_pesquisa.getSelectedIndex())+"");
                vacinaVO.setPaisOrigem(JTpais_origem.getText());
                vacinaVO.setNomePesquisador(""+JCnomepesquisador.getItemAt(JCestado_pesquisa.getSelectedIndex())+"");
                ControllerVacina controllerVacina = new ControllerVacina();

                if (controllerVacina.cadastrar(vacinaVO) == 1){
                    JOptionPane.showMessageDialog(null, "Sucesso em criar Vacina");

                }else {
                    JOptionPane.showMessageDialog(null, "Erro em criar Vacina");
                }

            }

        };
        cadastrar.addActionListener(Albutton);
        

        panel.setBackground(new Color(224, 224, 173));

        panel.setLayout(null);

        this.add(panel);

        JLnomepesquisador.setBounds(10, 40,200, 40);
        JCnomepesquisador.setBounds(180, 40, 200, 40);

        JLpais_origem.setBounds(10, 100,200, 40);
        JTpais_origem.setBounds(180, 100,200, 40);

        JLnome.setBounds(10, 160,200, 40);
        JTnome.setBounds(180, 160,200, 40);


        JLestado_pesquisa.setBounds(10, 230,200, 40);
        JCestado_pesquisa.setBounds(180, 230,200, 40);
        
        JLDT_inicio_pesquisa.setBounds(10, 280,200, 40);
        JTDT_inicio_pesquisa.setBounds(180, 280,200, 40);

        cadastrar.setBounds(300, 400, 200, 40);


        panel.add(JLnome);
        panel.add(JLnomepesquisador);
        panel.add(JLpais_origem);
        panel.add(JLestado_pesquisa);
        panel.add(JCestado_pesquisa);
        panel.add(JLDT_inicio_pesquisa);
        panel.add(JCnomepesquisador);
        panel.add(JTpais_origem);
        panel.add(JTnome);
        panel.add(JTDT_inicio_pesquisa);
        panel.add(cadastrar);



        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new CriaVacinasScreen();

    }

    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(null, e.getActionCommand());

    }


}
