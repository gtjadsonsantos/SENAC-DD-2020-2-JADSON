package br.com.jadson.views.exercicio1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jadson.models.vo.exercicio1.ImcExercicio1;
import br.com.jadson.controllers.exercicio1.ControllerImcExercicio1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.*;

public class AppExercicio1 extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -6982432662948850063L;
	private JPanel panel;
	private JTextField jtfWeight;
	private JTextField jtfHeigth;
	private JButton jbcalculate;
	private ImageIcon imageLogo;
	private JLabel containerImage;

	public AppExercicio1() {
		this.build();
	}

	private void build() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);

		panel = new JPanel();

		jtfWeight = new JTextField(30);
		jtfHeigth = new JTextField(30);
		jbcalculate = new JButton("Calcular");

		Path path = Paths.get("src/main/java/br/com/jadson/imgs/imcExercicio1.png");

		imageLogo = new ImageIcon(path.toAbsolutePath().toString());
		containerImage = new JLabel(imageLogo);

		containerImage.setBounds(100, 0, 400, 200);

		jtfHeigth.setBounds(200, 200, 200, 30);
		jtfHeigth.setText("Altura");

		jtfWeight.setBounds(200, 255, 200, 30);
		jtfWeight.setText("Peso");

		jbcalculate.setBounds(200, 300, 200, 30);
		jbcalculate.setBorderPainted(false);
		jbcalculate.setBackground(new Color(207, 180, 101));

		// Adding Event ActionListener to elements
		jbcalculate.addActionListener(this);

		// Adding Elements in window
		panel.add(jtfHeigth);
		panel.add(jtfWeight);
		panel.add(jbcalculate);
		panel.add(containerImage);

		panel.setBackground(new Color(224, 224, 173));

		panel.setLayout(null);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AppExercicio1();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		ImcExercicio1 imc = new ImcExercicio1();

		try {
			imc.setHeigth(Double.parseDouble(this.jtfHeigth.getText()));
			imc.setWeight(Double.parseDouble(this.jtfWeight.getText()));

			ControllerImcExercicio1 controllerImc = new ControllerImcExercicio1();

			double result = controllerImc.calculateImc(imc);

			JOptionPane.showMessageDialog(null, result);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números");
		}

	}
}
