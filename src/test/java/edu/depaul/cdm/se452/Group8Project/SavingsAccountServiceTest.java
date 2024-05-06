package edu.depaul.cdm.se452.Group8Project.SavingsAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.depaul.cdm.se452.Group8Project.savings.SavingsAccount;
import edu.depaul.cdm.se452.Group8Project.savings.SavingsAccountService;

@SpringBootTest
public class SavingsAccountServiceTest {
  
  @Autowired
  private SavingsAccountService service;

  @Test
  public void testNewSavingsAccount(){
    SavingsAccount sa1 = new SavingsAccount();
    SavingsAccount sa2 = new SavingsAccount();
    SavingsAccount sa3 = new SavingsAccount();
    SavingsAccount sa = new SavingsAccount();
 
    service.save(sa1);
    service.save(sa2);
    service.save(sa3);
    sa.setCustomer("Johnny Doe");
    sa.setOpenDate("2023-04-28");
    sa.setBalance(100.00);
    long before = service.list().size();
    service.save(sa);
    long after = service.list().size();
    assertEquals(3, before);
    assertEquals(4, after);
  }

  @Test
  public void testListSavingsAccounts(){
    SavingsAccount sa1 = new SavingsAccount();
    SavingsAccount sa2 = new SavingsAccount();
    SavingsAccount sa3 = new SavingsAccount();
    SavingsAccount sa = new SavingsAccount();
    sa1.setCustomer("Jane Smit");
    sa1.setOpenDate("2022-04-28");
    sa1.setBalance(1000.00);
    service.save(sa1);
    service.save(sa2);
    service.save(sa3);
    sa.setCustomer("Johnny Doe");
    sa.setOpenDate("2023-04-28");
    sa.setBalance(500.00);
    service.save(sa);
    ArrayList<SavingsAccount> list = new ArrayList<>();
    list = (ArrayList<SavingsAccount>)service.list();
    for(SavingsAccount l:list){
      System.out.println("ID " + l.getId());
      System.out.println("Customer: " + l.getCustomer());
      System.out.println("Balance " + l.getBalance());
    }
  }

  @Test
  public void testUpdateSavingsAccount(){
    // Implemented the test for updating a savings account
    SavingsAccount sa = new SavingsAccount();
    sa.setCustomer("Johnny Doe");
    sa.setOpenDate("2023-04-28");
    sa.setBalance(500.00);
    service.save(sa);

    // Retrieves saved data savings account
    SavingsAccount savedAccount = service.list().get(0);

    // Updated the balance
    savedAccount.setBalance(1000.00);

    // Saved the updated savings account
    service.save(savedAccount);

    // Retrieved the updated savings account
    SavingsAccount updatedAccount = service.list().get(0);

    // will check if the balance was updated successfully
    assertEquals(1000.00, updatedAccount.getBalance());
  }
}
