<div class="well">
    <div class="row">
        <div class="col-sm-3">
            <g:img dir="images" file="user.png" height="80"/>
            %{--<ls:userImage userId="${posts.createdBy.id}"/>--}%
        </div>

        <div class="col-sm-9">
            <div class="row">
                <span class="pull-left"><a href="#">${post.createdBy.fullName}</a></span>
                <span class="col-sm-3 text-muted">@${ post.createdBy.userName }</span>
                <span class="col-sm-3 pull-right"><a href="#">${post.topic.name}</a></span>
            </div>

            <div class="row">
                <p class="description">
                    ${post.description}
                </p>
            </div>

            <div class="row">
                <span class="col-sm-1 pull-left"><i class="fa fa-facebook"></i></span>
                <span class="col-sm-1 pull-left"><i class="fa fa-twitter"></i></span>
                <span class="col-sm-1 pull-left"><i class="fa fa-google-plus"></i></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline">
                    <a href="#">view post</a>
                </span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"></span>
            </div>
        </div>
    </div>
</div>
