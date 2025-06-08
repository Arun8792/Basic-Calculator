package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CalculatorService {

	public double addition(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1 + n2;
	}

	public double subtraction(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1 - n2;
	}

	public double multiplication(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1 * n2;
	}

	public double divison(double n1, double n2) {
		if (n2 == 0) {
			throw new ArithmeticException("Division by zero is not allowed");      
		} else {
		return n1 /n2;
		}
	}

	
}
