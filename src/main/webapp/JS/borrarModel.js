function borrarModal(url){
  Swal.fire({
    title: '¿Desea borrarlo?',
    icon:'warning',
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: 'Borrar',
    denyButtonText: `No Borrar`,
  }).then((result) => {
    /* Read more about isConfirmed, isDenied below */
    if (result.isConfirmed) {
      Swal.fire({
        title:'¡Fue Borrado!',
        icon:'success',
        timer: 1500,
        didClose: ()=>{
          window.location.replace(url);
        }
      });
    } else if (result.isDenied) {
      Swal.fire('No fue borrado', '', 'info')
    }
  })
}