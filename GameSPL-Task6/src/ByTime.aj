import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public aspect ByTime {

//	before(Graphics g, Sidescroller s):execution(void Sidescroller.repaint(Graphics)) && args(g) && this(s){
//		g = s.renderer.gr;
//		g.setColor(Color.white);
//		g.setFont(new Font("Arial", 1, 100));
//		System.out.println(s.score);
//		if (s.started) {
//			g.drawString(String.valueOf(s.score), s.WIDTH / 2 - 25, 100);
//		}
//	}
	before(Sidescroller s) : get(Graphics *.*) && this(s){
		Graphics g = s.renderer.gr;
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));
		
		if (!s.started) {
			g.drawString("Click to start", 30, s.HEIGHT / 2 - 50);
			g.setFont(new Font("Arial", 1, 50));
			g.drawString("Time Mode Unfinished", 100, s.HEIGHT / 2 +10);
		}
	}
}