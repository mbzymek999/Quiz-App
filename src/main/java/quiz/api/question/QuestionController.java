package quiz.api.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.domain.question.QuestionFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuestionController {

    private final QuestionFacade facade;

    @Autowired
    public QuestionController(QuestionFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/questions")
    List<QuestionDto> readAllQuestions() {
        return facade.readAll();
    }

    @PostMapping("/create/question")
    QuestionDto createQuestion(@RequestBody @Valid QuestionRequest request) {
        return facade.createQuestion(request);
    }

    @PutMapping("/update/question/{clientId}")
    QuestionDto updateQuestion(@PathVariable(value = "clientId") String clientId, @RequestBody QuestionUpdateRequest updateRequest) {
        return facade.updateQuestion(updateRequest, clientId);
    }

    @DeleteMapping("/delete/question/{clientId}")
    QuestionDto deleteQuestion(@PathVariable(value = "clientId") String clientId) {
        return facade.deleteQuestion(clientId);
    }

}
