package com.codingdojo.pokebooks.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.pokebooks.models.Pbook;

import com.codingdojo.pokebooks.repositories.PbookRepository;

@Service
public class PbookService {
	
    // adding the book repository as a dependency
	
	/*
	 * private final PbookRepository pbookRepository;
	 * 
	 * public PbookService(PbookRepository pbookRepository) {
	 * 
	 * this.pbookRepository = pbookRepository;
	 * 
	 * }
	 */
	
	@Autowired
	PbookRepository  pbookRepository;
    
    // returns all the books
    
    public List<Pbook> allBooks() {
    	
        return pbookRepository.findAll();
        
    }
    
    // creates a book
    public Pbook createBook(Pbook b) {
    	
        return pbookRepository.save(b);
        
    }
    // retrieves a book
    
    public Pbook findBook(Long id) {
    	
        Optional<Pbook> optionalBook = pbookRepository.findById(id);
        
        if(optionalBook.isPresent()) {
        	
            return optionalBook.get();
            
        } 
        
        else {
        
            return null;
        }
    }

	public Pbook updateBook(Long id, String name, String desc, String ven, double numberOfAmount) {
		
		Pbook pbooks = new Pbook (name, desc, ven , numberOfAmount);
		
		pbooks.setId(id);
		
		pbookRepository.save(pbooks);
		
		return null;
	}

	public Pbook updateBook(Pbook pbooks) {
		
		pbookRepository.save(pbooks);
		
		return null;
	}

	
	
	
	public void deleteBook(Long id) {
		pbookRepository.deleteById(id); 
		
	}
}


