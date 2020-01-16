<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="container">
    <div class="col-lg-8 col-md-7 col-sm-6">

        <form:form cssClass="form-horizontal" modelAttribute="vehicleMakeVO" action="/VehicleMakes" method="post">
            <fieldset>
                <legend>Manage Vehicle Models</legend>
                <div class="form-group">
                    <label for="inputNewVehicleMakeName" class="col-lg-2 control-label">Vehicle Model</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleMakeName" type="text" class="form-control" id="inputNewVehicleMakeName" placeholder="Vehicle Model"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleMakeCreateDate" class="col-lg-2 control-label">Date of Make (mm/dd/YYYY)</label>
                    <div class="col-lg-10">
                        <form:input path="newVehicleMakeCreateDate" type="date" class="form-control" rows="3" id="inputNewVehicleMakeCreateDate" pattern="YYYY-mm-dd" />
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

<%@include file="../includes/footer.jsp"%>