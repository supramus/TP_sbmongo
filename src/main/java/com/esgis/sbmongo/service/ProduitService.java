package com.esgis.sbmongo.service;

import com.esgis.sbmongo.model.Categorie;
import com.esgis.sbmongo.model.Produit;
import java.util.List;
import java.util.Optional;

public interface ProduitService {
    public Produit saveProduit(Produit p);

    public Optional<Produit> findById(String id);

    public List<Produit> findAll();

    public void deleteProduit(String id);

}
