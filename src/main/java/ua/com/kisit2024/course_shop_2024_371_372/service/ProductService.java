package ua.com.kisit2024.course_shop_2024_371_372.service;

import lombok.RequiredArgsConstructor;
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

}
