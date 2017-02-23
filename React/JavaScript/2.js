var myObject = {
    foo: "bar",
    func: function() {
      var self = this;
      console.log("outer func: this.foo = " + this.foo);
      console.log("outer func: self.foo = " + self.foo);
      (function() {
        console.log("inner func: this.foo = " + this.foo);
        console.log("inner func: self.foo = " + self.foo);
      }());
    }
  };


//output
myObject.func();
VM48:5 outer func: this.foo = bar
VM48:6 outer func: self.foo = bar
VM48:8 inner func: this.foo = undefined //in object closer property dont work soo this.foo is undefined in this
VM48:9 inner func: self.foo = bar
