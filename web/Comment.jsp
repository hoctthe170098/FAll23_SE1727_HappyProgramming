<%-- 
    Document   : Comment
    Created on : Sep 28, 2023, 12:30:07 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment</title>
        <script type ="text/javascript ">
            function content(){
                 var xhttp;
            var username = document.myform.Username.value;
            var content = document.myform.Content.value;
            var url = "CommentController?Content="+content+"&Username"+username;
            
            if (window.XMLHttpRequest)
            {
                xhttp = new XMLHttpRequest();
            } else{
                xhttp = new AtiveXObject("Microsoft.XMLHTTP");
            }
            
            
            xhttp.onreadystatachange = function(){
                if(xhttp.readyState == 4)
                {
                     var data = xhttp.responseText;
                document.getElementById(" ").innerHTML = data;
                }
               
            }
            xhttp.open("POST",url,true);
            http.send();
            }
           
        </script>

    </head>
    <body>
        <form action="myform">
            Username: <input type="text" name="Username"/>
            <br/>
            <br/>
            <textarea style="width: 300px; height: 100px " name="Content">
                
            </textarea>
            <br/> 
            <br/> 
            <input type="button" value="Post" onclick=""/>

        </form>
        <div id="mycomment">
            
        </div>
    </body>
</html>
