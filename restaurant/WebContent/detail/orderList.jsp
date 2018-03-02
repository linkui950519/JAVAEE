<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
System.out.print(basePath);


%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/detail/style/js/page_common.js"></script>
<link href="<%=basePath%>/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="<%=basePath%>/detail/stylesheet" type="text/css" href="<%=basePath%>/detail/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "/wirelessplatform/client.html?method=list";
		},1000 * 50);
	</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="<%=basePath%>/detail/style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单人</td>
					<td>联系电话</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				  <c:forEach items="${page.datas }" var="Preorder">
					<tr align="center" valign="middle" id="TableTitle">
						<td class="td07">${Preorder.ID }</td>
						<td class="td07">${Preorder.tablename }</td>
					 	<td class="td07">${Preorder.ordername }</td>
				        <td class="td07">${Preorder.mobile }</td>
			          	<td class="td07">${Preorder.ordertime }</td>
		    			<td class="td07">${Preorder.countprice }</td>
		    			
		    			<c:if test="${Preorder.flag == '0'}">
		    			<td class="td07">未结账</td>
		    			</c:if>	
            			
						<c:if test="${Preorder.flag == '1'}">
		    			<td class="td07">已结账</td>
		    			</c:if>	
						<%-- <td class="td07"><a href="../Cuisine/getONECuisine.do?id=${Cuisine.ID}" class="FunctionButton">更新</a>
  							  <a href="../Cuisine/deleteCuisine.do?id=${Cuisine.ID}" onClick="return delConfirm();" class="FunctionButton">删除</a>
 						</td> --%>
 					<td>
							<a href="../Orderdetails/OrderdetailsManage.do?ipreorderID=${Preorder.ID }" class="FunctionButton">详细</a> 
				 			<a href="../Preorder/updatePreorder.do?id=${Preorder.ID }" onClick="return Confirm();"  class="FunctionButton">结账</a>
				 		</td>	
					</tr>
				</c:forEach> 
			</tbody>
		 <c:choose>
      	<%-- 共计一页的情况 --%>
      	<c:when test="${page.totalPages == 1 }">
	      <tr>
	        <td colspan="5" align="left" class="td07"><img src="<%=basePath%>/detail/style/images/1.gif" 
	        width="4" height="5" align="absmiddle"> 首页　
	         <img src="<%=basePath%>/detail/style/images//2.gif" width="3" height="5" align="absmiddle"> 上一页　
	          <img src="<%=basePath%>/detail/style/images//2-2.gif" width="3" height="5" align="absmiddle"> 下一页
	          　 <img src="<%=basePath%>/detail/style/images//3.gif" width="4" height="5" align="absmiddle">
	                  末页　　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:when>
      	<%-- 当前页为第一页的情况 --%>
      	<c:when test="${page.pageno == 1 }">
	      <tr>
	        <td colspan="5" align="left" class="td07">
	        <img src="<%=basePath%>/detail/style/images/1.gif" width="4" height="5" align="absmiddle"> 首页
	        　 <img src="<%=basePath%>/detail/style/images//2.gif" width="3" height="5" align="absmiddle"> 上一页　 
	        <img src="<%=basePath%>/detail/style/images//2-2.gif" width="3" height="5" align="absmiddle"> 
	        <a href="../Preorder/PreorderManage.do?pageno=${page.pageno + 1 }">下一页</a>　 
	        <img src="<%=basePath%>/detail/style/images//3.gif" width="4" height="5" align="absmiddle">
	         <a href="../Preorder/PreorderManage.do?pageno=${page.totalPages }">末页</a>　
	             　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:when>
      	<%-- 当前页为最后一页的情况 --%>
      	<c:when test="${page.pageno == page.totalPages }">
	      <tr>
	        <td colspan="5" align="left" class="td07"><img src="<%=basePath%>/detail/style/images/1.gif" width="4" height="5" align="absmiddle">
	         <a href="../Preorder/PreorderManage.do?pageno=1">首页</a>　
	          <img src="<%=basePath%>/detail/style/images/2.gif" width="3" height="5" align="absmiddle"> 
	          <a href="../Preorder/PreorderManage.do?pageno=${page.pageno - 1 }">上一页</a>　
	           <img src="<%=basePath%>/detail/style/images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　
	            <img src="<%=basePath%>/detail/style/images/3.gif" width="4" height="5" 
	            align="absmiddle"> 末页　　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:when>
      	<%-- 当前页为中间页的情况 --%>
      	<c:otherwise>
	      <tr>
	        <td colspan="5" align="left" class="td07">
	        <img src="<%=basePath%>/detail/style/images/1.gif" width="4" height="5" align="absmiddle"> 
	        <a href="../Preorder/PreorderManage.do?pageno=1">首页</a>　
	         <img src="<%=basePath%>/detail/style/images/2.gif" width="3" height="5" align="absmiddle"> 
	         <a href="../Preorder/PreorderManage.do?pageno=${page.pageno - 1 }">上一页</a>　
	          <img src="<%=basePath%>/detail/style/images/2-2.gif" width="3" height="5" align="absmiddle">
	           <a href="../Preorder/PreorderManage.do?pageno=${page.pageno + 1 }">下一页</a>
	           　 <img src="<%=basePath%>/detail/style/images/3.gif" width="4" height="5" align="absmiddle">
	            <a href="../Preorder/PreorderManage.do?pageno=${page.totalPages }">末页</a>
	            　　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:otherwise>
      </c:choose>				 
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
					<h7>以上数据来源为模拟前端系统的传输，在该系统中不做增加数据的处理！</h7>	
		</div>
	</div>
</body>
</html>
