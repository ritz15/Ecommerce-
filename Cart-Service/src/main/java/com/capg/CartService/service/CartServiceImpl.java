package com.capg.CartService.service;

import com.capg.CartService.exception.CartException;
import com.capg.CartService.model.Cart;
import com.capg.CartService.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl {

    static Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @Autowired
    CartRepository repository;

    
    public Cart getcartById(int cartId) throws CartException {
        logger.info("Fetching Cart b y ID inprogress...");
        Optional<Cart> cartTemp = repository.findById(cartId);
        if (cartTemp.isPresent() == false) {
            throw new CartException("CartId does not exist");
        } else {
            Cart getCart = repository.findById(cartId).orElse(null);
            logger.info("Details of Cart are: " + getCart);
            return getCart;

        }
    }

    
    
    public Cart addCart(Cart cart) throws CartException {
    	logger.info("Adding cart in progess..");
        cart.setCartId(sequenceGeneratorService.getSequenceNumber(Cart.SEQUENCE_NAME));
        Cart cartTemp= repository.save(cart);
        return cartTemp;
    }
    
    
    public Cart updateCart(int cartId, Cart cart) throws CartException {
        logger.info("update cart inprogress...");
        Optional<Cart> cartTemp = repository.findById(cartId);
        if (cartTemp.isPresent() == false) {
            throw new CartException("Cart does not exist");
        } else {
        	

        	
        	
            Cart updatecart = repository.save(cart);
            logger.info("Cart details: " + updatecart);
            return updatecart;
        }
    }

    
    public List<Cart> getallcarts() throws CartException {
        List<Cart> cartTemp = repository.findAll();
        logger.info("Fetching Carts inprogress...");
        if (cartTemp.isEmpty()) {
            throw new CartException("Cart not found");
        } else {
            List<Cart> getAllCarts = repository.findAll();
            logger.info("All Cart details : " + getAllCarts);
            return getAllCarts;
        }

    }

//    @Override
//    public double cartTotal(Cart total) {
//        return cartTotal(total);
//    }

   
}
