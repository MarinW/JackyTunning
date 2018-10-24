import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabyrintheGraph extends JFrame {

	
	public LabyrintheGraph(Labyrinthe lab){
		super();
		setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("src/Resources/ciaBackground.png"));
        add(background);
        
		build(lab);//On initialise notre fenêtre
	}
	
	

	private void build(Labyrinthe lab){
		setTitle("Jeu des JackyTunning"); //On donne un nom à la fenêtre
		setSize(lab.getLargeur()*40,lab.getHauteur()*40+22); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	}

	public void dessinerLab(Labyrinthe lab) {

		BufferedImage  obstacle = null;
		
		BufferedImage  contourTop = null; //contour alligner haut bas
		BufferedImage  contourBot = null; // contour alligner gauche droite
		BufferedImage  contourHG = null; // coin haut gauche
		BufferedImage  contourBG = null; // coin bas gauche
		BufferedImage  contourHD = null; // coin haut droit
		BufferedImage  contourBD = null; // coin haut droit
		
		BufferedImage  heros = null;

		try {

			File input1 = new File("src/Resources/murTop.png");
			obstacle = ImageIO.read(input1);

			File input2 = new File("src/Resources/murTop.png");
			contourTop = ImageIO.read(input2);
			
			File input3 = new File("src/Resources/murBot.png");
			contourBot = ImageIO.read(input3);
			
			File input4 = new File("src/Resources/monstreBlanc.png");
			contourHG = ImageIO.read(input4);

			File input5 = new File("src/Resources/monstreBlanc.png");
			contourBG = ImageIO.read(input5);
			
			File input6 = new File("src/Resources/monstreBlanc.png");
			contourHD = ImageIO.read(input6);
			
			File input7 = new File("src/Resources/monstreBlanc.png");
			contourBD = ImageIO.read(input7);
			
			File input8 = new File("src/Resources/monstreBlanc.png");
			heros = ImageIO.read(input8);

		} catch (IOException ie) {
			System.out.println("Erreur :"+ie.getMessage());
		}


		for (int i = 0; i < lab.getLargeur(); i++){
			for (int j = 0; j < lab.getHauteur(); j++){
				if (lab.getInt(i, j)==10){
					this.getGraphics().drawImage(obstacle, i*40, (j*40)+22, 40,40, null);
				}
				else if(lab.getInt(i, j)==2) {
					if(i==0 || i==lab.getLargeur()-1) {
						if(i==0 && j==0) this.getGraphics().drawImage(contourHG, i*40, (j*40)+22, 40, 40, null);
						else if(i==0 && j==lab.getHauteur()-1) this.getGraphics().drawImage(contourBG, i*40, (j*40)+22, 40, 40, null);
						else if(i==lab.getLargeur()-1 && j==0) this.getGraphics().drawImage(contourHD, i*40, (j*40)+22, 40, 40, null);
						else if(i==lab.getLargeur()-1 && j==lab.getHauteur()-1) this.getGraphics().drawImage(contourBD, i*40, (j*40)+22, 40, 40, null);
						else this.getGraphics().drawImage(contourTop, i*40, (j*40)+22, 40, 40, null);	
					}
					else if(j==0 || j== lab.getHauteur()-1){
						if (i>0 && i<lab.getLargeur()-1 && j==0) this.getGraphics().drawImage(contourBot, i*40, (j*40)+22, 40, 40, null);	
						else if (i>0 && i<lab.getLargeur()-1 && j== lab.getHauteur()-1 ) this.getGraphics().drawImage(contourBot, i*40, (j*40)+22, 40, 40, null);	
					}
				}
				else if(lab.getInt(i, j)==20) {
					this.getGraphics().drawImage(heros, i*40, (j*40)+22, 40, 40, null);
				} 
			}
		}
	}
}
