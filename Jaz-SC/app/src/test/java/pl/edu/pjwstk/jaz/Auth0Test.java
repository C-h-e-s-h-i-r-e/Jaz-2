package pl.edu.pjwstk.jaz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@IntegrationTest
public class Auth0Test {

    @Test
    public void should_give_ok(){
        var response = given()
                .get("/api/auth0/")
                .then()
                .statusCode(200);
    }

}
