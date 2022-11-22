<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
</div>
<div class=" w-max h-max">
    <h1 class="text-center font-black text-2xl">Todas las peliculas</h1>
    <div class="grid grid-cols-2 gap-4 content-center align-center">
        <!--Card-->
        <c:forEach var="pelicula" items="${listaPeliculasVistas}">
            <div class="max-w-sm w-full lg:max-w-full lg:flex p-5">
                <div class="h-48 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden"
                     style="background-image: url('<c:out value="${pelicula.getFoto()}" />')" title="">
                </div>
                <div class="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal">
                    <div class="mb-8">
                        <p class="text-sm text-gray-600 flex items-center">
                            EN:  <c:out value="${pelicula.getNomb_ingles()}" />
                        </p>
                        <div class="text-gray-900 font-bold text-xl mb-2">ES: <c:out value="${pelicula.getNombre()}" /> </div>
                        <p class="text-gray-700 text-base">Categoria: <c:out value="${pelicula.getCategoria()}" /></p>
                        <p class="text-gray-700 text-base">Año: <c:out value="${pelicula.getYearp()}" /></p>
                        <p class="text-gray-700 text-base">Duracion: <c:out value="${pelicula.getDuracion()}" /></p>
                    </div>
                    <div class="flex items-center">
                        <div class="text-sm">
                            <a href="comentario?idpelicula=<c:out value='${pelicula.getIdpelicula()}' />" class="font-black">
                                Agregar comentario/vista <i class="fa-solid fa-plus" style="color: #3D68FF"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!--Card-->
    </div>
</div>

<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>
