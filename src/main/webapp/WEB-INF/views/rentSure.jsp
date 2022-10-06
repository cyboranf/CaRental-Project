<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="appheader.jsp" %>

<div class="m-4 p-4 border-dashed">
  <h1><span>Are you sure you want to rent this car?</span></h1>
  <h2 class="dashboard-content-title">
    <span>Car ID:</span> ${id}
  </h2>
  <%--    car--%>
  <h2 class="dashboard-content-title">
    <span>Brand and Model</span> ${brandd} ${model}
  </h2>
  <h2 class="dashboard-content-title">
    <span> Fuel Type: </span> ${fuelType}
  </h2>
  <h2 class="dashboard-content-title">
    <span> Package Name: </span>${packageName}
  </h2>
  <h2 class="dashboard-content-title">
    <span> Power: </span>${power}
  </h2>
  <h2 class="dashboard-content-title">
    <span>Price for hour:</span> ${pph}
  </h2>
  <h2 class="dashboard-content-title">
    <span>Price for day:</span> ${ppd}
  </h2>
  <form class="padding-small text-center" method="post">
    <h1 class="text-color-darker">How long would you like to rent for</h1>
    <div class="form-group">
      <input type="text" class="form-control" id="days" name="days" placeholder="days">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="hours" name="hours" placeholder="hours">
    </div>
   <button class="btn btn-color rounded-0" type="submit">Confirm</button>
  </form>
</div>
<a href="/app/profile/${cookie.car.value}/${cookie.cookieName.value}?days=${d}&hours=${h}" class="btn btn-warning rounded-0 text-light m-1"><span>Yes</span></a>
<a href="/app/rentCar" class="btn btn-warning rounded-0 text-light m-1"><span>No</span></a>
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