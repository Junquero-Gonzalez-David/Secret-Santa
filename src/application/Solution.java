package application;
import java.util.HashMap;

import domain.Family;
import domain.Participant;

public class Solution implements Comparable<Solution>{
	private HashMap<Participant,Participant> solution;
	private int rating = 1;
	
	public Solution(HashMap<Participant,Participant> solution){
		this.solution = new HashMap<Participant,Participant>();;
		HashMap<Family,Family> families = new HashMap<Family,Family>();
		for(Participant p:solution.keySet()){
			this.solution.put(p, solution.get(p));
			if(families.get(p.getFamily()) == null || !families.get(p.getFamily()).equals(solution.get(p).getFamily())){
				families.put(p.getFamily(), solution.get(p).getFamily());
			}
			else rating ++;
		}
	}
	public HashMap<Participant,Participant> getsolution(){
		return this.solution;
	}
	public String toString(){
		String output="";
		for(Participant p:solution.keySet()){
			output+= p.getPName() + " from family " + p.getFamilyName() + " sends present to " + solution.get(p).getPName() + " from family " + solution.get(p).getFamilyName() +"\n";
		}
		output+= "\n\nSolution rating: "+this.rating;
		return output;
	}
	public boolean equals(Object o){
		if(!(o instanceof Solution)) throw new IllegalArgumentException();
		return ((Solution)o).getsolution().equals(this.solution);
	}
	@Override
	public int compareTo(Solution o) {
		return this.rating - ((Solution)o).rating;
	}
	public int getRating(){
		return this.rating;
	}
}
