<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<pre>${error}</pre>
<div class="container">
    <form method="post">
        Username
        <input type="text" name="username"><br>
        Password
        <input type="password" name="password" class="mt-3"><br>
        <input type="submit" value="Submit" class="btn btn-success mt-3">
    </form>
</div>

<%@include file="common/footer.jspf" %>