//0. 헤더

const TITLE = document.getElementsByTagName("title")[0].innerHTML;
const HEADER_TITLE = document.getElementById("header_title")
console.log(TITLE);
if(HEADER_TITLE){
    HEADER_TITLE.innerHTML = TITLE;
    HEADER_TITLE.innerText = TITLE;
}

//1. 로그인


//3. 회원가입
  //회원가입 단계 이동
    const stages = document.getElementsByClassName("stage");
    const firstStageElem = document.getElementsByTagName("signup_1")[0];
      const secondStageElem = document.getElementsByTagName("signup_2")[0];
      const thirdStageElem = document.getElementsByTagName("signup_3")[0];
      function toSecondStage(){
        firstStageElem.classList.add("inactive");
        secondStageElem.classList.remove("inactive");
        thirdStageElem.classList.add("inactive");
        stages[0].classList.remove("now");
        stages[1].classList.add("now");
        stages[2].classList.remove("now");
      }
      function toThirdStage(){
        firstStageElem.classList.add("inactive");
        secondStageElem.classList.add("inactive");
        thirdStageElem.classList.remove("inactive");
        stages[0].classList.remove("now");
        stages[1].classList.remove("now");
        stages[2].classList.add("now");
      }
      const validationElem = document.getElementById("idValidation")
      function extendValidationForm(){
        validationElem.classList.replace("inactive","slideDown");
      }
      const termElem = document.getElementById("termForm");
      const validationBtn = document.getElementById("validationExtend");
      function extendTermForm(){
        if(!validationBtn.classList.contains("extended")){  
          validationBtn.classList.add("extended");
          termElem.classList.replace("inactive","slideDown");
          validationBtn.src="../static/image/expandLess.png";
        }
        else{
          validationBtn.classList.remove("extended");
          termElem.classList.replace("slideDown","inactive");
          validationBtn.src="../static/image/expandMore.png";
        }
      }
      const termBtns = document.querySelectorAll('input[type]');
      function checkAllTerms(checkAll){
        termBtns.forEach((checkbox)=>{
          checkbox.checked = checkAll.checked;
        })
      }



//6. 이벤트 상세 페이지 - 호스트
const EVENT_MENUS = document.querySelectorAll(".eventMenu");
const EVENT_CONTENTS = document.querySelectorAll('.eventMenuContent');
const EVENT_BTNS = document.querySelectorAll(".eventMenuContentBtn")
  //이벤트 메뉴바 활성화
  EVENT_MENUS.forEach(function(menu, index){
    menu.addEventListener('click', event=>{
      if(menu.childNodes[0].id!="this"){
        menu.querySelector('span').id="this";
        EVENT_MENUS.forEach(otherMenu=>{
          if(otherMenu!= menu){
            otherMenu.querySelector('span').removeAttribute('id');
          }
        })
      }
      EVENT_CONTENTS.forEach(function(event, eventIndex){
        if(eventIndex == index) event.classList.remove('inactive');
        else event.classList.add('inactive');
      })
    })
  })


//7. 이벤트 상세 페이지 - 유저

//8. 전체 밍글리스트
  //캘린더 라디오 버튼
  var today = new Date();
  const CALENDAR_DATES = document.querySelectorAll(".calendarDate");
    CALENDAR_DATES.forEach(function(date, index){
      date.addEventListener('click',event=>{
        date.classList.add("selected");
        CALENDAR_DATES.forEach(otherDate=>{
          if(otherDate!=date){
            otherDate.classList.remove("selected");
          }
        })
      })
      if(date.childNodes[3].innerHTML==today.getDate()) {
        date.childNodes[3].innerHTML="오늘";
        date.childNodes[3].id="today";
      }
    })
  
  //이벤트 라인
  const EVENTS = document.getElementsByClassName("eventListContent");
  if(EVENTS){
    var eventLineHeight = EVENTS.length * 77;
    console.log(eventLineHeight);
    $('#eventLine').css('height', String(eventLineHeight)+"px");
  }



