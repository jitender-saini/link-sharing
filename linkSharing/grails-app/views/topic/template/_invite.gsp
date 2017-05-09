<div class="modal fade" tabindex="-1" role="dialog" id="send-invite">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="form-horizontal" id="formcreatetopic" action="topic/invite" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Send Invitation</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="inviteemail" class="col-sm-2 control-label required">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inviteemail" placeholder="Email" name="email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label required">Topic</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="topicId">
                                <option>Select Topic</option>
                                <option></option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" target-form="formcreatetopic">Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->