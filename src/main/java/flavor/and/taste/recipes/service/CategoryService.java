package flavor.and.taste.recipes.service;

import flavor.and.taste.recipes.dao.repository.CategoryRepository;
import flavor.and.taste.recipes.helper.Mapper;
import flavor.and.taste.recipes.model.Category;
import flavor.and.taste.recipes.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryRepository categoryRepository;
    private final Mapper mapper;

    public void createCategory(CategoryDto category) {
        if (categoryRepository.findByName(category.getCategory().getName()).isPresent()) {
            throw new IllegalArgumentException("Category already exists");
        }
        categoryRepository.save(mapper.mapToCategoryEntity(category));
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(mapper::mapToCategory)
                .toList();
    }
}
