<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="lol" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.table-dark {
    margin: 0 auto;
    /* width: 107px; */
    width: 50%;
    color: #fff;
    background-color: #212529;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1>Xàm lol</h1>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="create">Thêm</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="update">sửa</a>
      </li>
      
     
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<table class="table table-dark " style="margin: 0 auto;width: 50%;">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">name</th>
      <th scope="col">price</th>
      <th scope="col">sale_price</th>
       <th scope="col">desscription</th>
        <th scope="col">status</th>
         <th scope="col">funtion</th>
    </tr>
  </thead>
  <tbody>
  <lol:forEach items="${list_pro}" var="pro">
    <tr>
    
      <th scope="row">${pro.id}</th>
      <td>${pro.name}</td>
      <td>${pro.price}</td>
      <td>${pro.sale_price}</td>
      <td>${pro.description}</td>
      <td>${pro.status==true?'Hiển Thị':'Ẩn'}</td>
         <td><a href="update?id=${pro.id}">edit</a></td>
         <td><a href="delete?id=${pro.id}">delete</a></td>
    </tr>
  </lol:forEach>
   
  </tbody>
  
</table>
</body>
</html>