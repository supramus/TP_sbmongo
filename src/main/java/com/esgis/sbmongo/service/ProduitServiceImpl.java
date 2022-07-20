package com.esgis.sbmongo.service;

import com.esgis.sbmongo.model.Categorie;
import com.esgis.sbmongo.repository.CategorieRepository;
import com.esgis.sbmongo.repository.ProduitRepository;
import com.esgis.sbmongo.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Optional<Produit> findById(String id) {
        return produitRepository.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(String id) {
        Optional<Produit> data = findById(id);
        if(data.isPresent()){
            produitRepository.deleteById(id);
        }

    }
}
