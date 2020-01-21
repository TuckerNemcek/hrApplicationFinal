<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">

        <div class="col-lg-8 col-md-7 col-sm-6">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/Vehicles/Add" method="post">
                <fieldset>
                    <legend>Add a Vehicle</legend>
                    <div class="form-group">
                        <label for="inputLicensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="licensePlate" type="text" class="form-control" id="inputLicensePlate" placeholder="LicensePlate"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleCreateDate" class="col-lg-2 control-label">Date added to fleet (mm/dd/YYYY)</label>
                        <div class="col-lg-10">
                            <form:input path="YearProduced" type="date" class="form-control" rows="3" id="inputNewVehicleCreateDate" pattern="YYYY-mm-dd" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVin" class="col-lg-2 control-label">VIN number</label>
                        <div class="col-lg-10">
                            <form:input path="Vin" type="text" class="form-control" id="inputVin" placeholder="VIN"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputColor" class="col-lg-2 control-label">Color</label>
                        <div class="col-lg-10">
                            <form:input path="Color" type="text" class="form-control" id="inputColor" placeholder="Color"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="inputVehicleModel"></label>
                        <div class="col-lg-10 col-lg-offset-2 blackText">
                            <form:select path="vehicleModel">
                                <c:forEach items="${vehicleModelList}" var="model">
                                    <form:option id="inputVehicleModel" value="${model.id}">${model.vehicleModelName}</form:option>
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