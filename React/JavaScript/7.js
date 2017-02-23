function test() {
    console.log(a);
    console.log(fun());
    var a = 1;
    function fun() {
        return 2;
    }
}

test();

output:

VM48:2 undefined -> in line 2 a is undefined as its value is assigned in line 4
VM48:3 2 -> it give a callback function fun()
