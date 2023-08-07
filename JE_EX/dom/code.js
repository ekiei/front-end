//要素の取得
let text = document.getElementById("text-1");
console.log(text);
//要素の内容を取得
console.log(text.innerHTML);

//要素の内容を変更
text.innerHTML = "Hello";

//aタグのリンクを取得　id link-1
let link = document.getElementById("link-1");
console.log(link);
//要素の内容を取得
console.log(link.innerHTML);
//href リンクの内容を取得
console.log(link.href);
//urlの変更
link.href = "https://developer.mozilla.org";
//target_blankを付け足す
link.target = "_blank";

//クラスを指定して値を取得するex-1
let ex1 = document.getElementsByClassName("ex-1");
console.log(ex1);
console.log(ex1[0]);

//ダグ名を指定して値を取得するdiv
let ex2 = document.getElementsByTagName("div");
console.log(ex2);