//9. 내 참여리스트

//10. 홈_검색

//11. 밍글 이벤트 만들기
  //카테고리 라디오 버튼
  const EVENT_CATEGORIES = document.querySelectorAll(".category");
  EVENT_CATEGORIES.forEach(function(category, index){
    category.addEventListener('click',event=>{
      category.classList.add("selected");
      EVENT_CATEGORIES.forEach(otherCategory=>{
        if(otherCategory!=category){
          otherCategory.classList.remove("selected");
        }
      })
    })
  })

  //날짜 라디오 버튼
  const EVENT_DATES = document.querySelectorAll(".mingleDate");
  EVENT_DATES.forEach(function(date, index){
    date.addEventListener('click',event=>{
      date.classList.add("selected");
      EVENT_DATES.forEach(otherDate=>{
        if(otherDate!=date){
          otherDate.classList.remove("selected");
        }
      })
    })
  })

  //인원 최대 & 최소
  const MIN_NUM = document.getElementsByClassName("minglePersonNumber")[0];
  const MAX_NUM = document.getElementsByClassName("minglePersonNumber")[1];
  const MIN_DEC_BTN = document.getElementsByClassName("minglePersonNumberOptionDec")[0];
  const MAX_DEC_BTN = document.getElementsByClassName("minglePersonNumberOptionDec")[1];
  const MIN_INC_BTN = document.getElementsByClassName("minglePersonNumberOptionInc")[0];
  const MAX_INC_BTN = document.getElementsByClassName("minglePersonNumberOptionInc")[1];

  if(MIN_NUM){
    var minNum = MIN_NUM.innerText;
  }
  if(MAX_NUM){
    var maxNum = MAX_NUM.innerText;
  }
  if(MIN_DEC_BTN){
    MIN_DEC_BTN.addEventListener("click",function(){
      if(minNum>3){
          minNum--;
          MIN_NUM.innerHTML = minNum;
          if(minNum<10){
            MIN_INC_BTN.classList.remove("inactiveBtn");
          }
      }
      if(minNum<=3){
        MIN_DEC_BTN.classList.add("inactiveBtn");
      }
    });
  }
  if(MIN_INC_BTN){
    MIN_INC_BTN.addEventListener("click",function(){
      if(minNum<10){
          minNum++;
          MIN_NUM.innerHTML = minNum;
          if(minNum>3){
            MIN_DEC_BTN.classList.remove("inactiveBtn");
          }
      }
      if(minNum>=10){
        MIN_INC_BTN.classList.add("inactiveBtn");
      }
    })
  }
  if(MAX_DEC_BTN){
    MAX_DEC_BTN.addEventListener("click",function(){
      if(maxNum>3){
          maxNum--;
          MAX_NUM.innerHTML = maxNum;
          if(maxNum<10){
            MAX_INC_BTN.classList.remove("inactiveBtn");
          }
      }
      if(maxNum<=3){
        MAX_DEC_BTN.classList.add("inactiveBtn");
      }
    });
  }
  if(MAX_INC_BTN){
    MAX_INC_BTN.addEventListener("click",function(){
      if(maxNum<10){
          maxNum++;
          MAX_NUM.innerHTML = maxNum;
          if(maxNum>3){
            MAX_DEC_BTN.classList.remove("inactiveBtn");
          }
      }
      if(maxNum>=10){
        MAX_INC_BTN.classList.add("inactiveBtn");
      }
    })
  }

  //나중에 정할래요
  const LOCATION_OPTION_LATER = document.getElementById("locationOption-later");
  const LOCATION_SELECTED = document.getElementById("locationSelected");
  let LOCATION_SELECTED_PLACEHOLDER = document.getElementById("locationSelectedPlaceholder");
  if(LOCATION_OPTION_LATER){
    LOCATION_OPTION_LATER.addEventListener("click",function(){
      LOCATION_SELECTED.classList.remove("inactiveBtn");
      LOCATION_SELECTED.classList.add("greenBorder");
      LOCATION_SELECTED_PLACEHOLDER.innerHTML = "국제캠퍼스 정문";
    })

  }

  //날짜&시간 동적 배치
  const WEEKDAY = ['일', '월', '화', '수', '목', '금', '토'];
  let now = new Date();
  let tomorrow = new Date();
  let tomorrow2 = new Date();
  let tomorrow3 = new Date();
  let tomorrow4 = new Date();
  let tomorrow5 = new Date();
  let tomorrow6 = new Date();
  now.setDate(new Date().getDate());
  tomorrow.setDate(new Date().getDate() + 1);
  tomorrow2.setDate(new Date().getDate() + 2);
  tomorrow3.setDate(new Date().getDate() + 3);
  tomorrow4.setDate(new Date().getDate() + 4);
  tomorrow5.setDate(new Date().getDate() + 5);
  tomorrow6.setDate(new Date().getDate() + 6);
  let nowDate = now.getDate();
  let nowDay = now.getDay();
  let nowMonth = now.getMonth();
  let nowHour = (now.getMinutes()>30 ? (now.getHours()+1 == 13 ? 1 : now.getHours()+1) : now.getHours());
  let nowMin = (now.getMinutes()<=30 ? 30 : "00");
  let nextHour = (nowHour+1 == 13 ? 1 : nowHour+1);
  const MINGLE_START_TIME_HOUR = document.getElementById("mingleStartTimeHour");
  const MINGLE_START_TIME_MIN = document.getElementById("mingleStartTimeMin");
  const MINGLE_END_TIME_HOUR = document.getElementById("mingleEndTimeHour");
  const MINGLE_END_TIME_MIN = document.getElementById("mingleEndTimeMin");
  if(MINGLE_START_TIME_HOUR) MINGLE_START_TIME_HOUR.innerHTML = nowHour;
  if(MINGLE_START_TIME_MIN) MINGLE_START_TIME_MIN.innerHTML = nowMin;
  if(MINGLE_END_TIME_HOUR) MINGLE_END_TIME_HOUR.innerHTML = nextHour;
  if(MINGLE_END_TIME_MIN) MINGLE_END_TIME_MIN.innerHTML = nowMin;
  if(document.getElementById("day+0")) document.getElementById("day+0").innerHTML = WEEKDAY[now.getDay()];
  if(document.getElementById("day+1")) document.getElementById("day+1").innerHTML = WEEKDAY[tomorrow.getDay()];
  if(document.getElementById("day+2")) document.getElementById("day+2").innerHTML = WEEKDAY[tomorrow2.getDay()];
  if(document.getElementById("day+3")) document.getElementById("day+3").innerHTML = WEEKDAY[tomorrow3.getDay()];
  if(document.getElementById("day+4")) document.getElementById("day+4").innerHTML = WEEKDAY[tomorrow4.getDay()];
  if(document.getElementById("day+5")) document.getElementById("day+5").innerHTML = WEEKDAY[tomorrow5.getDay()];
  if(document.getElementById("day+6")) document.getElementById("day+6").innerHTML = WEEKDAY[tomorrow6.getDay()];
  if(document.getElementById("date+1")) document.getElementById("date+1").innerHTML = tomorrow.getDate();
  if(document.getElementById("date+2")) document.getElementById("date+2").innerHTML = tomorrow2.getDate();
  if(document.getElementById("date+3")) document.getElementById("date+3").innerHTML = tomorrow3.getDate();
  if(document.getElementById("date+4")) document.getElementById("date+4").innerHTML = tomorrow4.getDate();
  if(document.getElementById("date+5")) document.getElementById("date+5").innerHTML = tomorrow5.getDate();
  if(document.getElementById("date+6")) document.getElementById("date+6").innerHTML = tomorrow6.getDate();


