package user;

import java.net.URI;

import org.oshopadma.customer.model.User;
import org.springframework.web.client.RestTemplate;

public class UserAPITest {

		
		private static final String REST_SERVICE_API = "http://localhost:8080/oshopadma/service/user";
		
	private static void registerUser() {
		System.out.println("testing registering user..........");
		RestTemplate restTmplt = new RestTemplate();
		User user = new User("permi@gmail.com", "abc12345");
		URI uri = restTmplt.postForLocation(REST_SERVICE_API+"/register/", user, User.class);
		System.out.println("Location : "+uri.toASCIIString());
	}

	public static void main(String[] args) {
		registerUser();
	}
}
