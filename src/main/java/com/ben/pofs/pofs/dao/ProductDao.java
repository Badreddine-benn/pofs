package com.ben.pofs.pofs.dao;
//import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ben.pofs.pofs.entity.ProductEntity;
import com.ben.pofs.pofs.repository.ProductRepo;
//import com.ben.pofs.pofs.repository.ProductNameRepo;
@Service

public class ProductDao {

    @Autowired
    private ProductRepo productRepo;




    public ProductEntity addProduct(ProductEntity product) {

        return this.productRepo.save(product);
    }

    public ProductEntity uptateProduct(ProductEntity product) {

        return this.productRepo.save(product);
    }

    public void deleteProduct(Integer productId) {
        this.productRepo.deleteById(productId);
    } 

 
    public  List<ProductEntity> getProductBybarecode(String barecod) { // i added list ti resolve error 500 with redendent result

        return this.productRepo.findByBarcode(barecod);

     
    }
        public ProductEntity getProductByName(String productName) {

          return  this.productRepo.findByProductName(productName);
       /*  Optional<ProductEntity> o = Optional.ofNullable(this.productRepo.findByProduct_name(product_name)); // i change findByBarcode by findAllByBarcode but even this the result it same in postman ...
        return o.isPresent()?o.get():null; */

    } 
   

    public ProductEntity getProductById(Integer productId) {
        return this.productRepo.findById(productId)
        .orElse(null); 
        /*Optional<ProductEntity> o = this.productRepo.findById(product_id);
        return o.isPresent()?o.get():null;*/
    }

    public List<ProductEntity> getAllProducts(){

        return this.productRepo.findAll();
    }

   

    

}

