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

	/**
	 * 	@fn		public ModelAndView send(@RequestParam(value="schoolfood",required=false)String[] schoolfood,
	 *						 			 @RequestParam(value="chicken",required=false)String[] chicken,
	 *						 			 @RequestParam(value="pizza",required=false)String[] pizza,
	 *						 			 @RequestParam("address")String address,
	 *						 			 ModelAndView mav)
	 *	@brief	shoolfood, chicken, pizza 값을 받아 선택한 음식을 저장하고 address 값을 받아 입력한 주소 값을 저장하며 가격을 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-06-20
	 *
	 *	@param	String[] schoolfood     HTML에서 선택된 값 저장
	 *			String[] chicken		HTML에서 선택된 값 저장
	 *			String[] pizza			HTML에서 선택된 값 저장
	 *			String address			HTML에서 입력받은 문자열 저장
	 *			ModelAndView mav 		ModelAndView 변수
	 *
	 *	@remark	선택된 음식을 출력하기 위해 food 선언
	 *			가격을 계산하기 위해 price 선언
	 *			배달비기 포함된 가격을 계산하기 위해 totalprice 선언       [2019-05-20; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="schoolfood",required=false)String[] schoolfood,
							 @RequestParam(value="chicken",required=false)String[] chicken,
							 @RequestParam(value="pizza",required=false)String[] pizza,
							 @RequestParam("address")String address,
							 ModelAndView mav){

		String food = "";
		int price = 0;
		int totalprice = 0;
		
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
			price = 15000 * chicken.length;
		} catch (NullPointerException e) {
			food += "";
		}
		
		try {
			food += pizza[0];
			for (int i=1; i<pizza.length; i++) {
				food+=", " + pizza[i];
			}
			price = 12000 * pizza.length;
		} catch (NullPointerException e) {
			food += "";
		}
		
		if(price<10000) {
			mav.addObject("alert", "최소 주문 금액은 10000원입니다");
		} else {
			if(price<20000) {
				totalprice = price+2500;
			} else {
				totalprice = price;
			}
			mav.addObject("timealert", "30분 이상 소요됩니다.");
			mav.addObject("food", food);
			mav.addObject("totalprice", totalprice);
			mav.addObject("address", address);
		}
		
		
		mav.setViewName("index");
		return mav;
		
	}
	
}

