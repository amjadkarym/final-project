<%@include file="../includes/header.jsp" %>

<body class="bg-light">

<div class="container">
    <div class="py-5">

        <div class="row">
            <div class="col-md-3 order-md-2 mb-4">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Your Score</span>
                </h4>
                <ul class="list-group mb-3">
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div class="text-success">
                            <h6 class="my-0">Correct Answers</h6>
                        </div>
                        <span class="text-success correctScoreId">${correctAns}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div class="text-danger">
                            <h6 class="my-0">Wrong Answers</h6>
                        </div>
                        <span class="text-danger wrongScoreId" >${wrongAns}</span>
                    </li>

                </ul>

                <div class="card p-2">
                    <div class="input-group">
                        <span class="form-control">Total </span>
                        <div class="input-group-append">
                <span class="btn btn-secondary resultScore">0/0</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-8 offset-md-1 order-md-1" id="quizDiv">
                <h4 class="mb-3 question" id="${question.id}">${question.title}></h4>
                <form class="needs-validation">

                    <div class="col-md-6 mb-3 answers">
                        <c:forEach var="answer" items="${answers}">
                        <div class="custom-control custom-radio">
                            <input id="${answer.id}" name="answered" type="radio" class="custom-control-input answer" value="${answer.id}">
                            <label class="custom-control-label" for="${answer.id}">${answer.title}</label>
                        </div>
                        </c:forEach>
                    </div>


                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="button" id="nextId">Next</button>
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
</div>

<%@include file="../includes/footer.jsp" %>
