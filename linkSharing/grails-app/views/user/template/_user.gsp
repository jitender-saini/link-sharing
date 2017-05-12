<div class="well">
    <div class="row">
        <div class="col-sm-3">
            <g:img dir="images" file="user.png" height="80"/>
            %{--<ls:userImage userId="${posts.createdBy.id}"/>--}%
        </div>

        <div class="col-sm-9">
            <div class="row">
                    <h4> ${session.user.fullName}</h4>
                    <a href="#">${session.user.userName}</a>
            </div>

            <div class="col-xs-6">
                <h5>Subscriptions</h5>
                <a href="#">topicCount</a>
            </div>

            <div class="col-xs-6">
                <h5>Topics</h5>
                <a href="#">topicCount</a>

            </div>
        </div>
    </div>
</div>
