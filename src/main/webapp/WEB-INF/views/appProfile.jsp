<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>CaRental</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">

    <link rel="stylesheet" href='<c:url value='/css/style.css'/>'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/app/dashboard" class="navbar-brand main-logo">
            Ca<span>Rental</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/app/avail/cars">Available Cars</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/app/car/list">All Cars</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="">Your Profile: </a>
            </li>
            <li class="nav-item ml-4">
                <h4 class="text-light mr-3" href=""> ${cookie.cookieName.value}</h4>

            </li>
            <li class="nav-item ml-4">
                <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
            </li>

        </ul>
    </nav>
</header>
<div class="m-4 p-3 width-medium">

    <div class="dashboard-content border-dashed p-3 m-4 view-height">

        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding"><h3 class="color-header text-uppercase">Your Rents Car</h3></div>
            <div class="col noPadding d-flex justify-content-end mb-2"><a href="/app/profile/history/${cookie.cookieUserID.value}"
                                                                          class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">
                Rents History</a></div>
        </div>

        <table class="table border-bottom schedules-content">
            <thead>
            <tr class="d-flex text-color-darker">
                <th scope="col" class="col-1">ID</th>
                <th scope="col" class="col-2">BRAND</th>
                <th scope="col" class="col-2">MODEL</th>
                <th scope="col" class="col-2">Type</th>
                <th scope="col" class="col-2">Access Key</th>
                <th scope="col" class="col-2">Due To</th>
                <th scope="col" class="col-1">Price</th>
            </tr>
            </thead>


            <tbody class="text-color-lighter">


            <c:forEach items="${rentedCar}"  var="rentedCar" >
                <tr class="d-flex">
                        <%--                    id--%>
                    <td class="col-1">${rentedCar.carId}</td>
                        <%--                    brand--%>
                    <td class="col-2">${rentedCar.carBrand}</td>
                        <%--                    model--%>
                    <td class="col-2">${rentedCar.carModel}</td>
                        <%--                    type--%>
                    <td class="col-2">${rentedCar.carType}</td>
                        <%--                    access key--%>
                    <td class="col-2">${rentedCar.accessKey}</td>
                        <%--                    date--%>
                    <td class="col-2">${rentedCar.date} (${rentedCar.time})</td>
                        <%--    cost--%>
                    <td class="col-1">${rentedCar.price}</td>
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