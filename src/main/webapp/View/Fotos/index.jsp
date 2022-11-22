<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->

<!--Container-->

    <!--Title-->
    <h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-2 text-xl md:text-2xl">
        Fotos
    </h1>

    <!--Card-->
    <div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">

        <button class="modal-open bg-blue-500 p-1 mb-2 items-center rounded text-white">
            <a href="<%=request.getContextPath()%>/fotos/nuevaFotos">
                Agregar <i class="fa-solid fa-plus"></i>
            </a>
        </button>

        <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
            <thead>
            <tr>
                <th data-priority="1">PELICULA</th>
                <th data-priority="1">FOTO</th>
                <th data-priority="1">PORTADA</th>
                <th data-priority="2" class="fecha-action">BORRAR</th>
                <th data-priority="2" class="flecha-action">EDITAR</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="fotos" items="${listaFotos}">
                <tr>
                    <td>
                        <c:out value="${fotos.getNombre()}"/>
                    </td>
                    <td>
                        <img class="object-scale-down h-15 w-20" src="<c:out value='${fotos.getFoto()}'/>">
                    </td>
                    <td>
                        <c:choose>
                            <c:when test = "${fotos.getPrimera() eq 'y'}">
                                <a onclick="estadoModal(`mostrarFotos?idfoto=<c:out value='${fotos.getIdfoto()}' />&idpelicula=<c:out value='${fotos.getIdpelicula()}'/>`)">
                                    <i class="fa-solid fa-thumbs-up" style="color: #3d68ff"></i>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a onclick="estadoModal(`mostrarFotos?idfoto=<c:out value='${fotos.getIdfoto()}' />&idpelicula=<c:out value='${fotos.getIdpelicula()}'/>`)">
                                    <i class="fa-solid fa-thumbs-down" style="color: orange"></i>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a onclick="borrarModal(`borrarFotos?idfoto=<c:out value='${fotos.getIdfoto()}' />`)">
                            <i class="fa-solid fa-trash" style="color: red"></i>
                        </a>
                    </td>
                    <td>
                        <a href="editarFotos?idfoto=<c:out value='${fotos.getIdfoto()}' />">
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
<script type="text/javascript" src="../JS/estadoModal.js"></script>
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
