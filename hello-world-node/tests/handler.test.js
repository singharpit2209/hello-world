const test = require("node:test");
const assert = require("node:assert/strict");
const { handler } = require("../index.js");

test("handler returns hello message", async () => {
  const response = await handler();
  assert.equal(response.statusCode, 200);
  assert.match(response.body, /Node/);
});
