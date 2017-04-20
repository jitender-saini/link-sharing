package com.ttn.collection

Map map = ['Computing' : ['Computing' : 600, 'Information Systems' : 300],
           'Engineering' : ['Civil' : 200, 'Mechanical' : 100],
           'Management' : ['Management' : 800] ]
println "Number of University Departments : "+map.size()
println "Number of programs delivered by the Computing department : "+map.Computing.size()
println "Number of  students enrolled in the Civil Engineering program : "+map.Engineering.Civil