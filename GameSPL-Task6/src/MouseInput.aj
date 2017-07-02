import java.awt.event.MouseEvent;

public aspect MouseInput {

	before(MouseEvent e, Sidescroller s):execution(void Sidescroller.mouseClicked(MouseEvent)) && args(e) && this(s){
			s.jump();
	}
}