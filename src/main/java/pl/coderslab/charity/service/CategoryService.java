package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save (Category category){
        categoryRepository.save(category);
    }

    public void delete (Category category){
        categoryRepository.delete(category);
    }

    public void edit (Category category){
        Category categoryToEdit = categoryRepository.getOne(category.getId());
        categoryRepository.save(categoryToEdit);
    }
    public Category read (Long id){
        return  categoryRepository.getOne(id);

    }

    public List<Category> findAll (){
        return  categoryRepository.findAll();
    }
}
