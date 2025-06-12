package com.formationMosh.store;

import com.formationMosh.store.services.CategoryService;
import com.formationMosh.store.services.ProductService;
import com.formationMosh.store.services.ProfileService;
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
        ProfileService profileService = applicationContext.getBean(ProfileService.class);

        //Product sorted
        productService.getAllProductSortedAndPagine(0, 7, "name", "ASC");

        //Users
        //userService.findUserLoyalty();
        //find all profiles where loyalty points is greater than a given value.
        //profileService.findSomeUserFromProfile();

        /*
        //Save user
        User user = new User();
        user.setName("AMEVO ANAGO");
        user.setEmail("aurelleamevo@gmail.com");
        user.setPassword("myPWD");
        userService.addUser(user);

        //Save Profile
        Profile profile1 = profileService.addProfile(
                new Profile(null, "Mon 2è profile", "0197741643",
                        LocalDate.of(1992, 9, 19), 5, userService.getById(13L)));
        System.out.println(profile1.getId() + " ID Renvoyé");

        Profile profile2 = profileService.addProfile(
                new Profile(null, "Mon 3è profile", "0197460873",
                        LocalDate.of(1989, 8, 9), 10, userService.getById(user.getId())));
        System.out.println(profile2.getId() + " ID Renvoyé");

        Profile profile3 = profileService.addProfile(
                new Profile(null, "Mon 4è profile", "0101010101",
                        LocalDate.of(2003, 3, 3), 20, userService.getById(13L)));
        System.out.println(profile3.getId() + " ID Renvoyé");
        */

        // Step 1: Create a Product with a new Category

        // --- Toyota ---
        /*
        Category toyota = new Category();
        toyota.setName("Toyota");

        Product camry = new Product();
        camry.setName("Camry");
        camry.setPrice(2_500_000.0);
        camry.setCategory(toyota);

        Product rav4 = new Product();
        rav4.setName("RAV4");
        rav4.setPrice(3_000_000.0);
        rav4.setCategory(toyota);

        toyota.setProducts(new HashSet<>(Arrays.asList(camry, rav4)));
        categoryService.save(toyota);

        // --- Mercedes-Benz ---
        Category mercedes = new Category();
        mercedes.setName("Mercedes-Benz");

        Product cClass = new Product();
        cClass.setName("C-Class");
        cClass.setPrice(3_800_000.0);
        cClass.setCategory(mercedes);

        Product gle = new Product();
        gle.setName("GLE");
        gle.setPrice(6_500_000.0);
        gle.setCategory(mercedes);

        mercedes.setProducts(new HashSet<>(Arrays.asList(cClass, gle)));
        categoryService.save(mercedes);

        // --- Volkswagen ---
        Category volkswagen = new Category();
        volkswagen.setName("Volkswagen");

        Product golf = new Product();
        golf.setName("Golf");
        golf.setPrice(1_800_000.0);
        golf.setCategory(volkswagen);

        Product passat = new Product();
        passat.setName("Passat");
        passat.setPrice(2_200_000.0);
        passat.setCategory(volkswagen);

        volkswagen.setProducts(new HashSet<>(Arrays.asList(golf, passat)));
        categoryService.save(volkswagen);

        // --- Samsung ---
        Category samsung = new Category();
        samsung.setName("Samsung");

        Product galaxyS24 = new Product();
        galaxyS24.setName("Galaxy S24");
        galaxyS24.setPrice(750_000.0);
        galaxyS24.setCategory(samsung);

        Product neoQLED = new Product();
        neoQLED.setName("Neo QLED 4K TV");
        neoQLED.setPrice(1_200_000.0);
        neoQLED.setCategory(samsung);

        samsung.setProducts(new HashSet<>(Arrays.asList(galaxyS24, neoQLED)));
        categoryService.save(samsung);

        // --- Apple ---
        Category apple = new Category();
        apple.setName("Apple");

        Product iPhone15 = new Product();
        iPhone15.setName("iPhone 15 Pro");
        iPhone15.setPrice(900_000.0);
        iPhone15.setCategory(apple);

        Product macBookAir = new Product();
        macBookAir.setName("MacBook Air M3");
        macBookAir.setPrice(1_500_000.0);
        macBookAir.setCategory(apple);

        apple.setProducts(new HashSet<>(Arrays.asList(iPhone15, macBookAir)));
        categoryService.save(apple);

        // --- IKEA ---
        Category ikea = new Category();
        ikea.setName("IKEA");

        Product bestaUnit = new Product();
        bestaUnit.setName("BESTÅ TV Storage Unit");
        bestaUnit.setPrice(150_000.0);
        bestaUnit.setCategory(ikea);

        Product malmBed = new Product();
        malmBed.setName("MALM Bed Frame");
        malmBed.setPrice(90_000.0);
        malmBed.setCategory(ikea);

        ikea.setProducts(new HashSet<>(Arrays.asList(bestaUnit, malmBed)));
        categoryService.save(ikea);
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
        //productService.deleteProduct(productService.getById(1L));

        //Modifier le prix d'un produit à partir de son ID
        //Product p = productService.updateProduct(2L, 4_500_000);
        //System.out.println("Name : " + p.getName() + "\nNouveau prix : " + p.getPrice());

        //Liste des produits d'une catégorie
        //productService.productListByCategory(categoryService.getById(1L));

        //Récupérer un user à partir de son email
        //userService.fetchByEmail();

        //allUser
        //userService.allUser();
    }

}
