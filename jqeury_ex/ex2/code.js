$(function () {
    //<ol>の要素の取得
    let list = $("#list");
    //新しい<a>要素追加
    let newLink = $("<a>");
    newLink.html("developer.mozilla.org");
    //添加在列表最后
    list.append(newLink);

    //小测试,添加一行文字(小tips,先制作再追加)
    let newText = $("<p>");
    newText.html("And more...");
    list.after(newText);


    //制作新列表并把a放进去
    let newItem = $("<li>");
    list.append(newItem);
    //添加内容
    newItem.append(newLink);



    //list全部消除--remove
    //list.remove();

    //清空列表
    // list.empty();

    //点击按钮后的动作 onclick
    $("#button1").click(() => {
        console.log("你好");
    })

    //点击按钮后的动作 addclick
    $("#button1").on("click", () => {
        console.log("再见");
    })
})
