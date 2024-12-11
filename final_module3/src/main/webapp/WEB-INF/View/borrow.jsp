<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Borrow Book</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Borrow Book</h1>
  <form action="/borrow?bookId=${bookId}" method="post">
    <div class="mb-3">
      <label for="id" class="form-label">Borrow ID</label>
      <input type="text" class="form-control" id="id" name="id" value="${borrowId}" readonly>
    </div>
    <div class="mb-3">
      <label for="bookName" class="form-label">Book Name</label>
      <input type="text" class="form-control" id="bookName" name="bookName" value="${bookName}" readonly>
    </div>
    <div class="mb-3">
      <label for="borrowDate" class="form-label">Borrow Date</label>
      <input type="datetime-local" class="form-control" id="borrowDate" name="borrowDate" required>
    </div>
    <div class="mb-3">
      <label for="returnDate" class="form-label">Return Date</label>
      <input type="datetime-local" class="form-control" id="returnDate" name="returnDate" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>
