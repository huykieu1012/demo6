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
<body>

<div class="container p-2">
    <form action="/nhan-vien/update">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Mã</span>
            <input type="text" class="form-control" name="ma" value="${nhanVien.ma}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon2">Tên</span>
            <input type="text" class="form-control" value="${nhanVien.ten}" name="ten" aria-label="Username"
                   aria-describedby="basic-addon2">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon12">Tên đệm</span>
            <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon3">Họ</span>
            <input type="text" class="form-control" name="ho" value="${nhanVien.ho}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>

        Giới Tính
        <div class="form-check">
            <input class="form-check-input" ${nhanVien.gioiTinh == "Nam"?"checked":""} type="radio" value="Nam"
                   name="gioiTinh" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" ${nhanVien.gioiTinh == "Nu"?"checked":""} type="radio" value="Nu"
                   name="gioiTinh" id="flexRadioDefault2">
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon15">Ngày Sinh</span>
            <input type="date" class="form-control" name="ngaySinh" value="${ngaySinh}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon16">Địa Chỉ</span>
            <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon">SĐT</span>
            <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon7">Mật Khẩu</span>
            <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>

        Trạng Thái
        <div class="form-check">
            <input class="form-check-input" type="radio" value="1" ${nhanVien.trangThai == 1?"checked":""}
                   name="trangThai" id="flexRadioDefault3">
            <label class="form-check-label" for="flexRadioDefault3">
                off
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="0"
                   name="trangThai" ${nhanVien.trangThai == 0?"checked":""} id="flexRadioDefault4">
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
                        <option value="${chucVu.ma}" ${chucVu.ma == nhanVien.chucVu.ma?"selected":""}>${chucVu.ten}</option>
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
                        <option value="${cuaHang.ma}" ${cuaHang.ma == nhanVien.cuaHang.ma?"selected":""} >${cuaHang.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>

        <button type="submit" formmethod="post" class="btn btn-primary">update</button>
    </form>
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
