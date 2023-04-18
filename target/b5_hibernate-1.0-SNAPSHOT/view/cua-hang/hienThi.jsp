<%--
  Created by IntelliJ IDEA.
  User: Quang Huy
  Date: 3/17/2023
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body class="row">
<jsp:include page="../menu/menuTong.jsp"></jsp:include>
<div class="col-9 container p-2">
    <form action="/cua-hang/add">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Mã</span>
            <input type="text" class="form-control" name="ma" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon2">Tên</span>
            <input type="text" class="form-control" name="ten" aria-label="Username" aria-describedby="basic-addon2">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon3">Địa chỉ</span>
            <input type="text" class="form-control" name="diaChi" aria-label="Username" aria-describedby="basic-addon2">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon4">Thành phố</span>
            <input type="text" class="form-control" name="thanhPho" aria-label="Username"
                   aria-describedby="basic-addon2">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon5">Quốc gia</span>
            <input type="text" class="form-control" name="quocGia" aria-label="Username"
                   aria-describedby="basic-addon2">
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Add</button>
    </form>

    <h2>Danh Sách Cửa Hàng</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Ma</th>
            <th scope="col">ten</th>
            <th scope="col">dia chi</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th>xxxxx</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCuaHang}" var="cuaHang">
            <tr>
                <th>${cuaHang.id}</th>
                <td>${cuaHang.ma}</td>
                <td>${cuaHang.ten}</td>
                <td>${cuaHang.diaChi}</td>
                <td>${cuaHang.thanhPho}</td>
                <td>${cuaHang.quocGia}</td>


                <td><a href="/cua-hang/detail?id=${cuaHang.id}">detail</a>

                    <a href="/cua-hang/remove?id=${cuaHang.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
