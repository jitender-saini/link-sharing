<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><g:img dir="images" file="logo.png" width="90" height="30"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <g:form class="navbar-form navbar-left" controller="resource" action="resourceSearch" name="test">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search" name="q" value="${params.q}">
                        </div>
                    </g:form>
                </li>
                <ls:isLoggedIn>
                    <li>
                        <a href="/topic/template/_create.gsp" data-toggle="modal" data-target="#topicCreate">
                            <i class="fa fa-comment" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="/topic/template/_invite.gsp" data-toggle="modal" data-target="#send-invite">
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="/resource/template/_create-link.gsp" data-toggle="modal" data-target="#link-create">
                            <i class="fa fa-link" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="/resource/template/_create-doc.gsp" data-toggle="modal" data-target="#doc-create">
                            <i class="fa fa-file-o" aria-hidden="true"></i>
                        </a>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${session.user.userName} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><g:link controller="login" action="logout">Logout</g:link></li>
                        </ul>
                    </li>
                </ls:isLoggedIn>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>