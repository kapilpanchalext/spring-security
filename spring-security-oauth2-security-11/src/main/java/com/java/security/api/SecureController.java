package com.java.security.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

	@GetMapping(path = "/secure")
	public String securePage() {
		return "secure.html";
	}
}
