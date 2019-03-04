package lucacipaul.mealplus;

import java.util.*;

public class Recipe extends Items {

	private Food foodProduct;
	private ArrayList<String> ingredients;
	private String tutorial;

	public ArrayList<String> getIngredients() {
		return this.ingredients;
	}

	/**
	 * 
	 * @param ingredients
	 */
	public void setIngredients(ArrayList<String> ingredients) {
		// TODO - implement Recipe.setIngredients
		throw new UnsupportedOperationException();
	}

	public String getTutorial() {
		return this.tutorial;
	}

	/**
	 * 
	 * @param tutorial
	 */
	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}

	/**
	 * 
	 * @param food
	 */
	public void setFoodProduct(Food food) {
		this.foodProduct = food;
	}

	public Food getFoodProduct() {
		return this.foodProduct;
	}

}