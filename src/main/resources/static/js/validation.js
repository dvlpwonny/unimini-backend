const TERMNAME = document.getElementById("termName");
const POPUP = document.getElementById("popup");
const BACKDROP = document.getElementsByClassName("backdrop")[0];
const SUBMIT_BTN = document.querySelector(".btnSubmit");

/*유효성 검사*/
function checkIfEmpty(args){
    if(args.value.length == 0) {
      showFeedback(args, args.value.length!=0);
      return true;
    }
    else {
      return false;
    }
  }
  
function showFeedback(args,validated){
  const VALIDATION_FEEDBACK = args.nextElementSibling;
  if(VALIDATION_FEEDBACK){
    if(validated){
      VALIDATION_FEEDBACK.classList.add("inactive");
      args.classList.remove("invalidated");
    }
    else{
      VALIDATION_FEEDBACK.classList.remove("inactive");
      args.classList.add("invalidated");
    }
  }
}

function validateBtn(btn){
  btn.classList.add("validated");
}
function invalidateBtn(btn){
  btn.classList.remove("validated");
}
function ableBtn(btn){
  btn.disabled = false;
}
function disableBtn(btn){
  btn.disabled = true;
}

//회원가입 유효성
const INPUT_EMAIL_SIGNUP = document.querySelector("#email-signup");
const INPUT_PASSWORD_SIGNUP = document.querySelector("#password-signup");
const INPUT_PASSWORD_DOUBLE_SIGNUP = document.querySelector("#password-double-signup");
const INPUT_NAME_SIGNUP = document.querySelector("#name-signup");
const INPUT_PHONE_SIGNUP = document.querySelector("#phone-signup");
const INPUT_NICKNAME_SIGNUP = document.querySelector("#nickname-signup");
const INPUT_GENDER_SIGNUP = document.querySelectorAll(".gender-signup");
const INPUT_STUDENT_ID_SIGNUP = document.querySelector("#studentId-signup");
const INPUT_MAJOR_SIGNUP = document.querySelector("#major-signup");
const BTN_TO_SIGNUP_SECOND_STAGE = document.querySelector("#toSignUpSecondStage");
const BTN_TO_SIGNUP_THIRD_STAGE = document.querySelector("#toSignUpThirdStage");
const BTN_TO_FINISH_SIGNUP = document.querySelector("#toFinishSignUp");
const CHECKBOX_SERVICE_TERM = document.querySelector("#checkServiceTerm");
const CHECKBOX_PERSONAL_INFO = document.querySelector("#checkPersonalInfo");
const CHECKBOX_TERMS = document.querySelectorAll("input[type='checkbox']");
const INPUT_STAGE2 = [INPUT_PASSWORD_SIGNUP,INPUT_PASSWORD_DOUBLE_SIGNUP,INPUT_NAME_SIGNUP,INPUT_PHONE_SIGNUP];
const INPUT_STAGE3 = [INPUT_NICKNAME_SIGNUP,INPUT_STUDENT_ID_SIGNUP, INPUT_MAJOR_SIGNUP];

