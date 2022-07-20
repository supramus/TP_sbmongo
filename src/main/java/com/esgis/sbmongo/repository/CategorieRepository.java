package com.esgis.sbmongo.repository;

import com.esgis.sbmongo.model.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String> {
}
