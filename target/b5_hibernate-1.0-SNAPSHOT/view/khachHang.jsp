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
<jsp:include page="./menu/menuTong.jsp"></jsp:include>
<div class="col-9 container p-2">
    <form action="/khach-hang/add">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ma"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ten"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên Đệm</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="tenDem"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ho"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SĐT</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="sdt"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa Chỉ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="diaChi"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Thành Phố</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="thanhPho"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Quốc Gia</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="quocGia"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="matKhau"><br>
            </div>
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Add</button>
    </form>
    <h2>Danh Sách Khách Hàng</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Ho</th>
            <th scope="col">Ngay Sinh</th>
            <th scope="col">SĐT</th>
            <th scope="col">Địa Chi</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">XXX</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhachHang}" var="KhachHang">
            <tr>
                <th>${KhachHang.id}</th>
                <td>${KhachHang.ma}</td>
                <td>${KhachHang.ten}</td>
                <td>${KhachHang.tenDem}</td>
                <td>${KhachHang.ho}</td>
                <td>${KhachHang.ngaySinh}</td>
                <td>${KhachHang.sdt}</td>
                <td>${KhachHang.diaChi}</td>
                <td>${KhachHang.thanhPho}</td>
                <td>${KhachHang.quocGia}</td>
                <td>${KhachHang.matKhau}</td>

                <td><a href="/khach-hang/detail?id=${KhachHang.id}">detail</a>

                    <a href="/khach-hang/remove?id=${KhachHang.id}">Xóa</a></td>
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
