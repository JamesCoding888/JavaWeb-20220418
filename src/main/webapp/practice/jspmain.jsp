<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>      

<%!
	int count=0;
	String message = "";
	public class RandomNumberGenerator{		
		public int random(){
			count = new Random().nextInt(10)+1;
			if(count == 5){		
				message = "die";				
			}
			return count;		
		}
		
	}
	
	class getNumber{	
		int get(){
			return new RandomNumberGenerator().random();			
		}
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="1">  <!-- 每一秒更新一次 -->
<meta charset="UTF-8">
<title>JSP Test</title>
</head>
<body>
The random number is <%=new getNumber().get() %>
<hr> 
You catch a bad luck number, then <%=message %> 
</body>
</html>