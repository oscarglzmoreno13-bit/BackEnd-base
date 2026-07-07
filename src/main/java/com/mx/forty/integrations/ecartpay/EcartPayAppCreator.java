package com.mx.forty.integrations.ecartpay;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EcartPayAppCreator {

    private static final String CREATE_APP_URL = "https://sandbox.ecartpay.com/api/oauth/applications";
    private static final String TOKEN_URL = "https://sandbox.ecartpay.com/api/authorizations/token";

    private final OkHttpClient client = new OkHttpClient();
    private static String publicKey ="pub6a321c67aafc167caa5f68b2";
    private static String privateKey = "priv6a321c67aafc167caa5f68b3";

    public String generateToken() throws Exception {
        String base64Credentials = Base64.getEncoder().encodeToString((publicKey + ":" + privateKey).getBytes());

        RequestBody body = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic " + base64Credentials)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);
            String token = root.path("access_token").asText();
            System.out.println("🔑 access_token: " + token);
            return token;
        }
    }

    public void createApplication(String accessToken) throws IOException {
        String jsonBody = "{"
                + "\"name\": \"IOSOI APP\","
                + "\"description\": \"Integración con EcartPay\","
                + "\"logo_url\": \"https://iosoi.mx/cdn/shop/files/Recurso_1iosoi.svg?v=1778189161&width=100\","
                + "\"redirect_url\": \"https://iosoi.mx/pages/contact\","
                + "\"scopes\": [\"read_orders\", \"write_orders\"],"
                + "\"onboarding\": {"
                + "   \"headline\": \"Conecta tu aplicación con EcartPay\","
                + "   \"permissions_summary\": [\"Ver y crear órdenes\"]"
                + "}"
                + "}";

        RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(CREATE_APP_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + accessToken)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            System.out.println("📥 Respuesta: " + jsonResponse);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            System.out.println("✅ client_id: " + root.path("client_id").asText());
            System.out.println("✅ client_secret: " + root.path("client_secret").asText());
        }
    }

    public static void main(String[] args) {
        EcartPayAppCreator creator = new EcartPayAppCreator();
        try {
            String token = creator.generateToken(); // Paso 1
            creator.createApplication(token);       // Paso 2
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
