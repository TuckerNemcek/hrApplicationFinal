<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicleModel_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <c:set var="idx" value="0" scope="page"/>
            <form:form class="form-horizontal" modelAttribute="vehicleModelVO" action="/VehicleModels/Update" method="post">
                <form:hidden path="id" />
                ${vehicleMakeVO.newVehicleMakeName}
                ${vehicleMakeVO.id}
                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleModelName" class="col-lg-2 control-label" >Vehicle Model Name</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleModelName"  type="text" id="inputVehicleModelName" cssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleMake" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10 col-lg-offset-2 blackText">
                            <form:select path="vehicleMake">
                                <c:forEach items="${vehicleMakeList}" var="vehicleMake">
                                    <form:option id="inputVehicleMake" value="${vehicleMake.id}">${vehicleMake.vehicleMakeName}</form:option>
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