//12. 마이페이지

  //프로필 캐릭터 설정
  const PROFILE_SAMPLES = document.querySelectorAll(".character img");
  const PROFILE_CHANGE_BTN = document.querySelector("#btnChangeProfile");
  PROFILE_SAMPLES.forEach(function(sample, index){
    sample.addEventListener('click', event=>{
      PROFILE_CHANGE_BTN.classList.add('validated')
      if(!sample.src.includes('_selected.png')){
        sample.src= sample.src.slice(0,-4)+'_selected.png';
        PROFILE_SAMPLES.forEach(function(otherSample, otherIndex){
          if(otherSample != sample && otherSample.src.includes('_selected')){
            otherSample.src = otherSample.src.replace('_selected','')
          }
        })
      }
    })
  })


/* 채워넣어야 할 변수들*/
//1. 닉네임
let NICKNAME = document.querySelectorAll("#var-nickname");

//2. 단과대학
let COLLEGE = document.querySelectorAll("#var-college");

//3. 학과
let MAJOR = document.querySelectorAll("#var-major");

//4. 학번 (형식 : NN)
let CLASS = document.querySelectorAll("#var-studentClass");

//5. 학번 (형식 : 2019102230) => 10자리
let ID = document.querySelectorAll("#var-studentID");

//6. 성별
let GENDER = document.querySelectorAll("#var-gender");

