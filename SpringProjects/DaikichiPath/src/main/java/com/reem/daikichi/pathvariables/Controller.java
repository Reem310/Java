package com.reem.daikichi.pathvariables;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/daikichi")
public class Controller {
    @RequestMapping("")
    public String welcome() {
            return "Welcome!";
    }
    @RequestMapping("/today")
    public String today() {
            return "Today you will find luck in all your endeavors!";
    }
    @RequestMapping("/tomorrow")
    public String tomorrow() {
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    @RequestMapping("/travel/{city}")
    public String travel(@PathVariable("city") String city) {
    	return "Congratulations! You will soon travel to " + city + "!";
    }
    @RequestMapping("/lotto/{num}")
    public String lotto(@PathVariable("num") String num) {
    	if(Integer.parseInt(num)%2==0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers";
    	}else {
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
    	}
    }
}
