package microservices.book.multiplication.challenge;
import jakarta.persistence.*;
import lombok.*;
import microservices.book.multiplication.user.User;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    private User user;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChallengeAttempt that = (ChallengeAttempt) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
