<%@include file="../includes/header.jsp" %>

<body class="bg-light">

<div class="container">
    <div class="py-5">

        <div class="row">
            <div class="col-md-8 offset-md-4 order-md-1">
                <h4 class="mb-3">Ready for the Quiz?</h4>
                <form method="post">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="type">Select Quiz</label>
                        <select class="custom-select d-block w-100" id="type" name="type">
                            <option selected="selected">Select</option>
                            <c:forEach var="type" items="${types}">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Start Quiz</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>