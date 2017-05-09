<div class="modal fade" id="doc-create" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body" style="margin-left: 15px;margin-right:15px">
                <form method="post" class="form-horizontal">
                    <div class="form-group">
                        <div class="control-label col-sm-3"><label for="document" class="pull-left">Document*</label></div>
                        <div class="col-sm-9">
                            <g:form name="upload" enctype="multipart/form-data" method="post" class="pull-right" controller="resource" action="upload" class="">
                                <input type="file" name="myFile" />
                            </g:form>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="control-label col-sm-3"><label for="description" class="pull-left">Description*</label></div>
                        <div class="col-sm-9">
                            <textarea rows="4" class="form-control pull-right" name="createDoc"></textarea></div>
                    </div>
                    <div class="form-group">
                        <div class="control-label col-sm-3"><label for="topic" class="pull-left">Topic*</label></div>
                        <div class="col-sm-9">
                            <select name="topic" class="form-control pull-right" defaultLabel="default topic" id="topic">
                                <option value="">Service Lines</option>
                                <option value="2" >Analytics</option>
                                <option value="12" >Analytics-SEA</option>
                                <option value="9" >Digital Marketing</option>
                                <option value="20" >Digital Marketing India</option>
                                <option value="13" >Digital Marketing-SEA</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="padding-left:15px;padding-right:15px">
                        <a href="user"><button type="submit" class="btn btn-info ">share</button></a>
                        <button type="button" class="btn btn-danger pull-right" data-dismiss="modal">cancel</button>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>