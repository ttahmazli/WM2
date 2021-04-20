package ada.wm2.libraryApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String fistName;

    private String lastName;

    @Column(nullable = false, unique = true, updatable = false)
    @Email(message = "Email should be valid")
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", columnDefinition = " integer default 1")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserBooks> userBooks;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
