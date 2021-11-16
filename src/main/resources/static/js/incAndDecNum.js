var minNum = document.getElementsByClassName("minglePersonNumber")[0].innerHTML;
var maxNum = document.getElementsByClassName("minglePersonNumber")[1].innerHTML;

const minNumElem = document.getElementsByClassName("minglePersonNumber")[0];
const maxNumElem = document.getElementsByClassName("minglePersonNumber")[1];
const minDecBtn = document.getElementsByClassName("minglePersonNumberOptionDec")[0];
const maxDecBtn = document.getElementsByClassName("minglePersonNumberOptionDec")[1];
const minIncBtn = document.getElementsByClassName("minglePersonNumberOptionInc")[0];
const maxIncBtn = document.getElementsByClassName("minglePersonNumberOptionInc")[1];

minDecBtn.addEventListener("click",function(){
    if(minNum>3){
        minNum--;
        minNumElem.innerHTML = minNum;
    }
})
minDecBtn.addEventListener(
    function(){minNum==3},
    function(){
        this.classList.add("disabled");
})
minIncBtn.addEventListener("click",function(){
    if(minNum<8){
        minNum++;
        minNumElem.innerHTML = minNum;
    }
})
maxDecBtn.addEventListener("click",function(){
    if(maxNum>3){
        maxNum--;
        maxNumElem.innerHTML = maxNum;
    }
})
maxIncBtn.addEventListener("click",function(){
    if(maxNum<8){
        maxNum++;
        maxNumElem.innerHTML = maxNum;
    }
})
