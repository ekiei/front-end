//ラベルの取得
let label = document.getElementById("label");
let button1 = document.getElementById("change-text1");
let button2 = document.getElementById("change-text2");
let button3 = document.getElementById("change-text3");

//リンゴに変更をクリックしたら初期表示を変更する
button1.addEventListener('click',()=>{
    label.innerHTML = "苹果"
})

//香蕉
button2.addEventListener('click',()=>{
    label.innerHTML = "香蕉"
})

//橘子
button3.addEventListener('click',()=>{
    label.innerHTML = "橘子"
})