<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Keeper</title>
</head>
<body>
<form>
    <select id="lang" name="lang" onchange="submit()">
        <option value="fr" ${pageContext.response.locale == 'fr' ? 'selected' : ''}>Français</option>
        <option value="en" ${pageContext.response.locale == 'en' ? 'selected' : ''}>English</option>
    </select>
</form>