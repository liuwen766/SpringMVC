<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 2019/10/27
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--http://localhost:8080/json.jsp--%>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery3.3.1.js"></script>
    <script type="text/javascript">
        $(function(){
            var user = {
                "id":1,
                "name":"张三"
            };
            $.ajax({
                url:"/data/json",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function(data){
                    alert(data.id+"---"+data.name);
                }
            })
        });
    </script>
</head>
<body>

</body>
</html>
