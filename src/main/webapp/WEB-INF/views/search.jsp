<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szukaj książki</title>
</head>
<body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <p>
                <form method="post">
                    <input type="text" name="search" width="80%" align="center"> <input type="submit" value="Szukaj">
                </form>
            </p>
        </div>
        <div>
            <c:if test="${searchResult.size() > 0}">
                <table align="center" border="1">
                    <tr>
                        <th>Tytuł</th>
                        <th>Autorzy</th>
                        <th>Link</th>
                    </tr>
                    <c:forEach items="${searchResult}" var="book">
                        <tr>
                            <td>${book.title}</td>
                            <td>
                                <c:forEach items="${book.authors}" var="author" varStatus="status">
                                    ${author.firstName} ${author.lastName}<c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </td>
                            <td><a href="/book/${book.id}">Link</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${searchResult.size() == 0}">
                <p>Brak wyników wyszuikwania. Spróbuj użyć innych słów kluczowych.</p>
            </c:if>
        </div>
    </div>
</body>
</html>
