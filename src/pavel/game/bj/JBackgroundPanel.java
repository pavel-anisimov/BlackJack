package pavel.game.bj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class JBackgroundPanel extends JPanel {

	private BufferedImage img;
	
	public JBackgroundPanel() {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("image/table.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
	}

}
