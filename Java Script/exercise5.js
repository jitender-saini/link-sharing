 var employees= [{name:"Jitender", Age:24, salary:985000, DOB:"14-11-1992" },{name:"Jay", Age:21, salary:450000, DOB:"10-10-1995" },{name:"Sam", Age:25, salary:900, DOB:"10-12-1991" },{name:"Tanay", Age:20, salary:13900, DOB:"01-02-1997" },{name:"Agam", Age:21, salary:45000, DOB:"11-11-1995" }];

            console.log("Employees with salary greater 50,000:");
            for(var k in employees)
                {
                    if(employees[k].salary>50000)
                        console.log(employees[k]);
                }
            //group employee on the basis of their age
             console.log("Grouping Employees");
            employees.sort(function (a,b) {
                return a.Age-b.Age;
            });
            for(var k in employees)
                {
                        console.log(employees[k]);
                }

            //fetch employees with salary less than 1000 and age greater than 20. Then give them an increment 5 times their salary
             console.log("fetching employees with salary less than 1000 and age greater than 20 and giving increament 5 times of their salary");
            for(var k in employees)
                {
                    if(employees[k].salary<1000 && employees[k].Age>20)
                        {
                           console.log(employees[k].salary,'salary before hike');
                         employees[k].salary=5*employees[k].salary;
                            console.log(employees[k],'after salary hike');
                        }
                }
