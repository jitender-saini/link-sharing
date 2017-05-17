<html>
<head>
    <meta name="layout" content="main"/>
    <title>Show topic</title>
</head>

<body>
<div class="col-md-4">

    <g:render template="show" model="[topic: topic]"/>
    <g:hasErrors bean="${topic1}">
        <ul>
            <g:eachError bean="${topic1}">
                <li><g:message error="${it}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <div class="${hasErrors(bean: topic1, field: 'name', 'form-group has-error')}">

        <g:field type="text" value="${topic1.name}" name="name" class="form-control"/>
        <div class="control-label">
        <g:fieldError field="name" bean="${topic1}"/>

    </div>
    </div>
</div>

<div class="col-md-8">
    <div class="panel">
        <div class="panel-heading custom-heading">Posts</div>

        <div class="panel-body custom-body">
            <g:render template="/resource/list" model="[resources: resources]"/>
        </div>

    </div>

</div>
</body>
</html>