package domain;

public class Participant{

	private String pName;
	private Family family;
	
	public Participant(String pName,Family family){
		this.pName = pName;
		this.family = family; 
	}
	public String getPName(){
		return this.pName;
	}
	public Family getFamily(){
		return this.family;
	}
	public String getFamilyName(){
		return this.family.getFName();
	}
	public String toString(){
		return this.pName;
	}
	public boolean equals(Object o){
		if(!(o instanceof Participant)) throw new IllegalArgumentException();
		return ((Participant)o).getPName().equals(this.pName);
	}
	public int hashCode(){
		return this.pName.hashCode();
	}
}
