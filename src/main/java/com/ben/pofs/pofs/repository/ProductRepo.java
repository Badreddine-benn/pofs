package com.ben.pofs.pofs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ben.pofs.pofs.entity.ProductEntity;
//import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.ListAppsOptionalParameter;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    //ProductEntity findByB(String product_name); // if i change findByBarcode by findAllByBarcode in repo,dao,and controller nothing change
   // ProductEntity findAllByBarcode(String product_name,String barcode);
   // ProductEntity findById(int product_id);// i will ask chat gpt why this line is not importent for my project (now it generate error in execution)
  // ProductEntity findByName(String product_name);// for test
//////////////////////////////////////////////////////////////////////////////////////////
 // ProductEntity findByProductName(String product_name);
  //ProductEntity findByBarcode (String barcode );
  List<ProductEntity> findByBarcode(String barcode); // i added list ti resolve error 500 with redendent result
  ProductEntity findByProductName(String productName);
}

/*package com.ben.pofs.pofs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ben.pofs.pofs.entity.ProductEntity;


public interface ProductNameRepo extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByName(String product_name);
}

 */