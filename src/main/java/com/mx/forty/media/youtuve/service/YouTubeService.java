package com.mx.forty.media.youtuve.service;

import com.mx.forty.dto.vo.media.youtube.VideoResponse;

public interface YouTubeService {

	public VideoResponse getTrendingVideos() throws Exception;
}
