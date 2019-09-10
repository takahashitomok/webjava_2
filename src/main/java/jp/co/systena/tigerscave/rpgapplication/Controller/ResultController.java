package jp.co.systena.tigerscave.rpgapplication.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.rpgapplication.Model.Job;
import jp.co.systena.tigerscave.rpgapplication.Model.MartialArtist;
import jp.co.systena.tigerscave.rpgapplication.Model.ResultForm;
import jp.co.systena.tigerscave.rpgapplication.Model.Senshi;
import jp.co.systena.tigerscave.rpgapplication.Model.Witch;

@RestController
public class ResultController {
	@Autowired
	  HttpSession session;

	  @RequestMapping(value = "/result", method = RequestMethod.GET)
	  public ModelAndView show(ModelAndView mav) {

	    Job Job = getJob();

	    ResultForm resultForm = new ResultForm();
	    if (Job.getAction().equals(jp.co.systena.tigerscave.rpgapplication.Model.Job.FIGHT)) {
	      // たかかう選択
	      resultForm.setResultString(Job.fight());
	    } else {
	      // かいふく選択
	      resultForm.setResultString(Job.recovery());
	    }
	    mav.addObject("result", resultForm);

	    mav.setViewName("Result");

	    return mav;
	  }

	  @RequestMapping(value = "/result", params = "fight", method = RequestMethod.POST)
	  public ModelAndView commandFight(ModelAndView mav) {

	    Job Job = getJob();
	    Job.setAction(jp.co.systena.tigerscave.rpgapplication.Model.Job.FIGHT);
	    if (Job instanceof Senshi) {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.SENSHI, Job);
	    } else if (Job instanceof Witch) {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.WITCH, Job);
	    } else {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.MARTIALARTIST, Job);
	    }

	    return new ModelAndView("redirect:/result"); // リダイレクト
	  }

	  @RequestMapping(value = "/result", params = "recovery", method = RequestMethod.POST)
	  public ModelAndView commandRecovery(ModelAndView mav) {

	    Job Job = getJob();
	    Job.setAction(jp.co.systena.tigerscave.rpgapplication.Model.Job.RECOVERY);
	    if (Job instanceof Senshi) {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.SENSHI, Job);
	    } else if (Job instanceof Witch) {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.WITCH, Job);
	    } else {
	      session.setAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.MARTIALARTIST, Job);
	    }

	    return new ModelAndView("redirect:/result"); // リダイレクト
	  }

	  private Job getJob() {
	    // 戦士取得
	    Job Job = (Senshi) session.getAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.SENSHI);
	    if (Job == null) {
	      // 魔法使い取得
	      Job = (Witch) session.getAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.WITCH);
	    }
	    if (Job == null) {
	      // 武闘家取得
	      Job = (MartialArtist) session.getAttribute(jp.co.systena.tigerscave.rpgapplication.Model.Job.MARTIALARTIST);
	    }

	    return Job;
	  }

	}