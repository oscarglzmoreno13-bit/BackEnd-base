package com.mx.forty.media.youtuve.service;

import com.mx.forty.dto.vo.media.google.GoogleTrendsResponse;

public interface SerpApiServices {

	
	public GoogleTrendsResponse getGoogleTrends() throws Exception;
}
