package Class;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class interfaceStart extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4823417960728181597L;
	public static int agentNumber = (int)Math.floor(Math.random()*1000000);
	private static JTextField txtPassword;
	public static JProgressBar progressBar;
	public static JLabel backLoad;
	private static ButtonGroup group = new ButtonGroup();
	private static JRadioButton jRadioButton1;
	private static JRadioButton jRadioButton2;
	private static JRadioButton jRadioButton3;
	
	public interfaceStart(){
		super();
		setLayout(null);
		
		build();//On initialise notre fenêtre
	
	}

	public void build(){
		
		String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/";
		
		setTitle("Jeu des JackyTunning"); //On donne un nom à la fenêtre
		setSize(800,600); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setAlwaysOnTop(true);
		
		backLoad=new JLabel(new ImageIcon(adressedufichier + "iconLoad.png"));
		backLoad.setBounds(321, 122, 158, 158);
		this.add(backLoad,0);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(100, 320, 600, 30);
		progressBar.setValue(0);
		this.add(progressBar,-1);
		
		
		
	}
	
	public void build2() {
		
		String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/";
		
		progressBar.setVisible(false);
		backLoad.setVisible(false);
		
		JButton btnStart = new JButton("Log In");
		btnStart.setBounds(325, 530, 150, 30);
		btnStart.setBackground(Color.GRAY);
		btnStart.addActionListener(new LogInAction());
		this.add(btnStart);
		
		JTextField txtLogin = new JTextField();
		txtLogin.setForeground(Color.GRAY);
		txtLogin.setText("N°"+Integer.toString(agentNumber));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(300, 410, 200, 30);
		txtLogin.setEditable(false);
		this.add(txtLogin);
		
		JLabel txtLabel = new JLabel("Name :");
		txtLabel.setForeground(Color.WHITE);
		txtLabel.setBounds(250, 465, 50, 30);
		this.add(txtLabel);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPassword.setBounds(300, 465, 200, 30);
		this.add(txtPassword);
		
		jRadioButton1 = new JRadioButton("Facile");
		jRadioButton1.setBounds(250, 497, 100, 30);
		jRadioButton1.setSelected(true);
		jRadioButton1.setForeground(Color.WHITE);
		
		jRadioButton2 = new JRadioButton("Moyen");
		jRadioButton2.setBounds(350, 497, 100, 30);
		jRadioButton2.setForeground(Color.WHITE);
		
		jRadioButton3 = new JRadioButton("Dur");
		jRadioButton3.setBounds(450, 497, 100, 30);
		jRadioButton3.setForeground(Color.WHITE);
		
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(jRadioButton3);
		
		
		
		group.add(jRadioButton1);
		group.add(jRadioButton2);
		group.add(jRadioButton3);
		

		JLabel background=new JLabel(new ImageIcon(adressedufichier + "backStart.jpg"));
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(background,-1);
		
	}

	public void miseEnPlaceInterfaceStart() {
		
		Graphics g = this.getGraphics();
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman ",Font.BOLD+Font.ITALIC,30));
		g.drawString("WELCOME Agent N°"+agentNumber, 180, 100);	
		
	}
	
	static class LogInAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			int difficulte = 0;
			
			if(jRadioButton1.isSelected()) {
				difficulte=2;
			}
			else if(jRadioButton2.isSelected()) {
				difficulte=4;
			}
			else {
				difficulte=6;
			}
			
			try {
				Principale.startClick=true;
				Principale.initilisation(txtPassword.getText(),difficulte);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}  
	  }
	
}



