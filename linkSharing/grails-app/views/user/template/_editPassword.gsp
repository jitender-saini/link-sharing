<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row-fluid user-row">
            Change Password
        </div>
    </div>

    <div class="panel-body regForm">
        <g:form controller="user" action="updatePassword" id="updatePassword">
            <div class="form-element-container">
                <input id="oldPassword" name="oldPassword" placeholder="Enter Old Password"
                       type="password" class="input-txt form-control"/></div>

            <div class="form-element-container">
                <input id="password" name="password" placeholder="Enter New Password"
                       type="password" class="input-txt form-control"/></div>

            <div class="form-element-container">
                <input id="confirmPassword" name="confirmPassword" placeholder="Re-enter password"
                       type="password" class="input-txt form-control"/></div>

            <button type="submit" class="btn btn-right btn-lg btn-success btn-block"
                    id="updatePassword">Update Password</button>
        </g:form><br/>
    </div>
</div>
