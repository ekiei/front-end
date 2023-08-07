$(function(){
    //这是写jQuery的地方
    //要素の取得
    let text = $("#text-1");
    //要素の内容の取得ーーhello
    console.log(text.html());
    //要素の内容の変更
    text.html("bye");


    //LINK
    //link要素の取得
    let link = $("#link-1");
    //link urlの取得
    console.log(link.attr("href"));
    //linkのurlの書き換え
    link.attr("href","http://www.thuong-ps.com");
    link.attr("target","_blank")

    //cssの話
    let texts = $(".text-class");
    //取ってきた要素に色をつける
    texts.css("color","blue");

})
