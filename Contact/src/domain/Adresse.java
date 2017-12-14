package domain;

public class Adresse {
	
	private long idAdresse ; 
	private String rue ; 
	private String ville ; 
	private String codepostal ; 
	private String pays;
	
	
	public Adresse(String rue, String ville, String codepostal, String pays) {
		this.rue = rue;
		this.ville = ville;
		this.codepostal = codepostal;
		this.pays = pays;
	}


	

	public Adresse() {
		
	}




	public long getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
