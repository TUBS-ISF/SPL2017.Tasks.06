import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 



public class Sidescroller implements KeyListener{
	public Sidescroller(){

		jframe.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			jump();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
