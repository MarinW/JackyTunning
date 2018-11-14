
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

	public void Degat() {
		this.setPDV(this.getPDV()-1);
	}

}
