package jp.co.systena.tigerscave.rpgapplication.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.rpgapplication.Model.ListForm;


@SpringBootApplication
@RestController
public class Controller {

	@RequestMapping(value = "/charactermake", method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {
		ListForm listForm = new ListForm();
		mav.addObject("character", listForm);

		mav.setViewName("CharacterMake");

		return mav;
	}
}