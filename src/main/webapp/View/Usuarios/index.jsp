<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->

<!--Container-->

<!--Title-->
<h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-2 text-xl md:text-2xl mx-5
">
    Usuarios
</h1>

<!--Card-->
<div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white m-5">

    <button class="bg-blue-500 p-1 mb-2 items-center rounded text-white">
        <a href="<%=request.getContextPath()%>/usuarios/nuevoUsuarios">
            Agregar <i class="fa-solid fa-plus"></i>
        </a>
    </button>

    <table id="example" class="stripe hover text-sm" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
        <thead>
        <tr>
            <th data-priority="1">
                CARNET
            </th>
            <th data-priority="1">
                NOMBRE
            </th>
            <th data-priority="1">
                APELLIDO
            </th>
            <th data-priority="1">
                TIPO
            </th>
            <th data-priority="1">
                TEL. CASA
            </th>
            <th data-priority="1">
                CELULAR
            </th>
            <th data-priority="1">
                EMAIL
            </th>
            <th data-priority="1">
                ESTADO
            </th>
            <th data-priority="1">
                CLAVE
            </th>
            <th data-priority="1">
                ACCESO
            </th>
            <th data-priority="1">
                ADMIN
            </th>
            <th data-priority="2" class="fecha-action">
                BORRAR
            </th>
            <th data-priority="2" class="flecha-action">
                EDITAR
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuarios" items="${listaUsuarios}">
            <tr>
                <td>
                    <c:out value="${usuarios.getCarnet()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getNom_usuario()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getApe_usuario()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getTipo()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getTelcasa()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getCelular()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getEmail()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getEstado()}"/>
                </td>
                <td>
                    <c:out value="${usuarios.getClave()}"/>
                </td>
                <td>
                    <c:choose>
                        <c:when test = "${usuarios.getAcessosistemas() == 1}">
                            <a onclick="estadoModal(`accesoUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />&estado=<c:out value="${usuarios.getAcessosistemas()}"/>`)">
                                <i class="fa-solid fa-eye" style="color: green"></i>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="estadoModal(`accesoUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />&estado=<c:out value="${usuarios.getAcessosistemas()}"/>`)">
                                <i class="fa-solid fa-eye-slash" style="color: orange"></i>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test = "${usuarios.getEsadministrador() == 1}">
                            <a onclick="estadoModal(`adminUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />&estado=<c:out value="${usuarios.getEsadministrador()}"/>`)">
                                <i class="fa-solid fa-user-tie" style="color: #3d68ff"></i>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="estadoModal(`adminUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />&estado=<c:out value="${usuarios.getEsadministrador()}"/>`)">
                                <i class="fa-solid fa-user-slash" style="color: orange"></i>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a onclick="borrarModal(`borrarUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />`)">
                        <i class="fa-solid fa-trash" style="color: red"></i>
                    </a>
                </td>
                <td>
                    <a href="editarUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />">
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
