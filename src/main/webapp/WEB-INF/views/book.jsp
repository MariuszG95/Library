<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
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
                </tr>
                <tr>
                    <td>${book.title}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author" varStatus="status">
                            ${author.firstName} ${author.lastName}<c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>
