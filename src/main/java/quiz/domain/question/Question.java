package quiz.domain.question;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String clientId;

    private String title;

    private String description;

    private int known;

    public Question() {
    }

    public Question(String clientId, String title, String description, int known) {
        this.clientId = clientId;
        this.title = title;
        this.description = description;
        this.known = known;
    }

    public String getClientId() {
        return clientId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKnown(int known) {
        this.known = known;
    }
}
