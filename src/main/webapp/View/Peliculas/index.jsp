<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->

<!--Container-->

<!--Title-->
<h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-2 text-xl md:text-2xl">
    Peliculas
</h1>

<!--Card-->
<div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">
    <button class="modal-open bg-blue-500 p-1 mb-2 items-center rounded text-white">
        Agregar <i class="fa-solid fa-plus"></i>
    </button>

    <!--Start Insert Modal-->
    <%@ include file="create.jsp" %>
    <!--End Insert Modal-->

    <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
        <thead>
        <tr>
            <th data-priority="1">NOMBRE ES</th>
            <th data-priority="1">NOMBRE EN</th>
            <th data-priority="1">CATEGORIA</th>
<%--            <th data-priority="1">FOTO</th>--%>
            <th data-priority="1">AÑO</th>
            <th data-priority="2">DURACION</th>
            <th data-priority="2" class="fecha-action">BORRAR</th>
            <th data-priority="2" class="flecha-action">EDITAR</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="peliculas" items="${listaPeliculas}">
            <tr>
                <td>
                    <c:out value="${peliculas.getNombre()}"/>
                </td>
                <td>
                    <c:out value="${peliculas.getNomb_ingles()}"/>
                </td>
                <td>
                    <c:out value="${peliculas.getCategoria()}"/>
                </td>
<%--                <td>--%>
<%--                    <img class="object-scale-down h-15 w-20" src="<c:out value='${peliculas.getFoto()}'/>">--%>
<%--                </td>--%>
                <td>
                    <c:out value="${peliculas.getYearp()}"/>
                </td>
                <td>
                    <c:out value="${peliculas.getDuracion()}"/>
                </td>
                <td>
                    <a onclick="borrarModal(`borrarPeliculas?idpelicula=<c:out value='${peliculas.getIdpelicula()}'/>`)">
                        <i class="fa-solid fa-trash" style="color: red"></i>
                    </a>
                </td>
                <td>
                    <a href="editarPeliculas?idpelicula=<c:out value='${peliculas.getIdpelicula()}' />">
                        <i class="fa-solid fa-file-pen" style="color: #F7BD02"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!--/Card-->

<!--/container-->

<script type="text/javascript" src="../JS/borrarModel.js"></script>
<script type="text/javascript" src="../JS/insertModal.js"></script>
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
