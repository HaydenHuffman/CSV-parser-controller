package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;

@Service
public class FileService {
	private String fileName;

	public FileService() {
	}
	
	public FileService(String fileName) {
		this.fileName = fileName;
	}
	
	
	public List<Recipe> readFile(String file) throws IOException {
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',').withEscape('\\').withHeader().withIgnoreSurroundingSpaces().parse(in);
		
		for (CSVRecord record : records) {
			Recipe recipe = new Recipe();
			
		    Integer cookingMinutes  = Integer.parseInt(record.get(0));
		    Boolean dairyFree = Boolean.parseBoolean(record.get(1));
		    Boolean glutenFree = Boolean.parseBoolean(record.get(2));
		    String instructions = record.get(3);
		    Double preparationMinutes = Double.parseDouble(record.get(4));
		    Double pricePerServing = Double.parseDouble(record.get(5));
		    Integer readyInMinute = Integer.parseInt(record.get(6));
		    Integer servings = Integer.parseInt(record.get(7));
		    Double spoonacularScore = Double.parseDouble(record.get(8));
		    String title = record.get(9);
		    Boolean vegan = Boolean.parseBoolean(record.get(10));
		    Boolean vegetarian = Boolean.parseBoolean(record.get(11));
		    
		    recipe.setCookingMinutes(cookingMinutes);
		    recipe.setDairyFree(dairyFree);
		    recipe.setGlutenFree(glutenFree);
		    recipe.setInstructions(instructions);
		    recipe.setPreparationMinutes(preparationMinutes);
		    recipe.setPricePerServing(pricePerServing);
		    recipe.setReadyInMinutes(readyInMinute);
		    recipe.setServings(servings);
		    recipe.setSpoonacularScore(spoonacularScore);
		    recipe.setTitle(title);
		    recipe.setVegan(vegan);
		    recipe.setVegetarian(vegetarian);
		    
		    recipes.add(recipe);
		    }
		return recipes;
	}
}
		   
	

