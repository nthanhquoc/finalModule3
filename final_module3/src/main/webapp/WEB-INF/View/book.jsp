<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/11/2024
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Books</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Product List</h1>
  <table class="table table-striped">
    <thead class="table-dark">
    <tr>
      <th>Mã Sách</th>
      <th>Tên Sách</th>
      <th>Tác giả</th>
      <th>Số Lượng</th>
      <th>Mô tả</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.idBook}</td>
        <td>${book.nameBook}</td>
        <td>${book.author}</td>
        <td>${book.number}</td>
        <td>${book.description}</td>
        <td>
          <button class="btn btn-primary borrow-btn"
                  data-id="${book.idBook}"
                  data-number="${book.number}">
            Mượn
          </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="errorModalLabel">Lỗi</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       Cuốn Sách này Tạm Thời đã cho mượn hết, vui lòng chọn sách khác
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', () => {
    const borrowButtons = document.querySelectorAll('.borrow-btn');

    borrowButtons.forEach(button => {
      button.addEventListener('click', function () {
        const bookId = this.dataset.id;
        if (!bookId) {
          alert("Book ID is missing!");
          return;
        }
        const number = parseInt(this.dataset.number);
        if (number === 0) {
          const errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
          errorModal.show();
        } else {
          window.location.href = `/borrow?bookId=${bookId}`;
        }
      });
    });
  });

</script>
</html>
