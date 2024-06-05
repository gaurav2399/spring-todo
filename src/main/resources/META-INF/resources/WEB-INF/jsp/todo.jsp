<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<pre>${error}</pre>
<div class="container">
    <div><h3>Enter your TODO Details</h3></div>
    <hr>
    <form:form method="post" modelAttribute="todo">
    <form:input type="hidden" path="id" />
    <form:input type="hidden" path="done" />
    <fieldset>
        <form:label path="title">Title</form:label>
        <form:input type="text" path="title" required="required" />
        <form:errors path="title" cssClass="text-warning"/>
    </fieldset>

    <fieldset class="mt-2">
        <form:label path="deadline">Deadline</form:label>
        <form:input type="text" path="deadline" required="required" />
        <form:errors path="deadline" cssClass="text-warning"/>
    </fieldset>

    <input type="submit" value="Submit" class="btn btn-success mt-3" />
    </form:form>
</div>

<%@include file="common/footer.jspf" %>

<script type="text/javascript">
          $('#deadline').datepicker({
              format: 'yyyy-mm-dd'
          });
</script>