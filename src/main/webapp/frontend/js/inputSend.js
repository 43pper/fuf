var inputEmail = document.getElementsByClassName('email');
var alertMessage = document.getElementsByClassName('footer-alert');

inputEmail[0].addEventListener('keydown',function(event) {
  if(alertMessage[0].style.animation = 'opacitiUp 4s ease-out') {
    alertMessage[0].style.animation = 'none';
  }
    if(event.keyCode == 13) {
      if(inputEmail[0].value != '') {
        alertMessage[0].style.animation = 'opacitiUp 4s ease-out';
        inputEmail[0].value = '';
      }
      else {
        alert('Введите пожалуйста почту');
      } 
      
    }  
}
);
