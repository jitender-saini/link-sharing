<div class="row well">
    <div class="col-sm-4">
        <g:img dir="images" file="user.png" height="80"/>
    </div>

    <div class="col-sm-8">
        <div class="row">
            <p><g:link controller="topic" action="showTopic"
                       params="[topic: topic.id]">${topic.name}</g:link>
            ( ${topic.visibility} )</p>
        </div>

        <div class="row">
            <div class="col-sm-4">
                <h5>@${topic.createdBy.userName}</h5>
                <ls:showSubscribe topicId="${topic.id}"/>
            </div>

            <div class="col-sm-4">
                <h5>Subscriptions</h5>
                <h5><ls:getSubscriptionCount topicId="${topic.id}"/></h5>
            </div>

            <div class="col-sm-4">
                <h5>Posts</h5>
                <h5><ls:getResourceCount topicId="${topic.id}"/></h5>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-sm-9">
        <div class="dropdown pull-right">
            <button class="btn btn-default dropdown-toggle" type="button"
                    data-toggle="dropdown">Serious
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">Not-So-Serious</a></li>
                <li><a href="#">Extremely-Serious</a></li>
            </ul>
        </div>
    </div>

    <div class="col-sm-3">
        <a href=""><span class="fa fa-envelope"></span></a>
    </div>

</div>
</div>