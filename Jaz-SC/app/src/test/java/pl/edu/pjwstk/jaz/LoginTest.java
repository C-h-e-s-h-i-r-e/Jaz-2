package pl.edu.pjwstk.jaz;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@IntegrationTest
public class LoginTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        given()
                .body(new RegisterRequest("s18855", "password", "aleks"))
                .when()
                .post("/api/register")
                .thenReturn();
    }

    @Test
    public void should_respond_to_readiness_request(){
        var response = given()
                .when()
                .body(new LoginRequest("s18855", "password"))
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.cookies())
                .get("/api/article/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void cool_name() {
        var response = given()
                .when()
                .body(new LoginRequest("s18855", "wrongpassword"))
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.cookies())
                .get("/api/article/1")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());

    }

}
