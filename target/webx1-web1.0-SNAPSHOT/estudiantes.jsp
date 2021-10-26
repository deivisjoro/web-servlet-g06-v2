<%@page import="java.util.ArrayList"%>
<%@page import="co.deivisjoro.webx1.modelos.entidades.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo de Matriculas</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        
        <div class="container p-3">
            
            <div class="jumbotron">
                <div class="alert alert-primary">
                    <a href="#" class="btn btn-primary">Ingresar</a>
                </div>
                
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>N</th>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th colspan="3">Notas</th>
                            <th>Promedio</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <%
                            ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) request.getAttribute("estudiantes");
                            int i = 0;
                            for (Estudiante estudiante : estudiantes) {
                                i++;
                            %>
                            <tr>
                                <td><%=i%></td>
                                <td><%=estudiante.getId()%></td>
                                <td><%=estudiante.getNombre()%></td>
                                <td><%=estudiante.getNota1()%></td>
                                <td><%=estudiante.getNota2()%></td>
                                <td><%=estudiante.getNota3()%></td>
                                <td>
                                    <%
                                      double promedio = (estudiante.getNota1()+estudiante.getNota2()+estudiante.getNota3())/3;  
                                      out.print(promedio);
                                    %>    
                                </td>
                                <td>
                                    <a href="#" class="btn btn-warning">Editar</a>
                                    <a href="#" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            <%
                            }
                        %>
                        
                        
                    </tbody>
                </table>
            </div>
            
        </div>
        
           
    </body>
</html>
