<%@ page import="dto.LoggedUserDTO" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <table style="width: 100%">
        <tr bgcolor="#6495ed">
            <td align="center"><h1><font color="white">Internetowa Biblioteka</font></h1></td>
            <%
                try {
                    String string = request.getUserPrincipal().getName();
                    %>
            <td align="right"><a href="/user-profile">Profil</a> <a href="/logout">Wyloguj</a></td>
            <%
                } catch (NullPointerException npe) {
                    %>
            <td align="right"><a href="/login">Zaloguj</a> <a href="/register">Rejestracja</a></td>
            <%
                }
            %>
        </tr>
        <tr bgcolor="#7fffd4">
            <td colspan="2"><a href="/home">Strona główna</a> <a href="/profile">Profil</a> </td>
        </tr>
    </table>
</div>
