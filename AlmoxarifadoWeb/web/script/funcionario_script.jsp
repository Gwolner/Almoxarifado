<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <script>
            
            var modalFuncionario = document.getElementById("modalFuncionario");
            
            
            
            var modalFuncionario2 = document.getElementById("modalFuncionario2");
            
            <%
            String redirect = request.getParameter("redirect");
            
            if(redirect == null){
            %>
                document.body.removeChild(modalFuncionario);
                document.body.removeChild(modalFuncionario2);
                
            <% }else if(redirect.equals("visualiza")){ %>
                
                document.body.removeChild(modalFuncionario);
                
            <% }else{ %>
                
                document.body.removeChild(modalFuncionario2); 
                
            <% } %>
            
            function modalclose(){
                document.body.removeChild(modalFuncionario);
            }
            
            function modal2close(){
                document.body.removeChild(modalFuncionario2);
            }
            
            function modalopen(){
                document.body.appendChild(modalFuncionario);
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
