package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    public ArrayList<Review> getReviews() {
        List<Review> reviewsList = reviewJpaRepository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(reviewsList);
        return reviews;
    }

    public Review getReviewById(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Review addReview(Review review) {
        Product product = review.getProduct();
        int productId = product.getProductId();

        try {
            product = productJpaRepository.findById(productId).get();
            review.setProduct(product);
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Review updateReview(int reviewId, Review review) {
        try {
            Review newReview = reviewJpaRepository.findById(reviewId).get();
            if(review.getProduct() != null) {
                int productId = review.getProduct().getProductId();
                Product newProduct = productJpaRepository.findById(productId).get();
                newReview.setProduct(newProduct);
            }
            if(review.getReviewContent()!=null){
                newReview.setReviewContent(review.getReviewContent());
            }
            if(review.getRating()!=0){
                newReview.setRating(review.getRating());
            }
            reviewJpaRepository.save(newReview);
            return newReview;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    public Product getReviewProduct(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            Product product = review.getProduct();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
