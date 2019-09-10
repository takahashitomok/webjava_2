package jp.co.systena.tigerscave.rpgapplication.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.rpgapplication.Model.Job;
import jp.co.systena.tigerscave.rpgapplication.Model.ListForm;
import jp.co.systena.tigerscave.rpgapplication.Model.MartialArtist;
import jp.co.systena.tigerscave.rpgapplication.Model.Senshi;
import jp.co.systena.tigerscave.rpgapplication.Model.Witch;

@SpringBootApplication
@RestController
public class CommandViewController {

	@Controller
	public class CommandController {

		@Autowired
		HttpSession session;

		@RequestMapping(value = "/command", method = RequestMethod.GET)
		public ModelAndView show(ModelAndView mav) {

			ListForm characterDispData = new ListForm();

			// 戦士表示
			Senshi senshi = (Senshi) session.getAttribute(Job.SENSHI);
			if (senshi != null && senshi.getName() != null) {
				characterDispData.setName(senshi.getName());
				characterDispData.setJob(Job.SENSHI);
			}

			// 魔法使い表示
			Witch witch = (Witch) session.getAttribute(Job.WITCH);
			if (witch != null && witch.getName() != null) {
				characterDispData.setName(witch.getName());
				characterDispData.setJob(Job.WITCH);
			}

			// 武闘家表示
			MartialArtist martialArtist = (MartialArtist) session.getAttribute(Job.MARTIALARTIST);
			if (martialArtist != null && martialArtist.getName() != null) {
				characterDispData.setName(martialArtist.getName());
				characterDispData.setJob(Job.MARTIALARTIST);
			}

			mav.addObject("character", characterDispData);

			mav.setViewName("command");

			return mav;
		}

		@RequestMapping(value = "/command", method = RequestMethod.POST)
		public ModelAndView makedCharacter(ModelAndView mav, ListForm characterInput) {
			String name = characterInput.getName();
			String job = characterInput.getJob();
			String action = characterInput.getAction();

			// 職業に応じてキャラクターをセッションに保存
			switch (job) {
			case Job.SENSHI:
				Senshi senshi = new Senshi(name, action);
				session.setAttribute(Job.SENSHI, senshi);
				session.removeAttribute(Job.WITCH);
				break;
			case Job.WITCH:
				Witch witch = new Witch(name, action);
				session.setAttribute(Job.WITCH, witch);
				session.removeAttribute(Job.SENSHI);
				break;

			case Job.MARTIALARTIST:
				MartialArtist martialArtist = new MartialArtist(name, action);
				session.setAttribute(Job.MARTIALARTIST, martialArtist);
				session.removeAttribute(Job.SENSHI);
				session.removeAttribute(Job.WITCH);
				break;
			}

			return new ModelAndView("redirect:/command"); // リダイレクト
		}

	}
}
