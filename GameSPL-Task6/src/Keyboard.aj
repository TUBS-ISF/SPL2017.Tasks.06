import java.awt.event.KeyEvent;


aspect Keyboard {
	before(KeyEvent e, Sidescroller s):execution(void Sidescroller.keyReleased(*)) && args(e) && this(s){
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			s.jump();
		}
	}	
}