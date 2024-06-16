package net.javaguides.mapper;

import net.javaguides.dto.AcccountDto;
import net.javaguides.entity.Account;

public class AccountMapper {
	
public static Account mapToAccount(AcccountDto accountdto) {
	Account account =new Account(
			accountdto.getId(),
			accountdto.getAccountHolderName(),
			accountdto.getBalance()
			);
return account;	
}
 
     public static AcccountDto mapToAcccountDto(Account account) {
    	 AcccountDto accountDto=new AcccountDto(
    			 account.getId(),account.getAccountHolderName(),account.getBalance());
    	 return accountDto;
     }
    
}
