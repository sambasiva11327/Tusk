package net.javaguides.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.dto.AcccountDto;
import net.javaguides.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountservice;

	public AccountController(AccountService accountservice) {
		
		this.accountservice = accountservice;
	}
	//add account Rest Api
	@PostMapping
	public ResponseEntity<AcccountDto>addAccount(@RequestBody AcccountDto accountDto){
		return new ResponseEntity<>(
				accountservice.createaccounting(accountDto),HttpStatus.CREATED);
		
	}
	// get account rest api
	@GetMapping("/{id}")
	public ResponseEntity<AcccountDto>getaccountById(@PathVariable  Long id){
		AcccountDto accountdto=accountservice.getacountByid(id);
		return ResponseEntity.ok(accountdto);
		
	}
	//Deposit Rest Api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AcccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){
		
	AcccountDto acountdto=	accountservice.deposit(id, request.get("amount"));
		return ResponseEntity.ok(acountdto);
		
	}
	// withdraw Rest Api
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AcccountDto>withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){
	AcccountDto accountdto=	accountservice.withdraw(id, request.get("amount"));
		return ResponseEntity.ok(accountdto);
		
	}
	//get all accounts Rest Api
	@GetMapping
	public ResponseEntity<List<AcccountDto>> getallaccounts(){
		List<AcccountDto>account= accountservice.getallaccounts();
		return ResponseEntity.ok(account);
	}
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String>deleteaccount(@PathVariable Long id){
		accountservice.deleteaccount(id);
		return ResponseEntity.ok("account is deleted sucessfully");
    
		}
}
