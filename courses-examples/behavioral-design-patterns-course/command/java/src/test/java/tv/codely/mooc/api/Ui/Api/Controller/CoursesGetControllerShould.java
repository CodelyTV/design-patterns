package tv.codely.mooc.api.Ui.Api.Controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.api.ApiTestCase;

public class CoursesGetControllerShould extends ApiTestCase {
    @Test
    public void create_a_valid_non_existing_course() throws Exception {
        var courseData = new JSONObject()
            .put("name", "The best course")
            .put("duration", "5 hours");
        givenACourseExistWith(courseData);

        whenGetRequestSentTo("/courses/0def00e9-b7b0-4d2b-ba98-721a1f6acf8a");

        assertSuccessJsonResponse(courseData);
    }

    private void givenACourseExistWith(JSONObject courseData) throws Exception {
        whenPutRequestSentTo("/courses/0def00e9-b7b0-4d2b-ba98-721a1f6acf8a", courseData.toString());
    }
}
