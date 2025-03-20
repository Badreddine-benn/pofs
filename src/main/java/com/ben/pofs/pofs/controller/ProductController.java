package com.ben.pofs.pofs.controller;
//import java.util.Optional;

//import org.hibernate.mapping.List;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ben.pofs.pofs.entity.ProductEntity;
//import com.ben.pofs.pofs.repository.ProductNameRepo;
import com.ben.pofs.pofs.dao.ProductDao;


@RequestMapping(path="/products")
@RestController
@CrossOrigin // i added this for allow not secure request in forontend
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @PostMapping("add-product")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {

        return this.productDao.addProduct(product);

    }
    @PostMapping("update-product")
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {

        return this.productDao.uptateProduct(product);

    }
    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam Integer productId) {
        this.productDao.deleteProduct(productId);

        return"succes";
    }

    @GetMapping("/get-by-barcode")
    public List<ProductEntity> getProductByBarcode(@RequestParam String barcode) { // i added list ti resolve error 500 with redendent result

        return this.productDao.getProductBybarecode(barcode);
    }
     @GetMapping("/get-by-name") // work
    public ProductEntity getProductByName(@RequestParam String productName) {

        return this.productDao.getProductByName(productName);
    }

 
    @GetMapping("/get-by-ProductId")
    public ProductEntity getProductById(@RequestParam Integer productId) {

        return this.productDao.getProductById(productId);
    }

    @GetMapping("/get-by-AllProducts")
    public List<ProductEntity> getAllProducts() {

        return this.productDao.getAllProducts();
    }

  
}
