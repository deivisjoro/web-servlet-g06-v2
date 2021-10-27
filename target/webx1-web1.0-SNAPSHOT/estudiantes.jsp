<%@page import="java.util.ArrayList"%>
<%@page import="co.deivisjoro.webx1.modelos.entidades.Estudiante"%>
<%@include file="WEB-INF/header.jsp" %>
                <div class="alert alert-primary">
                    <a href="?accion=ingresar" class="btn btn-primary">Ingresar</a>
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
                                    <a href="?accion=eliminar&id=<%=estudiante.getId()%>" 
                                       class="btn btn-danger"
                                       onclick="return confirm('Desea eliminar el estudiante seleccionado')">Eliminar</a>
                                </td>
                            </tr>
                            <%
                            }
                        %>
                        
                        
                    </tbody>
                </table>
<%@include file="WEB-INF/footer.jsp" %>
