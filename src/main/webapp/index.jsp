<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="Common/Shared/head.jspf" %>
<!--Webiste-->
<body class="flex flex-col items-center justify-center w-screen h-screen bg-gray-200 text-gray-700">
<h1 class="font-bold text-2xl">Movie App <i class="fa-solid fa-clapperboard"></i></h1>
<c:if test="${errorLogin == true}">
    <div class="p-4 mb-4 text-sm text-red-700 bg-red-100 rounded-lg dark:bg-red-200 dark:text-red-800" role="alert">
        <span class="font-medium">Error!</span> Ingrese un nickname o clave validos.
    </div>
</c:if>
<form class="flex flex-col bg-white rounded shadow-lg p-12 mt-12" action="login" method="post">
    <label class="font-semibold text-xs" for="carnet">Carnet</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="carnet"
           type="text">
    <label class="font-semibold text-xs mt-3" for="clave">Clave</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="clave"
           type="password">
    <button class="flex items-center justify-center h-12 px-6 w-64 bg-blue-600 mt-8 rounded font-semibold text-sm text-blue-100 hover:bg-blue-700">
        Iniciar sesión
    </button>
</form>
</body>