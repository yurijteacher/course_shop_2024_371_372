package ua.com.kisit2024.course_shop_2024_371_372.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Category;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Product;
import ua.com.kisit2024.course_shop_2024_371_372.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductsByCategory(Category category){
        return productRepository.findAllByCategories(category);
    }

   public List<Product> getProductsByName(String name){
      return  productRepository.findAllByNameContainsIgnoreCaseOrderByName(name);
   }

   @Cacheable(value = {"productByCategoryId"}, key = "#category.id  + '_' + #pageable.pageNumber")
   public Page<Product> getPageProducts(Pageable pageable, Category category){
        return productRepository.findAllByCategories(pageable, category);
   }

}
