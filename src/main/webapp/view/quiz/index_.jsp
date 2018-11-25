<%@include file="../includes/header.jsp" %>
    <form>
        <h1 class="question" id="${question.id}">${question.title}</h1>
        <c:forEach var="answer" items="${answers}">
            <input class="answer" type="radio" name="answered" value="${answer.id}" >${answer.title}</input> <br>
        </c:forEach>
        <input type="button" id="nextId" value="Next" ></input>
    </form>
<%@include file="../includes/footer.jsp" %>