const HOUR_LEFT_FOR_OPENING = document.getElementById("hourLeftForOpening");
const MIN_LEFT_FOR_OPENING = document.getElementById("minLeftForOpening");
const SEC_LEFT_FOR_OPENING = document.getElementById("secLeftForOpening");
const EVENT_CONTENT_BTNS = document.querySelectorAll(".eventMenuContentBtn");


//이벤트 오픈 시간 임시 변수 : 현재 시간으로 받아놨으니 수정해서 사용해주세요 !
let openTime = new Date("2021-11-15 02:07:00");

var x = setInterval(function(){
    let nowTime = new Date();

    var delta = (openTime - nowTime) / 1000;
    
    if(delta<=0){
        /* 카운트다운이 끝나면*/
        HOUR_LEFT_FOR_OPENING.innerText = "00";
        MIN_LEFT_FOR_OPENING.innerText = "00";
        SEC_LEFT_FOR_OPENING.innerText = "00";

        EVENT_CONTENT_BTNS[1].classList.add("inactive");
        EVENT_CONTENT_BTNS[2].classList.remove("inactive");
    }
    else{
        var days = Math.floor(delta / 86400);
        delta -= days * 86400;
        
        var hours = Math.floor(delta / 3600) % 24;
        delta -= hours * 3600;
        hours += days*24;
        if (hours < 10) hours = "0"+String(hours);
        
        var minutes = Math.floor(delta / 60) % 60;
        delta -= minutes * 60;
        if (minutes < 10) minutes = "0"+String(minutes);
        
        var seconds = Math.floor(delta % 60);
        if (seconds < 10) seconds = "0"+String(seconds);
        
        let hourLeftForOpening = hours;
        let minLeftForOpening = minutes;
        let secLeftForOpening = seconds;
        
        HOUR_LEFT_FOR_OPENING.innerText = hourLeftForOpening;
        MIN_LEFT_FOR_OPENING.innerText = minLeftForOpening;
        SEC_LEFT_FOR_OPENING.innerText = secLeftForOpening;
    }
},1000)
