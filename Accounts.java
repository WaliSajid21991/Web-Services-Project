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

@Path("/accounts")
public class Accounts {


	AccountService customerservice= new AccountService();
	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Account> getAccount() {
	    return customerservice.getAllAccounts();
	  }




}
