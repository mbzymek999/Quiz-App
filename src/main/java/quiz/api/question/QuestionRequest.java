package quiz.api.question;

public class QuestionRequest {

    private String title;
    private String description;
    private int known;

    public QuestionRequest() {
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
