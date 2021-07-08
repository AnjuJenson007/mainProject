package com.main.project.java.Controller;

import com.main.project.java.Entity.Product;
import com.main.project.java.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String productList(Model model) {
        List<Product> productList =productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product products = new Product();
        model.addAttribute("products", products);
        return "addProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product products) {
        productRepository.save(products);
        return "redirect:/product";
    }

    @GetMapping("/showProductFormForUpdate/{id}")
    public String showProductFormForUpdate(@PathVariable(value = "id") int productId, Model model) {
        Product products = productRepository.findById(productId).get();
        model.addAttribute("products", products);
        return "updateProduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int productId) {
        this.productRepository.deleteById(productId);
        return "redirect:/product";
    }
}

