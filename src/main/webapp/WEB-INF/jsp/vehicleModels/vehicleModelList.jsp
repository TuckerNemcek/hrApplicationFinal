<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicleModel_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <%--                LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Vehicle Model Name</th>
                    <th>Make Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicleModel" items="${listAllVehicleModels}">
                    <tr>
                        <td>${vehicleModel.vehicleModelName}</td>
                        <td>${vehicleModel.vehicleMake.vehicleMakeName}</td>
                            <%--                                Shouldn't I need to access the above with a getter? also why the fuck is it permanently gray?--%>
                        <td><a href="/vehicleModels/Edit/${vehicleModel.id}">Edit Model</a> </td>
                        <td><a href="/vehicleModels/Delete/${vehicleModel.id}">Delete Model</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>