/**
 **DESCRIPCIÓN: Programa con interfaz que soluciona una ecuación de segundo grado con una variable.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 08 de Noviembre de 2019
 **VERSION:1.0
 */
package punto1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Window extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JLabel lblExponente;
	private JLabel lblDato1;
	private JLabel lblError;
	private JButton btnSalir;
	private JButton btnCalcular;
	private JRadioButton rdbtnRBMinusA;
	private JRadioButton rdbtnRBPlusA;
	private JRadioButton rdbtnRBMinusB;
	private JRadioButton rdbtnRBPlusB;
	private JRadioButton rdbtnRBPlusC;
	private JRadioButton rdbtnRBMinusC;
	private JLabel lblLosResultadosSon;
	private final ButtonGroup buttonGroupA = new ButtonGroup();
	private final ButtonGroup buttonGroupB = new ButtonGroup();
	private final ButtonGroup buttonGroupC = new ButtonGroup();
	private Despeje calculo;
	private Ecuacion formula;
	private Lineal primerGrado;
	private JLabel lblDato2;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window ventana = new Window();
					ventana.setVisible(true);
					JOptionPane.showMessageDialog(null, "Buen día!!\n\nPrograma que le permite resolver una ecuación cuadrática");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Window() {
		initComponents();
		calculo=new Despeje();
		formula=new Ecuacion();
		primerGrado= new Lineal();
	}
	
	
	public JTextField getTextFieldA() {
		return textFieldA;
	}

	public void setTextFieldA(JTextField textFieldA) {
		this.textFieldA = textFieldA;
	}

	public JTextField getTextFieldB() {
		return textFieldB;
	}

	public void setTextFieldB(JTextField textFieldB) {
		this.textFieldB = textFieldB;
	}

	public JTextField getTextFieldC() {
		return textFieldC;
	}

	public void setTextFieldC(JTextField textFieldC) {
		this.textFieldC = textFieldC;
	}


	public void initComponents(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInstruccion = new JLabel("INGRESE LA ECUACI\u00D3N A RESOLVER:");
		lblInstruccion.setForeground(Color.GRAY);
		lblInstruccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblInstruccion.setBounds(72, 11, 385, 33);
		panel.add(lblInstruccion);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(73, 159, 45, 30);
		panel.add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setColumns(10);
		textFieldB.setBounds(211, 159, 45, 30);
		panel.add(textFieldB);
		
		textFieldC = new JTextField();
		textFieldC.setColumns(10);
		textFieldC.setBounds(335, 159, 45, 30);
		panel.add(textFieldC);
		
		rdbtnRBPlusA = new JRadioButton("+");
		rdbtnRBPlusA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupA.add(rdbtnRBPlusA);
		rdbtnRBPlusA.setSelected(true);
		rdbtnRBPlusA.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBPlusA.setBounds(22, 154, 45, 23);
		panel.add(rdbtnRBPlusA);
		
		rdbtnRBMinusA = new JRadioButton("-");
		rdbtnRBMinusA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupA.add(rdbtnRBMinusA);
		rdbtnRBMinusA.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBMinusA.setBounds(22, 179, 45, 23);
		panel.add(rdbtnRBMinusA);
		
		rdbtnRBPlusB = new JRadioButton("+");
		rdbtnRBPlusB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupB.add(rdbtnRBPlusB);
		rdbtnRBPlusB.setSelected(true);
		rdbtnRBPlusB.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBPlusB.setBounds(160, 154, 45, 23);
		panel.add(rdbtnRBPlusB);
		
		rdbtnRBMinusB = new JRadioButton("-");
		rdbtnRBMinusB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupB.add(rdbtnRBMinusB);
		rdbtnRBMinusB.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBMinusB.setBounds(160, 179, 45, 23);
		panel.add(rdbtnRBMinusB);
		
		rdbtnRBPlusC = new JRadioButton("+");
		rdbtnRBPlusC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupC.add(rdbtnRBPlusC);
		rdbtnRBPlusC.setSelected(true);
		rdbtnRBPlusC.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBPlusC.setBounds(284, 154, 45, 23);
		panel.add(rdbtnRBPlusC);
		
		rdbtnRBMinusC = new JRadioButton("-");
		rdbtnRBMinusC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroupC.add(rdbtnRBMinusC);
		rdbtnRBMinusC.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnRBMinusC.setBounds(284, 179, 45, 23);
		panel.add(rdbtnRBMinusC);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.BLUE);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblError.setBounds(10, 36, 464, 116);
		panel.add(lblError);
		
		lblExponente = new JLabel("2");
		lblExponente.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblExponente.setBounds(140, 163, 46, 14);
		panel.add(lblExponente);
		
		JLabel lblEcuacion = new JLabel("a     x          b   x           c =0");
		lblEcuacion.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblEcuacion.setBounds(73, 159, 411, 33);
		panel.add(lblEcuacion);
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBackground(Color.BLACK);
		btnCalcular.setBounds(177, 214, 112, 23);
		panel.add(btnCalcular);
		btnCalcular.addActionListener(this);
		
		lblLosResultadosSon = new JLabel("LOS RESULTADOS SON:  ");
		lblLosResultadosSon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLosResultadosSon.setForeground(Color.RED);
		lblLosResultadosSon.setBounds(140, 226, 206, 48);
		panel.add(lblLosResultadosSon);
		
		lblDato1 = new JLabel("X1:");
		lblDato1.setForeground(Color.DARK_GRAY);
		lblDato1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblDato1.setBounds(80, 272, 290, 33);
		panel.add(lblDato1);
		
		lblDato2 = new JLabel("X2:");
		lblDato2.setForeground(Color.DARK_GRAY);
		lblDato2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblDato2.setBounds(80, 317, 290, 33);
		panel.add(lblDato2);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(180, 350, 100, 30);
		panel.add(btnSalir);
		

		JLabel lblWallpaper = new JLabel("wallpaper");
		lblWallpaper.setBounds(0, 0, 500,400);
		lblWallpaper.setIcon(new ImageIcon(Window.class.getResource("/resources/wallpaperMath.jpg")));
		panel.add(lblWallpaper);

	}

	private void limpiar() {
		lblError.setText("");
		lblDato1.setText("X1: ");
		lblDato2.setText("X2: ");
	}
	
	private void asignarDatos(String a, String b, String c){
		
		formula.setA(Float.parseFloat(a));
		formula.setB(Float.parseFloat(b));
		formula.setC(Float.parseFloat(c));
	}
	
	private void asignarSignos(float a, float b, float c) {
		if (rdbtnRBMinusA.isSelected() == true) {
			formula.setA(a*-1);
		}
		if (rdbtnRBMinusB.isSelected() == true) {
			formula.setB(b*-1);
		}
		if (rdbtnRBMinusC.isSelected() == true) {
			formula.setC(c*-1);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnCalcular)) {
		limpiar();
			try {
			asignarDatos(textFieldA.getText(), textFieldB.getText(), textFieldC.getText());
			if(formula.getA()==0) {
				if(formula.getB()==0&&formula.getC()==0) {
					lblError.setText("    \t\t   \tESTA ES UNA IDENTIDAD \n\n\t0=0");
					lblLosResultadosSon.setVisible(false);
					lblDato1.setText("");
					lblDato2.setText("");
				}else if(formula.getB()==0||formula.getC()==0) {
					lblError.setText("    \t\t   \tESTA NO ES UNA ECUACION");
					lblLosResultadosSon.setVisible(false);
					lblDato1.setText("");
					lblDato2.setText("");
			}else {
				lblError.setText("    \t\t   \tECUACIÓN LINEAL");
				lblLosResultadosSon.setVisible(true);
				asignarSignos(formula.getA(), formula.getB(), formula.getC());
				primerGrado.resolverIncognita(formula.getB(), formula.getC());
				lblDato1.setText("\t\tX= "+(float)primerGrado.getSolucion());
				lblDato2.setText("");
			
			}
			}else if(formula.getA()<0||formula.getB()<0||formula.getC()<0){
				lblError.setText("SE HA ASIGNADO UN SIGNO DE MANERA INCORRECTA");
				lblLosResultadosSon.setVisible(false);
			}else{
				lblLosResultadosSon.setVisible(true);
			asignarSignos(formula.getA(), formula.getB(), formula.getC());
			calculo.setDiscriminante(formula.getA(), formula.getB(), formula.getC());
			calculo.resolverIncognita(formula.getA(), formula.getB(), formula.getC());
			if(calculo.isImaginario()) {
			lblDato1.setText("X1= "+(float)(calculo.getVariable1()-calculo.getNumImaginario())+" + "+(float)calculo.getNumImaginario()+" i");
			}else {
				lblDato1.setText("X1= "+(float)calculo.getVariable1());
			}
			if(calculo.isImaginario()) {
				lblDato2.setText("X2= "+(float)(calculo.getVariable2()+calculo.getNumImaginario())+" - "+(float)calculo.getNumImaginario()+" i");
				}else {
					lblDato2.setText("X2= "+(float)calculo.getVariable2());
				}
			}
			}catch(NumberFormatException nfe) {
				lblError.setText("NO TODOS LOS DATOS INGRESADOS SON NÚMEROS");
				lblLosResultadosSon.setVisible(false);
			}
		
		}
			if (e.getSource().equals(btnSalir)) {
				JOptionPane.showMessageDialog(null,"TENGA BUEN DÍA\n\nGRACIAS!!");
				dispose();
			}
	}
	}
