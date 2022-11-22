function estadoModal(url){
    Swal.fire({
        title: '¿Desea cambiar el estado?',
        icon:'question',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: 'Cambiar',
        denyButtonText: `No cambiar`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire({
                title:'¡Fue cambiado!',
                icon:'success',
                timer: 1500,
                didClose: ()=>{
                    window.location.replace(url);
                }
            });
        } else if (result.isDenied) {
            Swal.fire('No fue cambiado', '', 'info')
        }
    })
}