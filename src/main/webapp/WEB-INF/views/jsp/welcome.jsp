<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC</title>
    <c:url var="home" value="/" scope="request"/>
    <spring:url value="/resources/core/css/demo.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/core/js/demo.js" var="coreJs"/>

    <script src="${bootstrapJs}"></script>
    <script src="${coreJs}"></script>

    <script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
    </script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6" style="text-align: center">
            <form:form id="regFormId" modelAttribute="userReg" action="registerProcess.html" method="post">
            	<marquee behavior="alternate" scrollamount="5">
					SPRING &nbsp;MVC&nbsp;AJAX&nbsp;Registarion</marquee>
         
                <table align="center" class="table table-striped">
                    <tr>
                        <td><form:label path="userName">Username</form:label></td>
                        <td><form:input path="userName" name="userName" id="usernameId"
                                        onblur="lookUpUserNameAvailable(userName)"  cssStyle="width:180px;"/>  </td>
                        <td><form:label path="label" id="userNameLabelID"></form:label></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="passWord">PassWord</form:label>
                        </td>
                        <td>
                            <form:password path="passWord" name="passWord" id="passWordId"  cssStyle="width:180px;"/>
                        </td>
                        <td><form:label path="label" id="userNameLabelID"></form:label></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="province">Select Province</form:label>
                        </td>
                        <td>
                            <form:select path="province" items="${userReg.provincesList}" id="provinceId"
                                         onchange="lookUpCapitalRegion(province)"
                                         cssStyle="width:180px;" name="province"/>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="capitalRegion">CapitalRegion</form:label>
                        </td>
                        <td>
                            <form:select path="capitalRegion" items="${userReg.capitalRegionList}" id="capitalRegionId"
                                         onchange="lookUpMajorCities(capitalRegion)"
                                         cssStyle="width:180px;" name="capitalRegion"/>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <td>
                        <form:label path="population">Population&Area  </form:label>
                    </td>
                    <td>
                        <form:input path="population" id="populationId" cssStyle="width: 100px;" readonly="true"/>
                        &nbsp;
                        <form:input path="area" id="areaId" cssStyle="width: 70px;" readonly="true"/>
                    </td>
                    <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="majorCitiesList">MajorCities</form:label>
                        </td>
                        <td>
                            <form:select path="majorCitiesList" items="${userReg.majorCitiesList}" id="majorCitiesId"
                                         cssStyle="width:180px;" multiple="true" name="majorCitiesList"/>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            &nbsp;&nbsp;
                        </td>
                        <td style="text-align: right">
                            <form:button id="registerId" name="register">Register</form:button>
                            <input type="button" id="resetId" onclick="refreshControl()" value="Reset"/>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
<footer style="text-align: center">
    <p>naveennnm01@gmail.com</p>
</footer>


</body>
</html>