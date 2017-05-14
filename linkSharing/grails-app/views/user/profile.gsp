<html>
<head>
    <meta name="layout" content="main"/>
    <title>Show topic</title>
</head>

<body>
<div class="col-xs-5">
    <ls:showUserDetails userId="${session.user.id}"/>
</div>

<div class="col-sm-7">
    %{--<g:render template="template/inbox"/>--}%
</div>
</body>
</html>