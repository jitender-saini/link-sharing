var calculateAge = require('./calculateAge.js');
var i=2;
//var age=calculateAge.calculate_age(11,12,1991);
var age=calculateAge.calculate_age(process.argv[i],process.argv[i+1],process.argv[i+2]);
console.log('Age of the person-: '+age);
