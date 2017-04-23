package com.banksystem.BankSystem;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.banksystem.BankSystem.bean.Account;
import com.banksystem.BankSystem.bean.AccountService;
import com.banksystem.BankSystem.bean.Customer;
import com.banksystem.BankSystem.bean.CustomerService;

@Path("/customers")
public class Customers {


	CustomerService customerservice= new CustomerService();
	AccountService service= new AccountService();
	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Customer> getCustomers() {
	    return customerservice.getAllMessages();
	  }

	  // This method is called if HTML is request
	  
	  @GET
	  @Path("{CustomerId}")
	  @Produces(MediaType.TEXT_XML)
	  public Customer updateCustomerInfo(@PathParam("CustomerId") long CustomerId)
	  {
		  //Code to update customer record using customerid
		  return customerservice.getCustomer(CustomerId);
	  }
	  
//	  @GET
//	  @Path("{CustomerId}/ACC")
//	  @Produces(MediaType.TEXT_XML)
//	  public List<Account> getAccount(@PathParam("CustomerId") long CustomerId) {
//	    return service.getAllAccounts(CustomerId);
//	  }
	  
//	  @POST
//	  @Consumes(MediaType.APPLICATION_JSON)
//	  @Produces(MediaType.APPLICATION_JSON)
//	  public String postCustomer(Customer cust)
//	  {
//		  //Code to update customer record using customerid
//		  customerservice.addCustomer(cust);
//		  return "Psot works fine";
//	  }
//	  @GET
//	  @Path("/account")
//	  @Produces(MediaType.TEXT_XML)
//	  public List<Account> getAccounts() {
//		  AccountService accountservice= new AccountService();
//		    return accountservice.getAllAccounts();
//		  }


}
