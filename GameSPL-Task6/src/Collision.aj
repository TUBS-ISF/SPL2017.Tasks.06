import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public aspect Collision {

	before(ActionEvent e, Sidescroller s):execution(void Sidescroller.actionPerformed(ActionEvent)) && args(e) && this(s){
		for (Rectangle column : s.columns) {
			if (column.intersects(s.player)) {
				s.gameOver = true;
		
				s.player.x = column.x - s.player.width;
			}
		}
	}
}