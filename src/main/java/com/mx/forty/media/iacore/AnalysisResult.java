package com.mx.forty.media.iacore;

import java.util.List;

public class AnalysisResult {

	 private String platform;

	    private String sourceId;

	    private String emotion;

	    private String sentiment;

	    private String topic;

	    private String audience;

	    private String hook;

	    private String painPoint;

	    private String solution;

	    private String cta;

	    private Integer viralScore;

	    private List<String> keywords;

	    private String language;

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}

		public String getSourceId() {
			return sourceId;
		}

		public void setSourceId(String sourceId) {
			this.sourceId = sourceId;
		}

		public String getEmotion() {
			return emotion;
		}

		public void setEmotion(String emotion) {
			this.emotion = emotion;
		}

		public String getSentiment() {
			return sentiment;
		}

		public void setSentiment(String sentiment) {
			this.sentiment = sentiment;
		}

		public String getTopic() {
			return topic;
		}

		public void setTopic(String topic) {
			this.topic = topic;
		}

		public String getAudience() {
			return audience;
		}

		public void setAudience(String audience) {
			this.audience = audience;
		}

		public String getHook() {
			return hook;
		}

		public void setHook(String hook) {
			this.hook = hook;
		}

		public String getPainPoint() {
			return painPoint;
		}

		public void setPainPoint(String painPoint) {
			this.painPoint = painPoint;
		}

		public String getSolution() {
			return solution;
		}

		public void setSolution(String solution) {
			this.solution = solution;
		}

		public String getCta() {
			return cta;
		}

		public void setCta(String cta) {
			this.cta = cta;
		}

		public Integer getViralScore() {
			return viralScore;
		}

		public void setViralScore(Integer viralScore) {
			this.viralScore = viralScore;
		}

		public List<String> getKeywords() {
			return keywords;
		}

		public void setKeywords(List<String> keywords) {
			this.keywords = keywords;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}
}
