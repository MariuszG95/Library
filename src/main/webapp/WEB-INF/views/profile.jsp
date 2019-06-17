<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Profil ${user.login}</title>
</head>
<body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <table align="center" border="1">
                <tr>
                    <th>Login</th>
                    <td>${user.login}</td>
                </tr>
                <tr>
                    <th>Imię</th>
                    <td>${user.firstName}</td>
                </tr>
                <tr>
                    <th>Nazwisko</th>
                    <td>${user.lastName}</td>
                </tr>
            </table>
        </div>
        <div>
            <h1>Twoje wypożyczone książki:</h1>
            <c:if test="${user.books.size() == 0}">
                Brak wypożyczonych książek.
            </c:if>
            <c:if test="${user.books.size() > 0}">
                <table align="center" border="1">
                    <tr>
                        <th>Tytuł</th>
                        <th>Autorzy</th>
                        <th>Akcja</th>
                    </tr>
                    <c:forEach items="${user.books}" var="book">
                        <tr>
                            <td>${book.title}</td>
                            <td>
                                <c:forEach items="${book.authors}" var="author" varStatus="status">
                                    ${author.firstName} ${author.lastName}<c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <a href="/book/${book.id}">Link</a>
                                <a href="/profile/delete-book/${book.id}">Oddaj książkę</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
