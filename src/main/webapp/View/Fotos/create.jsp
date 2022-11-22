<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
<!-- Did get the path-->
<c:if test="${fotos != null}">
    <form action="actualizarFotos" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4"
    enctype='multipart/form-data'>
</c:if>
<!--Didn't get the path-->
<c:if test="${fotos == null}">
    <form action="insertarFotos" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4"
    enctype='multipart/form-data'>
</c:if>

<h2>
    <!-- Didn't get the path-->
    <c:if test="${fotos != null}">
        Editar Foto
    </c:if>
    <!-- Didn get the path-->
    <c:if test="${fotos == null}">
        Agregar Foto
    </c:if>
</h2>

<div class="mb-4">
    <c:if test="${fotos != null}">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="idfoto" hidden>
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="idfoto"
               value="<c:out value='${fotos.getIdpelicula()}' />"
               type="text" placeholder="ID" hidden>
    </c:if>
</div>
<div class="mb-4">
    <label class="block text-gray-700 text-sm font-bold mb-2" for="idpelicula">
        Pelicula
    </label>
    <select name="idpelicula"
            class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline block w-full p-2.5"
            required>
        <option value="">-- Selecione una pelicula--</option>
        <c:forEach items="${peliculas}" var="pelicula">
            <option value="${pelicula.getIdpelicula()}"
                    <c:if test="${pelicula.getIdpelicula() == fotos.getIdpelicula()}">
                        selected
                    </c:if>
            >${pelicula.getNombre()}</option>
        </c:forEach>
    </select>
</div>
<div class="mb-4">
    <label class="block text-gray-700 text-sm font-bold mb-2" for="foto">
        Imagen
    </label>
    <input class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50"
           name="foto"
           aria-describedby="file_input_help"
           id="file_input"
           type="file"
           accept="image/*"
           value="<c:out value='${fotos.getFoto()}' />"
           required="required">
    <p class="mt-1 text-sm text-gray-500 dark:text-gray-300" id="file_input_help">SVG, PNG, JPG o GIF</p>
</div>
<div class="mb-4 flex items-center">
    <input id="checked-checkbox"
           type="checkbox"
           name="primera"
    <c:if test="${fotos.getPrimera() == 'y'}">
           checked
    </c:if>
           value="y"
           class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500"
    <label for="checked-checkbox" class="ml-2 text-sm font-medium text-gray-900">Principal</label>
</div>
<div class="flex items-center justify-between">
    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            type="submit">
        Guardar
    </button>
</div>

</form>
</div>
<!--End-->
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
