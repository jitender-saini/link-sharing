<div class="well">

    <div class="row container-fluid">

        <div class="col-sm-3">
            %{--<g:img dir="images" file="user.png" height="80"></g:img>--}%
        </div>

        <div class="col-sm-9">

            <div class="row row-sm-12 ">
                <div class="col-sm-6">
                  <h5>${resource.createdBy.fullName}</h5>
                </div>

                <div class="col-sm-6">
                    <h5><g:link controller="topic" action="showTopic" params="[topic: resource.topic.id]">${resource.topic.name}</g:link></h5>
                </div>
            </div>

            <div class="row row-sm-12">
                <div class="col-sm-6">
                    <span>@${resource.createdBy.userName}</span>
                </div>
                %{-- show only on view topic page--}%
                <div class="col-sm-6">
                    <span class="fa fa-star-half-empty"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    %{--<ls:resourceRating resourceId = "${resource.id}"/>--}%
                </div>
            </div>

            <div class="row row-sm-12 custom_spacing">
                <p>${resource.description}</p>
            </div>

        </div>
    </div>

    <div class="row row-sm-12">

        <div class="container-fluid col-md-3">
            <div class="row">
                <div class="col-sm-4">
                    <i class="fa fa-facebook"></i>
                </div>

                <div class="col-sm-4">
                    <i class="fa fa-twitter"></i>
                </div>

                <div class="col-sm-4">
                    <i class="fa fa-google-plus"></i>
                </div>
            </div>
        </div>


        <div class="container-fluid col-md-9">
            <div class="row container-fluid pull-right">
                <ls:checkResourceType resourceId="${resource.id}"/>
                <ls:isRead resourceId="${resource.id}"/>
            </div>
        </div>

    </div>

</div>
