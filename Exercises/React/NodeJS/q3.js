const fileSystem = require('fs');
let content;
console.log("before ");
fileSystem.readFile('./calculateAge.js', function (err, content) {
    if(err) {
        return console.log(err);
    }
    console.log("after0");
    console.log(content.toString().split('\n').length - 1);
});
