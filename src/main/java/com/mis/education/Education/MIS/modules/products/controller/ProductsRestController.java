package com.mis.education.Education.MIS.modules.products.controller;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.products.service.ProductService;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.ProductThumbnails.ProductThumbnailsDatatableRepository;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import com.mis.education.Education.MIS.repositories.userdatatables.UserDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductsRestController {

    @Autowired
    ProductsDatatableRepository productsDatatableRepository;

    @Autowired
    ProductThumbnailsDatatableRepository productThumbnailsDatatableRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/apidataTable/getProducts", method = RequestMethod.GET)
    public DataTablesOutput<ProductsEntity> getUsers_(@Valid DataTablesInput input) {
        return productsDatatableRepository.findAll(input);
    }

    //http://localhost:8080/api/fetchProducts?page=0&size=10
    @RequestMapping(value = "/api/fetchProducts", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPaginatedData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {
        try {
            Page<ProductsEntity> paginatedData = productService.getPaginatedData(page, size);
            long totalRecords = productService.getTotalRecords();

            Map<String, Object> response = new HashMap<>();
            response.put("data", paginatedData.getContent());
            response.put("totalRecords", totalRecords);
            response.put("currentPage", paginatedData.getNumber());
            response.put("totalPages", paginatedData.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Top Trending Products
    //http://localhost:8080/api/fetchProducts?page=0&size=10
    @RequestMapping(value = "/api/fetchProductsTrending", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPaginatedTopTrending(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<ProductsEntity> paginatedData = productService.getPaginatedData(page, size);
            long totalRecords = productService.getTotalRecords();

            Map<String, Object> response = new HashMap<>();
            response.put("data", paginatedData.getContent());
            response.put("totalRecords", totalRecords);
            response.put("currentPage", paginatedData.getNumber());
            response.put("totalPages", paginatedData.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //fetchProductsFeatured
    @RequestMapping(value = "/api/fetchProductsFeatured", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> fetchProductsFeatured(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<ProductsEntity> paginatedData = productService.getPaginatedData(page, size);
            long totalRecords = productService.getTotalRecords();

            Map<String, Object> response = new HashMap<>();
            response.put("data", paginatedData.getContent());
            response.put("totalRecords", totalRecords);
            response.put("currentPage", paginatedData.getNumber());
            response.put("totalPages", paginatedData.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //getProductById
    @RequestMapping(value = "/api/getProductById", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getProductById(@RequestParam int id) {
        try {
            ProductsEntity product = productsDatatableRepository.getProductViaId(id);
            List<ProductsThumbnail> productsThumbnail = productThumbnailsDatatableRepository.getProductThumbnailsViaId(id);
            long totalRecords = productService.getTotalRecords();

            Map<String, Object> response = new HashMap<>();
            response.put("data", product);
            response.put("productThumbnails", productsThumbnail);
//            response.put("totalRecords", totalRecords);
//            response.put("currentPage", paginatedData.getNumber());
//            response.put("totalPages", paginatedData.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //addToWishList


}