package com.codingdojo.pokebooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.pokebooks.models.Pbook;

import com.codingdojo.pokebooks.services.PbookService;

@RestController

public class PbooksApi {
	
    private final PbookService bookService;
    
    public PbooksApi(PbookService bookService){
    	
        this.bookService = bookService;
        
    }
    
    
    @RequestMapping("/api/pbooks")
    
    public List<Pbook> index() {
    	
        return bookService.allBooks();
        
    }
    
    @RequestMapping(value="/api/pbooks", method=RequestMethod.POST)
    
    public Pbook create(@RequestParam(value="name") String name, @RequestParam(value="description") String desc, @RequestParam(value="vendor") String ven, @RequestParam(value="amount") double numOfAmount) {
    	
    	Pbook book = new Pbook(name, desc, ven, numOfAmount);
        
        return bookService.createBook(book);
        
    }
    
    @RequestMapping("/api/pbooks/{id}")
    
    public Pbook show(@PathVariable("id") Long id) {
    	
        Pbook book = bookService.findBook(id);
        
        return book;
        
    }
    
    // other methods removed for brevity
    
    @RequestMapping(value="/api/pbooks/{id}", method=RequestMethod.PUT)
    
    public Pbook update(
    		
    		@PathVariable("id") Long id, 
    		
    		@RequestParam(value="name") String name, 
    		
    		@RequestParam(value="description") String desc, 
    		
    		@RequestParam(value="vendor") String ven,
    		
    		@RequestParam(value="amount") double numOfAmount) {
    	
        Pbook book = bookService.updateBook(id, name, desc, ven, numOfAmount);
        
        return book;
    }
    
    @RequestMapping(value="/api/pbooks/{id}", method=RequestMethod.DELETE)
    
    public void destroy(@PathVariable("id") Long id) {
    	
        bookService.deleteBook(id);
    }
}
