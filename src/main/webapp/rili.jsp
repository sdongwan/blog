<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%
    String[] weekdays={"","日","一","二","三","四","五","六"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
        days[i]="";

    GregorianCalendar currentDay = new GregorianCalendar();
    int year= currentDay.get(Calendar.YEAR);
    int month=currentDay.get(Calendar.MONTH);
    int today=currentDay.get(Calendar.DAY_OF_MONTH);
    int weekday=currentDay.get(Calendar.DAY_OF_WEEK);

    String now=year+"年"+(month+1)+"月"+today+"日"+" 星期"+weekdays[weekday];

    Calendar thisMonth=Calendar.getInstance();
    thisMonth.set(Calendar.MONTH, month );
    thisMonth.set(Calendar.YEAR, year );
    thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
    thisMonth.set(Calendar.DAY_OF_MONTH,1);

    int firstIndex=thisMonth.get(Calendar.DAY_OF_WEEK)-1;
    int maxIndex=thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
    for(int i=0;i<maxIndex;i++){
        days[firstIndex+i]=String.valueOf(i+1);
    }
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<table width="210" border="0" align="center" cellspacing="1" >
    <tr height="25" bgcolor="#F0F0F0" align="center" style="font-size: 12px;">
        <td style="border:1 solid">日</td>
        <td style="border:1 solid">一</td>
        <td style="border:1 solid">二</td>
        <td style="border:1 solid">三</td>
        <td style="border:1 solid">四</td>
        <td style="border:1 solid">五</td>
        <td style="border:1 solid">六</td>
    </tr>
    <tr height="4"><td colspan="7"></td></tr>
    <% for(int j=0;j<6;j++) { %>
    <tr style="font-size: 12px;">
        <%
            for(int i=j*7;i<(j+1)*7;i++) {
                if((i-firstIndex+1)==today){%>
        <td width="30" height="23" align="center" bgcolor="gray" style="border:1 solid"><font color="#FFFFFF"><b><%=days[i]%></b></font></td>
        <%    }else{ %>
        <td width="30" height="23" align="center" style="border:1 solid"><%=days[i]%></td>
        <%    }
        }%>
    </tr>
    <% } %>
</table>
</body>
</html>
