import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Level {
	private Image background,logo;
	private boolean focus;
	
	//Initialisons les cases qui vont permettre de positionner et manipuler les coordonnés de nos bouttons
		private Case cases[]=new Case[2];
	//Tableau d'images et images	
		private Image[] level = new Image[2];
		private Image back = new Image("icon/back.png");
		private Image back_hover= new Image("icon/backh.png");
	//Tableau de coordonnées pour la position du boutton back	
	private static final int[] BACK_COOR={480,520,168,80};
	public static int selected;
	
	public Level() throws SlickException {
		logo = new Image("icon/LogoMemory-removebg-preview.png");
		background = new Image("icon/background3.gif");
		level[0] = new Image("icon/level.png");
		level[1] = new Image("icon/level_on.png");
		for(int l=0, y=200; l<cases.length; l++, y+=100)  
			cases[l]=new Case(91,y,80,480);
		selected=0;
		focus=false;
	}
	
	public void dessiner(Graphics g, GameContainer gc) {
		g.drawImage(background, -30,0);
		g.drawImage(logo, 100,-30);
		
		//dessiner les images de back....
		//si la souris survole le boutton back, il change de couleur et de position
		Input inp= gc.getInput();
			int x=inp.getMouseX();
			int y=inp.getMouseY();
			if(x<=BACK_COOR[0]+BACK_COOR[2] && x>=BACK_COOR[0] && y>=BACK_COOR[1] && y<=BACK_COOR[1]+BACK_COOR[3])
				g.drawImage(back_hover, BACK_COOR[0], BACK_COOR[1]);
			else
				g.drawImage(back, BACK_COOR[0], BACK_COOR[1]);
		//Dessiner les boutons level
			g.drawImage(level[0],cases[0].getX1(), cases[0].getY1());
			g.drawImage(level[0],cases[1].getX1(), cases[1].getY1()); 
		
		//Ecrire LEVEL1 ET LEVEL2	
			java.awt.Font font = new Font("Verdana", Font.BOLD, 45);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(cases[0].getX1() + 150, cases[0].getY1()+15,"LEVEL 1", Color.gray);
			
			java.awt.Font font1 = new Font("Verdana", Font.BOLD, 45);
			TrueTypeFont ttf1 = new TrueTypeFont(font, true);
			ttf.drawString(cases[1].getX1() + 150, cases[1].getY1()+15,"LEVEL 2", Color.gray);
	}
	
	public int quelleCase(int x, int y) { 
		//Recuperer la case dans laquelle la souris se trouve
			int ici= -1;
			for(int l=0; l<cases.length; l++)
				if(y<=this.cases[l].getY1()+80 && y>=this.cases[l].getY1()) ici=l;
	
	
			return (x>=91 && x<=91+480)?ici:-1;
	}
	
	public void dessinerHoverMenu(Graphics g, GameContainer gc) {
		//lorsque la souris survole un boutton, on dessine sa deuxieme face
			Input inp= gc.getInput();
			int x_mouse=inp.getMouseX();
			int y_mouse=inp.getMouseY();
			int l=quelleCase(x_mouse, y_mouse);
			if(l>=0) {
				if(l==0)  g.drawImage(level[1],cases[l].getX1(), cases[l].getY1());
				else if(l==1)  g.drawImage(level[1],cases[l].getX1(), cases[l].getY1());
				focus=true;
			}
			else focus=false;
		//Ecriture de LEVEL 1 et LEVEL 2
			java.awt.Font font = new Font("Verdana", Font.BOLD, 45);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(cases[0].getX1()+150, cases[0].getY1()+15,"LEVEL 1", Color.gray);
			
			java.awt.Font font1 = new Font("Verdana", Font.BOLD, 45);
			TrueTypeFont ttf1 = new TrueTypeFont(font, true);
			ttf.drawString(cases[1].getX1() + 150, cases[1].getY1()+15,"LEVEL 2", Color.gray);
	}
	
	
	
	public void clicCase(int x, int y) {
		//Si on clique sur le boutton back, le programme revient au menu
			if(x<=BACK_COOR[0]+BACK_COOR[2] && x>=BACK_COOR[0] && y>=BACK_COOR[1] && y<=BACK_COOR[1]+BACK_COOR[3]) {
				Menu.selection=0;	
			}
	}
	
	public void CaseMenu(int x, int y) {
		int l=quelleCase(x,y);
		if(l!=-1)
			selected+=1;
	}

	
}
