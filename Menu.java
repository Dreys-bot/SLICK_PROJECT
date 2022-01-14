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
	//Tableau de case pour controler le comportement des boutons à cliquer
		private Case cases[]=new Case[4];
		private Image background, logo1, logo2,level1,level2, helpMenu, exitMenu;
	
	//Tableau d'images pour le l'image en question et son image hover
		private Image[] Level = new Image[2];
		
		public static int selection;
	
	public Menu() throws SlickException {
		//Donnons les coordonnées de chasue case
			for(int l=0, y=200; l<cases.length; l++, y+=100)  
					cases[l]=new Case(91,y,80,480);
		
		//Initialisons chaque variable	
			Level[0]= new Image("icon/level.png");	
			Level[1]= new Image("icon/level_on.png");
			background= new Image("icon/background3.gif");
			logo1= new Image("icon/LogoMemory-removebg-preview.png");
			logo2= new Image("icon/menu.png");
			selection=0;
			level1 = new Image("icon/cooltext401837619488108.png");
			level2 = new Image("icon/cooltext401837735685672.png");
			helpMenu = new Image("icon/helpMenu.png");
			exitMenu = new Image("icon/Exit.png");
	}
	
	public void dessinerMenu(Graphics g) {
		//Dessinons les images
			g.drawImage(background,-30, 0);
			g.drawImage(logo1, 100, -30);
			g.drawImage(logo2, 200, 110);
			g.drawImage(Level[0],cases[0].getX1(), cases[0].getY1()); 
			g.drawImage(Level[0],cases[1].getX1(), cases[1].getY1());
			g.drawImage(Level[0],cases[2].getX1(), cases[2].getY1());
			g.drawImage(Level[0],cases[3].getX1(), cases[3].getY1());
			
			
		//Afficher l'image level1 de sa case	
			g.drawImage(level1, (float)cases[0].getX1() + 100, (float)cases[0].getY1()+5);
		
		//Afficher l'image level2 de sa case
			g.drawImage(level2, cases[1].getX1() + 100, cases[1].getY1()+5);
		
		//Afficher l'image help de sa case
			g.drawImage(helpMenu, cases[2].getX1() + 140, cases[2].getY1()+5);
		
		//Afficher l'image exit de sa case	
			g.drawImage(exitMenu, cases[3].getX1() + 140, cases[3].getY1()+5);
	}
	
	public int quelleCase(int x, int y) { 
		//retourne le numero de la case selectionné
			int ici= -1; 
			for(int l=0; l<cases.length; l++)
				if(y<=this.cases[l].getY1()+90 && y>=this.cases[l].getY1()) ici=l;
	
			return (x>=90 && x<=91+480)?ici:-1;
	}
	
	public void dessinerHoverMenu(Graphics g, GameContainer gc) {
		//je recupere les coordonnées de la souris et le numero de la case selectionné avec la fonction ci-dessus
			Input inp= gc.getInput();
			int x_mouse=inp.getMouseX();
			int y_mouse=inp.getMouseY();
			int l=quelleCase(x_mouse, y_mouse);
			
		if(l>=0) {
			//s'il s'agit de le curseur de la souris est sur la premiere case, on affiche l'image de son hover
			if(l==0)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1()); 
			else if(l==1)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1());
			else if(l==2)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1());
			else if(l==3)  g.drawImage(Level[1],cases[l].getX1(), cases[l].getY1());
					
			g.drawImage(level1, (float)cases[0].getX1() + 100, (float)cases[0].getY1()+5);
					
			g.drawImage(level2, cases[1].getX1() + 100, cases[1].getY1()+5);
					
			g.drawImage(helpMenu, cases[2].getX1() + 140, cases[2].getY1()+5);
					
			g.drawImage(exitMenu, cases[3].getX1() + 140, cases[3].getY1()+5);			
		}
	}
	
	public void clicCase(int x, int y) {
		//Recupere le numero de la case sélectionné
			if(quelleCase(x, y)!=-1) {//Si le curseur de la souris est sur une option du menu 
				selection=quelleCase(x, y)+1;
				Sounds.choice.play();
			}
	}

}
