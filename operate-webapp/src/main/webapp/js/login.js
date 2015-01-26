/**
 * Created by CHECHI on 2015/1/6.
 */
function clearLoginForm(){
    $('#loginForm').form('clear');
}

function loginSubmit(){
    $('#loginForm').form('submit',{
        url:'login.do',
        onSubmit:function(){
            return $(this).form('enableValidation').form('validate');
        },
        success:function(data){
            window.location.href='index';
        }
    });
}