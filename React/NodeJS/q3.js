const fileSystem = require('fs');
let content;
fileSystem.readFile('./calculateAge.js', function (err, content) {
    if(err) {
        return console.log(err);
    }
    console.log(content.toString().split('\n').length - 1);
});
