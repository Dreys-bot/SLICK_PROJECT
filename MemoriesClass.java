
import java.awt.Font;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class MemoriesClass {
	 
		private int x, y, //Coordonnées pour les cartes;
					x1, y1,
					x2,y2; //(x1,y1)  coordonnées de la souris
		private Image image, image1,image3;
		private int compt = 0;
		private int compteur = 0;
	
	//Stocke les cartes piochées
		Carte[] carte1 = new Carte[2];
	
	//Sticke les categories des cartes piochées
		int[] categorie = new int[2];
	
	//Stocke les cartes d'images piochées 
		Carte[] carte = new Carte[2];
	
	//Stocke les indices de cartes piochées
		int[][] indice = new int[2][2];
	
	//Stocke les points
		int point = 0;
		int k = 0;
		
	 // Stocke le nombres de tentatives
		int tentatives = 0;
		
	//Convertir la valeur du nombre de tentatives en chaine de caracteres pour l'afficher
		String tentative = "0";
		String score="0";
		int[] tab = new int[16];
		int l = 0;

	//Propriétés de l'image back	
		private Image back = new Image("icon/back.png");
		private Image back_hover= new Image("icon/backh.png");
		private static final int[] BACK_COOR={480,520,168,80};
	
	// Creation de la matrice d'images
		private Carte[][] c1 = new Carte[4][4];
	
	// Creation de la matrice de carré
		private Carte[][] c = new Carte[4][4];
	
	
	public MemoriesClass() throws SlickException {
		x = y = 0;

		// Image de chaque carte
			image = new Image("icon/backCarte.png");
			image1 = new Image("icon/background3.gif");
			image3 = new Image("icon/LogoMemory-removebg-preview.png");
		
		// Initialiser la grille de cartes
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					x1 = 120 * i + 150;
					y1 = 90 * j + 50;
					c[i][j] = new Carte(y1, x1, image, 0);//Au debut toutes les cartes sont retournées (categorie = 0)
				}
			}

		carteImages();
	}
	
	public void carteImages() throws SlickException {
		// Tableau d'images
					Image[] images = { new Image("icon/1.JPG"), new Image("icon/2.JPG"), 
							new Image("icon/3.JPG"), new Image("icon/4.JPG"), 
							new Image("icon/5.JPG"), new Image("icon/6.JPG"), 
							new Image("icon/7.JPG"), new Image("icon/8.JPG"), 
							new Image("icon/9.JPG"), new Image("icon/10.JPG"),
							new Image("icon/11.JPG"), new Image("icon/12.JPG"), 
							new Image("icon/13.JPG"), new Image("icon/14.JPG"), 
							new Image("icon/15.JPG"), new Image("icon/16.JPG") 
					};

			//Initialisons de la grille des cartes à images	
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						x2 = 120 * i + 150;
						y2 = 90 * j + 50;
						k = (int) (Math.random() * 16);
						
					do {	
						k = (int) (Math.random() * 16);
					}while(images[k]== null);
					
						//Chaque k correspond a une categorie d'image			
							if (k == 0 || k == 3)
								c1[i][j] = new Carte(y2, x2, images[k], 0);
							else if (k == 1 || k == 6) {
								c1[i][j] = new Carte(y2, x2, images[k], 1);
							} else if (k == 2 || k == 14) {
								c1[i][j] = new Carte(y2, x2, images[k], 2);
							} else if (k == 4 || k == 9) {
								c1[i][j] = new Carte(y2, x2, images[k], 3);
							} else if (k == 5 || k == 11) {
								c1[i][j] = new Carte(y2, x2, images[k], 4);
							} else if (k == 7 || k == 12) {
								c1[i][j] = new Carte(y2, x2, images[k], 5);
							} else if (k == 8 || k == 15) {
								c1[i][j] = new Carte(y2, x2, images[k], 6);
							} else if (k == 10 || k == 13) {
								c1[i][j] = new Carte(y2, x2, images[k], 7);
							}
						
					//Supprime l'image deja utilisé	
						images[k] = null;
					}
				}
	}
	public void dessiner(Graphics g, GameContainer gc) {
		// Dessin du background de couleur rose
			g.drawImage(image1, x-30, y);
			g.setColor(new Color(241,166,38));
			g.fillRoundRect(460,290, 180, 100, 20);
			g.drawImage(image3, 100,-30);
				
		//affichage du bouttons back
			Input inp= gc.getInput();
			int x1=inp.getMouseX();
			int y1=inp.getMouseY();
			if(x1<=BACK_COOR[0]+BACK_COOR[2] && x1>=BACK_COOR[0]+10 && y1>=BACK_COOR[1]+10 && y1<=BACK_COOR[1]+BACK_COOR[3])
				g.drawImage(back_hover, BACK_COOR[0], BACK_COOR[1]);
			else
				g.drawImage(back, BACK_COOR[0], BACK_COOR[1]);;
			
		// saisi des tentatives et du score du joueur
			java.awt.Font font = (java.awt.Font) new Font("Verdana",Font.BOLD, 18); 
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(y+470, x+310, "TENTATIVES :", Color.white);
			ttf.drawString(y+610, x+310, tentative, Color.white);
			ttf.drawString(y+470, x+350, "SCORE :", Color.white);
			ttf.drawString(y+560, x+350, score, Color.white);

		// Representons chaque element de la matrice par un carré
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (c[i][j] != null)
						c[i][j].dessiner(g);
				}
			}
	}
	
	
	public void update(GameContainer gc) throws SlickException {
		// Initialisons une variable pour commencer le jeu	
		boolean game = true;
	// Recuperation des coordonnées de la souris
		Input inp = gc.getInput();
		double x_mouse = inp.getMouseX();
		double y_mouse = inp.getMouseY();

		if (game == true) {
			// Lorsqu'on fait un clic, je verifie que le clic se fait sur la carte si c'est
			// le cas je retourne la carte en remplacant par son verso
			if (compteur == 2) {
				//je verifie si la premiere et la deuxieme carte sont a la meme position
					if(carte[0].getX() == carte1[1].getX() && carte[0].getY() == carte1[1].getY()) {
						compteur = 1;
						compt = 1;
					}
					else {
						tentatives += 1;
						tentative = String.valueOf(tentatives);
					
				//Si elles sont egales, elles restent ouvertes
					if (categorie[0] == categorie[1]) {
						point+= 1;
						score = String.valueOf(point);
						c[indice[0][0]][indice[1][0]] = null;
						c[indice[0][1]][indice[1][1]] = null;
						compteur = 0;
						compt = 0;
						
					} else if(categorie[0] != categorie[1]) {//sinon elles se retournent
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						c[indice[0][0]][indice[1][0]] = carte1[0];
						c[indice[0][1]][indice[1][1]] = carte1[1];
						compteur = 0;
						compt = 0;
					}
				}		
			}

			else if ( inp.isMousePressed(Input.MOUSE_LEFT_BUTTON) ) {/** ========= IF: Souris Cliquée ========= */
					for (int i = 0; i < 4; i++)
					{
						for (int j = 0; j < 4; j++) {
							if(c[i][j] == null)
								continue;
							else if ( 
								(c[i][j].getX()<= x_mouse && x_mouse <= c[i][j].getX() + 90) &&
								(c[i][j].getY() <= y_mouse && y_mouse <= c[i][j].getY() + 90) 
								) {
								Sounds.play.play();
								// je stocke les indices des cases retournés
									System.out.print("bonjour");
									indice[0][compt] = i;
									indice[1][compt] = j;
									compt += 1;
									carte1[compteur] = c[i][j];
									c[i][j] = c1[i][j];
									carte[compteur] = c[i][j];
									 
									//je stocke les categories des cartes deja piochées
									categorie[compteur] = c1[i][j].getCategorie();
									compteur += 1;
							}
						}
					}
			}
						if (point == 8)
							game = false;
				}/** ========= END IF: Souris Cliquée ========= */
			
				
	}
	
	 // Revenir sur le menu lorsqu'on clique sur le boutton back
		public void clicCase(int x, int y) {
			if(x<=BACK_COOR[0]+BACK_COOR[2]-20 && x>=BACK_COOR[0]-20 && y>=BACK_COOR[1]-20 && y<=BACK_COOR[1]+BACK_COOR[3]-20) {
				Menu.selection=0;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						x1 = 120 * i + 150;
						y1 = 90 * j + 50;
						c[i][j] = new Carte(y1, x1, image, 0);//Au debut toutes les cartes sont retournées (categorie = 0)
					}
				}
				tentatives = 0;
				tentative = String.valueOf(tentatives);
				Sounds.play.play();
			}
		}
	
		//Afficher la victoire
		public void afficherVictoire(Graphics g) throws IOException {
			g.setColor(Color.gray);
			g.fillRoundRect(20, 250, 660-40, 250, 50);
			g.setColor(Color.white);
			g.drawRoundRect(20, 250, 660-40, 250, 50);
			g.drawRoundRect(21, 251, 660-41, 250-1, 50);
			g.drawRoundRect(22, 252, 660-42, 250-2, 50);
			java.awt.Font font = new Font("Verdana", Font.BOLD, 40);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(100.0f, 320.0f, "Vous avez gagne en", Color.cyan);
			ttf.drawString(200.0f, 380.0f, tentatives+ " tentatives", Color.cyan);
			
		}
		
	//Afficher la perte
		public void afficherPerte(Graphics g) throws IOException {
			g.setColor(Color.gray);
			g.fillRoundRect(20, 250, 660-40, 250, 50);
			g.setColor(Color.white);
			g.drawRoundRect(20, 250, 660-40, 250, 50);
			g.drawRoundRect(21, 251, 660-41, 250-1, 50);
			g.drawRoundRect(22, 252, 660-42, 250-2, 50);
			java.awt.Font font = new Font("Verdana", Font.BOLD, 40);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(80.0f, 320.0f, "Vous avez perdu en", Color.white);
			ttf.drawString(200.0f, 380.0f, tentatives+ " tentatives", Color.cyan);
			
		}
}

