<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
<%@include file="vehicleMake_sidebar.jsp" %>

        <div id="main-wrapper" class="col-mid-11">
            <div class="col-lg-8 col-md-7 col-sm-6">

                <h2>Vehicle Makes</h2>

<%--                LIST OF EXISTING ELEMENTS--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Vehicle Make Name</th>
                        <th>Date Acquired</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vehicleMake" items="${listAllVehicleMakes}">
                            <tr>
                                <td>${vehicleMake.vehicleMakeName}</td>
                                <td>${vehicleMake.createDate}</td>
<%--                                Shouldn't I need to access the above with a getter? also why the fuck is it permanently gray?--%>
                                <td><a href="/VehicleMakes/Edit/${vehicleMake.id}">Edit</a> </td>
                                <td><a href="/VehicleMakes/Delete/${vehicleMake.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
</div>

<%@include file="../includes/footer.jsp"%>