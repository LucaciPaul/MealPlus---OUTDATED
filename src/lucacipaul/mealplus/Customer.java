package lucacipaul.mealplus;

import java.util.*;

public class Customer extends User {

	private Adviser adviser;
	private DietLog dietLog;
	private ArrayList<Report> reports;
	private ArrayList<Food> ownedFood;
	private ArrayList<Recipe> ownedRecipes;
	private int age;
	private float size;
	private float weight;
	private Gender gender;
	private ActivityLevel activityLevel;
	private Goal goal;
	private boolean pendingRequest;
	private float carbsPerDay;
	private float proteinsPerDay;
	private float fatsPerDay;
	private float caloriesPerDay;
	private ArrayList<DietLogEntry> dislikedItems;
	private ArrayList<DietLogEntry> frequentlyEaten;

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public float getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(float size) {
		this.size = size;
	}

	public float getWeight() {
		return this.weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Gender getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ActivityLevel getActivityLevel() {
		return this.activityLevel;
	}

	/**
	 * 
	 * @param activityLevel
	 */
	public void setActivityLevel(ActivityLevel activityLevel) {
		this.activityLevel = activityLevel;
	}

	public Goal getGoal() {
		return this.goal;
	}

	/**
	 * 
	 * @param goal
	 */
	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public boolean getPendingRequest() {
		return this.pendingRequest;
	}

	/**
	 * 
	 * @param pendingRequest
	 */
	public void setPendingRequest(boolean pendingRequest) {
		this.pendingRequest = pendingRequest;
	}

	public float getCarbsPerDay() {
		return this.carbsPerDay;
	}

	/**
	 * 
	 * @param carbsPerDay
	 */
	public void setCarbsPerDay(float carbsPerDay) {
		this.carbsPerDay = carbsPerDay;
	}

	public float getProteinsPerDay() {
		return this.proteinsPerDay;
	}

	/**
	 * 
	 * @param proteinsPerDay
	 */
	public void setProteinsPerDay(float proteinsPerDay) {
		this.proteinsPerDay = proteinsPerDay;
	}

	public float getFatsPerDay() {
		return this.fatsPerDay;
	}

	/**
	 * 
	 * @param fatsPerDay
	 */
	public void setFatsPerDay(float fatsPerDay) {
		this.fatsPerDay = fatsPerDay;
	}

	public float getCaloriesPerDay() {
		return this.caloriesPerDay;
	}

	/**
	 * 
	 * @param caloriesPerDay
	 */
	public void setCaloriesPerDay(float caloriesPerDay) {
		this.caloriesPerDay = caloriesPerDay;
	}

	public void setDefaultNutritionalValues() {
		// TODO - implement Customer.setDefaultNutritionalValues
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param adviser
	 */
	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}

	public Adviser getAdviser() {
		return this.adviser;
	}

	public ArrayList<Report> getReports() {
		return this.reports;
	}

	/**
	 * 
	 * @param report
	 */
	public void addReport(Report report) {
		// TODO - implement Customer.addReport
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dietLog
	 */
	public void setDietLog(DietLog dietLog) {
		this.dietLog = dietLog;
	}

	public DietLog getDietLog() {
		return this.dietLog;
	}

	public ArrayList<Food> getOwnedFood() {
		return this.ownedFood;
	}

	public ArrayList<Recipe> getOwnedRecipes() {
		return this.ownedRecipes;
	}

	/**
	 * 
	 * @param ownedFood
	 */
	public void submitFoodForReview(Food ownedFood) {
		// TODO - implement Customer.submitFoodForReview
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ownedRecipe
	 */
	public void submitRecipeForReview(Recipe ownedRecipe) {
		// TODO - implement Customer.submitRecipeForReview
		throw new UnsupportedOperationException();
	}

	public ArrayList<DietLogEntry> getDislikedItems() {
		return this.dislikedItems;
	}

	/**
	 * 
	 * @param dislikedFood
	 */
	public void dislikeFood(Food dislikedFood) {
		// TODO - implement Customer.dislikeFood
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param createdFood
	 */
	public void createFood(Food createdFood) {
		// TODO - implement Customer.createFood
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param createdRecipe
	 */
	public void createRecipe(Recipe createdRecipe) {
		// TODO - implement Customer.createRecipe
		throw new UnsupportedOperationException();
	}

	public ArrayList<DietLogEntry> getFrequentlyEaten() {
		return this.frequentlyEaten;
	}

	/**
	 * 
	 * @param frequentlyEaten
	 */
	public void addFrequentlyEaten(DietLogEntry frequentlyEaten) {
		// TODO - implement Customer.addFrequentlyEaten
		throw new UnsupportedOperationException();
	}

}