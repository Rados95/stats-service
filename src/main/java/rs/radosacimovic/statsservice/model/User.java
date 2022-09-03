package rs.radosacimovic.statsservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;
    private String username;
    private String firstName;
    private String lastName;
}
