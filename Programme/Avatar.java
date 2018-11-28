
public class Avatar extends Entite {

	public Avatar(int x,int y,String j) {
		super(x, y, j);
	}

	public Avatar(String j) {
		super(j);
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

	public void Degat(String S, int [][] Lab, ArrayList<Entite> ArrayE) {
		if (S.equals('A')) { //Dégâts sur la zone autour de rayon portee
			int portee = 2;
			int deg = 1; //quantité de points de vie enlevés grâce à l'attaque à chaque monstre touché.
			for (int i=-portee ; i<=portee ; i++){
				for (int j=-portee ; i<=portee ; i++) {
					for (int e = 1 ; e<ArrayE.size() ; ){ //on démarre au 2e terme pour ne pas avoir l'avatar
						if (this.getX()+i == ArrayE.get(e).getX() && this.getY()+j == ArrayE.get(e).getY()){
							ArrayE.get(e).setPDV(ArrayE.get(e).getPDV()-deg);
						}
					}
				}
			}
		}
		else if (S.equals('E')) { //Degâts et contrôle du monstre sur lequel le héros va (manque le contrôle pour le moment)
			int portee = 1;
			int deg = 1; 
			for (int i=-portee ; i<=portee ; i++){
				for (int j=-portee ; i<=portee ; i++) {
					for (int e = 1 ; e<ArrayE.size() ; ){ //on démarre au 2e terme pour ne pas avoir l'avatar
						if (this.getX()+i == ArrayE.get(e).getX() && this.getY()+j == ArrayE.get(e).getY()){
							ArrayE.get(e).setPDV(ArrayE.get(e).getPDV()-deg);
							this.setPDV(this.getPDV()-deg);
						}
					}
				}
			}
		}
	} //Pour le contrôle, il faut ajouter une caractéristique deplacementPossible aux monstres. Elle serait égale au nombre de tours nécessaires avant de pouvoir bouger.
	

}
