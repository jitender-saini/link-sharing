<div class="panel panel-default">
    <div class="panel-heading">
        <span class="panel-title">Recent Posts</span>
    </div>

    <div class="panel-body">
        <g:render template="/resource/template/post" collection="${posts}" var="post"/>
        <g:paginate total="5" max="5"/>
    </div>
</div>