package ada.wm2.libraryApp.service;

import ada.wm2.libraryApp.entity.Comment;
import ada.wm2.libraryApp.repo.CommentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;

    List<Comment> getCommentsByBookExtId(long id) {

        Optional<List<Comment>> result = Optional.ofNullable(commentRepository.findAllByBookExtId(id));

        if(result.isEmpty()) return new ArrayList<>(1);

        return result.get();
    }
}
