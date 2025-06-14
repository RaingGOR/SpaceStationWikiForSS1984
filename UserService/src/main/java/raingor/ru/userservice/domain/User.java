package raingor.ru.userservice.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, String email) {
        super(OffsetDateTime.now(), null);
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.USER;
    }
}
