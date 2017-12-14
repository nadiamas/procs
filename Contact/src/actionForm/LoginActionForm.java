package actionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class LoginActionForm extends ActionForm {
 /**
  *
  */
 private static final long serialVersionUID = 1L;
 private String userName;
 private String password;
 
 
 public void setUserName(String userName) {
  this.userName = userName;
 }
 
 
 public String getUserName() {
  return userName;
 }

 public void setPassword(String password) {
  this.password = password;
 }
 public String getPassword() {
  return password;
 }
 
 public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
  ActionErrors errors = new ActionErrors();
  if ( userName==null || userName.length()<=2) {
   errors.add("error",new ActionMessage ("error.login"));
  }
  if ( password==null || password.length()<=2) {
   errors.add("error",new ActionMessage ("error.password"));
  }
  return errors;
 }
 
 
 
 
}