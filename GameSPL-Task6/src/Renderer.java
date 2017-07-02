

import java.awt.Graphics; 

import javax.swing.JPanel; 

public  class  Renderer  extends JPanel {
	

	private static final long serialVerionUID = 1L;

	
	Graphics gr;

	
	
	@Override
	protected void paintComponent(Graphics g) {
		gr=g;
		super.paintComponent(gr);
		
		Sidescroller.sidescroller.repaint(gr);
	}


}
