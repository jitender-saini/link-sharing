<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>
        <g:layoutTitle default="LinkSharing"/>
    </title>

    <asset:stylesheet src="application.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <g:layoutHead/>
</head>

<body>

<g:render template="/header/header"/>
<g:render template="/topic/template/create" model="[topic:topic]"/>
<g:render template="/topic/template/invite" model="[topic:topic]"/>
<g:render template="/resource/template/create-link" model="[resource:resource]"/>
<g:render template="/resource/template/create-doc" model="[resource:resource]"/>

<g:if test="${flash.message}">
    <div class="alert alert-success">${flash.message}</div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-danger">${flash.error}</div>
</g:if>

<g:layoutBody/>


<asset:javascript src="application.js"/>
<asset:deferredScripts/>
</body>
</html>
