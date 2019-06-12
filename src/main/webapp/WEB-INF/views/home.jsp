<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Strona Główna</title>
</head>
<body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <h2>Strona główna</h2>
        </div>
        Użytkownik: ${user.login}
    </div>
</body>
</html>
