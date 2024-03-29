package ua.com.kisit2024.course_shop_2024_371_372.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Category;
import ua.com.kisit2024.course_shop_2024_371_372.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @GetMapping("/category/{id}")
//    public String getProductsByCategory(@PathVariable(name = "id") Category category,
//                                        Model model){
//
//        model.addAttribute("productsByCategory", productService.getProductsByCategory(category));
//
//        return "products-by-category";
//    }


    @GetMapping("/category/{id}")
    public String getProductsByCategory(@PathVariable(name = "id") Category category,
                                        @PageableDefault(sort = {"id"},
                                        direction = Sort.Direction.ASC, size = 2)
                                        Pageable pageable,
                                        Model model){

//        model.addAttribute("productsByCategory", productService.getProductsByCategory(category));

        model.addAttribute("page", productService.getPageProducts(pageable, category));
        model.addAttribute("url", "/category/" + category.getId());


        return "products-by-category";
    }


    @GetMapping("/search")
    public String getPageSearch(@RequestParam() String search,
                                Model model
                                ){
        model.addAttribute("productsByName", productService.getProductsByName(search));

        return "search";
    }


}
