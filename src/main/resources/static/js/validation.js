const TERMNAME = document.getElementById("termName");
const POPUP = document.getElementById("popup");
const BACKDROP = document.getElementsByClassName("backdrop")[0];
const SUBMIT_BTN = document.querySelector(".btnSubmit");

/*유효성 검사*/
function checkEmpty(args){
    if(args.value == "") {
      invalidateBtn(SUBMIT_BTN);
      showFeedback(args, args.value=="");
    }
    else validateBtn(SUBMIT_BTN);
  }
  
function showFeedback(args,validated){
  const VALIDATION_FEEDBACK = args.nextElementSibling;
  if(validated){
    VALIDATION_FEEDBACK.classList.add("inactive");
    args.classList.remove("invalidated");
    validateBtn(SUBMIT_BTN);
  }
  else{
    VALIDATION_FEEDBACK.classList.remove("inactive");
    args.classList.add("invalidated")
  }
}

function validateBtn(btn){
  btn.classList.add("validated");
}
function invalidateBtn(btn){
  btn.classList.remove("validated");
}

  //로그인


  //이메일
  function checkEmail(args){
    var input = String(args.value);
    var patternEmail = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/;
    var validated = (patternEmail.test(input)? true : false);
    showFeedback(args, validated);
  }

  //비밀번호
  function checkPassword(args){
    var input = String(args.value);
    var patternPassword = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/;
    var validated = (patternPassword.test(input)? true : false);
    showFeedback(args, validated);
  }

  function doubleCheckPassword(args){
    var input = String(args.value);
    var password = document.getElementById("password").value;
    var validated = (input == password? true : false);
    showFeedback(args, validated);
  }

  //전화번호
  function checkPhone(args){
    var input = String(args.value);
    var patternPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
    var validated = (patternPhone.test(input)? true : false);
    showFeedback(args, validated);
  }

  //닉네임
  function checkNickname(args){
    var input = String(args.value);
    var validated = false;
    showFeedback(args, validated);
  }
  
/*회원가입 - 이용약관*/
function openTerm(elem){
  const termName = elem.parentElement.parentElement.childNodes[3].childNodes[1].innerText;
  TERMNAME.innerHTML = termName;
  POPUP.classList.remove("inactive");
  BACKDROP.classList.add("show");
}
function closeTerm(){
  POPUP.classList.add("inactive");
  BACKDROP.classList.remove("show");
}