package com.codingdojo.pokebooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.codingdojo.pokebooks.models.Pbook;

import com.codingdojo.pokebooks.services.PbookService;

// ... imports removed for brevity

@Controller

public class PbookController {
	
	private PbookService bookService;
    
    public PbookController(PbookService bookService) {
    	
        this.bookService = bookService;
    }
    
    
    @RequestMapping("/")
    
    public String in() {
    	
    	return "redirect:/expenses";
    }
    
    // Shows all books
    
    @RequestMapping("/expenses")
    
    public String index(Model model) {
    	
        List<Pbook> books = bookService.allBooks();
        
        model.addAttribute("pbooks", books);
        
        return "index.jsp";
    }
    
    // Shows One Book
    
    @RequestMapping("/showbook/{id}")
    
    public String findBook(@PathVariable("id") Long id, Model model) {
    	
    	model.addAttribute("pbooks", bookService.findBook(id));
    	
    	return "show.jsp";
    	
    }
	
	
	
    // other methods removed for brevity
    
    @RequestMapping("/new")
    
    public String newBook(@ModelAttribute("pbook") Pbook book) {
    	
        return "new.jsp";
        
    }
    
    // Shows Errors Or Creates New Book
    
    @RequestMapping(value="/pbooks", method=RequestMethod.POST)
    
    public String create(@Valid @ModelAttribute("pbook") Pbook book, BindingResult result) {
    	
        if (result.hasErrors()) {
        	
            return "new.jsp";
            
        } 
        
        else {
        	
//            PbookService bookService = new PbookService(null);
            
			bookService.createBook(book);
           
            return "redirect:/";
            
        }
        
        }
    
    
    @RequestMapping("/edit/{id}")
    
    public String edit(@PathVariable("id") Long id, Model model) {
    	
    
    
        Pbook pbook = bookService.findBook(id);
        
        model.addAttribute("pbook", pbook);
        
        return "edit.jsp";
    }
    
    
    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    
    public String update(@Valid @ModelAttribute("pbook") Pbook pbook, BindingResult result){
        
    	if (result.hasErrors()) {
    		
    	return "edit.jsp";
    		
    	}
    	
         else {
    			
            bookService.updateBook(pbook);
            
            return "redirect:/";
            }
    		}
    
    
    
    
    
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    
    public String destroy(@PathVariable("id") Long id) {
    	
        bookService.deleteBook(id);
        
        return "redirect:/";
    }
    
   
}