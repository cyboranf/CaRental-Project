<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="appheader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">

        <form action="/app/car/add" method="post">
            <div class="mt-4 ml-4 mr-4">
                <div class="row border-bottom border-3">
                    <div class="col"><h3 class="color-header text-uppercase">New Car</h3></div>
                    <div class="col d-flex justify-content-end mb-2">
                        <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Save</button>
                    </div>
                </div>
                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Car Brand</th>
                        <td class="col-7">
                            <input name="brand" class="w-100 p-1" value="">
                        </td>
                    </tr>

                    <tr class="d-flex">
                        <th scope="row" class="col-2">Is Available</th>
                        <td class="col-3">
                            <input class="p-1" type="text" value="" name="isAvail">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row d-flex">
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Model
                       </h3></div>
                    <div class="col-2"></div>
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Type</h3></div>
                </div>
                <div class="row d-flex">
                    <div class="col-5 p-4">
                        <textarea class="w-100 p-1" rows="10" name="model"></textarea>
                    </div>
                    <div class="col-2"></div>

                    <div class="col-5 p-4">
                        <textarea class="w-100 p-1" rows="10" name="type"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="appfooter.jsp" %>


