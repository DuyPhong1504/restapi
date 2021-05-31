package project.restapi.controllere;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FoodDAO;
import model.Food;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {
	FoodDAO dao=new FoodDAO();
	
	@GetMapping("/getall")
	public List<Food> getFood() {
		try {
			return dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
