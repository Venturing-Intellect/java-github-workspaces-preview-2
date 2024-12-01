
const express = require('express');
const cors = require('cors');
const app = express();

// ...existing code...

app.use(cors());

// ...existing code...

app.listen(5000, () => {
  console.log('Server is running on port 5000');
});