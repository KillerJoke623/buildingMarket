package com.auto.data.controllers;

import com.auto.data.models.Product;
import com.auto.data.repositories.CategoryRepository;
import com.auto.data.repositories.ProductRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final ProductRepository productRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository,
                              ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products/categorie/{categorieId}")
    public String getModelsByManufacturer(@PathVariable Integer categorieId) throws JSONException {


        List<Product> products;
        if (categorieId==9999){
            products = productRepository.findAll();
        } else {
            products = categoryRepository.findById(categorieId).get().getProducts();
        }
        JSONArray jsonArray = new JSONArray();
        // Create a JSON object.
        JSONObject jsonObject = new JSONObject();

        for (Product product : products) {
            jsonArray.put(
                    new JSONObject()
                            .put("product_id", product.getProduct_id())
                            .put("product_name", product.getProduct_name())
                            .put("product_description", product.getProduct_description())
                            .put("product_price", product.getProduct_price())
            );

        }



        // Add property to the JSON object.
        jsonObject.put("products", jsonArray);

        // Convert the JSON object to a string.
        String jsonString = gson.toJson(jsonArray);



        return jsonString;
    }
}
