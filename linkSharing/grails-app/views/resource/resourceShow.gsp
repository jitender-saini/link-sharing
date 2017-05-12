<html>
<head>
    <meta name="layout" content="main"/>
    <title>Resource</title>
</head>

<body>
hello
<div class="col-xs-5">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Resource</span>
        </div>

        <div class="panel-body">

            <g:render template="/resource/template/show" collection="${resource}" var="resource"/>
        </div>
    </div>
</div>

</body>
</html>