package flavor.and.taste.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    APPETIZER("Appetizer"),
    MAIN_COURSE("Main Course"),
    DESSERT("Dessert"),
    SALAD("Salad"),
    SOUP("Soup"),
    BEVERAGE("Beverage"),
    SNACK("Snack"),
    OTHER("Other");

    private final String name;


    public static Category fromCategoryName(String categoryName) {
        for (Category category : Category.values()) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found");
    }
}
