package edu.depaul.cdm.se452.Group8Project.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;

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
 
    service.saveSavingsAccount(sa1);
    service.saveSavingsAccount(sa2);
    service.saveSavingsAccount(sa3);
    // sa.setCustomer("Johnny Doe");
    // sa.setOpenDate("2023-04-28");
    sa.setBalance(100.00);
    long before = service.listsSavingsAccounts().size();
    service.saveSavingsAccount(sa);
    long after = service.listsSavingsAccounts().size();
    assertEquals(3, before);
    assertEquals(4, after);
  }

  @Test
  public void testListSavingsAccounts(){
    SavingsAccount sa1 = new SavingsAccount();
    SavingsAccount sa2 = new SavingsAccount();
    SavingsAccount sa3 = new SavingsAccount();
    SavingsAccount sa = new SavingsAccount();
    // sa1.setCustomer("Jane Smit");
    // sa1.setOpenDate("2022-04-28");
    // sa.setCustomer("Johnny Doe");
    // sa.setOpenDate("2023-04-28");
    sa1.setId(22);
    sa2.setId(32);
    sa3.setId(42);
    sa.setId(52);
    sa1.setBalance(1000.00);
    sa2.setBalance(2000.00);
    sa3.setBalance(3000.00);
    service.saveSavingsAccount(sa1);
    service.saveSavingsAccount(sa2);
    service.saveSavingsAccount(sa3);
    
    sa.setBalance(500.00);
    service.saveSavingsAccount(sa);
    ArrayList<SavingsAccount> list = new ArrayList<>();
    list = (ArrayList<SavingsAccount>)service.listsSavingsAccounts();
    for(SavingsAccount l:list){
      System.out.println("ID " + l.getId());
      // System.out.println("Customer: " + l.getCustomer());
      System.out.println("Balance " + l.getBalance());
    }
  }

  @Test
  public void testUpdateSavingsAccount(){
    // Implemented the test for updating a savings account
    SavingsAccount sa = new SavingsAccount();
    // sa.setCustomer("Johnny Doe");
    // sa.setOpenDate("2023-04-28");
    sa.setBalance(1000.00);
    service.saveSavingsAccount(sa);

    // Retrieved the updated savings account
    SavingsAccount updatedAccount = service.listsSavingsAccounts().get(0);

    // will check if the balance was updated successfully
    assertEquals(1000.00, updatedAccount.getBalance());
  }
}
