const title = document.getElementsByTagName("title")[0].innerHTML;
const HEADER_TITLE_ELEM = document.getElementById("header_title")
console.log(title);
if(HEADER_TITLE_ELEM){
    HEADER_TITLE_ELEM.innerHTML = title;
    HEADER_TITLE_ELEM.innerText = title;
}