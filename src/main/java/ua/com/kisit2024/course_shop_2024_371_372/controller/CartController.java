package ua.com.kisit2024.course_shop_2024_371_372.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit2024.course_shop_2024_371_372.bl.Cart;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Product;

@Controller
@RequiredArgsConstructor
public class CartController {

    @PostMapping("/addToCart")
    public String saveNewItemToCart(@RequestParam(name = "id") Product product,
                                    @RequestParam(name = "quantity") int quantity,
                                    HttpServletRequest request
                                    ){

     HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model
                              ){

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());

        return "cart";
    }


    @PostMapping("/updateItemInCart")
    public String updateItemInCart(@RequestParam(name = "id") Product product,
                                   @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        cart.updateItemInCart(product, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                    HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        cart.deleteItemFromCart(product);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteAllItem")
    public String deleteAllItemFromCart(
                                     HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        cart.deleteAllItemFromCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


}
