const express = require('express');
const path = require('path');
const app = express();
const port = process.env.PORT || 3000;

app.use(express.static('dist'));
app.use(express.static(path.join(__dirname, 'src/main/resources/static')));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'src/main/resources/templates/dashboard.html'));
});

app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'src/main/resources/templates/dashboard.html'));
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
