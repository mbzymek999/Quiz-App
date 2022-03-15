package quiz.api.question;

import quiz.domain.question.Question;

public class QuestionDto {

    private final String clientId;
    private final String title;
    private final String description;

    public QuestionDto(Question question) {
        this.clientId = question.getClientId();
        this.title = question.getTitle();
        this.description = question.getDescription();
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
}
