package ada.wm2.libraryApp.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetByCategory {
    @NotBlank
    String category;
}
