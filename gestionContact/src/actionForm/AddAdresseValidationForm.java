package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddAdresseValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private String rue=null;
	private String codePostal=null;
	private String ville=null;
	private String pays=null;

	private String btn = null; 
	
	
	
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.btn= null ; 
		
		}
	
	
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
			
		ActionErrors errors = new ActionErrors();
		if(!getBtn().equals("retour")){
			
		if( getRue()== null || getRue().length() < 1 ) {
		errors.add("first name",new
		ActionMessage("creation.fn.error.required"));
		}
		if( getCodePostal()== null || getCodePostal().length() < 1 ) {
		errors.add("last name",new
		ActionMessage("creation.ln.error.required"));
		}
	
		}
		return errors;
}
}


		

