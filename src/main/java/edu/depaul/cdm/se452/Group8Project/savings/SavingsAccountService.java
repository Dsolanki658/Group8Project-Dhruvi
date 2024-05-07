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

  public List<SavingsAccount> listsSavingsAccounts(){
    // Retrieved all savings accounts from the repository and convert them to a list
    return StreamSupport.stream(repo.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }

  public SavingsAccount saveSavingsAccount(SavingsAccount account){
    // Saved the provided savings account to the repository
    return repo.save(account);
  }

  public void deleteSavingsAccountById(long id){
    // Deleted the savings account with the given ID from the repository
    repo.deleteById((int) id);
  }
}
