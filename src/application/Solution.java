package application;
import java.util.ArrayList;
import java.util.HashMap;

import domain.Participant;

public class Solution {

	private HashMap<Participant,Participant> solution;
	
	public Solution(ArrayList<Participant> solution){
		this.solution = new HashMap<Participant,Participant>();;
		for(Participant p:solution){
			this.solution.put(p, p.getPresentAddressee());
		}
	}
	public HashMap<Participant,Participant> getsolution(){
		return this.solution;
	}
	public String toString(){
		String output="";
		for(Participant p:solution.keySet()){
			output+= p.getPName() + " from family " + p.getFamilyName() + " sends present to " + p.getAddresseeName() + " from family " + p.getAddresseeFamilyName() +"\n";
		}
		return output;
	}
}
