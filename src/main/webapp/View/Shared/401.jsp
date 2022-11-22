<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/head.jspf" %>
<div class="flex items-center justify-center w-screen h-screen">
    <div class="px-4 lg:py-12">
        <div class="lg:gap-4 lg:flex">
            <div class="flex flex-col items-center justify-center md:py-24 lg:py-32">
                <h1 class="font-bold text-blue-600 text-9xl">401</h1>
                <p class="mb-2 text-2xl font-bold text-center text-gray-800 md:text-3xl">
                    <span class="text-red-500">Oops!</span> No tienes acceso a esta pagina
                </p>
                <p class="mb-8 text-center text-gray-500 md:text-lg">
                    Esta pagina no esta disponible para ti
                </p>
                <a href="http://localhost:8080/moviesapp_war_exploded/welcome"
                   class="px-6 py-2 text-sm font-semibold text-blue-800 bg-blue-100">Volver al inicio</a>
            </div>
            <div class="mt-4">
                <img
                        src="https://cdn.pixabay.com/photo/2016/11/22/23/13/black-dog-1851106__340.jpg"
                        alt="img"
                        class="object-cover w-full h-full"
                />
            </div>
        </div>
    </div>
</div>
