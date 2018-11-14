
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
		if(S.equals("D")) {
			if(Lab[this.getX()+1][this.getY()]==1 || Lab[this.getX()+1][this.getY()]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setX(this.getX()+1);
				Lab[this.getX()-1][this.getY()]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX()-1)*40, this.getY()*40+22, 40, 40);
			}
		}
		else if(S.equals("G")) {
			if(Lab[this.getX()-1][this.getY()]==1 || Lab[this.getX()-1][this.getY()]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setX(this.getX()-1);
				Lab[this.getX()+1][this.getY()]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX()+1)*40, this.getY()*40+22, 40, 40);
				}
		}
		else if(S.equals("H")) {
			if(Lab[this.getX()][this.getY()-1]==1 || Lab[this.getX()][this.getY()-1]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setY(this.getY()-1);
				Lab[this.getX()][this.getY()+1]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX())*40, (this.getY()+1)*40+22, 40, 40);
				}
		}
		else if(S.equals("B")) {
			if(Lab[this.getX()][this.getY()+1]==1 || Lab[this.getX()][this.getY()+1]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setY(this.getY()+1);
				Lab[this.getX()][this.getY()-1]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX())*40, (this.getY()-1)*40+22, 40, 40);
				}
		}
		else {
			//System.out.println("Vous restez perplexe...");
		}
	}

	public void Degat() {
		this.setPDV(this.getPDV()-1);
	}
	
}
