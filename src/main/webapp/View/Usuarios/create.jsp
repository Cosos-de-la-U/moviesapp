<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
<!-- Did get the path-->
<c:if test="${usuarios != null}">
    <form action="actualizarUsuarios" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>
<!--Didn't get the path-->
<c:if test="${usuarios == null}">
    <form action="insertarUsuarios" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>

<h2>
    <!-- Didn't get the path-->
    <c:if test="${usuarios != null}">
        Editar Usuarios
    </c:if>
    <!-- Didn get the path-->
    <c:if test="${usuarios == null}">
        Agregar Usuarios
    </c:if>
</h2>
<!--Start-->
<div class="grid grid-cols-2 gap-2">
    <!--Start First col-->
    <div>
        <div>
            <c:if test="${usuarios != null}">
                <label for="carnet" hidden>
                </label>
                <input
                        name="carnet"
                        value="<c:out value='${usuarios.getCarnet()}' />"
                        type="text" placeholder="ID" hidden>
            </c:if>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="nom_usuario">
                Nombre
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="nom_usuario"
                   value="<c:out value='${usuarios.getNom_usuario()}' />"
                   type="text" placeholder="" required="required" >
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="ape_usuario">
                Apellido
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="ape_usuario"
                   value="<c:out value='${usuarios.getApe_usuario()}' />"
                   type="text" placeholder="" required="required" maxlength="30">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="tipo">
                Tipo
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="tipo"
                   value="<c:out value='${usuarios.getTipo()}' />"
                   type="text" placeholder="" required="required" maxlength="30">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="telcasa">
                Tel. Casa
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="telcasa"
                   value="<c:out value='${usuarios.getTelcasa()}' />"
                   type="text" placeholder="" maxlength="9">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="celular">
                Celular
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="celular"
                   value="<c:out value='${usuarios.getCelular()}' />"
                   type="text" placeholder="" maxlength="9">
        </div>
    </div>
    <!-- Finish First col-->
    <!-- Start Second col-->
    <div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="email">
                Email
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="email"
                   value="<c:out value='${usuarios.getEmail()}' />"
                   type="email" placeholder="" maxlength="100">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="estado">
                Estado
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="estado"
                   value="<c:out value='${usuarios.getEstado()}' />"
                   type="text" placeholder="" maxlength="20">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="clave">
                clave
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="clave"
                   value="<c:out value='${usuarios.getClave()}' />"
                   type="text" placeholder="" required="required">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="acessosistemas">
                Acceso
            </label>
            <select name="acessosistemas"
                    class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline block w-full p-2.5" required>
                <option value="">-- Selecione acceso--</option>
                <c:forEach items="${accesos}" var="acceso">
                    <option value="${acceso.getId()}"
                            <c:if test="${acceso.getId() == usuarios.getAcessosistemas()}">
                                selected
                            </c:if>
                    >${acceso.getNombre()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="esadministrador">
                Tipo
            </label>
            <select name="esadministrador"
                    class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline block w-full p-2.5" required>
                <option value="">-- Selecione acceso--</option>
                <c:forEach items="${tipos}" var="tipo">
                    <option value="${tipo.getId()}"
                            <c:if test="${tipo.getId() == usuarios.getEsadministrador()}">
                                selected
                            </c:if>
                    >${tipo.getNombre()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <!-- Finish Second col-->
    <div class="flex items-center justify-between">
        <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="submit">
            Guardar
        </button>
    </div>
</div>
<!--Finish-->
</form>
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
