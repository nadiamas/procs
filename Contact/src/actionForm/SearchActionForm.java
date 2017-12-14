package actionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class SearchActionForm extends ActionForm  {
 
 /**
  *
  */
 private static final long serialVersionUID = 1L;
 
 private int search=0;
 private String searchName = "Recherche par nom";
 private String submit;
 
 
 public int getSearch() {
  return search;
 }
 public void setSearch(int search) {
  this.search = search;
 }
 
  public String getSearchName() {
	return searchName;
}
public void setSearchName(String searchName) {
	this.searchName = searchName;
}

public String getSubmit() {
	return submit;
}
public void setSubmit(String submit) {
	this.submit = submit;
}

public void reset(ActionMapping mapping, HttpServletRequest request) {
     this.search=0;
   }
   public ActionErrors validate(
        ActionMapping mapping, HttpServletRequest request ) {
        ActionErrors errors = new ActionErrors();
       
        if( getSearch()==0) {
          errors.add("Search",new ActionMessage("search.fn.error.required"));
        }
     
         return errors;
   
  
}
}