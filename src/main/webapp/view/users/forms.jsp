<%@include file="../includes/header.jsp" %>
<body class="bg-light">

<div class="container">
    <div class="py-5" id="login">

        <div class="row">

            <div class="col-md-8 offset-md-4 order-md-1">
                <h4 class="mb-3">User Login</h4>
                <form class="needs-validation" method="post" action="/login">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                            <input type="hidden" name=""/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                            <p class="py-4">Don't have an account? <a href="#" id="showReg">Register</a></p>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!--
        <footer class="my-5 pt-5 text-muted text-center text-small">
          <p class="mb-1">&copy; Online Quiz App</p>
        </footer>
      -->
    </div>
    <div class="py-5" id="registration">

        <div class="row">

            <div class="col-md-8 offset-md-2 order-md-1">
                <h4 class="mb-3">User Registration</h4>
                <form class="needs-validation" novalidate method="post" action="/register">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="firstName">First name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastName">Last name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="reg_username" name="reg_username" placeholder="Username" required>
                            <div class="invalid-feedback">
                                Valid username is required.
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="reg_password" name="reg_password" placeholder="Password" required>
                            <div class="invalid-feedback">
                                Valid Password is required.
                            </div>
                        </div>
                    </div>


                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
                    <p class="py-4">Already have an account? <a href="#" id="showLog">Login</a></p>
                </form>
            </div>
        </div>
        <!--
        <footer class="my-5 pt-5 text-muted text-center text-small">
          <p class="mb-1">&copy; Online Quiz App</p>
        </footer>
      -->
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->


<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    $(function() {
        $('#registration').css('display','none');
        $('#showReg').click(function(){
            $('#login').fadeOut("slow");
            $('#registration').fadeIn("slow");
        })
        $('#showLog').click(function(){
            $('#registration').fadeOut("slow");
            $('#login').fadeIn("slow");
        })
    })
    (function() {
        'use strict';

        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');

            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();

</script>
<%@include file="../includes/footer.jsp" %>