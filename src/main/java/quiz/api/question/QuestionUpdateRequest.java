package quiz.api.question;

import quiz.domain.question.Question;

public class QuestionUpdateRequest {
    private String title;
    private String description;
    private int known;

    public void updateEntity(Question question) {
        question.setTitle(this.title);
        question.setDescription(this.description);
        question.setKnown(this.known);
    }

    public QuestionUpdateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getKnown() {
        return known;
    }
}
