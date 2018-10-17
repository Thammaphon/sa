package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.repository.CategoryRepository;
import com.sut.sa.cpe.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
   

    @GetMapping("/Category")
    public Collection<Category> getCategory() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }
    // @PostMapping("/Category/addCategory/{categoryname}")
    // public Category newCategory(@PathVariable String categoryname){
    //     Category newCategory = new Category(categoryname);
    //     return categoryRepository.save(newCategory);  
    // }

    // @PutMapping("/Category/categoryname/{itemname}/{categoryname}")
    // public Category putClassName(//@PathVariable String itemname
    //         @PathVariable String categoryname) {
    //     // Category newCategory = categoryRepository.findByItemName(itemname);
    //     Category newCategory = categoryRepository.findByCategoryname(categoryname);
    //     newCategory(categoryname).setCategoryname(newCategory);
    //     return categoryRepository.save(newCategory);                               
    // }


 
}
