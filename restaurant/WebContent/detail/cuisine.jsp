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
<meta http-equiv="Content-Type" content="/text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/detail/style/js/page_common.js"></script>
<link href="<%=basePath%>/detail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="/text/css" href="<%=basePath%>/detail/style/css/index_1.css" />
</head>
<body>
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="<%=basePath%>/detail/style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
		 <c:forEach items="${cuisine}" var="o" varStatus="status">
                        <tr align="center" valign="middle" id="TableTitle">
							<td class="td07">${o.ID}</td>
							<td class="td07">${o.cuisinename}</td>
							<td class="td07"><a href="../Cuisine/getONECuisine.do?id=${o.ID}" class="FunctionButton">更新</a>
	  							  <a href="../Cuisine/deleteCuisine.do?id=${o.ID}" class="FunctionButton">删除</a>
	 						</td>
						</tr>                   
		</c:forEach> 
			</tbody>
      	<h1>${deleteCuisinefalg}</h1>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="<%=basePath%>/detail/saveCuisine.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
