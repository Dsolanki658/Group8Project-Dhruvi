package edu.depaul.cdm.se452.Group8Project.savings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {
  
  @Autowired
  private SavingsAccountRepository repo;

  

  public List<SavingsAccount> list(){
    List<SavingsAccount> listOfSavingsAccounts = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
    return listOfSavingsAccounts;
  }

  public SavingsAccount save(SavingsAccount account){
    repo.save(account);
    return account;
  }

  public void delete(long id){
    repo.deleteById(id);
  }
}
