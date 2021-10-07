package com.codingdojo.pokebooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.codingdojo.pokebooks.models.Pbook;


@Repository
public interface PbookRepository extends CrudRepository <Pbook, Long>{
	
    // this method retrieves all the books from the database
	
    List<Pbook> findAll();
    
    // this method finds books with descriptions containing the search string
    
    List<Pbook> findByDescriptionContaining(String search);
    
   

}
