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
            <a class="navbar-brand" href="#"><g:img dir="images" file="logo.png" width="110"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <g:form class="navbar-form navbar-left" controller="resource" action="searchByQuery"
                            name="searchQuery">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search" name="q" value="${params.q}">
                        </div>
                    </g:form>
                </li>
                <ls:isLoggedIn>
                    <li>
                        <a href="javascript:void(0)" data-toggle="modal" data-target="#topicCreate">
                            <i class="fa fa-comment" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" data-toggle="modal" data-target="#send-invite">
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" data-toggle="modal" data-target="#link-create">
                            <i class="fa fa-link" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" data-toggle="modal" data-target="#doc-create">
                            <i class="fa fa-file-o" aria-hidden="true"></i>
                        </a>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${session.user.userName} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href='${createLink(controller: 'user', action: 'profile', params: [userId: session.user.id])}'>profile</a>
                            </li>
                            <li><a href="#">Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><g:link controller="login" action="logout">Logout</g:link></li>
                        </ul>
                    </li>
                </ls:isLoggedIn>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>