package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateContactValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int idm;
	private String nom;
	private String prenom;
	private String mail;
	private String rue  ;
	private String ville  ; 
	private String codepostal  ; 
	private String pays  ; 
	private String typetel ; 
	private String tel  ; 
	private String submit;

	
	
		public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
		public String getTypetel() {
		return typetel;
	}
	public void setTypetel(String typetel) {
		this.typetel = typetel;
	}
		public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
		public String getNom() {
		return nom;
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
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
		/**
		* @return ID Returns ID
		*/
		public int getIdm() {
		return idm;
		}
		/**
		* @param l Sets the ID
		*/
		public void setIdm(int l) {
		idm = l;
		}
		
			public ActionErrors validate(
			ActionMapping mapping, HttpServletRequest request ) {
			ActionErrors errors = new ActionErrors();
			
			if(getIdm()==0) {
			errors.add("Id",new
			ActionMessage("creation.id.error.required"));
			}				
			if( getNom()== null || getNom().length() < 1 ) {
				errors.add("first name",new
				ActionMessage("creation.fn.error.required"));
				}
				if( getPrenom()== null || getPrenom().length() < 1 ) {
				errors.add("last name",new
				ActionMessage("creation.ln.error.required"));
				}
				if( getMail() == null || getMail().length() < 1 || !getMail().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
				errors.add("email", new
				ActionMessage("creation.email.error.required"));
				}
				if( getRue()== null || getRue().length() < 1 ) {
					errors.add("rue",new
					ActionMessage("creation.rue.error.required"));
					}
				if( getVille()== null || getVille().length() < 1 ) {
					errors.add("ville",new
					ActionMessage("creation.ville.error.required"));
					}
				if( getCodepostal()== null || getCodepostal().length() < 1 ) {
					errors.add("code",new
					ActionMessage("creation.code.error.required"));
					}
				if( getPays()== null || getPays().length() < 1 ) {
					errors.add("pays",new
					ActionMessage("creation.pays.error.required"));
					}
				if( getTel()== null || getTel().length() < 1 ) {
					errors.add("tel fix",new
					ActionMessage("creation.tel.error.required"));
					}
				
				try {
					Integer.parseInt(getTel());
				} catch (NumberFormatException e){
					errors.add("tel fix",new
							ActionMessage("creation.tel.error.required"));
				}
				try {
					Integer.parseInt(getCodepostal());
				} catch (NumberFormatException e){
					errors.add("code",new
							ActionMessage("creation.code.error.required"));
				}
			
			return errors;
	}
}



