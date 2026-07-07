package com.mx.forty.dto.vo.media.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Snippet getSnippet() {
		return snippet;
	}
	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	private Snippet snippet;
    private Statistics statistics;
}
