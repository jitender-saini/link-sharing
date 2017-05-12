<div id="forgotPassword" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
            </div>

        <div class="modal-body">
            <g:form controller="user" action="forgetPassword" class="form-horizontal" name="forgot-password-form">

                <div class="container">
                    <div class="row" style="padding-bottom:10px;">
                        <p class="col-xs-12">Enter your Email Address Below. We'll Send you your password in specified mail.</p>
                    </div>

                    <div class="row" style="padding-bottom:10px;">
                        <div class="form-group">
                            <label class="col-xs-1">Email:</label>

                            <div class="col-xs-4">
                                <g:field name="recoveryEmail" type="email" class="form-control"/>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                <div class="modal-footer">
                    <g:submitButton name="sendRecoveryEmail" value="Send" class="btn btn-info"/>
                </div>
            </g:form>

        </div>
    </div>
</div>