function validationSignUp(){
  //1단계
  INPUT_EMAIL_SIGNUP.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_EMAIL_SIGNUP) && CHECKBOX_PERSONAL_INFO.checked && CHECKBOX_SERVICE_TERM.checked){
      ableBtn(BTN_TO_SIGNUP_SECOND_STAGE);
      validateBtn(BTN_TO_SIGNUP_SECOND_STAGE);
    }
    else{
      disableBtn(BTN_TO_SIGNUP_SECOND_STAGE);
      invalidateBtn(BTN_TO_SIGNUP_SECOND_STAGE);
    }
  })
  CHECKBOX_TERMS.forEach((term)=>{
    term.addEventListener(('input'),event=>{
      if(!checkIfEmpty(INPUT_EMAIL_SIGNUP) && CHECKBOX_PERSONAL_INFO.checked && CHECKBOX_SERVICE_TERM.checked){
        ableBtn(BTN_TO_SIGNUP_SECOND_STAGE);
        validateBtn(BTN_TO_SIGNUP_SECOND_STAGE);
      }
      else{
        disableBtn(BTN_TO_SIGNUP_SECOND_STAGE);
        invalidateBtn(BTN_TO_SIGNUP_SECOND_STAGE);
      }
    })
  })
  //2단계
  INPUT_STAGE2.forEach((input)=>{
    input.addEventListener('keyup', event=>{
      if(checkPassword(INPUT_PASSWORD_SIGNUP) 
      && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
      && !checkIfEmpty(INPUT_NAME_SIGNUP) 
      && checkPhone(INPUT_PHONE_SIGNUP)){
        ableBtn(BTN_TO_SIGNUP_THIRD_STAGE);
        validateBtn(BTN_TO_SIGNUP_THIRD_STAGE);
    }
    else{
      disableBtn(BTN_TO_SIGNUP_THIRD_STAGE);
      invalidateBtn(BTN_TO_SIGNUP_THIRD_STAGE);
    }
  })
  //3단계
  INPUT_STAGE3.forEach((input)=>{
    input.addEventListener('keyup',event=>{
      if(!checkIfEmpty(INPUT_NICKNAME_SIGNUP)
      &&checkRadioBtn(INPUT_GENDER_SIGNUP)
      &&checkStudentId(INPUT_STUDENT_ID_SIGNUP)
      &&!checkIfEmpty(INPUT_MAJOR_SIGNUP)){
        ableBtn(BTN_TO_FINISH_SIGNUP);
        validateBtn(BTN_TO_FINISH_SIGNUP);
      }
      else{
        disableBtn(BTN_TO_FINISH_SIGNUP);
        invalidateBtn(BTN_TO_FINISH_SIGNUP);
      }
    })
  })
  INPUT_GENDER_SIGNUP.forEach((input)=>{
    input.addEventListener('input',event=>{
      if(!checkIfEmpty(INPUT_NICKNAME_SIGNUP)
      &&checkRadioBtn(INPUT_GENDER_SIGNUP)
      &&checkStudentId(INPUT_STUDENT_ID_SIGNUP)
      &&!checkIfEmpty(INPUT_MAJOR_SIGNUP)){
        ableBtn(BTN_TO_FINISH_SIGNUP);
        validateBtn(BTN_TO_FINISH_SIGNUP);
      }
      else{
        disableBtn(BTN_TO_FINISH_SIGNUP);
        invalidateBtn(BTN_TO_FINISH_SIGNUP);
      }
    })
  })
})
}



  //이메일
  function checkEmail(args){
    var input = String(args.value);
    var patternEmail = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/;
    var validated = (patternEmail.test(input)? true : false);
    showFeedback(args, validated);
    return validated;
  }

  //비밀번호
  function checkPassword(args){
    var input = String(args.value);
    var patternPassword = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/;
    var validated = (patternPassword.test(input)? true : false);
    showFeedback(args, validated);
    return validated
  }

  //비밀번호 재확인
  function doubleCheckPassword(args){
    var input = String(args.value);
    var password = document.getElementById("password-signup").value;
    var validated = (input == password? true : false);
    showFeedback(args, validated);
    return validated;
  }

  //전화번호
  function checkPhone(args){
    var input = String(args.value);
    var patternPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
    var validated = (patternPhone.test(input)? true : false);
    showFeedback(args, validated);
    return validated;
  }

  //닉네임
  function checkNickname(args){
    var input = String(args.value);
    var validated = false;
    showFeedback(args, validated);
    return validated;
  }

  //학번
  function checkStudentId(args){
    var input = String(args.value);
    var validated = (input.length == 10 ? true : false);
    showFeedback(args, validated);
    return validated;
  }

  //체크박스
  function checkRadioBtn(args){
    for(var i =0; i<args.length; i++){
      if(args[i].checked) return true;
    }
    return false;
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