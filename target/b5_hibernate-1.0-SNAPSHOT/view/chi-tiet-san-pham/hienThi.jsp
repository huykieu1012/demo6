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
    <form action="/chi-tiet-sp/add">

        <div class="d-flex justify-content-start">
            <div class="p-3">Mau sac</div>
            <div class="p-2">
                <select
                        name="tenMauSac"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listMauSac}" var="mauSac1"
                    >
                        <option value="${mauSac1.ma}">${mauSac1.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>
        <div class="d-flex justify-content-start">
            <div class="p-3">Sản Phẩm</div>
            <div class="p-2">
                <select
                        name="tenSanPham"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listSanPham}" var="sanPham1"
                    >
                        <option value="${sanPham1.ma}">
                                ${sanPham1.ten}
                        </option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>
        <div class="d-flex justify-content-start">
            <div class="p-3">Dòng SP</div>
            <div class="p-2">
                <select
                        name="tenDongSP"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listDongSP}" var="dongSp1"
                    >
                        <option value="${dongSp1.ma}">${dongSp1.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>
        <div class="d-flex justify-content-start">
            <div class="p-3">NSX</div>
            <div class="p-2">
                <select
                        name="tenNSX"
                        class="form-select"
                        aria-label="Default select example"
                >
                    <option value="">Chọn</option>
                    <c:forEach items="${listNSX}" var="nsx1"
                    >
                        <option value="${nsx1.ma}">${nsx1.ten}</option>
                    </c:forEach
                    >
                </select>
            </div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon15">Nam Bh</span>
            <input type="text" class="form-control" name="namBH" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon16">Mo ta</span>
            <input type="text" class="form-control" name="moTa" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon17">So luong ton</span>
            <input type="text" class="form-control" name="soLuongTon" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon18">Gia nhap</span>
            <input type="text" class="form-control" name="giaNhap" aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon19">Gia Ban</span>
            <input type="text" class="form-control" name="giaBan" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <button type="submit" formmethod="post" class="btn btn-primary">Add</button>
    </form>
    <h1>Danh sach chi tiet san pham</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mau sac</th>
            <th scope="col">San pham</th>
            <th scope="col">Dong sp</th>
            <th scope="col">NSX</th>
            <th scope="col">Nam BH</th>
            <th scope="col">Mo ta</th>
            <th scope="col">So luong ton</th>
            <th scope="col">gia nhap</th>
            <th scope="col">Gia ban</th>
            <th>XXXXX</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChiTietSP}" var="chiTietSP">
            <tr>

                <th scope="row">${chiTietSP.id}</th>
                <td>${chiTietSP.mauSac.ten}</td>
                <td>${chiTietSP.sanPham.ten}</td>
                <td>${chiTietSP.dongSP.ten}</td>
                <td>${chiTietSP.nsx.ten}</td>
                <td>${chiTietSP.namBH}</td>
                <td>${chiTietSP.moTa}</td>
                <td>${chiTietSP.soLuongTon}</td>
                <td>${chiTietSP.giaNhap}</td>
                <td>${chiTietSP.giaBan}</td>
                <td><a href="/chi-tiet-sp/detail?id=${chiTietSP.id}">detail</a> <a
                        href="/chi-tiet-sp/remove?id=${chiTietSP.id}">remove</a></td>
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
