package com.mx.forty.media.youtuve.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.forty.dto.vo.media.youtube.VideoResponse;
import com.mx.forty.media.youtuve.service.YouTubeService;
import com.mx.forty.util.Constantes;

@Service
public class YouTubeServiceImpl implements YouTubeService {


	public VideoResponse getTrendingVideos() throws Exception {
		RestTemplate restTemplate = new RestTemplate(); 
        String url = "https://www.googleapis.com/youtube/v3/videos"
                + "?part=snippet,statistics"
                + "&chart=mostPopular"
                + "&regionCode=MX"
                + "&maxResults=10"
                + "&key=" + Constantes.YOUTUBE_API_KEY;

        
        String json = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, VideoResponse.class);
	}

}
