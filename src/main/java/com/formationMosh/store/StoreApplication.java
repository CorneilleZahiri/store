package com.formationMosh.store;

import com.formationMosh.store.services.CategoryService;
import com.formationMosh.store.services.ProductService;
import com.formationMosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);

        UserService userService = applicationContext.getBean(UserService.class);
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        ProductService productService = applicationContext.getBean(ProductService.class);

        // Step 1: Create a Product with a new Category
        /*
        Category category = new Category();
        category.setName("Toyota");

        Product product = new Product();
        product.setName("Camry");
        product.setPrice(2_500_000.0);
        product.setCategory(category);

        category.getProducts().add(product);

        categoryService.save(category);
        */

        // Step 2: Create a Product for an Existing Category
        /*
        Product product1 = new Product();
        product1.setName("Avalon");
        product1.setPrice(3_000_000.0);
        product1.setCategory(categoryService.getById(1L));

        productService.save(product1);
        */

        //Step 3: Add Products to a User’s Wishlist
        //userService.saveAllProductWithUser(9L);

        //Step 4: Deleting a Product
        productService.deleteProduct(productService.getById(1L));
    }

}
