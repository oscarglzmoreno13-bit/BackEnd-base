package com.mx.forty.media.iacore.provider.impl;

import com.mx.forty.media.iacore.AIRequest;
import com.mx.forty.media.iacore.AIResponse;
import com.mx.forty.media.iacore.provider.IAProvider;

public class OpenIa implements IAProvider {

	private  String providerName = "OpenIA";
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String getProviderName() {
		// TODO Auto-generated method stub
		return providerName;
	}

	@Override
	public Boolean isAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	public AIResponse analyze() {
		return null;
	}

	@Override
	public AIResponse analyze(AIRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
