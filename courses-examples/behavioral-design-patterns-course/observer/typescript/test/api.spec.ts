import request from "supertest";

import app from "../src/app";

describe("GET /api/signup", () => {
  it("should return 201", () => {
    return request(app).get("/api/signup").expect(201);
  });
});
