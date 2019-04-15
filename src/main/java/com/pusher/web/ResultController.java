package com.pusher.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pusher.constants.GeneralConstants;
import com.pusher.constants.PusherConstants;

/**
 * Controller that serves the initial page
 */
@Controller
public class ResultController {

	/**
	 * Method that sets up and serves the initial page of the app
	 * @param model Object from Spring MVC
	 * @return ModelAndView object
	 */
  @RequestMapping(method=RequestMethod.GET, value="/result")
  public ModelAndView result(Model model) {
	  ModelAndView modelAndView = new ModelAndView();

	  modelAndView.setViewName("result");
	  modelAndView.addObject("pusher_app_key", PusherConstants.PUSHER_APP_KEY);
	  modelAndView.addObject("pusher_channel", PusherConstants.CHANNEL_NAME);

    return modelAndView;
  }
}
