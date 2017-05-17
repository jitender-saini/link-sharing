class customeMap {
  constructor() {
    this.map = {};
    this.size = 0;
  }

  function put(key,value){
    map[key]=value;
  }
  function remove(key){
    delete map[key];
  }




  get size() {
    return this.calcSize();
  }

  function sortObject(obj) {
    var arr = [];
    for (var prop in obj) {
        if (obj.hasOwnProperty(prop)) {
            arr.push({
                'key': prop,
                'value': obj[prop]
            });
        }
    }
    //arr.sort(function(a, b) { return a.value - b.value; }); for Numbers
    arr.sort(function(a, b) { return a.value.toLowerCase().localeCompare(b.value.toLowerCase()); }); //for strings
    return arr;
    //var list = {a:"d",b:"aa",c:"rt",d:"sdsd",e:"ac"};
    //var list = {a:44,b:12,c:166,d:786,e:234};
    // var arr = sortObject(list);
    // console.log(arr);
}

function toObject(arr) {
  var rv = {};
  for (var i = 0; i < arr.length; ++i)
    rv[i] = arr[i];
  return rv;
}
}
