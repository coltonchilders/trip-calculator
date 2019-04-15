package com.pusher.web;

import com.pusher.constants.GeneralConstants;
import com.pusher.constants.PusherConstants;
import com.pusher.model.Traveler;
import com.pusher.rest.Pusher;
import com.pusher.web.vo.Request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Controller for the REST API used by the shopping cart
 */
@RestController
public class Controller {

	private ArrayList<Traveler> travelers = new ArrayList<Traveler>();

	private Pusher pusher;

	/**
	 * Method executed after the object is created
	 * that creates an instance of the Pusher object and
	 * populates the list of products
	 */
	@PostConstruct
	public void configure() {
		pusher = new Pusher(
				PusherConstants.PUSHER_APP_ID,
				PusherConstants.PUSHER_APP_KEY,
				PusherConstants.PUSHER_APP_SECRET
		);
		pusher.setCluster(PusherConstants.PUSHER_CLUSTER_KEY);
		pusher.setEncrypted(true);
	}

	/**
	 * Method to add a product to the shopping cart
	 * @param request Request object
	 * @return Status string
	 */
	@RequestMapping(value = "/add",
			method = RequestMethod.POST,
			consumes = "application/json")
	public String addTravelers(@RequestBody Request request) {
		System.out.println("Test - Add");
		Traveler traveler = new Traveler();

		traveler.setName(request.getName());
		traveler.setExpense(request.getExpense());

		travelers.add(traveler);

		return "OK";
	}

	/**
	 * Method to add a product to the shopping cart
	 * @param request Request object
	 * @return Status string
	 */
	@RequestMapping(value = "/get",
			method = RequestMethod.GET,
			consumes = "application/json")
	public ArrayList<Traveler> getTravelers(@RequestBody Request request) {
		System.out.println("Test - Get");
		return travelers;
	}

	/**
	 * Method to add a product to the shopping cart
	 * @param request Request object
	 * @return Status string
	 */
	@RequestMapping(value = "/calculate",
			method = RequestMethod.GET,
			consumes = "application/json")
	public String calculate(@RequestBody Request request) {
		System.out.println("Test - Calculate");
		Integer payee = 0;
		ArrayList<Traveler> payors = new ArrayList<Traveler>();
		Integer totalExpenses = 0;
		for(int i = 1; i < travelers.size(); i++) {
			if(travelers.get(i).getExpense() > travelers.get(payee).getExpense()) {
				payee = i;
			}
		}
		for(int i = 0; i < travelers.size(); i++) {
			if(i != payee) {
				payors.add(travelers.get(i));
			}
			totalExpenses += travelers.get(i).getExpense();
		}
		ArrayList<Float> payouts = new ArrayList<Float>();
		Float equalShare = new Float(totalExpenses / travelers.size());
		for(int i = 0; i < payors.size(); i++) {
			payouts.add(equalShare - payors.get(i).getExpense());
		}
		String result = "";
		for(int i = 0; i < payors.size(); i++) {
			String s = String.format("%s owes %s $%.2f.", payors.get(i).getName(), travelers.get(payee).getName(), payouts.get(i));
			result += s;
		}
		return result;
	}
}
