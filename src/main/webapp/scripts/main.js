// VALIDAÇÃO DO FORM

function validationOfForm(){
    let nome = validarForm.nome.value;
    let profissao = validarForm.profissao.value;
    let idade = validarForm.idade.value;

    if(nome === ""){
        alert("Preencha o seu nome! 🚨");
        validarForm.nome.focus();
        return false;
    } else if(profissao === ""){
        alert("Preencha a sua profissão! 🚨");
        validarForm.profissao.focus();
        return false;
    } else if(idade === ""){
        alert("Preencha a sua idade! 🚨");
        validarForm.idade.focus();
        return false;
    } else {
        document.forms["validarForm"].submit();
    }
}