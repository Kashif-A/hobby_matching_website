package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfilesController {
	@RequestMapping(value = "/profiles", method = RequestMethod.POST)
	@ResponseBody
	public String home() {
		return "<h1>Profiles</h1>";
    }
}
