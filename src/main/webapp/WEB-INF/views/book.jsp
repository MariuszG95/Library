<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <c:if test="${book.title != null}">
        <title>${book.title}</title>
    </head>
    <body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <table align="center" border="1">
                <tr>
                    <th>Tytuł</th>
                    <th>Autorzy</th>
                    <th>Ilość dostępnych sztuk</th>
                    <th>Wypożycz</th>
                </tr>
                <tr>
                    <td>${book.title}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author" varStatus="status">
                            ${author.firstName} ${author.lastName}<c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </td>
                    <td>${availableAmount}</td>
                    <c:if test="${availableAmount > 0}">
                        <td><a href="/book/${book.id}/borrow">Kliknij, aby wypożyczyć</a></td>
                    </c:if>
                    <c:if test="${availableAmount == 0}">
                        <td>Pozycja niedostępna</td>
                    </c:if>
                </tr>
            </table>
        </div>
    </div>
    </body></c:if>
    <c:if test="${book.title == null}">
        <title>Błąd</title>
    </head>
    <body>
        <p>Aktualnie wybrana pozycja jest już przez Ciebie wypożyczona, spróbuj wypożyczyć inną książkę.</p>
    </body></c:if>

</html>
