import utilensemjava.Lecture;

public class Principale {
	public static void main (String[] args) {
		Avatar Jacky=new Avatar();
		int[][] M= {{1,1,1,1},{1,0,1,1},{1,0,0,1},{1,1,1,1}}; //Mini labyrinthe de test avec 1 pour les murs
		
		String S;
		while(Jacky.getX()!=4 || Jacky.getY()!=1) {
			Jacky.afficher();
			S=Lecture.lireChaine("Où veux tu te déplacer ? (D:Droit,G:Gauche,H:Haut,B:Bas)");
			Jacky.deplacement(S,M);
		}
		System.out.println("Bien joué !");
	}
}
