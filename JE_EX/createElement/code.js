//ol li の情報を取得
let list = document.getElementById("list");

//新しい要素の作成
let newLink = document.createElement("a");

//内容を挿入
newLink.innerHTML = "developer.mozilla.org";
list.append(newLink);

//list.after(newLink);

//新しい<li>を作成する
let item = document.createElement("li");
list.append(item);
list.append(newLink);

//要素の削除
let removeLink = document.getElementById("link-2");
//removeLink.remove
removeLink.parentNode.remove();

/**document.getElementById("button").onclick = function() {
  // ここに#buttonをクリックしたら発生させる処理を記述する
}; */


// document.getElementById("button").onclick=()=>{
//   処理
// }

let btnEvent = document.getElementById("button1");
btnEvent.onclick = function(){
    console.log("点击鼠标");
}

btnEvent.onclick = function(){
    console.log("再次点击鼠标");
}

/**対象の要素.addEventListener(種類, () => {
  // 処理を記述
}); */
// 対象の要素.addEventListener(種類, function() {
//    // 処理を記述
//  }, false);

btnEvent.addEventListener('click',()=>{
    console.log("ボタンクリックその３");
})

btnEvent.addEventListener('click',()=>{
    console.log("ボタンクリックその4");
})

//helloメソッド
function hello(){
    console.log("hello")
}