package tv.codely.mooc.api.Ui.Api.Controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.api.ApiTestCase;

public class CoursesPutControllerShould extends ApiTestCase {
    @Test
    public void create_a_valid_non_existing_course() throws Exception {
        var newCourseJsonBody = new JSONObject()
            .put("name", "The best course")
            .put("duration", "5 hours")
            .toString();

        whenPutRequestSentTo("/courses/0def00e9-b7b0-4d2b-ba98-721a1f6acf8a", newCourseJsonBody);

        assertEmptyJsonResponse(201);
    }
}
