var sectionList = document.getElementsByTagName('section');
var aboutList = document.getElementsByClassName('about');

var btn = document.getElementById('header-btn_text');


btn.addEventListener('click',allElementReturn);
function displayNoneSection() {
    for(let i = 2;i < sectionList.length;i++) {
        sectionList[i].style.display = 'none';
        if(aboutList.length != 0) {
            displayNoneAbout();
        }
    }
}
function allElementReturn() {
    for(let i = 2;i < sectionList.length;i++) {
        sectionList[i].style.display = 'block';
        if(aboutList.length != 0) {
            displayAboutReturn();
        }
    }
    
}
function displayAboutReturn() {
    for(let i = 0;i < aboutList.length;i++) {
        if( aboutList[i].style.display != 'flex') {
            aboutList[i].style.display = 'flex';
        }
    }
}
function displayNoneAbout() {
    for(let i = 0;i < aboutList.length;i++) {
        aboutList[i].style.display = 'none';
    }
}
displayNoneSection();