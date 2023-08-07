//要素を取得
let result = document.getElementById("text-result");
let buttonReset = document.getElementById("change-text1");
let buttonAdd = document.getElementById("change-text2");
let buttonSub = document.getElementById("change-text3");

//値を文字列で定数にしておく
const BASE_TEXT = "値："

//計算結果
let resultValue = 0;

//値を表示するメソッド
function changeResultText(){
    result.innerHTML = BASE_TEXT + resultValue;
}

//計算するメソッド
function calculateResultValue(setValue){
    resultValue = resultValue + setValue;
}

//リセットする
buttonReset.addEventListener('click',()=>{
    //値を初期化
    resultValue = 0
    changeResultText();
})

//加算する
buttonAdd.addEventListener('click',()=>{
    calculateResultValue(1);
    changeResultText();
})

//減算する
buttonSub.addEventListener('click',()=>{
    calculateResultValue(-1);
    changeResultText();
})