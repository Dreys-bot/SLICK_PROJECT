import java.io.IOException;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Memories extends BasicGame {
	
	//Initialisons les variables de chaque classe que nous allons utiliser
	Menu menu;
	MemoriesClass memories;
	HelpTest help;
	Level level;
	ExitTest exit;
	int l;
	Level2 level2;

	
	public Memories(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Input inp= gc.getInput();
		
		//Afficher le menu si la variable selection vaut 0
		if(Menu.selection==0) {
			menu.dessinerMenu(g);
			menu.dessinerHoverMenu(g, gc);
		}
		
		//Afficher le menu si la variable selection vaut 1
		else if(Menu.selection==1) {
			memories.dessiner(g, gc);
		}
		
		//Afficher le menu si la variable selection vaut 3
		else if(Menu.selection==2) {
			level2.dessiner(g,gc);
		}
		
		//Afficher les niveau
		else if(Menu.selection==3) {
			help.dessinerHelp(g, gc);
		}	
		//Afficher le menu si la variable selection ne vaut ni 0, ni 1, ni  3
		else {
			menu.dessinerMenu(g);
			exit.dessinerExit(g, gc);
		}
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
		menu= new Menu();
		help= new HelpTest();
		level =new Level();
		/*score= new Scores();*/
		exit=new ExitTest();
		level2=new Level2();
		memories = new MemoriesClass();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input inp = gc.getInput();
		 //Lorsque nous sommes qu'aucun boutton n'est selectionné, on affiche le menu et lorsque qu'on fait un clic sur l'un des bouutons , on se retrouvr sur une autre page
		if(Menu.selection==0) {
			if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON))
				menu.clicCase(inp.getMouseX(), inp.getMouseY());
		}
		
		//losque le boutton new game est selectionné, on exécute la page du game
		else if(Menu.selection==1) {
			memories.update(gc);
			memories.clicCase(inp.getMouseX(), inp.getMouseY());
		}
		
		else if(Menu.selection==2) {
			level2.update(gc);
			if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON))
				level.clicCase(inp.getMouseX(), inp.getMouseY());
		}
		
		
		//lorsque la case help est selectionné on execute sa page
		else if(Menu.selection==3 ) {
			if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON))
				help.clicCase(inp.getMouseX(), inp.getMouseY());
		}
		
		//Execution de la page exit
		else {
			//Si le joueur appuie sur yes, le jeu se ferme
				if(exit.close()) java.lang.System.exit(0);
			//sinon, on revient au menu	
				if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON))
					exit.clicExit(inp.getMouseX(), inp.getMouseY());
		}
		

	}

}
