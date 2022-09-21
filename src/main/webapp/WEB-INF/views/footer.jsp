<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

  <link rel="stylesheet" href='<c:url value='/views/css/style.css'/>'>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-around">
    <a href="/" class="navbar-brand main-logo">
      Ca<span>Rental</span>
    </a>
    <ul class="nav nounderline text-uppercase">
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="/login">sign in</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="/register">sign up</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link" href="#about">about app</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link disabled" href="../toChangeHTMLs/recipes.html">cars</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link disabled" href="#contact">contact</a>
      </li>
    </ul>
  </nav>
</header>

<section class="padding-large bg-light">
  <div id="carouselExampleControls" class="carousel slide main-slider" data-ride="carousel">
    <div class="carousel-inner container">
      <div class="carousel-item active">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/views/css/images/BMW-5.jpg"/>" alt="" width="600" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/views/css/images/Audi-Q8.jpg"/>" alt="" width="800" height="459">
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container w-75 d-flex">
          <div class="carousel-caption d-block">
            <img src="<c:url value="/views/css/images/Porsche-911-Carrera.jpg"/>" alt="" width="800" height="459">
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

<section class="section-more padding-small">
  <div class="container d-flex justify-content-between">
    <div class="mr-4">
      <h1 class="pb-3">You can make your dreams come true </h1>
      <h4 class="pt-1">Book your dream car and enjoy life!</h4>
    </div>
    <div class="ml-4 align-self-center">
      <button class="btn btn-color rounded-0 mt-4 pl-4 pr-4">
        <a href="/login">Book a car</a>
      </button>
    </div>
  </div>
</section>
<footer class="footer-section pt-3 pb-3">
  <div class="container text-center">
    <h5 class="text-light">Copyright <span class="footer-text-color">CaRental.pl</span></h5>
  </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

</body>
</html>
