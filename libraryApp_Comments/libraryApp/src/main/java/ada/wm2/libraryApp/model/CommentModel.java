package ada.wm2.libraryApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentModel {

    private String id;
    private String author_name;
    private String content;

    private List<CommentModel> replies;
}
