<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@include file="vehicleMake_sidebar.jsp" %>

    <div id="main-wrapper" class="col-mid-11">
        <div class="col-lg-8 col-md-7 col-sm-6">

            <c:set var="idx" value="0" scope="page"/>
           <form:form class="form-horizontal" modelAttribute="vehicleMake" action="/VehicleMakes/Edit" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
               ${vehicleMake.vehicleMakeName}
<%--               {{vehicleMake.id}}--%>
               <div class="row">
                   <div class="form-group">
                       <label for="inputVehicleMakeName" class="col-lg-2 control-label" >Vehicle Make Name</label>
                       <div class="col-sm-10">
                           <form:input path="vehicleMakeName"  type="text" id="inputVehicleMakeName" cssClass="form-control" />
                       </div>
                   </div>
               </div>

               <div class="row">
                   <div class="col-sm-10">
                       <hr>
                   </div>
               </div>

<%--                   <div class="row">--%>
<%--                        <div class="form-group">--%>
<%--                            <label class="col-sm-3 control-label" for="inputVehicleMakeName">Vehicle Make Name</label>--%>
<%--                            <div class="col-sm-7">--%>
<%--                                <div class="input-group">--%>
<%--                                    <form:input path="vehicleMake.vehicleMakeName"  cssClass="form-control" />--%>
<%--                                        <span class="input-group-btn">--%>
<%--                                            <button name="${idx}" class="btn btn-default remove button" type="button">Remove</button>--%>
<%--                                        </span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                   </div>--%>

               <div class="row">
                   <div class="form-group">
                       <label class="col-sm-3 control-label" for="inputVehicleMakeCreateDate">Vehicle Make Name</label>
                       <div class="col-sm-7">
                           <input type="text" class="form-control" name="inputNewVehicleMake" id="inputVehicleMakeCreateDate"/>
                       </div>
                   </div>
               </div>

               <div class="row">
                   <button class="btn btn-primary">Update</button>
               </div>

           </form:form>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>