
public class testInterface {
	
	public static void main(String[] args) {

		Labyrinthe lab = new Labyrinthe(20,20,2);
		LabyrintheGraph fenetre = new LabyrintheGraph(lab);
		fenetre.setVisible(true); 
		try {
			Thread.sleep(2000); //temps de chargement
		}
		catch(InterruptedException e) {
		System.out.println(e.getMessage());
		}
		fenetre.dessinerLab(lab);
		
	}


}
