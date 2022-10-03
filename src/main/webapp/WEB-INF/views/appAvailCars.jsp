<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>CaRental</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
        rel="stylesheet">

  <link rel="stylesheet" href='<c:url value='/css/style.css'/>'>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-around">
    <a href="/app/dashboard" class="navbar-brand main-logo">
      Ca<span>Rental</span>
    </a>
    <ul class="nav nounderline text-uppercase">
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="/app/car/list">All Cars</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="">My profile</a>
      </li>

    </ul>
  </nav>
</header>

<div class="m-4 p-3 width-medium">

  <div class="dashboard-content border-dashed p-3 m-4 view-height">

    <div class="row border-bottom border-3 p-1 m-1">
      <div class="col noPadding"><h3 class="color-header text-uppercase">Available Cars List</h3></div>
      <div class="col noPadding d-flex justify-content-end mb-2"><a href="/app/rentCar"
                                                                    class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">
        Rent Car</a></div>
    </div>

    <table class="table border-bottom schedules-content">
      <thead>
      <tr class="d-flex text-color-darker">
        <th scope="col" class="col-1">ID</th>
        <th scope="col" class="col-2">BRAND</th>
        <th scope="col" class="col-7">MODEL AND TYPE</th>
        <th scope="col" class="col-2 center">Options</th>
      </tr>
      </thead>
      <tbody class="text-color-lighter">


      <c:forEach items="${carList}" var="car" varStatus="loopStatus">

        <tr class="d-flex">
          <th scope="row" class="col-1">${loopStatus.count}</th>

           <td class="col-2">${car.brand}</td>
          <td class="col-7">${car.model}, ${car.type}</td>
          <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
            <a href="/app/car/details/${car.id}" class="btn btn-info rounded-0 text-light m-1">Details</a>
          </td>
        </tr>

      </c:forEach>


      </tbody>
    </table>
  </div>
</div>

</section>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>