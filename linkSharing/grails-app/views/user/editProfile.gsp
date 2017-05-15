<html>
<head>
    <meta name="layout" content="main"/>
    <title>Show topic</title>
</head>

<body>
<div class="col-xs-6">
    <ls:showUserDetails userId="${session.user.id}"/>
    <g:render template="template/createdTopic"/>
</div>

<div class="col-sm-6">
<g:render template="template/editProfile" collection="${user}"/>
<g:render template="template/editPassword"/>
</div>
</body>
</html>