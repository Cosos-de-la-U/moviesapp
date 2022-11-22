<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Modal/insertModalBeggining.jsp" %>
<!--Web start-->

<!-- Didn't get the path-->

<!--Title-->
<div class="modal-close cursor-pointer z-50 py-2">
    <svg class="fill-current text-black" xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
        <path d="M14.53 4.53l-1.06-1.06L9 7.94 4.53 3.47 3.47 4.53 7.94 9l-4.47 4.47 1.06 1.06L9 10.06l4.47 4.47 1.06-1.06L10.06 9z"></path>
    </svg>
</div>
<p class="text-2xl font-bold">
    <c:if test="${peliculas != null}">
        Editar Pelicula
    </c:if>
    <!-- Didn get the path-->
    <c:if test="${peliculas == null}">
        Agregar Pelicula
    </c:if>
</p>

<!-- Did get the path-->
<c:if test="${peliculas != null}">
    <form action="actualizarPeliculas" method="post">
</c:if>
<!--Didn't get the path-->
<c:if test="${peliculas == null}">
    <form action="insertarPeliculas" method="post">
</c:if>

<div class="mb-4">
    <c:if test="${peliculas != null}">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="idpelicula" hidden>
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="nombre"
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
<!--End-->
<!--Web end-->
<%@ include file="../../Common/Modal/insertModalEnd.jsp" %>