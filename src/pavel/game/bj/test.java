package pavel.game.bj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser1Score;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
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
		
		tfUser1Score = new JTextField();
		jpEast2.add(tfUser1Score);
		tfUser1Score.setColumns(10);
		
		JPanel jpEast3 = new JPanel();
		jpEast.add(jpEast3);
		
		JPanel jpEast4 = new JPanel();
		jpEast.add(jpEast4);
		
		JPanel jpEast5 = new JPanel();
		jpEast.add(jpEast5);
		
		textField = new JTextField();
		jpEast5.add(textField);
		textField.setColumns(10);
		
		JPanel jpEast6 = new JPanel();
		jpEast.add(jpEast6);
		
		JPanel jpSouth = new JPanel();
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		
		JButton btnHitMe = new JButton("Hit Me");
		jpSouth.add(btnHitMe);
		
		JButton btnStay = new JButton("Stay");
		jpSouth.add(btnStay);
		
		JButton btnDeal = new JButton("Deal");
		btnDeal.setEnabled(false);
		jpSouth.add(btnDeal);
		
		JPanel jpNorth = new JPanel();
		contentPane.add(jpNorth, BorderLayout.NORTH);
		
		JPanel jpCenter = new JPanel();
		contentPane.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel jpTop = new JPanel();
		jpCenter.add(jpTop);
		
		JPanel jpBottom = new JPanel();
		jpCenter.add(jpBottom);
		jpBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
