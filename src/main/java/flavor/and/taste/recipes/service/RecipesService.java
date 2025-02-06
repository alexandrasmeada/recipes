package flavor.and.taste.recipes.service;

import flavor.and.taste.recipes.dao.entity.RecipeEntity;
import flavor.and.taste.recipes.dao.repository.CategoryRepository;
import flavor.and.taste.recipes.dao.repository.RecipeRepository;
import flavor.and.taste.recipes.helper.Mapper;
import flavor.and.taste.recipes.model.Recipe;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipesService {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    @Transactional
    public void createRecipe(@Valid Recipe recipe) {
        RecipeEntity recipeEntity = mapper.mapToRecipeEntity(recipe);
        recipeEntity.setRecipeCategory(categoryRepository.findByName(recipe.getRecipeCategory().getName())
                .orElseThrow());
        recipeRepository.save(recipeEntity);
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll().stream().map(mapper::mapToRecipe).toList();
    }
}
