<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicleMake_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <c:set var="idx" value="0" scope="page"/>
           <form:form class="form-horizontal" modelAttribute="vehicleMakeVO" action="/VehicleMakes/Update" method="post">
                <form:hidden path="id" />
               ${vehicleMakeVO.newVehicleMakeName}
               ${vehicleMakeVO.id}
               <div class="row">
                   <div class="form-group">
                       <label for="inputVehicleMakeName" class="col-lg-2 control-label" >Vehicle Make Name</label>
                       <div class="col-sm-10">
                           <form:input path="newVehicleMakeName"  type="text" id="inputVehicleMakeName" cssClass="form-control" />
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
                            <label for="inputNewVehicleMakeCreateDate" class="col-lg-2 control-label">Date of Make (mm/dd/YYYY)</label>
                            <div class="col-lg-10">
                                <form:input path="newVehicleMakeCreateDate" type="date" class="form-control" rows="3" id="inputNewVehicleMakeCreateDate" pattern="YYYY-mm-dd" />
                            </div>
                        </div>
                   </div>

<%--               <div class="row">--%>
<%--                   <div class="form-group">--%>
<%--                       <label class="col-sm-3 control-label" for="inputVehicleMakeCreateDate">Vehicle Make Name</label>--%>
<%--                       <div class="col-sm-7">--%>
<%--                           <input type="text" class="form-control" name="inputNewVehicleMake" id="inputVehicleMakeCreateDate"/>--%>
<%--                       </div>--%>
<%--                   </div>--%>
<%--               </div>--%>

               <div class="row col-lg-offset-2">
                   <button class="btn btn-default">Update</button>
               </div>

           </form:form>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>