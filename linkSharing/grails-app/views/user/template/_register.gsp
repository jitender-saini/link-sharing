<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row-fluid user-row">
            Register
        </div>
    </div>

    <div class="panel-body regForm">
        <g:form controller="user" action="register" id="registerForm"
                enctype="multipart/form-data">
            <div class="form-element-container"><input id="firstName" name="firstName"
                                                       placeholder="First Name"
                                                       type="text" class="input-txt form-control"/></div>

            <div class="form-element-container"><input id="lastName" name="lastName"
                                                       placeholder="Last Name"
                                                       type="text" class="input-txt form-control"/></div>

            <div class="form-element-container"><input id="email" name="email" placeholder="Email Address"
                                                       type="text" class="input-txt form-control"/></div>

            <div class="form-element-container"><input id="userName" name="userName"
                                                       placeholder="User Name"
                                                       type="text" class="input-txt form-control"/></div>

            <div class="form-element-container"><input id="password" name="password"
                                                       placeholder="Password"
                                                       type="password"
                                                       class="input-txt form-control"/></div>

            <div class="form-element-container"><input id="confirmPassword" name="confirmPassword"
                                                       placeholder="Re-enter password" type="password"
                                                       class="input-txt form-control"/></div>

            <label for="profilePic"><small>Upload Profile Picture</small></label>

            <div class="form-element-container"><input type="file" name="profilePic" id="profilePic" value=""/>
            </div>
            <button type="submit" class="btn btn--right btn-lg btn-success btn-block"
                    id="register">Create My Account</button>
        %{--<input type="submit" id="createAccount"--}%
        %{--class="create-acc btn btn--right btn-lg btn-success btn-block" value="Create My Account"/>--}%
        </g:form><br/>
    </div>
</div>
