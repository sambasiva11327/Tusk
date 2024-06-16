package net.javaguides.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.dto.AcccountDto;
import net.javaguides.entity.Account;
import net.javaguides.mapper.AccountMapper;
import net.javaguides.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{
    
	private AccountRepository accountrepository;
	
	public AccountServiceImpl(AccountRepository accountrepository) {
		super();
		this.accountrepository = accountrepository;
	}

	@Override
	public AcccountDto createaccounting(AcccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account=AccountMapper.mapToAccount(accountDto);
	Account savedAccount=	accountrepository.save(account);
		return AccountMapper.mapToAcccountDto(savedAccount);
	}

	

	@Override
	public AcccountDto getacountByid(@PathVariable Long id) {
		// TODO Auto-generated method stub
	Account account=accountrepository.findById(id).orElseThrow(()
				->new RuntimeException("account does not exist"));
		return AccountMapper.mapToAcccountDto(account);
	}

	@Override
	public AcccountDto deposit(Long id, double amount) {
		// TODO Auto-generated method stub

		Account account=accountrepository.findById(id).orElseThrow(()
					->new RuntimeException("account does not exist"));
	double total=	account.getBalance() + amount;
	account.setBalance(total);
	Account savedaccount=accountrepository.save(account);
		return AccountMapper.mapToAcccountDto(savedaccount);
	}

	@Override
	
	public AcccountDto withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
         Account account=accountrepository.findById(id).orElseThrow(()
					->new RuntimeException("account does not exist"));
         double total=account.getBalance()-amount;
         account.setBalance(total);
       Account saveaccount=  accountrepository.save(account);
       
		return AccountMapper.mapToAcccountDto(saveaccount);
	}

	@Override
	public List<AcccountDto> getallaccounts() {
		// TODO Auto-generated method stub
	List<Account> accounts=	accountrepository.findAll();
return	accounts.stream().map((account)->AccountMapper.mapToAcccountDto(account))
	.collect(Collectors.toList());
	

		
	}

	@Override
	public void deleteaccount(Long id) {
		// TODO Auto-generated method stub

        Account account=accountrepository.findById(id).orElseThrow(()
					->new RuntimeException("account does not exist"));
        accountrepository.deleteById(id);
	}



}
