<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberVO> memList =(List<MemberVO>)request.getAttribute("memList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<%
			int memSize = memList.size();
		if (memSize > 0) {
			for (MemberVO mv : memList) {
		%>
		<tr>
			<td><%=mv.getMemId()%></td>
			<td><%=mv.getMemName()%></td>
			<td><%=mv.getMemTel()%></td>
			<td><%=mv.getMemAddr()%></td>
		</tr>
		<%
			}
		} else {
		%>
		<tr>
			<td colspan="4">회원정보가 없습니다.</td>
		</tr>
		<%
			}
		%>
		<tr align="center">
			<td colspan="4"><a href="<%=request.getContextPath()%>/member/insert.do">[회원 등록]</a></td>
		</tr>
	</table>

</body>
</html>