//7. 이름
let NAME = document.querySelectorAll("#var-name");

//8. 휴대폰 번호
let PHONENUMBER = document.querySelectorAll("#var-phoneNum");

//9. 이메일
let EMAIL = document.querySelectorAll("#var-email");

//10. 프로필 사진
let PROFILE = document.querySelectorAll("#var-profile");

//11. 주최 횟수 (형식 : "N회")
let NUM_HOLDING_EVENTS = document.querySelectorAll("#var-numOfHoldingEvents");

//12. 참여 횟수 (형식 : "N회")
let NUM_PARTICIPATIONS = document.querySelectorAll("#var-numOfParticipation");

//13. 이벤트 제목 
let EVENT_TITLE = document.querySelectorAll("#var-eventTitle");

//14. 이벤트 날짜 
  //(1) 날짜 (형식 : "M.D")
  //  => ex) 11.1 , 3.12 
  let EVENT_DATE = document.querySelectorAll("#var-eventDate");

  //(2) 요일 (형식 : "N요일")
  let EVENT_DAY = document.querySelectorAll("#var-eventDay");

//15. 이벤트 시간
  //(1) 이벤트 시작시간 (형식 : "HH:MM")
  //  HH는 24시간 기준
  //  MM는 숫자 0 포함
  //  =>  ex) 14:00 , 08::20 
  let EVENT_BEGIN_TIME = document.querySelectorAll("#var-eventBeginTime");

  //(2) 이벤트 종료시간 (형식 : "HH:MM")
  let EVENT_END_TIME = document.querySelectorAll("#var-eventEndTime");

//16. 이벤트 장소
let EVENT_LOCATION = document.querySelectorAll("#var-eventLocation");

//17. 이벤트 현재 인원 (형식 : N)
let EVENT_NOW_NUMBER = document.querySelectorAll("#var-eventNowNumber");

//18. 이벤트 최대 인원 (형식 : N)
let EVENT_MAX_NUMBER = document.querySelectorAll("#var-eventMaxNumber");

//19. 이벤트 내용 (형식 : 줄바꿈 포함해야함)
let EVENT_CONTENT = document.querySelectorAll("#var-eventContent");


let ELEMENTS = [NICKNAME, COLLEGE, MAJOR, CLASS, ID, GENDER, NAME, 
PHONENUMBER, EMAIL, PROFILE, NUM_HOLDING_EVENTS, NUM_PARTICIPATIONS, EVENT_TITLE,
EVENT_DATE, EVENT_DAY, EVENT_BEGIN_TIME, EVENT_END_TIME, EVENT_LOCATION, 
EVENT_NOW_NUMBER, EVENT_MAX_NUMBER, EVENT_CONTENT
]

