package com.example.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

	@GetMapping("/calculate")  // обработка операций вычислений
	public String calculate(
			@RequestParam(value = "operation", defaultValue = "add") String operation,
			@RequestParam(value = "a") double a,
			@RequestParam(value = "b") double b) {

		double result = 0.0;

		// выполнение операции в зависимости от переданного значения параметра operation
		switch (operation) {
			case "add":
				result = a + b;// сложение
				break;
			case "multiply":
				result = a * b;// умножение
				break;
			case "divide":
				if (b != 0) {
					result = a / b;// деление
				} else {
					return "Ошибка: Не удается разделить на ноль!";
				}
				break;
			default:
				return "Недопустимая операция";
		}

		return String.format("Result of %s: %.2f", operation, result);
	}
}
