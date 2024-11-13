package ru.spmi.winery.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spmi.winery.enums.UserRole;

@Data
@Entity
@Builder
@Table(name = "employers")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Logginable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @Override
    public String getLogin() {
        return email;
    }

    @Override
    public String getAuthorities() {
        return UserRole.CUSTOMER.toString();
    }

}
