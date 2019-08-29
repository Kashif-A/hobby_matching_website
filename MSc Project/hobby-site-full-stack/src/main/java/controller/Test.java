package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.HobbyDAO;

@Controller
public class Test {
	HobbyDAO hobbyDAO = new HobbyDAO();
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		hobbyDAO.populateHobbiesLinkedToUser(null, 9);
		/*List<Object[]> hobbies = hobbyDAO.getHobbyList();
		for(Object[] h : hobbies) {
			System.out.println(h[0].toString());
		}*/
    }
}
