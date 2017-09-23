package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import application.SecretSantaSolver;
import application.Solution;

public class App {

	private SecretSantaSolver secretSantaSolver;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		this.secretSantaSolver = new SecretSantaSolver();
		solve();
	}
	private void solve(){
		ArrayList<Solution> solutions = secretSantaSolver.findSolutions();
		int i = 1;
		for(Solution s:solutions){
			System.out.println("########################");
			System.out.println("SOLUTION "+i);
			System.out.println("########################");
			System.out.println(s.toString());
			System.out.println("\n\n\n");
			i++;
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
