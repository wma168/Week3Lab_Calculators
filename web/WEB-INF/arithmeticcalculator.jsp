<%-- 
    Document   : arithmeticcalculator
    Created on : 26-Jan-2023, 9:49:27 PM
    Author     : xbali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" name="firstNum"><br>
            Second: <input type="text" name="secondNum"><br>
            <input type="submit" name="submit" value="+">
            <input type="submit" name="submit" value="-">
            <input type="submit" name="submit" value="*">
            <input type="submit" name="submit" value="%">
            <br>
            <br>
            <div>Result: ${showResult}</div>
        </form>
        <a href="age">Age Calculator</a>
    </body>
</html>
