package com.mx.forty.integrations.ecartpay;

import java.time.LocalDateTime;

public class TokenSession {

	private final String token;
    private final LocalDateTime expirationTime;

    public TokenSession(String token) {
        this.token = token;
        // El token expira en 1 hora. Restamos 5 minutos como margen de seguridad.
        this.expirationTime = LocalDateTime.now().plusMinutes(55);
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationTime);
    }
}
