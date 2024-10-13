package SpringBootDemo.first.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FunRestController {
	@GetMapping("/")
	public String sayHello() {
		return "HelloWorld";
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run";
	}

	@GetMapping("/sport")
	public String favSport() {
		return "Cricket";
	}
	
}
