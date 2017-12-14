package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddGroupValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;

	private String nomgroupe=null;
	private String btn;
	
	
	
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}

	public String getNomgroupe() {
		return nomgroupe;
	}
	public void setNomgroupe(String nomgroupe) {
		this.nomgroupe = nomgroupe;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	
		this.nomgroupe=null;
		this.btn=null;

		}
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		if(getBtn().equals("save")){
		if( getNomgroupe()== null || getNomgroupe().length() < 1 ) {
		errors.add("groupe",new
		ActionMessage("creation.grp.error.required"));
		}}
		return errors;
}
		
	
	
}
