<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>fileUpload</title>
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>
<body>
<g:uploadForm name = "upload" enctype="multipart/form-data" method="post" controller="util" action="upload">
    <input type="file" name="myfile"/>
    <input type="submit" name="submit"/>
</g:uploadForm>
</body>
</html>