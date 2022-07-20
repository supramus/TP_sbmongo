package com.esgis.sbmongo.controller;

import com.esgis.sbmongo.model.Categorie;
import com.esgis.sbmongo.model.Produit;
import com.esgis.sbmongo.service.CategorieService;
import com.esgis.sbmongo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/create")
    public ResponseEntity<Produit> createCateg(@RequestBody Produit p) {
        try {
            Produit prod = produitService.saveProduit(p);
            return  new ResponseEntity<>(prod, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAll() {
        try {
            List<Produit> produits = produitService.findAll();
            if(produits.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produits, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
