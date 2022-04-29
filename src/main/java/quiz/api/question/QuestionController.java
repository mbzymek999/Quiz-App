package quiz.api.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.domain.question.QuestionFacade;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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

    @GetMapping("/question/{clientId}")
    QuestionDto readByClientId(@PathVariable(value = "clientId") @Size(min = 10, max = 10) String clientId) {
        return facade.readByClientId(clientId);
    }

    @GetMapping("/question/random")
    QuestionDto readRandomQuestion() {
        return facade.randomClient();
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

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
