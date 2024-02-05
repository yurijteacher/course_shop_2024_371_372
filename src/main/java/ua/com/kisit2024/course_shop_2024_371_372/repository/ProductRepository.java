package ua.com.kisit2024.course_shop_2024_371_372.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Category;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategories(Category category);

//    List<Product> findAllByCategoriesAndAndBrandes(Category category, Brande brande);


    // пошук по словам!!!
    List<Product> findAllByNameOrderByName(String name);

    // пошук по буквам!!!
    List<Product> findAllByNameContainsIgnoreCaseOrderByName(String name);
}
