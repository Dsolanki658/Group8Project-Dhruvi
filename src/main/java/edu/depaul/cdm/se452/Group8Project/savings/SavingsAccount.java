package edu.depaul.cdm.se452.Group8Project.savings;

import edu.depaul.cdm.se452.Group8Project.account.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Table(name = "savings")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class SavingsAccount extends Account {
    private double intRate;

    public SavingsAccount(String customer, String openingDate, double balance, double intRate) {
        //In order to inherit the properties from parent class Account we need to call constructor
        // Commented out below code until non default constructor is defined in Account class
        // vague definition we can always modify later
        //super(customer, openingDate, balance); 
        super();
        this.intRate = intRate;
    }

    // Will add other methods specific to SavingsAccount
}
