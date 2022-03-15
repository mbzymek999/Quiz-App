package quiz.domain.question;

import quiz.api.question.QuestionDto;
import quiz.api.question.QuestionRequest;
import quiz.api.question.QuestionUpdateRequest;

import java.util.List;

public interface QuestionFacade {

    List<QuestionDto> readAll();

    QuestionDto createQuestion(QuestionRequest request);

    QuestionDto updateQuestion(QuestionUpdateRequest updateRequest, String clientId);

    QuestionDto deleteQuestion(String clientId);

}
