package ada.wm2.libraryApp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    private String id;

    private String bookExtId;

    private String commentAuthName;

    private String commentContent;
}
