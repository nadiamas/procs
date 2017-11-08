package servletAction;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.*;
import domain.*;

public class SearchAction extends Action {
 
 public ActionForward execute(final ActionMapping pMapping,
   ActionForm pForm, final HttpServletRequest pRequest,
   final HttpServletResponse pResponse) throws ClassNotFoundException, ServletException, IOException, SQLException, NamingException {
  
  final SearchActionForm lForm=(SearchActionForm)pForm;
  
  
  final int idSearch = lForm.getSearch();
  final String searchNAme = lForm.getSearchName();
  final String submit = lForm.getSubmit();
  List<Contact> list;
  DAOContact dao = new DAOContact();
  
  if(submit.equals("Chercher par identifiant"))
	  list = dao.SearchByID(idSearch);
  else
	  list = dao.SearchByName(searchNAme);
  
  RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/SearchResultat.jsp");
  pRequest.setAttribute("list", list);
  rd.forward(pRequest, pResponse);
  return null;
   // If any exception, return the "error" forward
   //return pMapping.findForward("error");
  
 }
}