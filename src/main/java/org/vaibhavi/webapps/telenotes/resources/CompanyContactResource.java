package org.vaibhavi.webapps.telenotes.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vaibhavi.webapps.telenotes.model.CompanyContact;
import org.vaibhavi.webapps.telenotes.service.CompanyContactService;
import org.vaibhavi.webapps.telenotes.service.UserService;

@Path("/vaibhavi")
public class CompanyContactResource {
	
	CompanyContactService companyContactService = new CompanyContactService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompanyContact> getContacts() {
		return companyContactService.getAllCompanyContacts();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompanyContact addContact(CompanyContact companyContact) {
		return companyContactService.addCompanyContact(companyContact);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompanyContact updateContact(CompanyContact companyContact) {
		return companyContactService.updateCompanyContact(companyContact);
	}
	
	@DELETE
	@Path("/{companyName}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteContact(@PathParam("companyName") String companyRecordToDelete) {
		return companyContactService.deleteCompanyContact(companyRecordToDelete);
	}
	
	/*@GET
	@Path("/{companyNameID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String putContacts(@PathParam("companyNameID") String companyNameID) {
		return "Got path param" + companyNameID;
	}*/
	
	
	/*@Produces(MediaType.APPLICATION_XML)
	public List<CompanyContact> getContacts() {
		return companyContactService.getAllCompanyContacts();
	}*/
}
