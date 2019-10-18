/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarFormulario(forma)
{
    var usuario=forma.usuario;
    if(usuario.value.length==0)
    {
        alert("debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        
       return false;
    }
    var password=forma.password;
    if(password==""||password.value.length<8)
    {
        alert("Debe proporcionar una contraseña de al menos 8 caracteres");
        password.focus();
        password.select();
        return false;        
    }
    
    
    if(usuario.value.length !=0 && password!="" && password.value.length>=8)
    {
     alert("Enviando Formulario");
     return true;
    }
    
    
    
   
}

