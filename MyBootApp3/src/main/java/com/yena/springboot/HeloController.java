package com.yena.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	
	/**
	 * 	@fn		public ModelAndView index(@ModelAttribute("formModel" MyData mydata,
	 * 									  ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-06-20
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-06-20; 한예나]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		
		mav.setViewName("index");
		return mav;
		
	}

	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="schoolfood",required=false)String[] schoolfood,
							 @RequestParam(value="chicken",required=false)String[] chicken,
							 @RequestParam(value="pizza",required=false)String[] pizza,
							 @RequestParam("address")String address,
							 ModelAndView mav){

		String food = "";
		int price = 0;
		
		try {
			food += schoolfood[0];
			for (int i=1; i<schoolfood.length; i++) {
				food+=", " + schoolfood[i];
			}
			price = 3000 * schoolfood.length;
		} catch (NullPointerException e) {
			food += "";
		}
		
		try {
			food += chicken[0];
			for (int i=1; i<chicken.length; i++) {
				food+=", " + chicken[i];
			}
		} catch (NullPointerException e) {
			food += "";
		}
		
		try {
			food += pizza[0];
			for (int i=1; i<pizza.length; i++) {
				food+=", " + pizza[i];
			}
		} catch (NullPointerException e) {
			food += "";
		}
		
		mav.addObject("food", food);
		mav.addObject("price", price);
		mav.addObject("address", address);
		mav.setViewName("index");
		return mav;
		
	}
	
}

