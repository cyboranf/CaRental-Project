
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="appheader2.jsp"%>
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
