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

    private int displayedStatus;

    public Question() {
    }

    public Question(String clientId, String title, String description, int known, int displayedStatus) {
        this.clientId = clientId;
        this.title = title;
        this.description = description;
        this.known = known;
        this.displayedStatus = displayedStatus;
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

    public void setDisplayedStatus(int displayedStatus) {
        this.displayedStatus = displayedStatus;
    }
}
