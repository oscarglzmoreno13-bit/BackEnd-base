package com.mx.forty.media.youtuve.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.forty.dto.vo.media.youtube.VideoResponse;
import com.mx.forty.media.youtuve.service.YouTubeService;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeRestController {
	@Autowired
	private YouTubeService YouTubeService;

    @GetMapping("/trending")
    public VideoResponse trending() throws Exception {
        return YouTubeService.getTrendingVideos();
    }
}
