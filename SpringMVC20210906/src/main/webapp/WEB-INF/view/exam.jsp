<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exam Crud</title>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
</head>
<body style ="padding: 15px;">
	<table border="0">
		<tr>
			<!-- 表單資料處Crud -->
			<td valign="top">
				<form:form modelAttribute="exam" 
						   class="pure-form" 
						   method="post" 
						   action="${ pageContext.request.contextPath }/mvc/exam/${ action }" >
					<fieldset>
						<legend>Exam Post 考試註冊</legend>
						學員編號：<form:input path="id" placeholder="請輸入學員編號"/>
						<p/>
						考試代號：<form:select path="name">
									<form:option value="">請選擇</form:option>
									<form:option value="808">OCP I 808</form:option>
									<form:option value="809">OCP II 809</form:option>
									<form:option value="900">OCAD 900</form:option>
								</form:select> <p/>
						考試時段（可複選）
						<form:checkbox path="slot" value="A"/> 上午(A)
						<form:checkbox path="slot" value="B"/> 下午(B)
						<form:checkbox path="slot" value="C"/> 晚上(C)
						<p/>
						繳費狀況：
						<form:radiobutton path="pay" value="true"/>已繳
						<form:radiobutton path="pay" value="false"/>未繳 
						<p/>
						備註：
						<form:textarea path="note"/>
						<p/>
						<button type="submit" class="pure-button pure-button-primary">${ action }</button>
						<button type="reset" class="pure-button pure-button-primary">reset</button>						
					</fieldset>				
				</form:form>
				
				<!-- 資料呈現 -->
				<table class="pure-table pure-table-bordered" >
					<thead>
						<tr>
							<th>id</th>
							<th>exam</th>
							<th>slot</th>
							<th>pay</th>
							<th>note</th>
							<th>edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${ exams }" >
						<tr>
							<th>${ e.id }</th>
							<th>${ e.name }</th>
							<th>${ e.slotToString }</th>
							<th>${ e.pay }</th>
							<th>${ e.note }</th>
							<th>
								<button type="button"
										onclick="location.href='${ pageContext.request.contextPath }/mvc/exam/get/${e.id}'"
										class="pure-button pure-button-primary">
								edit
								</button>
							</th>

						</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			
			<!-- 資料統計圖 -->
			<td valign="top">
			</td>
			
		</tr>
	</table>
</body>
</html>