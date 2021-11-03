const dateElements = document.getElementsByClassName("mingleDate");
for (var i =0; i<dateElements.length; i++){
    dateElements[i].addEventListener("click",function(){
        for (var j =0; j<dateElements.length; j++){
            dateElements[j].classList.replace("selected","notSelected")
        };
        this.classList.replace("notSelected","selected")
    })
}