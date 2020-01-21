<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <c:set var="idx" value="0" scope="page"/>
            <form:form class="form-horizontal" modelAttribute="vehicleVO" action="/Vehicles/Update" method="post">
                <form:hidden path="id" />

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleLicensePlate" class="col-lg-2 control-label" >License Plate</label>
                        <div class="col-sm-10">
                            <form:input path="licensePlate"  type="text" id="inputVehicleLicensePlate" cssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleYearProduced" class="col-lg-2 control-label" >Year Acquired</label>
                        <div class="col-sm-10">
                            <form:input path="YearProduced"  type="text" id="inputVehicleYearProduced" cssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleVIN" class="col-lg-2 control-label" >VIN Number</label>
                        <div class="col-sm-10">
                            <form:input path="Vin"  type="text" id="inputVehicleVIN" cssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleColor" class="col-lg-2 control-label" >Color</label>
                        <div class="col-sm-10">
                            <form:input path="Color"  type="text" id="inputVehicleColor" cssClass="form-control" />
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleModel" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10 col-lg-offset-2 blackText">
                            <form:select path="vehicleModel">
                                <c:forEach items="${vehicleModelList}" var="vehicleModel">
                                    <form:option id="inputVehicleModel" value="${vehicleModel.id}">${vehicleModel.vehicleModelName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                </div>



                <div class="row col-lg-offset-2">
                    <button class="btn btn-default">Update</button>
                </div>

            </form:form>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>