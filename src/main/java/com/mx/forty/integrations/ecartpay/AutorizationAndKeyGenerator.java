package com.mx.forty.integrations.ecartpay;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.forty.util.Constantes;

import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class AutorizationAndKeyGenerator {
	private static final String TOKEN_URL = "https://sandbox.ecartpay.com/api/authorizations/token";
	private static final String CREATE_APP_URL = "https://sandbox.ecartpay.com/api/oauth/applications";
    private static OkHttpClient client = new OkHttpClient();
    private static String publicKey ="pub6a321c67aafc167caa5f68b2";
    private static String privateKey = "priv6a321c67aafc167caa5f68b3";
    
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private TokenSession tokenSession;


    public AutorizationAndKeyGenerator(String clientId2, String clientSecret2) {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
	}

	public AutorizationAndKeyGenerator() {
		this.httpClient = HttpClient.newHttpClient();
		this.objectMapper = new ObjectMapper();
		// TODO Auto-generated constructor stub
	}

	public static String getPublicKey() {
		return publicKey;
	}

	public static void setPublicKey(String publicKey) {
		AutorizationAndKeyGenerator.publicKey = publicKey;
	}

	public static String getPrivateKey() {
		return privateKey;
	}

	public static void setPrivateKey(String privateKey) {
		AutorizationAndKeyGenerator.privateKey = privateKey;
	}

	//////////////////////////////
	/// 
	 public void refreshAccessToken() throws Exception {
	        String credentials = this.publicKey + ":" + this.privateKey;
	        String base64Encoded = Base64.getEncoder().encodeToString(credentials.getBytes());

	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(this.TOKEN_URL))
	                .header("Authorization", "Basic " + base64Encoded)
	                .header("Content-Type", "application/json")
	                .header("Accept", "application/json")
	                .POST(HttpRequest.BodyPublishers.noBody())
	                .build();

	        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());

	        if (response.statusCode() == 200) {
	            JsonNode jsonResponse = this.objectMapper.readTree(response.body());
	            String token = jsonResponse.get("token").asText();
	            this.tokenSession = new TokenSession(token);
	        } else {
	            throw new RuntimeException("Error de autenticación API: " + response.statusCode() + " - " + response.body());
	        }
	    }

	    // Método público que garantiza devolver un token válido antes de cada petición de negocio
	    public synchronized String getValidToken() throws Exception {
	        if (this.tokenSession == null || this.tokenSession.isExpired()) {
	            refreshAccessToken();
	        }
	        return this.tokenSession.getToken();
	    }

	    // ==========================================
	    // EJEMPLO: Método de negocio usando Bearer Token
	    // ==========================================
//	    public String crearOrden(String jsonOrdenPayload) throws Exception {
//	        // 1. Obtiene el token (se autorefresca si expiró)
//	        String bearerToken = getValidToken();
//
//	        // 2. Construye la petición para crear la orden
//	        HttpRequest request = HttpRequest.newBuilder()
//	                .uri(URI.create(this. + "/orders")) // Reemplaza por el endpoint real de órdenes
//	                .header("Authorization", "Bearer " + bearerToken) // Uso de autenticación Bearer
//	                .header("Content-Type", "application/json")
//	                .header("Accept", "application/json")
//	                .POST(HttpRequest.BodyPublishers.ofString(jsonOrdenPayload))
//	                .build();
//
//	        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//	        return response.body();
//	    }

	    // ==========================================
	    // EJEMPLO: Método de negocio usando Bearer Token
	    // ==========================================
/**	    public String crearOrden(String jsonOrdenPayload) throws Exception {
	        // 1. Obtiene el token (se autorefresca si expiró)
	        String bearerToken = getValidToken();

	        // 2. Construye la petición para crear la orden
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(this.baseUrl + "/orders")) // Reemplaza por el endpoint real de órdenes
	                .header("Authorization", "Bearer " + bearerToken) // Uso de autenticación Bearer
	                .header("Content-Type", "application/json")
	                .header("Accept", "application/json")
	                .POST(HttpRequest.BodyPublishers.ofString(jsonOrdenPayload))
	                .build();

	        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	        return response.body();
	    }
	
	///////////////////////////////////////////////////////
	
	private static String clientId = null;
    private static String clientSecret = null;
    
    public static String generateCredential() {
    	String cadena = getPublicKey()+":"+getPrivateKey();
    	String enBase64 = Base64.getEncoder().encodeToString(cadena.getBytes());
    	return enBase64;
    }

    public void AutorizationAndKeyGenerator(String clientId, String clientSecret) {
        this.client = new OkHttpClient();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
**/
    /**
     * Solicita un token de acceso usando grant_type=client_credentials
     * @return token en formato JSON
     * @throws IOException si falla la conexión
     */
//    public String requestToken() throws IOException {
//        // Construir credenciales en Basic Auth
//        String credential = Credentials.basic(clientId, clientSecret);
//
//        // Body con grant_type
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type", "client_credentials")
//                .build();
//
//        // Construir request
//        Request request = new Request.Builder()
//                .url(TOKEN_URL)
//                .post(body)
//                .addHeader("Authorization", credential)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                .build();
//
//        // Ejecutar request
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("Error en la petición: " + response.code() + " - " + response.message());
//            }
//            return response.body().string();
//        }
//    }
	    
	    public void createApplication() throws IOException {
	    	
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

//	        RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));
	        
	       try {
	    	   HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(CREATE_APP_URL)) // Reemplaza por el endpoint real de órdenes
		                .header("Authorization", "Bearer " + tokenSession.getToken()) // Uso de autenticación Bearer
		                .header("Content-Type", "application/json")
		                .header("Accept", "application/json")
		                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
		                .build();
		        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		        String jsonResponse = response.body();
	            System.out.println("📥 Respuesta: " + jsonResponse);

	            ObjectMapper mapper = new ObjectMapper();
	            JsonNode root = mapper.readTree(jsonResponse);

	            System.out.println("✅ client_id: " + root.path("client_id").asText());
	            System.out.println("✅ client_secret: " + root.path("client_secret").asText());
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }

//	        Request request = new Request.Builder()
//	                .url(CREATE_APP_URL)
//	                .post(body)
//	                .addHeader("Authorization", "Bearer " + accessToken)
//	                .addHeader("Content-Type", "application/json")
//	                .build();

//	        try (Response response = client.newCall(request).execute()) {
//	            String jsonResponse = response.body().string();
//	            System.out.println("📥 Respuesta: " + jsonResponse);
//
//	            ObjectMapper mapper = new ObjectMapper();
//	            JsonNode root = mapper.readTree(jsonResponse);
//
//	            System.out.println("✅ client_id: " + root.path("client_id").asText());
//	            System.out.println("✅ client_secret: " + root.path("client_secret").asText());
//	        }
	    }
    

    // Ejemplo de uso
    public static void main(String[] args) {
        AutorizationAndKeyGenerator aut = new AutorizationAndKeyGenerator();
        try {
			aut.getValidToken();
			aut.createApplication();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        AutorizationAndKeyGenerator authClient = new AutorizationAndKeyGenerator(clientId, clientSecret);
//        try {
//            String tokenResponse = authClient.requestToken();
//            System.out.println("Respuesta del servidor: " + tokenResponse);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
