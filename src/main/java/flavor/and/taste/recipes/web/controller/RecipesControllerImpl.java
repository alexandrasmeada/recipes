package flavor.and.taste.recipes.web.controller;

import flavor.and.taste.recipes.model.Recipe;
import flavor.and.taste.recipes.service.RecipesService;
import flavor.and.taste.recipes.web.api.RecipesController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RecipesControllerImpl implements RecipesController {

    private final RecipesService recipeService;

    @Override
    public ResponseEntity<Void> createRecipe(@Valid @RequestBody Recipe recipe) {
        recipeService.createRecipe(recipe);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getRecipes();
        return ResponseEntity.ok(recipes);
    }
}
