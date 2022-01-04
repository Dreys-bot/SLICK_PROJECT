import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;

public class Menu {
	//Tableau de case pour controler le comportement des boutons � cliquer
		private Case cases[]=new Case[4];
	private Image background, logo1, logo2;
	
	//Tableau d'images pour le l'image en question et son image hover
		private Image[] newGame = new Image[2];
		private Image[] Level = new Image[2];
		private Image[] help = new Image[2];
		private Image[] exit = new Image[2];
		
	public static int selection;
	
	public boolean focus;
	
	public Menu() throws SlickException {
		//Donnons les coordonn�es de chasue case
			for(int l=0, y=200; l<cases.length; l++, y+=100)  
					cases[l]=new Case(91,y,80,480);
		
		//Initialisons chaque variable	
			newGame[0]= new Image("icon/new_game_off.png");
			newGame[1]= new Image("icon/new_game_on.png");	
			Level[0]= new Image("icon/level.png");	
			Level[1]= new Image("icon/level_on.png");
			help[0]= new Image("icon/help_off.png");
			help[1]= new Image("icon/help_on.png");
			exit[0]= new Image("icon/exit_off.png");
			exit[1]= new Image("icon/exit_on.png");
			background= new Image("icon/background3.gif");
			logo1= new Image("icon/LogoMemory-removebg-preview.png");
			logo2= new Image("icon/menu.png");
			selection=0;
			
			focus=false;
		
	}
	
	public void dessinerMenu(Graphics g) {
		//Dessinons les images
			g.drawImage(background,-30, 0);
			g.drawImage(logo1, 100, -30);
			g.drawImage(logo2, 200, 110);
			g.drawImage(Level[0],cases[0].getX1(), cases[0].getY1()); 
			g.drawImage(Level[0],cases[1].getX1(), cases[1].getY1());
			g.drawImage(help[0],cases[2].getX1(), cases[2].getY1());
			g.drawImage(exit[0],cases[3].getX1(), cases[3].getY1());
			
			java.awt.Font font = new Font("Verdana", Font.PLAIN, 50);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(cases[0].getX1() + 150, cases[0].getY1()+15,"LEVEL 1", Color.darkGray);
			
			java.awt.Font font1 = new Font("Verdana", Font.PLAIN, 50);
			TrueTypeFont ttf1 = new TrueTypeFont(font, true);
			ttf.drawString(cases[1].getX1() + 150, cases[1].getY1()+15,"LEVEL 2", Color.darkGray);
	}
	
	public int quelleCase(int x, int y) { 
		//retourne le numero de la case selectionn�
			int ici= -1; 
			for(int l=0; l<cases.length; l++)
				if(y<=this.cases[l].getY1()+80 && y>=this.cases[l].getY1()) ici=l;
	
	
			return (x>=91 && x<=91+480)?ici:-1;
	}
	
	public void dessinerHoverMenu(Graphics g, GameContainer gc) {
		//je recupere les coordonn�es de la souris et le numero de la case selectionn� avec la fonction ci-dessus
			Input inp= gc.getInput();
			int x_mouse=inp.getMouseX();
			int y_mouse=inp.getMouseY();
			int l=quelleCase(x_mouse, y_mouse);
			if(l>=0) {
				//s'il s'agit de le curseur de la souris est sur la premiere case, on affiche l'image de son hover
					if(l==0)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1());
					else if(l==1)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1());
					else if(l==2)  g.drawImage(help[1],cases[l].getX1(), cases[l].getY1());
					else if(l==3)  g.drawImage(exit[1],cases[l].getX1(), cases[l].getY1());
					
					java.awt.Font font = new Font("Verdana", Font.PLAIN, 50);
					TrueTypeFont ttf = new TrueTypeFont(font, true);
					ttf.drawString(cases[0].getX1() + 150, cases[0].getY1()+15,"LEVEL 1", Color.darkGray);
					
					
					java.awt.Font font1 = new Font("Verdana", Font.PLAIN, 50);
					TrueTypeFont ttf1 = new TrueTypeFont(font, true);
					ttf.drawString(cases[1].getX1() + 150, cases[1].getY1()+15,"LEVEL 2", Color.darkGray);
					
			}
			else focus=false;
	}
	
	public void clicCase(int x, int y) {
		//Recupere le numero de la case s�lectionn�
			int l=quelleCase(x, y);
			if(l!=-1) {//Si le curseur de la souris est sur une option du menu 
				selection=l+1;	
			}
	}

}
