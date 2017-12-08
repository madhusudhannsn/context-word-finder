package com.focus.word;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FocusWordController {
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces="application/json")
	public Response findFocusWord(@RequestParam(value = "question") String question) {
		Response response = new Response();
		String focusWord = null;
		try {
			if(question == null || question == "") {
				throw new Exception("Invalid Request");
			}
			System.out.println("User Question : "+question);
			StanfordParser.initialize();
			FocusWordFinder.initialize();
			// Validate the request
			focusWord = FocusWordFinder.findFocusWord(question);
			System.out.println("Focous Word : "+focusWord);
			response.setError(false);
			response.setFocusWord(focusWord);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setError(true);
		}
		System.out.println("Response : "+response);
		return response;
	}
}
	