Exercise for groovy collection

1. Initialize an empty list and give the output of the following code:
   l[11] = "myelement"  ->  insert "myelement" on 11th index in the list and fill null on all index before 11th index
   println l[11]  ->  print "myelement"
   println l.get(5)  ->  print null
   println l        -> print null on 0-10 index and on 11th index print "myelement"
   Initialize a list using a range and find all elements which are even.
  
2. Create a set from a list containing duplicate elements. What do you observe? How can you achieve the same result without converting a list to a set?
    In groovy we can use list as set to obtain set property on that list or array 
    we can also use list.unique()
    list as set don't change the original list
    list.unique() apply changes in the original list 
    
3. Given two lists [11, 12, 13, 14] and [13, 14, 15], how would we obtain the list of items from the first that are not in the second?

4. Find whether two lists have a common element or not
5.   Remove all records from a list whose index is odd
6.   Consider the following list: [1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ] Print the class name of each element. What's the output of the following statement? list.get(6).get(9)
7.   Sort the given list in descending order having distinct elements: [14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35]
8.   Consider a class Employee with following details * Name * Age * Salary Create a list consisting of 10 Employee objects.
    . Get a list of employees who earn less than 5000
    . Get the name of the youngest employee and oldest employee
    . Get the employee with maximum salary
    . Get the list of names of all the employees
9. Consider the following piece of code: String s = "this string needs to be split"
    . println s.tokenize(" ")
    . println s.tokenize()
  Compare this with the following code:
    . String s = "this string needs to be split"
    . println s.split(" ")  -> split the string with comma
    . println s.split(/\s/) (Try Same Parameter with tokenize)  -> split the string from given parameter 
  Also try the following exercise:
    . String s = "are.you.trying.to.split.me.mister?" 
    . s.tokenize(".") s.split(".")   -> split the string from all dot(.) with comma
10. Get first, second and last element of Range.
11. WAP to print the table of a given number
12. We have a sorted list of alphabets a-z, print all alphabets appearing after j
13. Find the number of occurences of a character in a string
14. Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print "FizzBuzz".
15. Consider a class named "Stack" that holds a list of objects and has the following operations associated:
     POP - Pops the last element off the stack
     PUSH - Pushes an element on top of the stack
     TOP - Returns the element at the top of the list Implement the aforesaid class
16. Create a new map consisting of 10 of your friend's name's as keys and their ages as value.
17. Create a new map by adding two existing maps
18. Try the following code on a map: println map.class println map.getClass() What do you observe?
19. Consider the following map: Map m = ['1' : 2, '2' : 3, '3' : 4, '2':5] Is this a valid construction? What is the value of m['2']?
20. Find if a map contains a particular key.
21. Consider the following map: Map m = [‘Computing’ : [‘Computing’ : 600, ‘Information Systems’ : 300], ‘Engineering’ : [‘Civil’ : 200, ‘Mechanical’ : 100], ‘Management’ : [‘Management’ : 800] ]
    . How many university departments are there?
    . How many programs are delivered by the Computing department?
    . How many students are enrolled in the Civil Engineering program?
22. Conside a class named "Employee" which has the following properties: 1) Name 2) Age 3) DepartmentName 4) EmployeeNumber 5) Salary Let's say that there's a list of 50 employees available. Perform the following operations on the list of employees:
   . Group the employees on the basis of the bracket in which their salary falls. The ranges are 0-5000, 5001 and 10000, and so on.
   . Get a count of the number of employees in each department
   . Get the list of employees whose age is between 18 and 35
   . Group the employees according to the alphabet with which their first name starts and display the number of employees in each group whose age is greater than
   . Group the employees according to their department.
23. Write a method which retruns the value of passed key from a search string of the form "http://www.google.com?name=johny&age=20&hobby=cricket"