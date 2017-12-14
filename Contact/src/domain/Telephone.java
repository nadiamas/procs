package domain;

public class Telephone {
	
	private long idTel ; 
	private String typeTel ; 
	private String numTel ; 
	private Contact contact;
	
	
	public Telephone( String typeTel, String numTel) {
		super();
		this.typeTel = typeTel;
		this.numTel = numTel;
	} 
	public Telephone(){
		
	}
	
	public Telephone(String typeTel, String numTel, Contact contact) {
		super();
		this.typeTel = typeTel;
		this.numTel = numTel;
		this.contact = contact;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public long getIdTel() {
		return idTel;
	}
	public void setIdTel(long idTel) {
		this.idTel = idTel;
	}
	public String getTypeTel() {
		return typeTel;
	}
	public void setTypeTel(String typeTel) {
		this.typeTel = typeTel;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	
	

}
