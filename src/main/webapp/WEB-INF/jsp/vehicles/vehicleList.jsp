<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <h2>Vehicles</h2>


        <%--                LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>License Plate</th>
                    <th>Color</th>
                    <th>VIN number</th>
                    <th>Year Acquired</th>
                    <th>Model</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${listAllVehicles}">
                    <tr>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.color}</td>
                        <td>${vehicle.vin}</td>
                        <td>${vehicle.yearProduced}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>

                        <td><a href="/Vehicles/Edit/${vehicle.id}">Edit</a> </td>
                        <td><a href="/Vehicles/Delete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>