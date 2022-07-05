package softuni.coffeeshop.service.impl;

import org.springframework.stereotype.Service;
import softuni.coffeeshop.model.entity.Category;
import softuni.coffeeshop.model.entity.CategoryName;
import softuni.coffeeshop.repository.CategoryRepository;
import softuni.coffeeshop.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryName.values())
                .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        switch (categoryName){
                            case Coffee -> category.setNeededTime(2);
                            case Cake -> category.setNeededTime(10);
                            case Drink -> category.setNeededTime(1);
                            case Other -> category.setNeededTime(5);
                        }
                        categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryName(CategoryName category) {

        return categoryRepository.findByName(category).orElse(null);
    }
}
