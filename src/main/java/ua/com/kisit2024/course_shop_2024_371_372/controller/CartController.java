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
import ua.com.kisit2024.course_shop_2024_371_372.bl.ItemCart;
import ua.com.kisit2024.course_shop_2024_371_372.entity.*;
import ua.com.kisit2024.course_shop_2024_371_372.repository.ProductHasOrderRepository;
import ua.com.kisit2024.course_shop_2024_371_372.service.OrderService;
import ua.com.kisit2024.course_shop_2024_371_372.service.UserService;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductHasOrderRepository productHasOrderRepository;


    @PostMapping("/addToCart")
    public String saveNewItemToCart(@RequestParam(name = "id") Product product,
                                    @RequestParam(name = "quantity") int quantity,
                                    HttpServletRequest request
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
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
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.updateItemInCart(product, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                     HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.deleteItemFromCart(product);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteAllItem")
    public String deleteAllItemFromCart(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.deleteAllItemFromCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request,
                               Model model) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());


        Long userId = (Long) session.getAttribute("user");

        Clients client = null;

        if (userId == null) {
            client = new Clients();
        } else {
            client = userService.getClientById(userId);
        }

        model.addAttribute("client", client);

        return "order";

    }


    @PostMapping("/buy")
    public String buyProduct(@RequestParam(name = "delivery") String deliveryId,
                             @RequestParam(name = "payment") String paymentId,
                             HttpServletRequest request
    ) {

        String delivery = (deliveryId.equals("1")) ? "Готівка" : "Банківська карта";

        String payment = "";
        if (paymentId.equals("1")) {
            payment = "Самовивіз";
        } else if (paymentId.equals("2")) {
            payment = "Нова пошта";
        } else {
            payment = "Укрпошта";
        }

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return "redirect:/category";
        }

        Long clientId = (Long) session.getAttribute("user");

        if (clientId != null) {

            Clients client = userService.getClientById(clientId);

            Order order = new Order();
            order.setDelivery(delivery);
            order.setPayment(payment);
            order.setDateCreated(new Date());
            order.setCliente(client);
            order.setStatus(false);

            Order order1 = orderService.saveNewOrderForClient(order);

            for (ItemCart el : cart.getCart()) {
                productHasOrderRepository.save(new ProductHasOrder(el.getProduct(), el.getQuantity(), order1));
            }

            return "redirect:/thank";
        } else {
            return "redirect:/category";
        }
    }


    @GetMapping("/thank")
    public String getPageThank() {
        return "thank";
    }


}
