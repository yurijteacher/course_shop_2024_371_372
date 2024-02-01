package ua.com.kisit2024.course_shop_2024_371_372.bl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ItemCart {

    private Product product;
    private int quantity;

}
