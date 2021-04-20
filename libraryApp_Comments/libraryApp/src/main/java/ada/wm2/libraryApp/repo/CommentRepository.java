package ada.wm2.libraryApp.repo;

import ada.wm2.libraryApp.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByBookExtId(long Id);
}
