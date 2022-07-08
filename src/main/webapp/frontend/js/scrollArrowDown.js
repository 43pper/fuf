var arrowCollectuon = document.getElementsByClassName('arrow');
var aboutList = document.getElementsByClassName('about');
var sectionList = document.getElementsByTagName('section');
for(let i = 0;i < arrowCollectuon.length;i++) {
    arrowCollectuon[i].addEventListener('click',blockVisible);
}
let count = 1;
let scrolValue = 950;
function blockVisible() {
  if(count < arrowCollectuon.length) {
    let aboutSection = arrowCollectuon[count].parentNode.parentNode.parentNode.parentNode 
    if(aboutList[count-1].style.display != 'flex') {
      aboutSection.style.display = 'block';
      aboutList[count-1].style.display = 'flex';
    }
    count++;
  }
  else {
    if(sectionList[3].style.display != 'block') {
      sectionList[3].style.display = 'block';
    }
    count = 1;
  }
  setTimeout(window.scroll({top:scrolValue,behavior:'smooth'}),1000);
  scrolValue += 950;
  if(scrolValue == 950 * 7) {
    scrolValue = 950;
  }
}
