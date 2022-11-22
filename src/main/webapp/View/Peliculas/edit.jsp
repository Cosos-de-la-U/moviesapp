<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
<!-- Did get the path-->
<form action="actualizarPeliculas" method="post"
      class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
    <h2>
        Editar peliculas
    </h2>
    <!--Start-->
    <div class="mb-4">
        <c:if test="${peliculas != null}">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="idpelicula" hidden>
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="idpelicula"
                   value="<c:out value='${peliculas.getIdpelicula()}' />"
                   type="text" placeholder="ID" hidden>
        </c:if>
    </div>
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="nombre">
            Nombre ES
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="nombre"
               value="<c:out value='${peliculas.getNombre()}' />"
               type="text" placeholder="" required="required">
    </div>
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="nombreIngles">
            Nombre EN
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="nombreIngles"
               value="<c:out value='${peliculas.getNomb_ingles()}' />"
               type="text" placeholder="" required="required">
    </div>
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="idcategoria">
            Categoria
        </label>
        <select name="idcategoria"
                class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline block w-full p-2.5"
                required>
            <option value="">-- Selecione una categoria--</option>
            <c:forEach items="${listaCategorias}" var="categorias">
                <option value="${categorias.getIdcategoria()}"
                        <c:if test="${categorias.getCategoria() == peliculas.getCategoria()}">
                            selected
                        </c:if>
                >${categorias.getCategoria()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="yearp">
            Año
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="yearp"
               value="<c:out value='${peliculas.getYearp()}' />"
               type="number">
    </div>
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="duracion">
            Duracion
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="duracion"
               value="<c:out value='${peliculas.getDuracion()}' />"
               type="number">
    </div>
    <div class="flex items-center justify-between">
        <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="submit">
            Guardar
        </button>
    </div>
</form>
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
