package softuni.coffeeshop.service;


import softuni.coffeeshop.model.entity.Category;
import softuni.coffeeshop.model.entity.CategoryName;

public interface CategoryService {

    void initCategories();

    Category findByCategoryName(CategoryName category);
}
