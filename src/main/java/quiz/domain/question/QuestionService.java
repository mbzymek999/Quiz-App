package quiz.domain.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.api.question.QuestionDto;
import quiz.api.question.QuestionRequest;
import quiz.api.question.QuestionUpdateRequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionService implements QuestionFacade{

    private final QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuestionDto> readAll() {
        return repository.findAll().stream().map(QuestionDto::new).collect(Collectors.toList());
    }

    public QuestionDto createQuestion(QuestionRequest request) {

        String randomId = UUID.randomUUID().toString().substring(1,10);
        Question question = new Question(
                randomId,
                request.getTitle(),
                request.getDescription(),
                0
        );

        repository.save(question);
        return new QuestionDto(question);
    }

    public QuestionDto updateQuestion(QuestionUpdateRequest updateRequest, String clientId) {
        Question question = repository.findByClientId(clientId).orElseThrow();
        updateRequest.updateEntity(question);
        repository.save(question);
        return new QuestionDto(question);
    }

    public QuestionDto deleteQuestion(String clientId) {
        Question question = repository.findByClientId(clientId).orElseThrow();
        repository.delete(question);
        return new QuestionDto(question);
    }
}
