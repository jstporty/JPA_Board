<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
	<div id="wrapper">
		<div id="title">
			<h1>게시글 상세</h1>
		</div>
		<div id="content" class="getBoard">
			<form action="/board/updateBoardProc" method="post">
				<input name="seq" type="hidden" value="${board.seq }" />
				<table>
					<colgroup>
						<col width="30%">
						<col width="70%">
					<tr>
						<td width="70">제목</td>
						<td align="left"><input name="title" type="text"
							value="${board.title }" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td class="alignLeft">${board.writer }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td class="alignLeft"><textarea name="content" cols="40"
								rows="10">${board.content }</textarea></td>
					</tr>
					<tr>
						<td>등록일</td>
						<td class="alignLeft"><fmt:formatDate
								value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td class="alignLeft">${board.cnt }</td>
					</tr>
					<tr>
						<td colspan="2" class=alignCenter><input type="submit"
							value="글 수정" /></td>
					</tr>
				</table>
			</form>
		</div>
		<a href="/board/insertBoard">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="/board/deleteBoard?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp; 
		<a href="/board/listBoard">글목록</a>
	</div>
</body>
</html>
