<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Strona Główna</title>
</head>
<body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <h2>Ostatnio dodane:</h2>
            <h2>Losowe książki:</h2>
            <table border="1" align="center">
                <tr>
                    <td>Tytuł</td>
                    <td>Autorzy</td>
                    <td>Link</td>
                </tr>
                <c:forEach items="${randomBookSet}" var="book">
                    <tr>
                        <td><c:out value="${book.title}" /></td>
                        <c:choose>
                            <c:when test="${book.authors.size() == 1}">
                                <td>
                                    <c:forEach items="${book.authors}" var="author">
                                        <c:out value="${author.firstName}" /> <c:out value="${author.lastName}" />
                                    </c:forEach>
                                </td>
                            </c:when>
                            <c:when test="${book.authors.size() > 1}">
                                <td>
                                    <c:forEach items="${book.authors}" var="author">
                                        <c:out value="${author.firstName}" /> <c:out value="${author.lastName}" />,
                                    </c:forEach>
                                </td>
                            </c:when>
                        </c:choose>
                        <td><a href="/book/${book.id}">Link</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
