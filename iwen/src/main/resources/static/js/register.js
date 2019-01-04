function save(){
    var form = $('#registerForm').attr('action','/register/save');
    form.submit();
}