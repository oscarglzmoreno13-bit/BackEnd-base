package com.mx.forty.media.youtuve.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.forty.dto.vo.media.google.GoogleTrendsResponse;
import com.mx.forty.media.youtuve.service.SerpApiServices;
import com.mx.forty.util.Constantes;

@Service
public class SerpApiServiceImpl implements SerpApiServices {

	@Override
	public GoogleTrendsResponse getGoogleTrends() throws Exception {
		RestTemplate restTemplate = new RestTemplate(); 
        String url = "https://serpapi.com/search.json?engine=google_trends_trending_now&geo=MX&api_key=" + Constantes.SERP_API_KEY;

        
        String json = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        GoogleTrendsResponse response = mapper.readValue(json, GoogleTrendsResponse.class);
        return  response;
	}

}
