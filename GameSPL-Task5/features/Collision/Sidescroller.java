import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Sidescroller {
	public void actionfeature(){
		
		original();
		for (Rectangle column : columns) {
			if (column.intersects(player)) {
				gameOver = true;
		
				player.x = column.x - player.width;
			}
		}
	}
}
