<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Random r = new Random();
	int work = r.nextInt(10);
	int eat = r.nextInt(10);
	int commute = r.nextInt(10);
	int watchTV = r.nextInt(10);
	int sleep = r.nextInt(10);
	int coding = r.nextInt(10);
	int w = 300;
	int h = 150;
%>
<html>
  <head>
  	<meta http-equiv="refresh" content="1">  <!-- 每一秒更新一次 -->
  	<!--將 google 的 loader 內容存放到 loader.js --> 
  	<!-- <script type="text/javascript" src="http://localhost:8080/JavaWeb-20220418/jsp/loader.js"></script> -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     <%=work %>],
          ['Eat',      <%=eat %>],
          ['Commute',  <%=commute %>],
          ['Watch TV', <%=watchTV %>],
          ['Sleep',    <%=sleep %>],
          ['Coding',   <%=coding %>]
        ]);
        var options = {
          title: 'My Daily Activities',
          is3D: true
        };
        var piechart = new google.visualization.PieChart(document.getElementById('piechart'));
        var linechart = new google.visualization.LineChart(document.getElementById('linechart'));
        var columnchart = new google.visualization.ColumnChart(document.getElementById('columnchart'));
        var barchart = new google.visualization.BarChart(document.getElementById('barchart'));
        
        piechart.draw(data, options);
        linechart.draw(data, options);
        columnchart.draw(data, options);
        barchart.draw(data, options);
        
      }
    </script>
  </head>
  <body>
    <table width="50%">
    	<tr>
    		<td width="50%">
    			<div id="piechart" style="width: <%=w %>px; height: <%=h %>px;"></div>
    		</td>
    		<td width="50%">
    			<div id="linechart" style="width: <%=w %>px; height: <%=h %>px;"></div>
    		</td>
    	</tr>
    	<tr>
    		<td width="50%">
    			<div id="columnchart" style="width: <%=w %>px; height: <%=h %>px;"></div>
    		</td>
    		<td width="50%">
    			<div id="barchart" style="width: <%=w %>px; height: <%=h %>px;"></div>
    		</td>
    	</tr>
    </table>
    
  </body>
</html>