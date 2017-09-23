package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

import domain.Family;
import domain.Participant;

public class SecretSantaSolver {

	private ArrayList<Participant> participants;
	private boolean marks[];
	private TreeSet<Solution> solutions;
	public SecretSantaSolver(){
		
		try {
			this.participants = loadConfiguration();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.solutions = new TreeSet<Solution>();
		
	}
	
	public TreeSet<Solution> findSolutions(){
		this.solutions = new 	TreeSet<Solution>();
		marks = new boolean[participants.size()];
		for(int i=0; i<marks.length;i++){
			marks[i] = false;
		}
		
		HashMap<Participant,Participant> solution = new HashMap<Participant,Participant>();
		backTracking(solution,0);
		
		if(solutions.size()<1) throw new IllegalArgumentException("No solution could be found");
		return this.solutions;
		
	}
	private void backTracking(HashMap<Participant,Participant> solution, int index){
		    if(isSolution()){
		        this.solutions.add(new Solution(solution));
		    } else {
		        for(Participant p:participants){
		        	if(!marks[participants.indexOf(p)]){
		        		if(p.getFamily() != participants.get(index).getFamily()){
			        		
		        			solution.put(participants.get(index),p);
			        		marks[participants.indexOf(p)] = true;		
			        		
			        		backTracking(solution,index+1);
			        		
			        		solution.remove(participants.get(index));
			        		marks[participants.indexOf(p)] = false;	

		        		}
		        	}
		        }       
		    }
		}
	private boolean isSolution(){
		for(int i = 0; i<marks.length;i++){
			if (!marks[i]) return false;
		}
		return true;
	}
	
	private ArrayList<Participant> loadConfiguration() throws Exception{
		ArrayList<Participant> set = new ArrayList<Participant>();
		BufferedReader in = new BufferedReader(new FileReader("src/application/participants.txt"));

		String line;
		Family currentFamily = new Family("independent");
		char ch = ' ';
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				ch = line.charAt(0);
				if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
					set.add(new Participant(line, currentFamily));
					System.out.println("Adding participant: " + line + " (" + currentFamily.getFName() + " family)");
				} else if (ch == '#') {
					currentFamily = new Family(line.substring(1));
					System.out.println("Setting family to " + line.substring(1));
				}
			}
		}
		System.out.println("\n\n Loading Complete \n\n");
		    in.close();
			return set;
	}
}
