<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->

<!--Container-->

<!--Title-->
<h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-2 text-xl md:text-2xl">
    Categorias
</h1>

<!--Card-->
<div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">

    <button class="bg-blue-500 p-1 mb-2 items-center rounded text-white">
        <a href="<%=request.getContextPath()%>/categoria/nuevaCategoria">
            Agregar <i class="fa-solid fa-plus"></i>
        </a>
    </button>

    <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
        <thead>
        <tr>
            <th data-priority="1">CATEGORIA</th>
            <th data-priority="2" class="fecha-action">BORRAR</th>
            <th data-priority="2" class="flecha-action">EDITAR</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="categoria" items="${listaCategoria}" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${categoria.getCategoria()}"/>
                </td>
                <td>
                    <a onclick="borrarModal(`borrarCategoria?idcategoria=<c:out value='${categoria.getIdcategoria()}' />`)">
                        <i class="fa-solid fa-trash" style="color: red"></i>
                    </a>
                </td>
                <td>
                    <a id="editar" href="editarCategoria?idcategoria=<c:out value='${categoria.getIdcategoria()}' />">
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
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
