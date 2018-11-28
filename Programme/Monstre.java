import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;


public class Monstre extends Entite {
	private int x;
	private int y;
	private int PDV=5;

	public Monstre(int x,int y, String j) {
		super(x, y, j);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPDV() {
		return PDV;
	}

	public void setPDV(int pDV) {
		PDV = pDV;
	}

	
	public void deplacement(String S,int [][] Lab,LabyrintheGraph fenetre) {
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


	public boolean[] detectionMur(int [][] Lab) {
		boolean[] dirpos = {true, true, true, true};
		if(Lab[x+1][y]==1) {
		}
		else {
			dirpos[0] = false; //Bas
		}
		if(Lab[x-1][y]==1) {
		}
		else {
			dirpos[1] = false; //Haut
		}
		if(Lab[x][y-1]==1) {
		}
		else {
			dirpos[2] = false; //Gauche
		}

		if(Lab[x][y+1]==1) {
		}
		else {
			dirpos[3] = false; //Droite
		}
		return dirpos;
	}
	
	public int DistanceM(int[] Case){//calcul de distance entre une case et le monstre
		double dist = Math.sqrt((Math.pow(Case[0]-this.getX(),2)-(Math.pow(Case[1]-this.getY(),2))));
		return (int)(dist*10);
	}
	
	public boolean[] detectionMur2(int [][] Lab,int[] Case) {//Permet de détecter un mur sur n'importe quelle case
		boolean[] dirpos = {true, true, true, true};
		if(Lab[Case[0]+1][Case[1]]==1) {
		}
		else {
			dirpos[0] = false; //Bas
		}
		if(Lab[Case[0]-1][Case[1]]==1) {
		}
		else {
			dirpos[1] = false; //Haut
		}
		if(Lab[Case[0]][Case[1]-1]==1) {
		}
		else {
			dirpos[2] = false; //Gauche
		}

		if(Lab[Case[0]][Case[1]+1]==1) {
		}
		else {
			dirpos[3] = false; //Droite
		}
		return dirpos;
	}
	
	public int[] Direction(int n,Avatar A) {//Permet de connaître la direction dans laquelle est la position suivante
		if(n==0) {
			int[] suivant= {this.getX()+1,this.getY(),this.DistanceM(new int[]{this.getX()+1,this.getY()})+A.DistanceH(new int[]{this.getX()+1,this.getY()})};
			return(suivant);
		}
		if(n==1) {
			int[] suivant= {this.getX()-1,this.getY(),this.DistanceM(new int[]{this.getX()-1,this.getY()})+A.DistanceH(new int[]{this.getX()-1,this.getY()})};
			return(suivant);
		}
		if(n==2) {
			int[] suivant= {this.getX(),this.getY()-1,this.DistanceM(new int[]{this.getX()+1,this.getY()-1})+A.DistanceH(new int[]{this.getX()+1,this.getY()-1})};
			return(suivant);
		}
		else {
			int[] suivant= {this.getX(),this.getY()+1,this.DistanceM(new int[]{this.getX(),this.getY()+1})+A.DistanceH(new int[]{this.getX(),this.getY()+1})};
			return(suivant);
		}
	}
	
	
	public String deplacementInt(Avatar A,int [][] Lab, LabyrintheGraph fenetre) {
		double dist = Math.sqrt((Math.pow(this.getX()-this.getX(),2)-(Math.pow(this.getY()-this.getY(),2))));//calcul de distance
		if(A.getX()==this.getX()) {
			if(A.getX()>=this.getX()) {
				return("B");
			}
			else {
				return("H");
			}
		}
		if(A.getX()==this.getX()) {
			if(A.getY()>=this.getY()) {
				return("D");
			}
			else {
				return("G");
			}
		}
		if (dist<=0.20*Lab.length) {//test de distance entre monstre et avatar
			double[] distPrevue = calculDist(Lab, A);
			double min = distPrevue[0];
			int indmin = 0;
			for (int i = 1; i<4 ; i++) {
				if (distPrevue[i]<min) {
					min = distPrevue[i];
					indmin = i;
				}
			}
			if (indmin == 0) return "G";
			else if (indmin == 1) return "D";
			else if (indmin == 2) return "B";
			else return "H";
		}
		else {
			double aleat = Math.random();
			if (aleat < 0.25) return "G";
			else if (0.25 <= aleat && aleat < 0.5) return "D";
			else if (0.5 <= aleat && aleat < 0.75) return "B";
			else return "H";
		}
		
			/*int[] start=new int[3];//initialisation de la position de départ du monstre, le 3e élément est f
			start[0]=this.getX();
			start[1]=this.getY();
			start[2]=0;
			
			ArrayList<int[]> Open=new ArrayList<int[]>();//création de la liste des case sà évaluer
			Open.add(start);
			
			ArrayList<int[]> Close=new ArrayList<int[]>();//création de la liste des cases déjà évaluer
			
			ArrayList<int[]> Chemin=new ArrayList<int[]>();
			Chemin.add(start);
			
			int[] goal=new int[2];//initialisation de la position du héros
			goal[0]=A.getX();
			goal[1]=A.getY();
			
			int[] posM=new int[2];//Liste de 2 valeurs pour réinitialiser la position actuelle du monstre
			
			//https://www.youtube.com/watch?v=-L-WgKMFuhE
			while(!Open.isEmpty()) {
				int[] current=Open.get(0);
				for(int k=0;k<=Open.size()-1;k++) {//boucle pour trouver f le plus petit dans Open
					if(this.DistanceM(Open.get(k))+A.DistanceH(Open.get(k))<this.DistanceM(current)+A.DistanceH(current)) {
						//test pour vérifier que f est plus petite que celui de tous les open
						current=Open.get(k);
					}
				}
				Open.remove(current);
				Close.add(current);
				
				if(current==goal) {
					break;
				}
				
				//On regarde les voisins de la case courrante en enlevant les murs et les cases déjà dans open
				ArrayList<int[]> voisins=new ArrayList<int[]>(4);//création de la liste des voisins
				for(int n=0;n<=3;n++) {//On complète la liste des voisins
					if(this.detectionMur2(Lab,current)[n] && !Open.contains(this.Direction(n,A))) {
						voisins.add(this.Direction(n,A));
					}
				}
				
				for(int j=0;j<=Open.size()-1;j++) {
					if(this.DistanceM(current)+A.DistanceH(current)>this.DistanceM(voisins.get(j))+A.DistanceH(voisins.get(j)) || !Open.contains(voisins.get(j))) {
						  Open.add(voisins.get(j));
						  Chemin.add(voisins.get(j));
					}
				}
			}
			
			for(int m=0;m<=3;m++) {//boucle pour renvoyer les instructions
				if(Chemin.get(0)[0]==this.Direction(m, A)[0] && Chemin.get(0)[1]==this.Direction(m,A)[1]) {
					if(m==0) {return("b");}
					else if(m==1){return("h");}
					else if(m==2){return("g");}
					else {return("d");}
				}
			}
		}
		return "f";*/
	}
	public double[] calculDist(int[][] Lab, Avatar A) {
		double[] distPrevue = {0, 0, 0, 0};
		distPrevue[0] = Math.sqrt((Math.pow(A.getX()-this.getX()+1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Droit
		distPrevue[1] = Math.sqrt((Math.pow(A.getX()-this.getX()-1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Gauche
		distPrevue[2] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()-1,2)))); //Haut
		distPrevue[3] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()+1,2)))); //Bas
		return distPrevue;
	}
}


