package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.ProductAlreadyExistsException;
import com.shopping.model.Product;
import com.shopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    ProductRepository productRepository;
    
    @Override
    public Product addProducts(Product product) throws ProductAlreadyExistsException{
        //product.setProductId(SequenceGeneratorService.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
       // Profile profile = restTemplate.getForObject("http://localhost:5050/profile/show"+product.getProfileId(), Profile.class);
    	  product.setProductId(sequenceGeneratorService.getSequenceNumber(Product.SEQUENCE_NAME));
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId)  {
     
        Optional<Product> productTemp = productRepository.findById(productId);
       
            Product getProduct = productRepository.findById(productId).orElse(null);
           
            return getProduct;

        }
    
    
@Override
public List<Product> getAllProductsByName(String productName) {
	
	return null;
}

    @Override
    public Product updateProducts(Product product, int productId) {
        Product pro= productRepository.findById(productId).get();
        pro.setProductType(product.getProductType());
        pro.setProductName(product.getProductName());
        pro.setCategory(product.getCategory());
        pro.setImage(product.getImage());
        pro.setPrice(product.getPrice());
        pro.setDescription(product.getDescription());
        pro.setSpecification(product.getSpecification());
        return productRepository.save(pro);
    }
    
  @Override
    public void deleteProductsById(Integer productId) {
        productRepository.deleteById(productId);

    }

//	public List<Product> getAllProductsByName(String name) {
//		
//		return 
//	}


public Product getProductById(long id) {
	// TODO Auto-generated method stub
	return null;
}

//@Override
public void deleteProductsById(Long id) {
	// TODO Auto-generated method stub
	
}

//@Override
public void deleteProductsById(int productId) {
	// TODO Auto-generated method stub
	
}

}
