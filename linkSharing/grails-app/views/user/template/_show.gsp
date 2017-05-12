<div class="well">
    <div class="row">
        <div class="col-lg-3">
            <g:img dir="images" file="user.png" height="80"/>
        </div>

        <div class="col-lg-9">
            <div class="row col-lg-12 col-md-12">
                <span>${user.fullName}</span>
            </div>

            <div class="col-lg-12 col-md-12">
                <p>@${user.userName}</p>
            </div>

            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <p>Subscription</p>
                </div>

                <div class="col-md-6 col-lg-6">
                    <p>Topics</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <p><ls:getSubscriptionCount topicId="${user.topic.id}"/></p>
                </div>

                <div class="col-md-6 col-lg-6">
                    <p><ls:topicCount userId="${user.id}"/></p>
                </div>
            </div>
        </div>
    </div>

</div>