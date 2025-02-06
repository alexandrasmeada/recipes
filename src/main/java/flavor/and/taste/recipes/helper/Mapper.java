package flavor.and.taste.recipes.helper;

import flavor.and.taste.recipes.dao.entity.CategoryEntity;
import flavor.and.taste.recipes.dao.entity.RecipeEntity;
import flavor.and.taste.recipes.dao.entity.UserEntity;
import flavor.and.taste.recipes.model.Category;
import flavor.and.taste.recipes.model.CategoryDto;
import flavor.and.taste.recipes.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public RecipeEntity mapToRecipeEntity(Recipe recipe) {
        return modelMapper.map(recipe, RecipeEntity.class);
    }

    public Recipe mapToRecipe(RecipeEntity recipeEntity) {
        return modelMapper.map(recipeEntity, Recipe.class);
    }

    public CategoryEntity mapToCategoryEntity(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getCategory().getName());
        return categoryEntity;
    }

    public UserDetails mapToUserDetail(UserEntity userEntity) {
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }

    public CategoryDto mapToCategory(CategoryEntity categoryEntity) {
        return CategoryDto.builder()
                .idCategory(categoryEntity.getIdCategory())
                .category(Category.fromCategoryName(categoryEntity.getName()))
                .build();
    }
}
