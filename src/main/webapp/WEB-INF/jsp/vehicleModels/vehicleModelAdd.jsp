<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicleModel_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">

        <div class="col-lg-8 col-md-7 col-sm-6">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleModelVO" action="/VehicleModels/Add" method="post">
                <fieldset>
                    <legend>Add a Vehicle Model</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleModelName" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleModelName" type="text" class="form-control blackText" id="inputNewVehicleModelName" placeholder="Vehicle Model"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVehicleMake"></label>
                        <div class="col-lg-10 col-lg-offset-2 blackText">
                            <form:select path="vehicleMake">
                                <c:forEach items="${vehicleMakeList}" var="vehicleMake">
                                    <form:options id="inputVehicleMake" value="${vehicleMake.id}">${vehicleMake.vehicleMakeName}</form:options>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>
    </div>

</div>

<%@include file="../includes/footer.jsp"%>