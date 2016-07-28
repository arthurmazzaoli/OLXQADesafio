package test.restTest;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Arthur on 26/07/2016.
 */
@RunWith(JUnit4.class)
public class DesafioQAREST {

    @Before
    public void setup() {

        baseURI = "http://httpbin.org";
        port = 80;

    }

    @Test
    public void testPost() {

        Response response = given()
                .when()
                .post("/post");

        Headers allHeaders = response.getHeaders();

        given()
                .when()
                .post("/post")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("url", containsString("http://httpbin.org/post"));

        System.out.println(allHeaders);
        System.out.println(response.getBody().print());
        System.out.println("1 - Post realizado com sucesso!");
    }

    @Test
    public void testGet() {

        Response response = given()
                .when()
                .get("/get");

        Headers allHeaders = response.getHeaders();

        given()
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("url", containsString("http://httpbin.org/get"));

        System.out.println(allHeaders);
        System.out.println(response.getBody().print());
        System.out.println("2 - Post realizado com sucesso!");
    }

}


