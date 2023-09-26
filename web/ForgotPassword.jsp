<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/assets/js/validate.js"></script>
<div class="form-gap"></div>

<c:if test="${acc == null}">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3><i class="fa fa-lock fa-4x"></i></h3>
                            <h2 class="text-center">Forgot Password?</h2>
                            <p>You can reset your password here.</p>
                            <div class="panel-body">

                                <form action="ForgotPassword" method="post" id="register-form" role="form" autocomplete="off" class="form" method="post">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                            <input id="email" name="email" placeholder="email address" class="form-control"  type="email" value="${email}"  oninput="updateInput2(this.value)" required>
                                        </div>
                                    </div>
                                    <p class="text-danger">${mess}</p>
                                    <div class="form-group">
                                        <input name="resetPassword" class="btn btn-lg btn-success btn-block" value="Reset Password" type="submit">
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${acc != null}">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h1>Change Password</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <p class="text-center">Use the form below to change your password. Your password cannot be the same as your username.</p>
                <form action="ForgotPassword" method="post" id="passwordForm">
                    <input id="input2" type="password" name="email" style="display: none" value="${acc.getEmail()}">
                    <input type="oldPassword" class="input-lg form-control" name="oldPassword" id="oldPassword" placeholder="Code reset" autocomplete="off" required>
                    <p class="text-danger">${mess2}</p>
                    <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="New Password" autocomplete="off" required>
                    <div class="row">
                        <div class="col-sm-6">
                            <span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>
                            <span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
                        </div>
                        <div class="col-sm-6">
                            <span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
                            <span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
                        </div>
                    </div>
                    <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat Password" autocomplete="off" required>
                    <div class="row">
                        <div class="col-sm-12">
                            <span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match
                        </div>
                    </div>
                    <input type="submit" name="resetPassword" class="col-xs-12 btn btn-success btn-load btn-lg" data-loading-text="Changing Password..." value="Change Password">
                </form>
            </div><!--/col-sm-6-->
        </div><!--/row-->
    </div>
</c:if>
<!-- MDB -->
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.js"
></script>
<!<!-- check email -->
<<script>
    $("input[type=password]").keyup(function () {
        var ucase = new RegExp("[A-Z]+");
        var lcase = new RegExp("[a-z]+");
        var num = new RegExp("[0-9]+");

        if ($("#password1").val().length >= 8) {
            $("#8char").removeClass("glyphicon-remove");
            $("#8char").addClass("glyphicon-ok");
            $("#8char").css("color", "#00A41E");
        } else {
            $("#8char").removeClass("glyphicon-ok");
            $("#8char").addClass("glyphicon-remove");
            $("#8char").css("color", "#FF0004");
        }

        if (ucase.test($("#password1").val())) {
            $("#ucase").removeClass("glyphicon-remove");
            $("#ucase").addClass("glyphicon-ok");
            $("#ucase").css("color", "#00A41E");
        } else {
            $("#ucase").removeClass("glyphicon-ok");
            $("#ucase").addClass("glyphicon-remove");
            $("#ucase").css("color", "#FF0004");
        }

        if (lcase.test($("#password1").val())) {
            $("#lcase").removeClass("glyphicon-remove");
            $("#lcase").addClass("glyphicon-ok");
            $("#lcase").css("color", "#00A41E");
        } else {
            $("#lcase").removeClass("glyphicon-ok");
            $("#lcase").addClass("glyphicon-remove");
            $("#lcase").css("color", "#FF0004");
        }

        if (num.test($("#password1").val())) {
            $("#num").removeClass("glyphicon-remove");
            $("#num").addClass("glyphicon-ok");
            $("#num").css("color", "#00A41E");
        } else {
            $("#num").removeClass("glyphicon-ok");
            $("#num").addClass("glyphicon-remove");
            $("#num").css("color", "#FF0004");
        }

        if ($("#password1").val() == $("#password2").val()) {
            $("#pwmatch").removeClass("glyphicon-remove");
            $("#pwmatch").addClass("glyphicon-ok");
            $("#pwmatch").css("color", "#00A41E");
        } else {
            $("#pwmatch").removeClass("glyphicon-ok");
            $("#pwmatch").addClass("glyphicon-remove");
            $("#pwmatch").css("color", "#FF0004");
        }
    });
</script>
</div>