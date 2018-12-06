
package Class;

import java.util.ArrayList;

public class Avatar extends Entite {

	public Avatar(int x,int y,String j) {
		super(x, y, j);
		setPDV(10);
	}

	public Avatar(String j) {
		super(j);
		setPDV(10);
	}

	public void afficher() {
		System.out.println(this.getJ()+"("+this.getX()+","+this.getY()+")");
	}

	public void deplacement(String S,int [][] Lab, LabyrintheGraph fenetre) {

		switch(S) {

		case "D":

			switch(Lab[this.getX()+1][this.getY()]) {
			case 2 : // contour
				break;
			case 1:
				break;
			default: // Sinon
				this.setX(this.getX()+1);
				fenetre.repaint((this.getX()-1)*40, this.getY()*40+22, 40, 40);
				break;
			}
			break;

		case "G":

			switch(Lab[this.getX()-1][this.getY()]) {
			case 2 : // contour
				break;
			case 1:
				break;
			default: // Sinon
				this.setX(this.getX()-1);
				fenetre.repaint((this.getX()+1)*40, this.getY()*40+22, 40, 40);
				break;
			}
			break;

		case "H":

			switch(Lab[this.getX()][this.getY()-1]) {
			case 2 : // contour
				break;
			case 1:
				break;
			default: // Sinon
				this.setY(this.getY()-1);
				fenetre.repaint((this.getX())*40, (this.getY()+1)*40+22, 40, 40);
				break;
			}

			break;

		case "B":

			switch(Lab[this.getX()][this.getY()+1]) {
			case 2 : // contour
				break;
			case 1:
				break;
			default: // Sinon
				this.setY(this.getY()+1);
				fenetre.repaint((this.getX())*40, (this.getY()-1)*40+22, 40, 40);
				break;
			}

			break;

		default:
			break;
		}
	}

	public void degats(String S, int [][] Lab, ArrayList<Entite> ArrayE) {
		if (S.equals("A")) { //DÃ©gÃ¢ts sur la zone autour de rayon portee
			int portee = 2;
			int deg = 1; //quantitÃ© de points de vie enlevÃ©s grÃ¢ce Ã  l'attaque Ã  chaque monstre touchÃ©.
			for (int i=-portee ; i<=portee ; i++){
				for (int j=-portee ; j<=portee ; j++) {	
					for (int e = 1 ; e<ArrayE.size() ; e++){ //on dÃ©marre au 2e terme pour ne pas avoir l'avatar	
						if (this.getX()+i == ArrayE.get(e).getX() && this.getY()+j == ArrayE.get(e).getY()){
							ArrayE.get(e).setPDV(ArrayE.get(e).getPDV()-deg);							
							System.out.println("Vie de " + ArrayE.get(e).getJ() + " :" + ArrayE.get(e).getPDV());
						}						
					}
				}
			}
			System.out.println("Votre vie : " + this.getPDV());
		}
		else if (S.equals("E")) { //DegÃ¢ts et contrÃ´le du monstre sur lequel le hÃ©ros va 
			int portee = 1;
			int deg = 1; 
			for (int i=-portee ; i<=portee ; i++){
				for (int j=-portee ; j<=portee ; j++) {
					for (int e = 1 ; e<ArrayE.size() ; e++){ //on dÃ©marre au 2e terme pour ne pas avoir l'avatar
						if (this.getX()+i == ArrayE.get(e).getX() && this.getY()+j == ArrayE.get(e).getY()){
							ArrayE.get(e).setPDV(ArrayE.get(e).getPDV()-deg);
							this.setPDV(this.getPDV()-deg);
							ArrayE.get(e).setDeplacementpossible(getDeplacementpossible() + 1);							
							System.out.println("Vie de " + ArrayE.get(e).getJ() + " :" + ArrayE.get(e).getPDV());
						}						
					}
				}
				System.out.println("Votre vie : " + this.getPDV());
			}
		} 
	}

	@Override
	String deplacementInt(int[][] Lab, Avatar A) {
		// TODO Auto-generated method stub
		return null;
	}

}
