package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calcii")
public class ControllerClass {
	
	private final CalculatorService calciService;
	
	@Autowired
	public ControllerClass(CalculatorService calciService) {
		this.calciService = calciService;
	}


	@RequestMapping("/")
	public String home() {
		return "homepage";
	}
	
	
	@PostMapping("/calculate")
	public String result(@RequestParam("num1") double n1, @RequestParam("num2") double n2, @RequestParam("operation") String operation, Model mod) {
		
		double result = 0;

        switch (operation) {
            case "add":
                result = calciService.addition(n1, n2);
                break;
            case "sub":
                result = calciService.subtraction(n1, n2);
                break;
            case "mul":
                result = calciService.multiplication(n1, n2);
                break;
            case "div":
                if (n2 != 0) {
                    result = calciService.divison(n1, n2);
                } else {
                    mod.addAttribute("result", "Division by zero is not allowed.");
                    mod.addAttribute("operation",operation);
                    return "resultpage";
                }
                break;
            default:
                mod.addAttribute("error", "Invalid operation.");
                return "result";
        }
        
        mod.addAttribute("result", result);
        mod.addAttribute("operation",operation);
        
		return "resultpage";
	}

}
