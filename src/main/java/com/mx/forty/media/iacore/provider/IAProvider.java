package com.mx.forty.media.iacore.provider;

import com.mx.forty.media.iacore.AIRequest;
import com.mx.forty.media.iacore.AIResponse;

public interface IAProvider {

	 AIResponse analyze(AIRequest request);

	 String getProviderName();

	 Boolean isAvailable();
}
