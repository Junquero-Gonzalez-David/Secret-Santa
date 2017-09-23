package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;

import application.SecretSantaSolver;
import application.Solution;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;

public class App {

	private SecretSantaSolver secretSantaSolver;
	ArrayList<Solution> solutions;
	private JFrame frame;
	JList<String> list;
	DefaultListModel<String> model;
	JPanel buttonGrid;
	
	Solution activeSolution;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
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
	}
	private void logSolutions(){
		TreeSet<Solution> solutions = secretSantaSolver.findSolutions();
		int i = 1;
		System.out.println("\n\n\n");
		for(Solution s:solutions){
			System.out.println("########################");
			System.out.println("SOLUTION "+i);
			System.out.println("########################");
			System.out.println(s.toString());
			System.out.println("\n\n\n");
			i++;
		}
		System.out.println("Total number of solutions found: "+solutions.size());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel start = new JPanel();
		start.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(start);
		start.setLayout(null);

		JPanel raffle = new JPanel();
		raffle.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(raffle);
		raffle.setLayout(null);
		raffle.setVisible(false);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(userPanel);
		userPanel.setLayout(null);
		userPanel.setVisible(false);
		
		JLabel lblSecretSanta = new JLabel("Peix_Hack.exe");
		lblSecretSanta.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblSecretSanta.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecretSanta.setBounds(197, 89, 376, 101);
		start.add(lblSecretSanta);
		
		JLabel lblDesignedBy = new JLabel("Disseny:");
		lblDesignedBy.setFont(new Font("Sitka Display", Font.PLAIN, 30));
		lblDesignedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesignedBy.setBounds(21, 324, 244, 26);
		start.add(lblDesignedBy);
		
		JLabel lblImplementation = new JLabel("Implementaci\u00F3:");
		lblImplementation.setHorizontalAlignment(SwingConstants.CENTER);
		lblImplementation.setFont(new Font("Sitka Display", Font.PLAIN, 30));
		lblImplementation.setBounds(21, 361, 244, 26);
		start.add(lblImplementation);
		
		JLabel lblJanDuo = new JLabel("Jan Du\u00F1o");
		lblJanDuo.setHorizontalAlignment(SwingConstants.LEFT);
		lblJanDuo.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		lblJanDuo.setBounds(294, 327, 214, 26);
		start.add(lblJanDuo);
		
		JLabel lblDavidJunquero = new JLabel("David Junquero");
		lblDavidJunquero.setHorizontalAlignment(SwingConstants.LEFT);
		lblDavidJunquero.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		lblDavidJunquero.setBounds(294, 364, 214, 26);
		start.add(lblDavidJunquero);
		
		JLabel lblNewLabel = new JLabel("v1.1B");
		lblNewLabel.setBounds(10, 536, 46, 14);
		start.add(lblNewLabel);
		
		JButton btnInitializeRaffle = new JButton("Iniciar sorteig");
		btnInitializeRaffle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnInitializeRaffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					loadConfiguration();
					try {
						loadSolutions();
						raffle.setVisible(true);
						start.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(new JFrame(),
								 "No solutions could be found. Check the list of participats (participants.txt) to corroborate this issue",
								    null,
								    JOptionPane.WARNING_MESSAGE);	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(),
							 "Unable to read participants.txt. Make sure the file is properly configured on the application directory.",
							    null,
							    JOptionPane.WARNING_MESSAGE);	
				}	
			}
		});
		btnInitializeRaffle.setBounds(524, 459, 250, 91);
		start.add(btnInitializeRaffle);
		
		JPanel nameSelection = new JPanel();
		nameSelection.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(nameSelection);
		nameSelection.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 52, 784, 509);
		nameSelection.add(scrollPane_1);
		
		buttonGrid = new JPanel();
		scrollPane_1.setViewportView(buttonGrid);
		buttonGrid.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnBack = new JButton("Retrocedir");
		btnBack.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userPanel.setVisible(true);
				nameSelection.setVisible(false);
			}
		});
		btnBack.setBounds(0, 0, 784, 41);
		nameSelection.add(btnBack);
		nameSelection.setVisible(false);
		
		JLabel lblSolution_1 = new JLabel("Solution 0");
		lblSolution_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolution_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolution_1.setBounds(591, 11, 183, 26);
		userPanel.add(lblSolution_1);
		
		JButton btnNewButton = new JButton(">peix.Rastreig");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userPanel.setVisible(false);
				nameSelection.setVisible(true);
			}
		});
		btnNewButton.setBounds(187, 349, 388, 123);
		userPanel.add(btnNewButton);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		
		JLabel lblPeixhackexe = new JLabel("Peix_Hack.exe");
		lblPeixhackexe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeixhackexe.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
		lblPeixhackexe.setBounds(95, 82, 610, 153);
		userPanel.add(lblPeixhackexe);
		
		JLabel lblSolution = new JLabel("Selecciona una soluci\u00F3 disponible:");
		lblSolution.setFont(new Font("Palatino Linotype", Font.PLAIN, 40));
		lblSolution.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution.setBounds(41, 39, 681, 68);
		raffle.add(lblSolution);
		
		this.model = new DefaultListModel<String>();
		
		JButton btnNewButton_1 = new JButton("Soluci\u00F3 aleat\u00F2ria");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				randomSolution();
				lblSolution_1.setText("Solution "+Integer.toString(randomSolution()+1));
				setupNameSelection();
				raffle.setVisible(false);
				userPanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(28, 480, 363, 50);
		raffle.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Continuar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblSolution_1.setText("Solution "+Integer.toString(selectSolution()+1));
					setupNameSelection();
					raffle.setVisible(false);
					userPanel.setVisible(true);
				} catch (IllegalStateException e1) {
					JOptionPane.showMessageDialog(new JFrame(),
							 "Select a solution to continue.",
							    null,
							    JOptionPane.WARNING_MESSAGE);	
				}
			}
		});
		btnNewButton_2.setBounds(401, 480, 321, 50);
		raffle.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 118, 694, 351);
		raffle.add(scrollPane);
		
		list = new JList<String>(model);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void loadSolutions() throws Exception{
		this.solutions = new ArrayList<Solution>(secretSantaSolver.findSolutions());
		int i = 1;
		for(@SuppressWarnings("unused") Solution s:solutions){
			model.addElement("Solution "+i);
			i++;
		}
	}
	private void loadConfiguration() throws Exception{
		if(!secretSantaSolver.loadConfiguration()) throw new Exception();
		logSolutions();
	}
	private int randomSolution(){
		int randomNum = 0 + (int)(Math.random() * (solutions.size()-1));
		this.activeSolution = solutions.get(randomNum);
		return randomNum;
	}
	private int selectSolution(){
		int index = list.getSelectedIndex();
		if(index < 0) throw new IllegalStateException();
		this.activeSolution = solutions.get(list.getSelectedIndex());
		return list.getSelectedIndex();
	}

	private void setupNameSelection() {
		for (String s : this.activeSolution.getKeyPNames()) {
			
			
			JButton name= new JButton(s);
			name.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(new JFrame(),
							 ("AGENT: "+s+"\nOBJECTIU: " + activeSolution.getAddressee(s)),
							    null,
							    JOptionPane.WARNING_MESSAGE);	
				}
			});
			name.setBounds(41, 227, 166, 23);
			buttonGrid.add(name);	
		}
	}
}
