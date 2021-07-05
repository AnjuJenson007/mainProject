package com.main.project.java.Controller;

import com.main.project.java.Entity.Cart;
import com.main.project.java.Entity.Product;
import com.main.project.java.Entity.User;
import com.main.project.java.Repository.CartRepository;
import com.main.project.java.Repository.ProductRepository;
import com.main.project.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class CartController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/show")
    public String show(Model model) {
        Cart cart = new Cart();
        List<User> user = userRepository.findAll();
        List<Product> product = productRepository.findAll();
        model.addAttribute("productList", product);
        model.addAttribute("userList", user);
        model.addAttribute("cart", cart);
        return "cartItem";
    }

    @PostMapping("/saveItems")
    public String saveItems(Cart cart) {
        cartRepository.save(cart);
        return "redirect:/cartList";
    }

    @GetMapping("/cartList")
    public String cartLists(Model model) {
        List<User> user = userRepository.findAll();
        List<Product> product = productRepository.findAll();
        List<Cart> cartList = cartRepository.findAll();
        model.addAttribute("product", product);
        model.addAttribute("user", user);
        model.addAttribute("cartList", cartList);
        return "cart";
    }
    @GetMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable(value = "id") int cartId) {
        this.cartRepository.deleteById(cartId);
        return "redirect:/cartList";
    }
}
