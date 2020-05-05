package RestApi.Api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class DummyRestApiTest {


    String employeeName = "Alex";
    String employeeSalary = "100";
    String employeeAge = "20";
    String cookies = "PHPSESSID=79e490a8abdad102b11065659142ccc0; path=/" +
            "ezoadgid_133674=-1; Path=/; Domain=restapiexample.com; Expires=Mon, 04 May 2020 07:27:06 UTC" +
            "ezoref_133674=; Path=/; Domain=restapiexample.com; Expires=Mon, 04 May 2020 08:57:06 UTC" +
            "ezoab_133674=mod1; Path=/; Domain=restapiexample.com; Expires=Mon, 04 May 2020 08:57:06 UTC" +
            "active_template::133674=pub_site.1588575426; Path=/; Domain=restapiexample.com; Expires=Wed, 06 May 2020 06:57:06 UTC";



//            "PHPSESSID=b22e6b619ba2b60ddcb82dce3d7a9e4e; ezoref_133674=; ezCMPCCS=true; " +
//            "ezds=ffid%3D1%2Cw%3D2048%2Ch%3D1152; __utmc=222003227; " +
//            "__utmz=222003227.1588327565.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); " +
//            "ezoadgid_133674=-1; ezoab_133674=mod81-c; ezepvv=0; lp_133674=http://dummy.restapiexample.com/; " +
//            "_ga=GA1.2.176009073.1588327565; _gid=GA1.2.1019594218.1588340502; ezopvc_133674=1; ezovid_133674=1859917085;" +
//            " ezovuuidtime_133674=1588343037; ezovuuid_133674=2518b840-c757-48fb-4d51-550a142f1701; " +
//            "__utma=222003227.176009073.1588327565.1588340503.1588343039.3; __utmt_e=1; __utmt_f=1; ezohw=w%3D2048%2Ch%3D594; " +
//            "__utmb=222003227.4.10.1588343039; ezux_lpl_133674=1588343189415|cdb00a6a-65f0-4afb-77b2-880259c61060|true; " +
//            "active_template::133674=pub_site.1588343194";


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
    }

    @Test
    public void getAllEmployees() {
        when()
                .request("GET", "/api/v1/employees")
                .then()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", hasItems("1", "2", "3"));
    }

    @Test
    public void getAllEmployeesNegative() {
        when()
                .request("GET", "/api/v1/employee")
                .then()
                .statusCode(404);
    }

    @Test
    public void postNewEmployee() {
        PostRequestModel postRequest = new PostRequestModel(employeeName, employeeSalary, employeeAge);
        PostResponseModel postResponse = with()
                .body(postRequest.toString())
                .log()
                .all()
                .when()
                .request("Post", "/api/v1/create")
                .then()
                .log()
                .all()
//                .when()
                .statusCode(200)
                .extract()
                .as(PostResponseModel.class);
        PostResponseModel expectedPostResponse = new PostResponseModel("success", new ResponseData(employeeName, employeeSalary, employeeAge));
        assertEquals(expectedPostResponse, postResponse);
    }

    @Test
    public void postNewEmployeeNegative() {
        PostRequestModel postRequest = new PostRequestModel(employeeName, employeeSalary, employeeAge);
        when()
                .request("GET", "/api/v1/employee")
                .then()
                .statusCode(404);
        PostResponseModel expectedPostResponse = new PostResponseModel("success", new ResponseData(employeeName, employeeSalary, employeeAge));
    }


    @Test(priority = 2, description = "Update Employee with ID '4' - Positive")
    public void putUpdateEmployeeByPositiveId() {
        String employeeName2 = "Vasja";
        String employeeSalary2 = "9999";
        String employeeAge2 = "27";
        String id = "24";
        PutRequestModel putRequest = new PutRequestModel(employeeName2, employeeSalary2, employeeAge2);
        PutResponseModel putResponse = with()
                .header("Cookie", cookies)
                .body(putRequest.toString())
                .when()
                .request("PUT", "/api/v1/update/" + id)
                .then()
                .statusCode(200)
                .extract()
                .as(PutResponseModel.class);
        PutResponseModel expectedPutModel = new PutResponseModel("success", new PutResponseDataModel(employeeName2, employeeSalary2, employeeAge2));
        assertEquals(expectedPutModel, putResponse);
    }

    @Test(description = "Update Employee with False ID - Negative")
    public void putUpdateEmployeeByNegativeId() {
        String employeeName = "Vasja";
        String employeeSalary = "9999";
        String employeeAge = "27";
        String id = "657";
        PutRequestModel putRequest = new PutRequestModel(employeeName, employeeSalary, employeeAge);
        with()
//                .header("Cookie", cookies)
                .body(putRequest.toString())
                .when()
                .request("PUT", "/api/v1/update/" + id)
                .then()
                .statusCode(401);

    }

    }