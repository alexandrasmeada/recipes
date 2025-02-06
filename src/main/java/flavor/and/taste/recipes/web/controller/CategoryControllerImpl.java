package flavor.and.taste.recipes.web.controller;

import flavor.and.taste.recipes.model.Category;
import flavor.and.taste.recipes.model.CategoryDto;
import flavor.and.taste.recipes.service.CategoryService;
import flavor.and.taste.recipes.web.api.CategoryController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    @Override
    public ResponseEntity<Void> createCategory(String requestId, CategoryDto category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories(String requestId) {
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }
}
