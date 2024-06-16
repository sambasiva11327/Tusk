package net.javaguides.service;

import java.util.List;

import net.javaguides.dto.AcccountDto;

public interface AccountService {
AcccountDto createaccounting(AcccountDto account);
AcccountDto getacountByid(Long id);
AcccountDto deposit(Long id,double amount);
AcccountDto withdraw(Long id,double amount);
List<AcccountDto>getallaccounts();

void deleteaccount(Long id);

}
