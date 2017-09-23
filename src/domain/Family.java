package domain;

public class Family{

	private String fName;

	public Family(String fName){
		this.fName=fName;
	}
	
	public String getFName(){
		return this.fName;
	}
	public boolean equals(Object o){
		if(!(o instanceof Family)) throw new IllegalArgumentException();
		return ((Family)o).getFName().equals(this.fName);
	}
	public String toString(){
		return this.fName;
	}
}
