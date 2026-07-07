package com.mx.forty.media.iacore;

import java.time.LocalDateTime;
import java.util.Map;

public class AIResponse {

	    private String provider;

	    /**
	     * gpt-5.5
	     * gpt-4.1
	     * gemini-2.5-pro
	     */
	    private String model;

	    /**
	     * Texto completo que respondió la IA
	     */
	    private String content;

	    /**
	     * JSON ya convertido (si aplica)
	     */
	    private Map<String,Object> json;

	    /**
	     * Tokens utilizados
	     */
	    private Integer promptTokens;

	    private Integer completionTokens;

	    private Integer totalTokens;

	    /**
	     * Tiempo de respuesta
	     */
	    private Long responseTimeMs;

	    /**
	     * Fecha
	     */
	    private LocalDateTime createdAt;

		public String getProvider() {
			return provider;
		}

		public void setProvider(String provider) {
			this.provider = provider;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Map<String, Object> getJson() {
			return json;
		}

		public void setJson(Map<String, Object> json) {
			this.json = json;
		}

		public Integer getPromptTokens() {
			return promptTokens;
		}

		public void setPromptTokens(Integer promptTokens) {
			this.promptTokens = promptTokens;
		}

		public Integer getCompletionTokens() {
			return completionTokens;
		}

		public void setCompletionTokens(Integer completionTokens) {
			this.completionTokens = completionTokens;
		}

		public Integer getTotalTokens() {
			return totalTokens;
		}

		public void setTotalTokens(Integer totalTokens) {
			this.totalTokens = totalTokens;
		}

		public Long getResponseTimeMs() {
			return responseTimeMs;
		}

		public void setResponseTimeMs(Long responseTimeMs) {
			this.responseTimeMs = responseTimeMs;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

	    
}
