import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabyrintheGraph extends JFrame implements KeyListener {

	public LabyrintheGraph(Labyrinthe lab){
		super();
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("Resources/ciaBackground.png"));
		add(background);

		build(lab);//On initialise notre fenêtre
	}



	private void build(Labyrinthe lab){
		setTitle("Jeu des JackyTunning"); //On donne un nom à la fenêtre
		setSize(lab.getLargeur()*40,lab.getHauteur()*40+22); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setAlwaysOnTop(true);
		addKeyListener(this);
		requestFocusInWindow();
	}

	public void dessinerLab(Labyrinthe lab) {

		BufferedImage  obstacle = null;

		BufferedImage  contourTop = null; //contour alligner haut bas
		BufferedImage  contourBot = null; // contour alligner gauche droite
		BufferedImage  contourHG = null; // coin haut gauche
		BufferedImage  contourBG = null; // coin bas gauche
		BufferedImage  contourHD = null; // coin haut droit
		BufferedImage  contourBD = null; // coin haut droit

		BufferedImage  contourG = null; // coin haut droit
		BufferedImage  contourD = null; // coin haut droit

		BufferedImage  heros = null;
		BufferedImage  fantome = null;
		
		BufferedImage  data = null;

		try {

			File input1 = new File("Resources/obstacle.png");
			obstacle = ImageIO.read(input1);

			File input2 = new File("Resources/murH.png");
			contourTop = ImageIO.read(input2);

			File input3 = new File("Resources/murB.png");
			contourBot = ImageIO.read(input3);

			File input4 = new File("Resources/coinHG.png");
			contourHG = ImageIO.read(input4);

			File input5 = new File("Resources/coinBG.png");
			contourBG = ImageIO.read(input5);

			File input6 = new File("Resources/coinHD.png");
			contourHD = ImageIO.read(input6);

			File input7 = new File("Resources/coinBD.png");
			contourBD = ImageIO.read(input7);

			File input8 = new File("Resources/herosBlanc.png");
			heros = ImageIO.read(input8);

			File input9 = new File("Resources/murG.png");
			contourG = ImageIO.read(input9);

			File input10 = new File("Resources/murD.png");
			contourD = ImageIO.read(input10);
			
			File input11 = new File("Resources/monstre.png");
			fantome = ImageIO.read(input11);
			
			File input12 = new File("Resources/data.png");
			data = ImageIO.read(input12);

		} catch (IOException ie) {
			System.out.println("Erreur :"+ie.getMessage());
		}


		for (int i = 0; i < lab.getLargeur(); i++){
			for (int j = 0; j < lab.getHauteur(); j++){
				if (lab.getInt(i, j)==1){
					this.getGraphics().drawImage(obstacle, i*40, (j*40)+22, 40,40, null);
				}
				else if(lab.getInt(i, j)==2) {
					if(i==0 || i==lab.getLargeur()-1) {
						if(i==0 && j==0) this.getGraphics().drawImage(contourHG, i*40, (j*40)+22, 40, 40, null);
						else if(i==0 && j==lab.getHauteur()-1) this.getGraphics().drawImage(contourBG, i*40, (j*40)+22, 40, 40, null);
						else if(i==lab.getLargeur()-1 && j==0) this.getGraphics().drawImage(contourHD, i*40, (j*40)+22, 40, 40, null);
						else if(i==lab.getLargeur()-1 && j==lab.getHauteur()-1) this.getGraphics().drawImage(contourBD, i*40, (j*40)+22, 40, 40, null);
						else if(i==0) this.getGraphics().drawImage(contourG, i*40, (j*40)+22, 40, 40, null);
						else this.getGraphics().drawImage(contourD, i*40, (j*40)+22, 40, 40, null);
					}
					else if(j==0 || j== lab.getHauteur()-1){
						if (i>0 && i<lab.getLargeur()-1 && j==0) this.getGraphics().drawImage(contourTop, i*40, (j*40)+22, 40, 40, null);	
						else if (i>0 && i<lab.getLargeur()-1 && j== lab.getHauteur()-1 ) this.getGraphics().drawImage(contourBot, i*40, (j*40)+22, 40, 40, null);	
					}
				}
				else if(lab.getInt(i, j)==20) {
					this.getGraphics().drawImage(heros, i*40, (j*40)+22, 40, 40, null);
				} 
				else if(lab.getInt(i, j)==30) {
					this.getGraphics().drawImage(fantome, i*40, (j*40)+22, 40, 40, null);
				}
				else if(lab.getInt(i, j)==100) {
					this.getGraphics().drawImage(data, i*40, (j*40)+22, 40, 40, null);
				} 
			}
		}
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		int codeDeLaTouche = arg0.getKeyCode();
		if(!Principale.partieTerminee) {
			
			switch (codeDeLaTouche) 
			{
			case KeyEvent.VK_UP: 
				Principale.deplacerJoueur("H");
				break;
			case KeyEvent.VK_LEFT: 
				Principale.deplacerJoueur("G");
				break;
			case KeyEvent.VK_RIGHT: 
				Principale.deplacerJoueur("D");
				break;
			case KeyEvent.VK_DOWN: 
				Principale.deplacerJoueur("B");
				break;
			}
		}

	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
