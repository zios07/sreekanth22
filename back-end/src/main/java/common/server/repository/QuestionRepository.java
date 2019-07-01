package common.server.repository;

import common.server.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByUserAccountUsername(String username);

    List<Question> findByCategory(String category);
}
