<div class="well">
    <div class="row">
        <div class="col-xs-4">
            <ls:userProfileImage userId="${topic.createdBy.id}"/>
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


            <div class="row">
                <div class="col-sm-9">
                    <ls:isSubscribedToTopic topicId="${topic.id}">
                        <div class="row">

                            <div class="col-sm-3 pull-right">
                                <p id="updateTextOfSeriousness${topic.id}"></p>
                            </div>

                            <div class="col-sm-6">
                                <div class="dropdown pull-right">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            data-toggle="dropdown">Seriousness
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#"
                                               onclick="updateSeriousness(${topic.id}, 'serious')">  Serious  </a>
                                        </li>
                                        <li><a href="#"
                                               onclick="updateSeriousness(${topic.id}, 'casual')">Not-So-Serious</a>
                                        </li>
                                        <li><a href="#"
                                               onclick="updateSeriousness(${topic.id}, 'very serious')">Extremely-Serious</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <a href=""><span class="fa fa-envelope"></span></a>
                            </div>
                        </div>
                    </ls:isSubscribedToTopic>
                </div>
            </div>
        </div>

    </div>
</div>