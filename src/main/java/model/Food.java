package model;

public class Food {
	String idFood, name, description, image;
	float price;
	public String getIdFood() {
		return idFood;
	}
	public void setIdFood(String idFood) {
		this.idFood = idFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Food(String idFood, String name, String description, String image, float price) {
		super();
		this.idFood = idFood;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", price=" + price + "]";
	}
	
	
	
	
}
