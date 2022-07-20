package com.esgis.sbmongo.controller;


import com.esgis.sbmongo.model.Categorie;
import com.esgis.sbmongo.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categoryService;

    @GetMapping("/create")
    public ResponseEntity<Categorie> createCateg(@RequestBody Categorie c) {
        try {
            Categorie categ = categoryService.saveCategorie(c);
                    return  new ResponseEntity<>(categ, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categorie>> getAll() {
        try {
            List<Categorie> categories = categoryService.findAll();
            if(categories.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
