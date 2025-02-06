package flavor.and.taste.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
@Data
public class Recipe {

    public Long recipeId;
    public String recipeName;
    public String recipeDescription;
    public Category recipeCategory;
    public List<String> recipeIngredients;
    public List<String> recipeInstructions;
    public Duration preparationTime;
    public Duration cookingTime;
    public Duration totalTime;
}
