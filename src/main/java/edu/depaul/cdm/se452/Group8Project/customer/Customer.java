package edu.depaul.cdm.se452.Group8Project.customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String name;

  private String email;

  private Account accounts[];

}
