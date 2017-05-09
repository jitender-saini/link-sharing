<div class="col-md-4 col-md-offset-4 pull-right">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="row-fluid user-row">
                Register
            </div>
        </div>

        <div class="panel-body regForm">
            <form accept-charset="UTF-8" id="registerForm" method="POST" enctype="multipart/form-data">
                <fieldset>
                    <div class="form-element-container"><input id="firstName" name="firstName" placeholder="First Name"
                                                               type="text" class="input-txt form-control"/></div>

                    <div class="form-element-container"><input id="lastName" name="lastName" placeholder="Last Name"
                                                               type="text" class="input-txt form-control"/></div>

                    <div class="form-element-container"><input id="email" name="email" placeholder="Email Address"
                                                               type="text" class="input-txt form-control"/></div>

                    <div class="form-element-container"><input id="userName" name="userName" placeholder="User Name"
                                                               type="text" class="input-txt form-control"/></div>

                    <div class="form-element-container"><input id="password" name="password" placeholder="Password"
                                                               type="password" class="input-txt form-control"/></div>

                    <div class="form-element-container"><input id="password-confirm" name="passwordConfirm"
                                                               placeholder="Re-enter password" type="password"
                                                               class="input-txt form-control" />
                    </div>

                    <label for="userImage"><small>Upload Profile Picture</small></label>

                    <div class="form-element-container"><input type="file" id="userImage" value=""/></div>
                    <input type="submit" id="createAccount"
                           class="create-acc btn btn--right btn-lg btn-success btn-block" value="Create My Account"/>
                </fieldset>
            </form><br/>
            <label>Already have and account? <a href="login.html">Login here</a></label>
        </div>
    </div>
</div>
