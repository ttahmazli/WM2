<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
import="java.util.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Don't Tell Me What to Do</title>
  </head>
  <style>
    body {
      background-image: url("http://localhost:8080/htmlredyellow.jpg");
      background-attachment: fixed;
      background-size: cover;
    }
    .center {
      text-align: center;
      border: 5px dashed white;
      font-size: 120px;
      font-family: Helvetica, sans-serif;
      color: white;
      padding: 50px;
      width: 50%;
      margin: auto;
    }
    span {
      display: inline-block;
      vertical-align: middle;
      line-height: normal;
    }
  </style>
  <body>
    <% Calendar calendar = GregorianCalendar.getInstance(); 
    String message = "";
    if(calendar.get(Calendar.HOUR_OF_DAY) < 12) message = "You need a breakfast!"; 
    else if(calendar.get(Calendar.HOUR_OF_DAY) >= 12 && calendar.get(Calendar.HOUR_OF_DAY) <= 16) message = "You need a lunch!";
    else if(calendar.get(Calendar.HOUR_OF_DAY) >= 16) message = "You need a dinner!";%>

    <div class="center">
      <span
        ><%= String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":" +
        String.valueOf(calendar.get(Calendar.MINUTE))%></span
      >
    </div>
    <div class="center">
      <span><%= message%></span>
    </div>
    <div class="center">
    <span
      ><a color="white" href="<%= request.getRequestURI() %>"
        >Try Again</a
      ></span>
      </div>
  </body>
</html>