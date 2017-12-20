package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteContactToGroupeValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;

	private long idGroupe;
	private long idContactS;
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

	public long getIdContactS() {
		return idContactS;
	}
	public void setIdContactS(long idContactS) {
		this.idContactS = idContactS;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {		
		this.btn=null;

		}
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		
		return errors;
}
		
	
	
}
