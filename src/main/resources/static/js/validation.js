/*유효성 검사*/
function checkEmpty(elem){
    if(elem.value == "") return true;
    else return false;
  }


function checkEmail(){
    var form = document.FORM_ID;
    var btn = form.BTN_ID;
    if(!checkEmpty(form.INPUT_ID)) {
      btn.classList.add("validated");
      btn.removeAttribute("disabled");
    }
    else {
      btn.classList.remove("validated");
      btn.addAttribute("disabled")
    }
  }

function checkPassword(){
    var form = document.FORM_PASSWORD;
    var btn = form.BTN_PASSWORD;
    var input = form.INPUT_PASSWORD
    if(!checkEmpty(input)){
        /* 비밀번호 유효성 */
    }
    else{
    }
}