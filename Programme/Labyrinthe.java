
package Class;

public class Labyrinthe {

	private int hauteur;
	private int largeur;
	int[][] lab;

	public Labyrinthe(int dificulte){
		
		this.hauteur=20;
		this.largeur=20;

		GenerationLabyrintheTexte.Generation(dificulte, hauteur, largeur);
		lab = LectureLabyrintheTexte.Lecture(hauteur, largeur);	
		
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int[][] getLab(){
		return(this.lab);
	}

	public int getInt(int i,int j) {
		return(lab[i][j]);
	}

	public void initJoueur(int x,int y) {
		this.lab[x][y]=20;
	}

	public void initFantome(Fantome[] f) {

		for(Fantome fan:f) {
			this.lab[fan.getX()][fan.getY()]=30;
		}


	}

	public void initData(int x, int y) {
		this.lab[x][y]=100;
	}

}

