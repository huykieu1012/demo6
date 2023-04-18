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
    <form action="/nhan-vien/add">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Mã</span>
            <input type="text" class="form-control" name="ma" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon2">Tên</span>
            <input type="text" class="form-control" name="ten" aria-label="Username" aria-describedby="basic-addon2">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon12">Tên đệm</span>
            <input type="text" class="form-control" name="tenDem" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon3">Họ</span>
            <input type="text" class="form-control" name="ho" aria-label="Username" aria-describedby="basic-addon1">
        </div>

        Giới Tính
        <div class="form-check">
            <input class="form-check-input" type="radio" value="Nam" name="gioiTinh" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="Nu" name="gioiTinh" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon15">Ngày Sinh</span>
            <input type="date" class="form-control" name="ngaySinh" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon16">Địa Chỉ</span>
            <input type="text" class="form-control" name="diaChi" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon">SĐT</span>
            <input type="text" class="form-control" name="sdt" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon7">Mật Khẩu</span>
            <input type="text" class="form-control" name="matKhau" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>

        Trạng Thái
        <div class="form-check">
            <input class="form-check-input" type="radio" value="1" name="trangThai" id="flexRadioDefault3">
            <label class="form-check-label" for="flexRadioDefault3">
                off
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="0" name="trangThai" id="flexRadioDefault4" checked>
            <label class="form-check-label" for="flexRadioDefault4">
                on
            </label>
        </div>
        <div class="d-flex justify-content-start">
            <div class="p-3">Chức Vụ</div>
            <div class="p-2">
                <select
                        name="tenChucVu"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listChucVu}" var="chucVu"
                    >
                        <option value="${chucVu.ma}">${chucVu.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>
        <div class="d-flex justify-content-start">
            <div class="p-3">Cửa Hàng</div>
            <div class="p-2">
                <select
                        name="tenCuaHang"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listCuaHang}" var="cuaHang"
                    >
                        <option value="${cuaHang.ma}">${cuaHang.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>

        <button type="submit" formmethod="post" class="btn btn-primary">Add</button>
    </form>

    <h2>Danh Sách Nhân Viên</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Ma</th>
            <th scope="col">ten</th>
            <th scope="col">Ten dem</th>
            <th scope="col">Ho</th>
            <th scope="col">Gioi Tinh</th>
            <th scope="col">Ngay Sinh</th>
            <th scope="col">Dia Chi</th>
            <th scope="col">SDT</th>
            <th scope="col">Mat Khau</th>
            <th scope="col">Trang Thai</th>
            <th scope="col">Chuc Vu</th>
            <th scope="col">Cua Hang</th>
            <th>xxxxx</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNhanVien}" var="nhanVien">
            <tr>
                <th>${nhanVien.id}</th>
                <td>${nhanVien.ma}</td>
                <td>${nhanVien.ten}</td>
                <td>${nhanVien.tenDem}</td>
                <td>${nhanVien.ho}</td>
                <td>${nhanVien.gioiTinh}</td>
                <th>${nhanVien.ngaySinh}</th>
                <td>${nhanVien.diaChi}</td>
                <td>${nhanVien.sdt}</td>
                <td>${nhanVien.matKhau}</td>
                <td><c:if test="${nhanVien.trangThai ==1}">off</c:if>
                    <c:if test="${nhanVien.trangThai ==0}">on</c:if>

                <td>${nhanVien.chucVu.ten}</td>
                <td>${nhanVien.cuaHang.ten}</td>
                <td><a href="/nhan-vien/detail?id=${nhanVien.id}">detail</a>

                    <a href="/nhan-vien/remove?id=${nhanVien.id}">Xóa</a></td>
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
