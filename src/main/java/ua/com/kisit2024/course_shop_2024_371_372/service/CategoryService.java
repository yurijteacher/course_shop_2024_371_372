package ua.com.kisit2024.course_shop_2024_371_372.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Category;
import ua.com.kisit2024.course_shop_2024_371_372.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

//    public CategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }


    public List<Category> findAllCategory(){

//        List<Category> categories = new ArrayList<>();
//        categories = categoryRepository.findAll();
//
//        return categories;

        return categoryRepository.findAll();
    }

    public Page<Category> findPageCategory(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }


}
