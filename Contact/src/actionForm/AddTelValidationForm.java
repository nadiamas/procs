package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddTelValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private Long idm = null ;
	private String typeTel=null;
	private String tel=null;
	private String btn = null; 
	
	
	

	
	public Long getIdm() {
		return idm;
	}
	public void setIdm(Long idm) {
		this.idm = idm;
	}
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	
	

	public String getTypeTel() {
		return typeTel;
	}
	public void setTypeTel(String typeTel) {
		this.typeTel = typeTel;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.btn= null ; 
		
		
		}
	
	
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
			
		ActionErrors errors = new ActionErrors();
		if(!getBtn().equals("retour")){
			
		if( getTypeTel()== null || getTypeTel().length() < 1 ) {
		errors.add("first name",new
		ActionMessage("creation.fn.error.required"));
		}
		if( getTel()== null || getTel().length() < 1 ) {
		errors.add("last name",new
		ActionMessage("creation.ln.error.required"));
		}
	
		}
		return errors;
}
}


		

