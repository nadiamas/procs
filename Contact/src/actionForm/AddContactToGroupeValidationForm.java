package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactToGroupeValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;

	private long idGroupe;
	private long idContactA;
	private String btn;
	
	
	
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	
	public long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public long getIdContactA() {
		return idContactA;
	}
	public void setIdContactA(long idContactA) {
		this.idContactA = idContactA;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {		
		this.btn=null;
		this.idContactA=0;
		}
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		
		return errors;
}
		
	
	
}
