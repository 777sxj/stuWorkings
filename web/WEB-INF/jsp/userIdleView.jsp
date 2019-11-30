<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>userSellingView</title>

    <!-- Bootstrap -->
    <link href="http://localhost:8080/whh/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--导航栏--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/main">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/toUserview">${username}<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/toMessageview">Messages</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的收藏 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">收藏的物品</a></li>
                        <li><a href="#">收藏的店铺</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的闲置 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/toUserSelling">出售中</a></li>
                        <li><a href="#">这个功能我没想好！</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<table class="table .table-striped">
    <c:forEach var="good" items="${userSellingList}">
        <thead>
        <tr>
            <th>${good.goodname}</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td><a href="#"><img src="http://localhost:8080/whh${good.imgroad}"></a><a href="">下架</a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="http://localhost:8080/whh/assets/js/jquery-1.11.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="http://localhost:8080/whh/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
