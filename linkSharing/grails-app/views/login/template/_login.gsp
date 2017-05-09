<div class="col-md-4 col-md-offset-4 pull-right">
    <div class="panel panel-default ">
        <div class="panel-heading">
            <div class="row-fluid user-row">
                Login
            </div>
        </div>

        <div class="panel-body">
            <form id="loginForm" method="POST" class="form-signin">
                <fieldset>
                    <label class="panel-login">
                        <div class="login_result"></div>
                    </label>
                    <input class="form-control input-txt" placeholder="User Name/Email Id" id="username" type="text"
                           name="email" required="required">
                    <input class="form-control input-txt" placeholder="Password" id="password" type="password"
                           name="password" required="required">
                    <br>
                    <button type="submit" class="btn btn--right btn-lg btn-success btn-block"
                            id="login">Sign in</button>
                </fieldset>
            </form><br/>
            <label>Don't have an account?  <a href="register.html">Sign up here</a></label>
        </div>
    </div>
</div>