<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form  method="post" style="width: 50%;margin: 0 auto;">
<h1>Thêm Sản Phẩm</h1>
  <div class="form-group" >
    <label for="exampleInputEmail1">Name</label>
    <input type="text" class="form-control" name="name" placeholder="Enter name">
    <small  class="form-text text-muted" >We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="number" class="form-control" name="price"  placeholder="Price">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">sale_Price</label>
    <input type="number" class="form-control" name = "sale_price"  placeholder="Sale_Price">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">description</label>
    <input type="text" class="form-control" name="description"  placeholder="description">
  </div>
  <div class="">
    <input type="radio"  value="false" name="status" >
    <label class="form-check-label" >Ẩn</label>
     <input type="radio"  value="true" name="status" checked>
    <label class="form-check-label" >Hiện</label>
  </div>
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>