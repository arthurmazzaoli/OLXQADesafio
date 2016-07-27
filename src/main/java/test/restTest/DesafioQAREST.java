package test.restTest;

import org.apache.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Arthur on 26/07/2016.
 */

public class DesafioQAREST {

    public DesafioQAREST() {
        baseURI = "http://httpbin.org";
        port = 80;

    }

    @Test
    public void testPost() {

        given()
                .when()
                .post("/post")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("url", containsString("http://httpbin.org/post"));
    }

    @Test
    public void testGet() {

        given()
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("url", containsString("http://httpbin.org/get"));
    }

}


