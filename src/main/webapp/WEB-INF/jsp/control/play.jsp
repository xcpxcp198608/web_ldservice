<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<rapid:override name="title">
    Play
</rapid:override>
<rapid:override name="css/js">

</rapid:override>


<rapid:override name="content">

    <div style="clear: both; margin-top: 5px; box-shadow: 0 0 5px #000;">
        <table class="table table-bordered table-hover table-striped table-condensed"
               id="tbDevices">
            <thead style="background-color: #566778;">
            <tr id="trSales">
                <th></th>
                <th>#</th>
                <th>MAC</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${controlPlayInfoList}" var="controlPlayInfo" varStatus="status">
                <tr>
                    <td><input type="radio" name="update" value="${controlPlayInfo.id}" currentRow="${status.index}"></td>
                    <td>${status.index+1}</td>
                    <td>${controlPlayInfo.mac}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</rapid:override>


<%@ include file="../base.jsp"%>