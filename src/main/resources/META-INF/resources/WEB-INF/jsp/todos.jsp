
<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

        <div class="container">
                <div>Welcome to TODOs ${username}</div>
                <hr>
                <h1>Your TODOS</h1>

                <table class="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Deadline</th>
                            <th>Is done</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="item" items="${todos}" >
                          <tr>
                            <td>${item.title}</td>
                            <td>${item.deadline}</td>
                            <td>${item.done}</td>
                            <td><a href="delete-todo?id=${item.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="update-todo?id=${item.id}" class="btn btn-success">Update</a></td>
                          </tr>
                      </c:forEach>
                    </tbody>
                </table>
                <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>


        <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
    </body>
</html>