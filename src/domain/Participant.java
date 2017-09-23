package domain;

public class Participant implements Cloneable{

	private String pName;
	private Family family;
	private Participant presentAddressee;
	
	public Participant(String pName,Family family){
		this.pName = pName;
		this.family = family; 
	}
	private Participant(String pName,Family family,Participant presentAddressee){
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
	public String getAddresseeName(){
		return this.presentAddressee.getPName();
	}
	public String getAddresseeFamilyName(){
		return this.presentAddressee.getFamilyName();
	}
	public Participant getPresentAddressee(){
		if(this.presentAddressee == null) throw new IllegalStateException();
		return this.presentAddressee;
	}
	
	public void setPresentAddressee(Participant p){
		this.presentAddressee = p;
	}
	public boolean equals(Object o){
		if(!(o instanceof Participant)) throw new IllegalArgumentException();
		return ((Participant)o).getPName().equals(this.pName);
	}
	public Participant clone(){
		return new Participant(this.pName,this.family,new Participant(this.presentAddressee.getPName(),this.presentAddressee.getFamily()));
	}
}
