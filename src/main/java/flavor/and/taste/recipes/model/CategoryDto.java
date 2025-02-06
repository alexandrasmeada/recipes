package flavor.and.taste.recipes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CategoryDto {
    @JsonProperty
    private Long idCategory;
    @JsonProperty
    private Category category;
}
