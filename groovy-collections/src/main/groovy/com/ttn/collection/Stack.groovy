package com.ttn.collection

class Stack {
    def list=[]

    void push(element){
        list.push(element)
//        list.add(element)

    }
    def pop(){
        if(list.size()>0)
        list.pop()
        else  throw new NoSuchElementException("Underflow Exception")
//        list.remove(list.size()-1)
//        list.remove(list.indexOf(list.last()))
    }
    def top(){
        list.last()
    }

    static void main(String[] args) {

        Stack stack = new Stack()
        stack.push(10)
        stack.push("Hello")
        stack.push("332")
        stack.push('Friends')
        stack.push(42.2)
        stack.push(5l)

        println stack.list

        println "Poping element from stack : " +stack.pop()
        println stack.list
        println "Top element of the list is : "+stack.top()
        println "Poping element from stack : " +stack.pop()
        println "Poping element from stack : " +stack.pop()
        println "Poping element from stack : " +stack.pop()
        println "Poping element from stack : " +stack.pop()
        println "Poping element from stack : " +stack.pop()
        println "Poping element from stack : " +stack.pop()

    }
}
