//配列の初期化
let arr = [1,2,3,"Alice",12.5];
//中身の確認
console.log(arr);
//配列の長さの確認
console.log(arr.length);


//配列に値の追加push
arr.push("追加");
//中身の確認
console.log(arr);


//中身の削除(删除最后一个变量)
arr.pop();
//中身の確認
console.log(arr);

//配列の作成
let arr2 = new Array(5);
arr2[0] = 23;
console.log(arr2);


/*
----------------------------------------------
オブジェクトの作成
*/
let obj = {name:"ひな",id:122,isStudent:true};
console.log(obj);

//名前を表示する
console.log(obj.name);
console.log(obj["name"]);

console.log(obj.id);

//上書きの仕方
obj.id = 130;
console.log(obj.id);
obj["isStudent"] = false;
console.log(obj["isStudent"]);

/*
----------------------------------------------
メソッド
*/
//メソッドの一
function printHello(){
    console.log("hello");
}
//メソッドを呼び出し
printHello();


//メソッドの二　return
function sum(a,b){
    return a + b;
}
//メソッドを呼び出し
console.log(sum(1,2))

//デフォルトパラメータ
function print(str1,str2="世界",str3="!!!"){
    console.log(str1+str2+str3)
}
print("ヤッホー");
print("ヤッホー","お昼休みした");
print("hello","word","byb")

//ラムダ式
let add = (x,y) => x+y;
console.log(add(3,7));