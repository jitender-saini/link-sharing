<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="container-fluid">

    <div class="col-xs-6">

        <div class="row">
            <div class="container-fluid">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title">Topic : "${topic.name}"</span>
                    </div>

                    <div class="panel-body">
                        <!--FOr User Image,topic ,rating-->
                        <g:render template="template/topic-desc" collection="${topic}" var="topic"/>
                    </div>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="row container-fluid">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title">Users : "${topic.name}"</span>
                    </div>

                    <div class="panel-body">
                        <g:render template="/user/template/show" collection="${subscribers}" var="user"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="col-xs-6">

                <div class="row container-fluid">
                    <div class="my-panel">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <span class="panel-title">posts : "${topic.name}"</span>
                                    </div>

                                    <div class="col-sm-6">
                                        <form class="navbar-form">

                                            <div class="inner-addon left-addon pull-right" style="margin-top: -10px">
                                                <i class="fa fa-search"></i>
                                                <input type="text" class="form-control search-box"
                                                       placeholder="search"/>
                                            </div>

                                            <!--            <button type="submit" class="btn btn-default">Submit</button>-->
                                        </form>
                                    </div>

                                </div>
                            </div>

                            <div class="panel-body">
                                <g:render template="/resource/template/post" collection="${resources}" var="post"/>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
</body>
</html>