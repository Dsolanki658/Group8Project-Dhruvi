package edu.depaul.cdm.se452.Group8Project.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.depaul.cdm.se452.Group8Project.savings.SavingsAccount;
import edu.depaul.cdm.se452.Group8Project.savings.SavingsAccountRepository;


@SpringBootTest
public class SavingsAccountRepositoryTest {

    @Autowired
    private SavingsAccountRepository repo;

    @Test
    public void testAddSavingsAccount() {
        // Create a new savings account
        SavingsAccount sa1 = new SavingsAccount();
        // sa1.setCustomer("Johnny Doe");
        // sa1.setOpenDate("2023-04-28");
        sa1.setAccountNumber(1094354);
        sa1.setIntRate(0.05);
        sa1.setPin(5454);
        sa1.setBalance(1500.00);
        // sa1.setInterestRate(0.05); // 5% interest rate

        // Will Save the savings account
        repo.save(sa1);

        // Will Check if the savings account was added successfully
        assertEquals(1, repo.count(), "The savings account could not be added successfully.");
    }

    @Test
    public void testUpdateSavingsAccount() {
        // Creates a new savings account
        SavingsAccount sa1 = new SavingsAccount();
        sa1.setBalance(2500.00);
        // Will Save the savings account
        repo.save(sa1);

        // Retrieves the saved data of savings account
        SavingsAccount savedAccount = repo.findById(1).orElse(null);
        if (savedAccount != null) {
            // Updates the existing balance
            savedAccount.setBalance(1000.00);

            // Saved the updated savings account
            repo.save(savedAccount);

            // Will Check if the balance was updated successfully
            assertEquals(1500.0, repo.findById(1).orElse(new SavingsAccount()).getBalance(),
             "The balance update to savings account failed.");
        }
    }

    @Test
    public void testDeleteSavingsAccount() {
        // Created three new savings accounts
        SavingsAccount sa1 = new SavingsAccount();
        SavingsAccount sa2 = new SavingsAccount();
        SavingsAccount sa3 = new SavingsAccount();

        // Saved the savings accounts
        repo.save(sa1);
        repo.save(sa2);
        repo.save(sa3);

        // Deleted one savings account
        repo.deleteById(1);

        // Will Check if one savings account was deleted successfully
        assertEquals(2, repo.count(), "The account could not be deleted.");
    }
}
