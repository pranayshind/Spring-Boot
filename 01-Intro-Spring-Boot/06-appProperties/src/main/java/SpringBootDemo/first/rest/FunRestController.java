package SpringBootDemo.first.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FunRestController {

	//inject properties for coach.name and team.name
	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	@GetMapping("/teamInfo")
	public String getTeamInfo() {
		return "Coach: "+ coachName + " Team name: "+teamName;
	}
	





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
