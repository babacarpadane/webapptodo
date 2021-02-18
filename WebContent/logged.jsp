<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci le attività da svolgere</title>
</head>
<body>
     <h4>Utente loggato: ${logged_user}</h4>
     
     <form name="insert activity" method="GET">
           <div>Inserisci attività o promemoria:</div>
           <div><input type="text" name="todo_phrase" size="40px"> 
           <input type="submit" value="inserisci" formaction="insert"></div>
     </form>
     
     <p>Numero di frasi inserite: ${numero_frasi}</p>
   
      <form name="check activity" method="GET">
        <c:forEach items = "${activity_map }" var="activity">
              <div>
                <c:choose> 
                    <c:when test="${activity.value.checked}">
                         <input type="checkbox" name="${activity.key}" checked>
                    </c:when>
                    <c:otherwise>
                         <input type="checkbox" name="${activity.key}">
                    </c:otherwise>
                </c:choose>
                    ${activity.value.description}                 
                    <a href="/webAppToDo/remove?code_to_remove=${activity.key}">Elimina</a>
               </div>
        </c:forEach> <br>
        <div> <input type="submit" value="completa i selezionati" formaction="/webAppToDo/complete"> </div>
     </form>      
           
     <form name="logout" method="GET"> 
         <p> <input type="submit" value="logout" formaction="logout"> </p> 
     </form>
</body>
</html>