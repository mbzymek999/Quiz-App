package quiz.domain.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz.api.question.QuestionDto;

import java.util.List;
import java.util.Optional;

@Repository
interface QuestionRepository extends JpaRepository<Question, Integer> {

    Optional<Question> findByClientId(String clientId);

    List<Question> findAllByDisplayedStatus(int displayedStatus);

}
