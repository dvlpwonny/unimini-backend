const TERMNAME = document.getElementById("termName");
const POPUP = document.getElementById("popup");
const BACKDROP = document.getElementsByClassName("backdrop")[0];
const SUBMIT_BTN = document.querySelector(".btnSubmit");

/*유효성 검사*/
function checkIfEmpty(args){
  showFeedback(args, args.value.length!=0);
    if(args.value.length == 0) {
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
function enableBtn(btn){
  btn.disabled = false;
}
function disableBtn(btn){
  btn.disabled = true;
}

//회원가입 유효성
const INPUT_EMAIL_LOGIN = document.querySelector('#email-login');
const INPUT_PASSWORD_LOGIN = document.querySelector('#password-login');
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
const BTN_TO_FINISH_LOGIN = document.querySelector("#toLogin");
const CHECKBOX_SERVICE_TERM = document.querySelector("#checkServiceTerm");
const CHECKBOX_PERSONAL_INFO = document.querySelector("#checkPersonalInfo");
const CHECKBOX_TERMS = document.querySelectorAll("input[type='checkbox']");

function validationLogin(){
  INPUT_PASSWORD_LOGIN.addEventListener('keyup',event=>{
    if (!checkIfEmpty(INPUT_PASSWORD_LOGIN) && !checkIfEmpty(INPUT_EMAIL_LOGIN)) validateBtn(BTN_TO_FINISH_LOGIN);
    else invalidateBtn(BTN_TO_FINISH_LOGIN);
  })
  INPUT_EMAIL_LOGIN.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_EMAIL_LOGIN) && !checkIfEmpty(INPUT_PASSWORD_LOGIN)) validateBtn(BTN_TO_FINISH_LOGIN);
    else invalidateBtn(BTN_TO_FINISH_LOGIN);
  })
}

function validationSignUp(){
  INPUT_EMAIL_SIGNUP.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && checkPassword(INPUT_PASSWORD_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && !checkIfEmpty(INPUT_NAME_SIGNUP)
    && checkPhone(INPUT_PHONE_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
  })
  INPUT_PASSWORD_SIGNUP.addEventListener('keyup',event=>{
    if(checkPassword(INPUT_PASSWORD_SIGNUP) 
    && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && !checkIfEmpty(INPUT_NAME_SIGNUP)
    && checkPhone(INPUT_PHONE_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
  })
  INPUT_PASSWORD_DOUBLE_SIGNUP.addEventListener('keyup',event=>{
      if(doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
      && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
      && checkPassword(INPUT_PASSWORD_SIGNUP) 
      && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
      && checkRadioBtn(INPUT_GENDER_SIGNUP)
      && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
      && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
      && !checkIfEmpty(INPUT_NAME_SIGNUP)
      && checkPhone(INPUT_PHONE_SIGNUP)){
        enableBtn(BTN_TO_FINISH_SIGNUP);
        validateBtn(BTN_TO_FINISH_SIGNUP);}
    else{
      disableBtn(BTN_TO_FINISH_SIGNUP);
      invalidateBtn(BTN_TO_FINISH_SIGNUP);
      }
    })
  INPUT_NICKNAME_SIGNUP.addEventListener('keyup',event=>{
      if(!checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
      && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
      && checkPassword(INPUT_PASSWORD_SIGNUP) 
      && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
      && checkRadioBtn(INPUT_GENDER_SIGNUP)
      && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
      && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
      && !checkIfEmpty(INPUT_NAME_SIGNUP)
      && checkPhone(INPUT_PHONE_SIGNUP)){
        enableBtn(BTN_TO_FINISH_SIGNUP);
        validateBtn(BTN_TO_FINISH_SIGNUP);}
    else{
      disableBtn(BTN_TO_FINISH_SIGNUP);
      invalidateBtn(BTN_TO_FINISH_SIGNUP);
      }
    })
  INPUT_GENDER_SIGNUP.forEach(gender=>{
    gender.addEventListener('keyup',event=>{
        if(!checkIfEmpty(INPUT_EMAIL_SIGNUP) 
        && checkPassword(INPUT_PASSWORD_SIGNUP) 
        && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
        && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
        && checkRadioBtn(INPUT_GENDER_SIGNUP)
        && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
        && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
        && !checkIfEmpty(INPUT_NAME_SIGNUP)
        && checkPhone(INPUT_PHONE_SIGNUP)){
          enableBtn(BTN_TO_FINISH_SIGNUP);
          validateBtn(BTN_TO_FINISH_SIGNUP);}
      else{
        disableBtn(BTN_TO_FINISH_SIGNUP);
        invalidateBtn(BTN_TO_FINISH_SIGNUP);
        }
    })
  })
  INPUT_MAJOR_SIGNUP.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && checkPassword(INPUT_PASSWORD_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && !checkIfEmpty(INPUT_NAME_SIGNUP)
    && checkPhone(INPUT_PHONE_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
  })
  INPUT_STUDENT_ID_SIGNUP.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && checkPassword(INPUT_PASSWORD_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_NAME_SIGNUP)
    && checkPhone(INPUT_PHONE_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
  })
  INPUT_NAME_SIGNUP.addEventListener('keyup',event=>{
    if(!checkIfEmpty(INPUT_NAME_SIGNUP)
    && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && checkPassword(INPUT_PASSWORD_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && checkPhone(INPUT_PHONE_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
  })
  INPUT_PHONE_SIGNUP.addEventListener('keyup',event=>{
    if(checkPhone(INPUT_PHONE_SIGNUP)
    && !checkIfEmpty(INPUT_EMAIL_SIGNUP) 
    && checkPassword(INPUT_PASSWORD_SIGNUP) 
    && !checkIfEmpty(INPUT_NICKNAME_SIGNUP) 
    && doubleCheckPassword(INPUT_PASSWORD_DOUBLE_SIGNUP) 
    && checkRadioBtn(INPUT_GENDER_SIGNUP)
    && !checkIfEmpty(INPUT_MAJOR_SIGNUP)
    && !checkIfEmpty(INPUT_STUDENT_ID_SIGNUP)
    && !checkIfEmpty(INPUT_NAME_SIGNUP)){
      enableBtn(BTN_TO_FINISH_SIGNUP);
      validateBtn(BTN_TO_FINISH_SIGNUP);}
  else{
    disableBtn(BTN_TO_FINISH_SIGNUP);
    invalidateBtn(BTN_TO_FINISH_SIGNUP);
    }
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
    var num = input.search(/[0-9]/g);
    var eng = input.search(/[a-z]/ig);
    var spe = input.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
    var validated;
    if(input.length < 8 || input.length > 20)
      validated =  false;
    else if(input.search(/₩s/) != -1)
      validated =  false;
    else if(num < 0 || eng < 0 || spe < 0 )
      validated = false;
    else validated = true;
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