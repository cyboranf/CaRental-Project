<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="appheader.jsp" %>

<div class="m-4 p-3 width-medium">

  <div class="dashboard-content border-dashed p-3 m-4 view-height">

    <div class="row border-bottom border-3 p-1 m-1">
      <div class="col noPadding"><h3 class="color-header text-uppercase">List of Cars available to rent</h3></div>

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
          <td class="col-2"><${car.brand}</td>
          <td class="col-7">${car.model}, ${car.type}</td>
          <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
            <a href="/app/car/details?id=${car.id}" class="btn btn-info rounded-0 text-light m-1">Details</a>
            <a href="/app/car/edit?id=${car.id}" class="btn btn-warning rounded-0 text-light m-1">Rent</a>
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