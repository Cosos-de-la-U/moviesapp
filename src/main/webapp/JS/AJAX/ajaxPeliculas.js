const fetchDepartment = () => {
    const departmentId = $('#department').val()

    $.ajax({
        type: "POST",
        url: "listarPeliculas",
        data: `departmentId=${departmentId}`,
        cache: false,
        success: response => {
            $("#data").html(response)
        }
    })
}

const saveDepartment = () => {
    const number = $("#departmentNumber").val();
    const name = $("#departmentName").val();
    const loc = $("#location").val();

    $.ajax({
        type: 'POST',
        url: 'handlers/saveDepartment.jsp',
        data: `departmentNumber=${number}&departmentName=${name}&location=${loc}`,
        cache: false,
    })
}