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
<link rel="stylesheet" type="text/css" href="<%=basePath%>/detail/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="<%=basePath%>/detail/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="../Dishes/getDishes.do" method=POST>
			<input type="hidden" name="method" value="search">
			<input type="text" name="name" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		  <c:forEach items="${page.datas }" var="Dishes">
					<tr align="center" valign="middle" id="TableTitle">
						<td class="td07">${Dishes.ID }</td>
						<td class="td07">${Dishes.dishesname }</td>
						<td class="td07">${Dishes.theircuisine }</td>
					    <td class="td07">${Dishes.price }</td>
					    <td class="td07">${Dishes.vipprice }</td>
						<td class="td07"><a href="../Dishes/getONEDishes.do?id=${Dishes.ID}" class="FunctionButton">更新</a>
  							  <a href="../Dishes/deleteDishes.do?id=${Dishes.ID}" class="FunctionButton">删除</a>
 						</td>
					</tr>
				</c:forEach> 
        </tbody>
        					<tr align="center" valign="middle" id="TableTitle">
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
	        <a href="../Dishes/DishesManage.do?pageno=${page.pageno + 1 }">下一页</a>　 
	        <img src="<%=basePath%>/detail/style/images//3.gif" width="4" height="5" align="absmiddle">
	         <a href="../Dishes/DishesManage.do?pageno=${page.totalPages }">末页</a>　
	             　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:when>
      	<%-- 当前页为最后一页的情况 --%>
      	<c:when test="${page.pageno == page.totalPages }">
	      <tr>
	        <td colspan="5" align="left" class="td07"><img src="<%=basePath%>/detail/style/images/1.gif" width="4" height="5" align="absmiddle">
	         <a href="../Dishes/DishesManage.do?pageno=1">首页</a>　
	          <img src="<%=basePath%>/detail/style/images/2.gif" width="3" height="5" align="absmiddle"> 
	          <a href="../Dishes/DishesManage.do?pageno=${page.pageno - 1 }">上一页</a>　
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
	        <a href="../Dishes/DishesManage.do?pageno=1">首页</a>　
	         <img src="<%=basePath%>/detail/style/images/2.gif" width="3" height="5" align="absmiddle"> 
	         <a href="../Dishes/DishesManage.do?pageno=${page.pageno - 1 }">上一页</a>　
	          <img src="<%=basePath%>/detail/style/images/2-2.gif" width="3" height="5" align="absmiddle">
	           <a href="../Dishes/DishesManage.do?pageno=${page.pageno + 1 }">下一页</a>
	           　 <img src="<%=basePath%>/detail/style/images/3.gif" width="4" height="5" align="absmiddle">
	            <a href="../Dishes/DishesManage.do?pageno=${page.totalPages }">末页</a>
	            　　共 ${page.pageno }/${page.totalPages } 页 ${page.totalRows } 条记录</td>
	      </tr>
      	</c:otherwise>
      </c:choose>
      	</tr>
      	<h1>${deleteDishesfalg}</h1>
        <h1>${errorMSG}</h1>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="../Dishes/getCuisine.do" >添加</a></div>
    </div> 
</div>
</body>
</html>
