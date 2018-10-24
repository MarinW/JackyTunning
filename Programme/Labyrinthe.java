
public class Labyrinthe {

	private int hauteur;
	private int largeur;
	int[][] lab;

	public Labyrinthe(int hauteur, int largeur, int dificulte){
		this.hauteur=hauteur;
		this.largeur=largeur;

		lab = new int[hauteur][largeur];

		for (int i = 0; i < largeur; i++){
			lab[0][i] = 2;
			lab[hauteur - 1][i] = 2;
		}

		for (int i = 0; i < hauteur; i++){
			lab[i][0] = 2;
			lab[i][largeur - 1] = 2;
		}
		
		for (int i = 1; i < largeur - 1; i++){

			for (int j = 1; j < largeur - 1; j++){

				double test = Math.random();

				if (test < (0.5/(0.5/dificulte))/20){

					lab[i][j] = 10; //10 obstacle

				}

			}

		}
		
		lab[3][10] = 20; // Monstre

	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getInt(int i,int j) {
		return(lab[i][j]);
	}


}

