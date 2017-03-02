/* 

console.log("hello friends");
name="jay";
function callMe(){
	console.log(this.name);
	}
callMe();



	var http = require('http');
	const PORT = 3000;
	var server = http.createServer(function (req, res) {
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.end('Hello World');
		});

		//Lets start our server
	server.listen(PORT, function(){
   		//Callback triggered when server is successfully listening.
   	console.log("Server listening on: http://localhost:%s", PORT);
	});
*/
function getMinutes(milliseconds){
var min;
min = Math.round(milliseconds / 60);
return min;
}
module.exports.getMinutes=getMinutes;
