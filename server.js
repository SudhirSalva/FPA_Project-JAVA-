const express = require("express");
const mysql = require("mysql2");
const bodyParser = require("body-parser");
const cors = require("cors");
require("dotenv").config(); // Load environment variables

const app = express();
const PORT = 3000;

app.use(cors()); // Enable CORS
app.use(bodyParser.json());

// MySQL Connection (Using Environment Variables)
const db = mysql.createConnection({
  host: process.env.DB_HOST || "localhost",
  user: process.env.DB_USER || "root",
  password: process.env.DB_PASSWORD || "1234",
  database: process.env.DB_NAME || "fpa",
});

db.connect((err) => {
  if (err) {
    console.error("Database connection failed:", err.message);
    process.exit(1);
  } else {
    console.log("Connected to MySQL database!");
  }
});

// Test Route
app.get("/", (req, res) => {
  res.send("Server is running!");
});

// Fetch all records from the contributions table
app.get("/records", (req, res) => {
  db.query("SELECT * FROM contributions", (err, results) => {
    if (err) {
      return res.status(500).json({ error: "Database query failed" });
    }
    res.json(results);
  });
});

// Start Server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
