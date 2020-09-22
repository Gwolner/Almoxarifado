<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <script>
            
            var modal = document.getElementById("modal");
                      
            var modal2 = document.getElementById("modal2");
            
            <%
            String redirect = request.getParameter("redirect");
            
            if(redirect == null){
            %>
                document.body.removeChild(modal);
                document.body.removeChild(modal2);
                
            <% }else if(redirect.equals("visualiza")){ %>
                
                document.body.removeChild(modal);
            
             <% }else if(redirect.equals("atualiza")){ %>
                
                document.body.removeChild(modal2);    
    
            <% }else{ %>
                
                document.body.removeChild(modal);
                document.body.removeChild(modal2); 
                
            <% } %>
            
            function modalclose(){
                document.body.removeChild(modal);
            }
            
            function modal2close(){
                document.body.removeChild(modal2);
            }
            
            function modalopen(){
                document.body.appendChild(modal);
            }
            
            function deleteFuncionario(codigo){                
                fetch("FuncionarioServlet?codigo="+codigo,{method:'delete'})
                        .then(function(response){
                            location.reload();
                });
            };
            
        </script>
    </body>
</html>
