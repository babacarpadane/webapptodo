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
     
     <form name="login credentials" method="GET">
           Inserisci attività o promemoria:<br>
           <input type="text" name="todo_phrase" size="40px"> 
           <input type="submit" name="add_phrase" value="inserisci" formaction="insert">
     </form>
     
     <p>Numero di frasi inserite: ${numero_frasi}</p>
     
           <c:forEach items = "${activity_map}" var="activity">
           <input type="checkbox" name="check"> ${activity}<br>
           </c:forEach>
           
     <form name="logout" method="GET"> 
           <p> Inserisci codice dell'attività che vuoi rimuovere<br>
               <input type="text" name="code_remove" size="20px"> 
               <input type="submit" name="code_to_remove" value="rimuovi" formaction="remove"> </p> 
     </form>
           
     <form name="logout" method="GET"> 
           <p> <input type="submit" name="logout" value="logout" formaction="logout"> </p> 
     </form>
     

</body>
</html>