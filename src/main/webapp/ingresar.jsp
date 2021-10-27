<%@include file="WEB-INF/header.jsp" %>
<h3 class="text-center pb-3">Ingresar Estudiante</h3>
<form method="post" action="">
<div class="row">
    <div class="col-md-8 offset-md-2">
        <div class="card">
            <div class="card-header bg-dark">
                <h4 class="text-white text-center">Ingresar Datos</h4>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del estudiante" class="form-control">
                </div>

                <div class="form-group">
                    <label for="nota1">Nota1:</label>
                    <input type="text" id="nota1" name="nota1" placeholder="Ingrese la nota 1" class="form-control">
                </div>

                <div class="form-group">
                    <label for="nota2">Nota2:</label>
                    <input type="text" id="nota2" name="nota2" placeholder="Ingrese la nota 2" class="form-control">
                </div>

                <div class="form-group">
                    <label for="nota3">Nota3:</label>
                    <input type="text" id="nota3" name="nota3" placeholder="Ingrese la nota 3" class="form-control">
                </div>
            </div>
            <div class="card-footer">
                <div class="row">

                    <div class="col-md-6">                    
                        <input type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-block">
                    </div>

                    <div class="col-md-6">
                        <a href="estudiantes" class="btn btn-danger btn-block">Cancelar</a>
                </div>
            </div>
        </div>
    </div>
    
    

</div>
</form>

<%@include file="WEB-INF/footer.jsp" %>          
