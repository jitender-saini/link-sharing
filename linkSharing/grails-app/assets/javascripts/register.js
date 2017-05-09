/**
 * Created by jitender on 9/5/17.
 */

$(function(){
    $("form[name='registerForm']").validate({
        rules:{
            firstName: "required",
            lastName: "required",
            email:{
                required:true,
                email:true
            },
            password:{
                required:true,
                minlength: 5
            }
        },
        messages:{
            firstName: "Please enter your first name",
            lastName: "Please enter your first name",
            email: "Please enter a valid email address",
            password:{
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        submitHandler: function(form){
            form.submit();
        }
    });
});
