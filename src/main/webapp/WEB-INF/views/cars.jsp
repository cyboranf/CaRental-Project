
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<div class="m-4 p-3 width-medium">

  <div class="dashboard-content border-dashed p-3 m-4 view-height">

    <div class="row border-bottom border-3 p-1 m-1">
      <div class="col noPadding"><h3 class="color-header text-uppercase">Car List</h3></div>
      <div class="col noPadding d-flex justify-content-end mb-2"><a href="/login"
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
          </td>
        </tr>

      </c:forEach>


      </tbody>
    </table>
  </div>
</div>

</section>
<section class="padding-large bg-light">
  <div id="carouselExampleControls" class="carousel slide main-slider" data-ride="carousel">
    <div class="carousel-inner container">
      <div class="carousel-item active">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/BMW-5.jpg"/>" alt="" width="600" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/Audi-Q8.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/Porsche-911-Carrera.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/tesla-S.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/Gla.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/RangeRover.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/MercedesS.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/css/images/LucidAir.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
    </div>

    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</section>
<%@include file="footer.jsp"%>