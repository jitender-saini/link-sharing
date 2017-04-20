package com.ttn.collection

class Stack {
    def list=[]

    void push(def element){
        list.add(element)
    }
    def pop(){
        list.pop()
    }
    def top(){
        list.last()
    }

    static void main(String[] args) {

        Stack stack = new Stack()
        stack.push(10)
        stack.push("wer")
        stack.push("3434")
        stack.push('sdfs')
        stack.push(42.2)
        stack.push(5l)

        println stack.list

        println stack.pop()
        println stack.list
        println stack.top()
    }
}
