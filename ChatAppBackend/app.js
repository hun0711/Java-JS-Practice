const express = require("express");
const mongoose = require("mongoose");
require("dotenv").config();
const cors = require("cors");
const app = express();
app.use(cors());

mongoose
  .connect(process.env.DB, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("Connected to the database");
  })
  .catch((error) => {
    console.error("Error connecting to the database:", error);
  });

module.exports = app;
