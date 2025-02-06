package flavor.and.taste.recipes.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
public class RecipeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipe;
    private String recipeName;
    private String recipeDescription;

    @ManyToOne
    @JoinColumn(name = "recipe_category_id", referencedColumnName = "idCategory")
    private CategoryEntity recipeCategory;

    private List<String> recipeIngredients;
    private List<String> recipeInstructions;
    private Duration preparationTime;
    private Duration cookingTime;
    private Duration totalTime;


}
