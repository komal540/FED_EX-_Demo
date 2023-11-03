package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add parts only if they don't already exist
        addPartIfNotExists("Greeting Cards", 10, 40.0, 100, outsourcedPartRepository);
        addPartIfNotExists("Holiday Cards", 10, 55.0, 101, outsourcedPartRepository);
        addPartIfNotExists("Photo Posters", 10, 15.0, 102, outsourcedPartRepository);
        addPartIfNotExists("Canvas Print", 10, 5.0, 103, outsourcedPartRepository);
        addPartIfNotExists("Bags", 10, 65.0, 104, outsourcedPartRepository);

        // Add products only if they don't already exist
        addProductIfNotExists("Boxes", 100.0, 15, productRepository);
        addProductIfNotExists("PostCard", 50.0, 10, productRepository);
        addProductIfNotExists("Longboard", 215.0, 10, productRepository);
        addProductIfNotExists("Old School Skateboard", 180.0, 5, productRepository);
        addProductIfNotExists("Electric Skateboard", 500.0, 5, productRepository);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: " + partRepository.count());
        System.out.println(partRepository.findAll());
    }

    private void addPartIfNotExists(String name, int inv, double price, long id, OutsourcedPartRepository repository) {
        boolean partExists = false;
        for (OutsourcedPart existingPart : repository.findAll()) {
            if (existingPart.getName().equals(name)) {
                partExists = true;
                break;
            }
        }

        if (!partExists) {
            OutsourcedPart part = new OutsourcedPart();
            part.setName(name);
            part.setInv(inv);
            part.setPrice(price);
            part.setId(id);
            repository.save(part);
        }
    }

    private void addProductIfNotExists(String name, double price, int inv, ProductRepository repository) {
        boolean productExists = false;
        for (Product existingProduct : repository.findAll()) {
            if (existingProduct.getName().equals(name)) {
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            Product product = new Product(name, price, inv);
            repository.save(product);
        }
    }
}
