package pavel.game.bj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener, MouseListener  {

	private JPanel contentPane;
	private JButton btnStay;
	private JButton btnDeal;
	private JButton btnHitMe;
	private Game game = new Game();
	private Card lastCard;
	private JTextPane textPane;
	private JTextField tfUser0Score;
	private JTextField tfUser1Score;
	private JLabel lblCard[] = new JLabel[7];
	
	private JPanel jpBottom;
	private BufferedImage image;
	private Dimension size = new Dimension();
	private ImageIcon icon;

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public GameFrame() throws InterruptedException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jpWest = new JPanel();
		contentPane.add(jpWest, BorderLayout.WEST);
		
		JPanel jpEast = new JPanel();
		contentPane.add(jpEast, BorderLayout.EAST);
		jpEast.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel jpEast1 = new JPanel();
		jpEast.add(jpEast1);
		
		JPanel jpEast2 = new JPanel();
		jpEast.add(jpEast2);
		
		tfUser0Score = new JTextField();
		jpEast2.add(tfUser0Score);
		tfUser0Score.setColumns(10);
		
		JPanel jpEast3 = new JPanel();
		jpEast.add(jpEast3);
		
		JPanel jpEast4 = new JPanel();
		jpEast.add(jpEast4);
		
		JPanel jpEast5 = new JPanel();
		jpEast.add(jpEast5);
		
		tfUser1Score = new JTextField();
		jpEast5.add(tfUser1Score);
		tfUser1Score.setColumns(10);
		
		JPanel jpEast6 = new JPanel();
		jpEast.add(jpEast6);
		
		JPanel jpSouth = new JPanel();
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		
		btnHitMe = new JButton("Hit Me");
		jpSouth.add(btnHitMe);
		btnHitMe.addActionListener(this);
		
		btnStay = new JButton("Stay");
		jpSouth.add(btnStay);
		btnStay.addActionListener(this);
	
		btnDeal = new JButton("Deal");
		btnDeal.setEnabled(false);
		jpSouth.add(btnDeal);
		btnDeal.addActionListener(this);
		
		JPanel jpNorth = new JPanel();
		contentPane.add(jpNorth, BorderLayout.NORTH);
		
		JPanel jpCenter = new JPanel();
		contentPane.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JPanel jpTop = new JPanel();
		jpCenter.add(jpTop);
		
		jpBottom = new JPanel();
		jpCenter.add(jpBottom);
		jpBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for (int l = 0; l < 7; l++) {
			lblCard[l] = new JLabel();
			jpBottom.add(lblCard[l]);
			lblCard[l].setLocation(20 * l, 3 * l);
		}
		
		this.firstTwoCards(0);
 
	}

 
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		int player = game.showPlayingUser();
		
		if (ev.getSource() == btnHitMe) {


			this.makeMove(player);
			
		
			
		} else if (ev.getSource() == btnStay) {
			game.changePlaingUser(1);
			btnHitMe.setEnabled(false);
			btnStay.setEnabled(false);
			btnDeal.setEnabled(true);
			 

		} else if (ev.getSource() == btnDeal) {
			btnDeal.setEnabled(false);
			btnHitMe.setEnabled(true);
			btnStay.setEnabled(true);
			game = new Game ();
			for (int l = 0; l < 7; l++){
				lblCard[l].setIcon(null);
			}
		}
		
	}
	
	public void makeMove(int player){
		game.userPlayCard(player);
		lastCard = game.showLastCard();
		icon = new ImageIcon("images/" + lastCard.getID() + ".png");
		int l = game.showCurentCard();
		lblCard[l].setIcon(icon);
		lblCard[l].setSize(100, 200);
		System.out.println("You draw " + lastCard.toString());
		
		tfUser1Score.setText(game.showUserScore(player) + " Points");
		
		if (game.checkBust(game.showUserScore(player))){
			btnHitMe.setEnabled(false);
			btnStay.setEnabled(false);
			btnDeal.setEnabled(true);
			tfUser1Score.setText(game.showUserScore(player) + " Points. BUST!!!");
		} else if (game.checkBlackJack(game.showUserScore(player))){
			btnHitMe.setEnabled(false);
			btnStay.setEnabled(false);
			btnDeal.setEnabled(true);
			tfUser1Score.setText("Black Jack");
			game.changePlaingUser(1);
		}
	}
	
	public void firstTwoCards(int player) throws InterruptedException{
		icon = new ImageIcon("images/0.png");
		lblCard[0].setIcon(icon);
		lblCard[0].setSize(100, 200);
		Thread.sleep(1 * 1000);
		lblCard[1].setIcon(icon);
		lblCard[1].setSize(100, 200);
		Thread.sleep(1 * 1000);

		
		game.userPlayCard(player);
		lastCard = game.showLastCard();
		icon = new ImageIcon("images/" + lastCard.getID() + ".png");

		lblCard[0].setIcon(icon);
		lblCard[0].setSize(100, 200);
		System.out.println("You draw " + lastCard.toString());
		Thread.sleep(1 * 1000);
		
		game.userPlayCard(player);
		lastCard = game.showLastCard();
		icon = new ImageIcon("images/" + lastCard.getID() + ".png");

		lblCard[1].setIcon(icon);
		lblCard[1].setSize(100, 200);
		System.out.println("You draw " + lastCard.toString());
 
		
		tfUser1Score.setText(game.showUserScore(player) + " Points");
		
		if (game.checkBust(game.showUserScore(player))){
			btnHitMe.setEnabled(false);
			btnStay.setEnabled(false);
			btnDeal.setEnabled(true);
			tfUser1Score.setText(game.showUserScore(player) + " Points. BUST!!!");
		} else if (game.checkBlackJack(game.showUserScore(player))){
			btnHitMe.setEnabled(false);
			btnStay.setEnabled(false);
			btnDeal.setEnabled(true);
			tfUser1Score.setText("Black Jack");
		}
		
		
	}
	
	
	public void AI(){
		int player = 1;
		game.changePlaingUser(player);
		game.userPlayCard(player);
		lastCard = game.showLastCard();
		String text = textPane.getText();
		game.userPlayCard(player);
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
