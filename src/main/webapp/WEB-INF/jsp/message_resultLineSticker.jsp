<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>Message Result</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" action="/JavaWeb-20220418/html/message_form_linesticker.html" method="get">
		<fieldset>
			<legend>Message Result:</legend>
			<h1>Message result:</h1>			
			<h2>content: ${ content }</h2>
			貼圖: <img src="https://stickershop.line-scdn.net/stickershop/v1/sticker/${ stickerId }/android/sticker.png"><p />
			網路圖片: <img src="${ webImageUrl }"><p />
			<h2>httpCode: ${ httpCode }</h2>
			<button type="submit" class="pure-button pure-button-primary">
				返回
			</button>			
		</fieldset>	
	</form>	
</body>
</html>