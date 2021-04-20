package ada.wm2.libraryApp.repo;

import ada.wm2.libraryApp.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    Optional<List<Comment>> findAllByBookExtId(long id);
}
