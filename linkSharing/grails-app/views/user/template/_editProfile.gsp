<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row-fluid user-row">
            Edit Profile
        </div>
    </div>

    <div class="panel-body regForm">
        <g:form controller="user" action="updateProfile" id="updateForm"
                enctype="multipart/form-data">
            <div class="form-element-container">
                <input id="firstName" name="firstName" placeholder="First Name"
                       type="text" class="input-txt form-control" value="${user.firstName}"/></div>

            <div class="form-element-container">
                <input id="lastName" name="lastName" placeholder="Last Name"
                       type="text" class="input-txt form-control"  value="${user.lastName}"/></div>

            <div class="form-element-container">
                <input id="userName" name="userName" placeholder="User Name"
                       type="text" class="input-txt form-control"  value="${user.userName}"/></div>

            <label for="profilePic"><small>Upload Profile Picture</small></label>

            <div class="form-element-container"><input type="file" name="profilePic" id="profilePic" value=""/>
            </div>
            <button type="submit" class="btn btn-right btn-lg btn-success btn-block"
                    id="update">Update Account</button>
        </g:form><br/>
    </div>
</div>
