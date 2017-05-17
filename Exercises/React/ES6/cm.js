class cusMap{
 // let element;
   constructor(){
   this.arr= new Array();

       this.count=0;
   }
   setA(key,value){
       var temp=0;
       for(let data of this.arr){
           if((data[0]==key)){
               data[1]=value;
               temp=1;
           }
       }
       if(temp==0){
       let ele= new Array(key,value);
       this.arr[this.count]=ele;
       this.count++;
   }
      // console.log(ele);

   }
   getA(key){
     //  console.log(this.arr);
       var temp="";
       for(let data of this.arr){
           if(data[0]==key){
               temp=data[1];
              // console.log(data);
               }

           }
       return temp;
   }
   deleteA(key){
        for(let data of this.arr){
           if(data[0]==key){
           var index =this.arr.indexOf(data);
               console.log(index);
           }

               if (index > -1) {
           this.arr.splice(index,1);

                   this.count--;

               break;
               }

        }
   }
   size(){
      return this.count++;
   }
   clear(){
       this.arr.splice(0,this.count--);
   }
   sortA(){
       let temp= new Array();
       let c=0;
       for(let data of this.arr){
           temp[c]=data[0];
           c++;
       }
       temp.sort();

       let m1= new cusMap();
       for(let v of temp){
           m1.setA(v,this.getA(v));
       }
      return m1;
   }
}

   /*set(key,value){
       var temp={key,value};

       this.key=key;

       this.value=value;
       console.log(this.key+" "+this.value);
       console.log(temp);
   }*/

  /* addElement(element){

       this.arr[this.count] =element;
       this.count++;


       //this.arr=elements;

   }
   showElements(){
 for (let value of this.arr) {
     console.log(value.key+"  "+value.value);
}}


}
class element{
   constructor(key,value){
       this.key=key;
       this.value=value;
   }
}*/

/*let e= new element("1","Arpit");
let e2= new element("2","Arpit");
let e3= new element("3","Arpit");
console.log(e);
m.addElement(e);
m.addElement(e2);
m.addElement(e3);
m.showElements();
m.set(4,"shubham");*/

let m= new cusMap();
m.setA(4,"Sumit");
m.setA(2,"Mayank");
m.setA(1,"Shubham");

m.setA(3,"Arpit");

m.setA(5,"Jay");

console.log(m);
m.setA(4,"Sdfbh");
console.log(m);
//m.getA(5);
m.deleteA(1);
console.log("After Deletion of element with key 1=>>>> "+m.arr);
m.getA(1);
m.setA(6,"Shefali");
m.getA(4);
console.log("Size is"+m.size());

//m.clear();
m=m.sortA();
console.log("Sorted Map is=>>> "+m.arr);
let m2= new cusMap();
m2.setA("S","Shubham");
m2.setA("A","Arpit");
m2.setA("M","Mayank");
m2.setA("J","Jay");
console.log(m2);
m2=m2.sortA();
console.log(m2);
