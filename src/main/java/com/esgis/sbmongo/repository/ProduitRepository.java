package com.esgis.sbmongo.repository;

import com.esgis.sbmongo.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, String> {
}
