package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	

	private String firstName=null;
	private String lastName=null;
	private String email=null;
	private String rue =null ;
	private String ville = null ; 
	private String codepostal = null ; 
	private String pays = null ; 
	private String portable = null ; 
	private String telport = null ; 
	private String fix =null ; 
	private String telfix= null ; 
	private String[] groupe = null ; 
	private String btn = null; 
	
	
	
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}

	public String[] getGroupe() {
		return groupe;
	}
	public void setGroupe(String[] groupe) {
		this.groupe = groupe;
	}
	public String getPortable() {
		return portable;
	}
	public void setPortable(String portable) {
		this.portable = portable;
	}
	public String getTelport() {
		return telport;
	}
	public void setTelport(String telport) {
		this.telport = telport;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getTelfix() {
		return telfix;
	}
	public void setTelfix(String telfix) {
		this.telfix = telfix;
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
	/**
	* @return Email
	*/
	public String getEmail() {
	return email;
	}
	/**
	* @return First Name
	*/
	public String getFirstName() {
	return firstName;
	}
	/**
	* @return Last name
	*/
	public String getLastName() {
	return lastName;
	}
	/**
	* @param string Sets the Email
	*/
	public void setEmail(String string) {
	email = string;
	}
	/**
	* @param string Sets the First Name
	*/
	public void setFirstName(String string) {
	firstName = string;
	}
	/**
	* @param string sets the Last Name
	*/
	public void setLastName(String string) {
	lastName = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName=null;
		this.lastName=null;
		this.email=null;
		this.codepostal= null ; 
		this.pays= null ; 
		this.rue= null  ; 
		this.ville= null ; 
		this.telfix= null ; 
		this.portable= null ; 
		this.fix= null ; 
		this.telfix= null ; 
		this.btn= null ; 
		
		
		}
	
	
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
			
		ActionErrors errors = new ActionErrors();
		if(!getBtn().equals("retour")){
			
		if( getFirstName()== null || getFirstName().length() < 1 ) {
		errors.add("first name",new
		ActionMessage("creation.fn.error.required"));
		}
		if( getLastName()== null || getLastName().length() < 1 ) {
		errors.add("last name",new
		ActionMessage("creation.ln.error.required"));
		}
		if( getEmail() == null || getEmail().length() < 1 || !getEmail().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
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
		
		if(getTelport()!=null || getTelport().length()>1){
		try {
			Integer.parseInt(getTelport());
		} catch (NumberFormatException e){
			errors.add("tel fix",new
					ActionMessage("creation.tel.error.required"));
		}
		}
		if(getTelfix()!=null || getTelfix().length()>1) {
			try {
				Integer.parseInt(getTelfix());
			} catch (NumberFormatException e){
				errors.add("tel fix",new
						ActionMessage("creation.tel.error.required"));
			}
		}
		
		
		try {
			Integer.parseInt(getCodepostal());
		} catch (NumberFormatException e){
			errors.add("code",new
					ActionMessage("creation.code.error.required"));
		}
		}
		return errors;
}
}


		

