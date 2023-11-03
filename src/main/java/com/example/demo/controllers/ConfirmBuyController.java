package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Product;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfirmBuyController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/confirmBuy/{productID}")
    public String showConfirmationBuyPage(@PathVariable Long productID, Model model) {
        // Retrieve the product based on the provided productID
        Product product = productRepository.findById(productID).orElse(null);

        if (product == null) {
            return "errorPage";
        }

        model.addAttribute("product", product);

        return "confirmBuy";
    }


    @PostMapping("/confirmBuy/{productID}")
    public String processPurchase(@PathVariable Long productID) {
        // Retrieve the product based on the provided productID
        Product product = productRepository.findById(productID).orElse(null);

        if (product == null) {
            return "errorPage";
        }

        // Decrement the product inventory by one
        int currentInventory = product.getInv();
        if (currentInventory > 0) {
            product.setInv(currentInventory - 1);
            productRepository.save(product); // Save the updated product
        } else {
            return "errorPage"; // Inventory is zero, return an error page
        }

        return "confirmBuy"; // Return to the confirmation page
    }

}
