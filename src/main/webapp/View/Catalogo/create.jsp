<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
<!-- Did get the path-->
<c:if test="${comentario != null}">
    <form action="updateComentario" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>
<!--Didn't get the path-->
<c:if test="${comentario == null}">
    <form action="insertComentario" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>
<h2>
    <!-- Didn't get the path-->
    <c:if test="${comentario != null}">
        Editar comentario
    </c:if>
    <!-- Didn get the path-->
    <c:if test="${comentario == null}">
        Agregar comentario
    </c:if>
</h2>

<div class="mb-4">
    <c:if test="${comentario != null}">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="idpelicula" hidden>
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="idpelicula"
               value="<c:out value='${comentario.getIdpelicula()}' />"
               type="text" placeholder="ID" hidden>
    </c:if>
</div>
<div class="mb-4">
    <label class="block text-gray-700 text-sm font-bold mb-2" for="comentario"> Comentario
    </label>
    <textarea id="message"
              rows="4"
              name="comentario"
              type="text" required="required"
              class="py-5 px-10 block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 white:bg-gray-700 white:border-gray-600 white:placeholder-gray-400 white:text-white white:focus:ring-blue-500 white:focus:border-blue-500"
              placeholder="Escribe aqui tu comentario"><c:out value='${comentario.getComentario()}' /></textarea>


</div>
<div class="mb-4">
    <label class="block text-gray-700 text-sm font-bold mb-2" for="calificacion">
        Calificacion
    </label>
    <c:forEach var="loop" begin="1" end="5">
        <ul class="items-center w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 sm:flex white:bg-gray-700 white:border-gray-600 white:text-white">
            <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r white:border-gray-600">
                <div class="flex items-center pl-3">
                    <input id="horizontal-list-radio-license" type="radio"
                           value="${loop}" name="calificacion"
                           class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 white:focus:ring-blue-600 white:ring-offset-gray-700 focus:ring-2 white:bg-gray-600 white:border-gray-500"
                           required
                    <c:if test="${loop == comentario.getCalificacion()}">
                           checked
                    </c:if>
                    >
                    <label for="horizontal-list-radio-license"
                           class="py-3 ml-2 w-full text-sm font-medium text-gray-900 white:text-gray-300">
                        ${loop}
                        <c:forEach var="starLoop" begin="1" end="${loop}">
                            <i class="fa-solid fa-star" style="color: #F7BD02"></i>
                        </c:forEach>
                    </label>
                </div>
            </li>
        </ul>
    </c:forEach>
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