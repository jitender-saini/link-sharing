const fileSystem = require('fs');
let content;
try {
content = fileSystem.readFileSync('./calculateAge.js');
} catch (ex) {
  console.log(ex)
}
console.log(content.toString().split('\n').length - 1);
