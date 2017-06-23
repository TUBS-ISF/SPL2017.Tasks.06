import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Sidescroller {
	public void textfeatures(){
		
		original();

		Graphics g = renderer.gr;
		
		for (Rectangle column : columns) {
			if (/*column.y == 0 &&*/ player.x + player.width /2 > column.x + column.width / 2  - 10 && player.x + player.width / 2 < column.x + column.width / 2 + 10){
				score++;
			}
		}
			
		if (started){
			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}
}
