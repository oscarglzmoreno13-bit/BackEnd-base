package com.mx.forty.media.youtuve.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.media.google.GoogleTrendsResponse;
import com.mx.forty.media.youtuve.service.SerpApiServices;

@RestController
@RequestMapping("/api/SerpApi")
public class SerpApiRestController {

	@Autowired
	private SerpApiServices serpApiServices;

	@GetMapping("/trending")
	public GoogleTrendsResponse getGoogleTrends() throws Exception {
		return serpApiServices.getGoogleTrends(); 
	}
 	
	
}
