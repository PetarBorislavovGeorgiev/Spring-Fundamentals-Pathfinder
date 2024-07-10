package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;
    private Integer age;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany
    private Set<Role> roles;

    public User(){
        this.roles = new HashSet<>();
    }


}
