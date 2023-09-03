package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;

@RestController
public class FileController {
	
	private String fileName = "recipes.txt";
	
	@Autowired
	private Recipe recipe;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree() throws IOException {
    	List<Recipe> recipes = fileService.readFile(fileName);
    	List<Recipe> glutenFree = recipes.stream()
    		   .filter(recipe -> (recipe.getGlutenFree()).equals(true))
    		   .collect(Collectors.toList());
		
		return glutenFree;
	}
	
	@GetMapping("/vegan")
    public List<Recipe> vegan() throws IOException {
		List<Recipe> recipes = fileService.readFile(fileName);
		List<Recipe> vegan = recipes.stream()
				.filter(recipe -> (recipe.getVegan()).equals(true))
				.collect(Collectors.toList());
		
        return vegan;	
    }
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() throws IOException {
		List<Recipe> recipes = fileService.readFile(fileName);
		List<Recipe> veganAndGlutenFree = recipes.stream()
				.filter(recipe -> (recipe.getGlutenFree()).equals(true))
				.filter(recipe -> (recipe.getVegan()).equals(true))
				.collect(Collectors.toList());
		
        return veganAndGlutenFree;	
    }
	
    @GetMapping("/vegetarian")
    public List<Recipe> vegetarian() throws IOException {
    	List<Recipe> recipes = fileService.readFile(fileName);
        List<Recipe> vegetarian = recipes.stream()
				.filter(recipe -> (recipe.getVegetarian()).equals(true))
				.collect(Collectors.toList());
		
        return vegetarian;
    }
    
    @GetMapping("/all-recipes")
    public List<Recipe> allRecipes() throws IOException {
    	List<Recipe> recipes = fileService.readFile(fileName);
    	System.out.println(recipes);
        return recipes;
    }
	
  
	

}
