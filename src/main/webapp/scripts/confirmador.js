//@param idade

function confirmarExcluir(cod_registro) {
    let resposta = confirm("Deseja mesmo excluir esse usuário? 🚨");

    if(resposta === true ){
        window.location.href = "deleteUsuario?cod_registro=" + cod_registro;
    }
}