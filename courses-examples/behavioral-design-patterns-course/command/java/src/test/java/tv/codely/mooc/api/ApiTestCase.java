package tv.codely.mooc.api;

import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc
public abstract class ApiTestCase {

    @Autowired
    private MockMvc mockMvc;
    private ResultActions currentRequest;

    protected void assertJsonResponse(
            String endpoint,
            Integer expectedStatusCode,
            String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response)
                .andExpect(header().string("content-type", "application/json"));

    }

    protected void whenGetRequestSentTo(String endpoint) throws Exception {
        currentRequest = mockMvc.perform(get(endpoint));
    }

    protected void whenPutRequestSentTo(String endpoint, String body) throws Exception {
        currentRequest = mockMvc
            .perform(put(endpoint).content(body).contentType(APPLICATION_JSON));
    }

    protected void assertStatusCodeIs(Integer expectedStatusCode) throws Exception {
        currentRequest.andExpect(status().is(expectedStatusCode));
    }

    protected void assertContentTypeIsA(String expectedContentType) throws Exception {
        currentRequest.andExpect(header().string("content-type", expectedContentType));
    }

    protected void assertResponseIs(String expectedResponse) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        currentRequest.andExpect(response);
    }

    protected void assertSuccessJsonResponse(JSONObject json) throws Exception {
        assertJsonResponse(200, json);
    }

    protected void assertJsonResponse(int statusCode, JSONObject json) throws Exception {
        assertStatusCodeIs(statusCode);
        assertContentTypeIsA("application/json");
        assertResponseIs(json.toString());
    }

    protected void assertEmptyJsonResponse(int statusCode) throws Exception {
        assertJsonResponse(statusCode, new JSONObject());
    }
}
