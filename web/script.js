function adicionarAreas(){
    var opcoesSelecionadas = document.getElementById("area_selecionadas").selectedOptions;
    var opcoesAdicionadas = document.getElementById("area_adicionadas");
    forPrincipal:
    for(var i = 0; i < opcoesSelecionadas.length; i++){
        for(var j = 0; j < opcoesAdicionadas.length; j++){
            if(opcoesSelecionadas[i].value === opcoesAdicionadas[j].value)
                continue forPrincipal;
        }
        opcoesSelecionadas[i].value;
        opcoesAdicionadas.appendChild(opcoesSelecionadas[i]);
    }
}
function removerAreas(){
    var opcoesSelecionadas = document.getElementById("area_selecionadas");
    var opcoesAdicionadas = document.getElementById("area_adicionadas").selectedOptions;
    forPrincipal:
    for(var m = 0; m < opcoesAdicionadas.length; m++){
        for(var n = 0; n < opcoesSelecionadas.length; n++){
            if(opcoesAdicionadas[m].value === opcoesSelecionadas[n].value)
                continue forPrincipal;
        }
        opcoesAdicionadas[m].value;
        opcoesSelecionadas.appendChild(opcoesAdicionadas[m]);
    }
}

function validarFormularioColaborador(isCadastro){
    var nome = document.getElementById("nomeColaborador").value;
    var login = document.getElementById("loginColaborador").value;
    var senha = document.getElementById("senha").value;
    var senhaRepetida = document.getElementById("senhaRepetida").value;
    if(nome === ""){
        alert("Preencha o nome.");
        document.getElementById("nomeColaborador").focus();
        return false;
    }
    else if(login === ""){
        alert("Preencha o login.");
        document.getElementById("loginColaborador").focus();
        return false;
    }
    else if(senha === "" && isCadastro){
        alert("Preencha a senha.");
        document.getElementById("senha").focus();
        return false;
    }
    else if(senha !== senhaRepetida){
        alert("Senhas não são iguais.");
        document.getElementById("senha").focus();
        return false;
    }
    else {
        var areaSelecionadas = document.getElementById("area_selecionadas");
        var areaAdicionadas = document.getElementById("area_adicionadas");
        for(var i = 1; i < areaSelecionadas.childNodes.length - 1; i++){
            //alert(areaSelecionadas.childNodes[i]);
            //alert(areaSelecionadas.childNodes[i].value);
            areaSelecionadas.childNodes[i].setAttribute("selected", "selected");
            //areaSelecionadas.childNodes[i].setAttribute("value", i);
        }
        for(var i = 1; i < areaAdicionadas.childNodes.length - 1; i++){
            areaAdicionadas.childNodes[i].setAttribute("selected", "selected");
            //areaAdicionadas.childNodes[i].setAttribute("value", i);
        }
        if(isCadastro)
            return confirm("Tem certeza que deseja efetuar o cadastro?");
        else
            return confirm("Tem certeza que deseja alterar seu dados?");
    }
}