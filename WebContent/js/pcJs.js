function openclose(){
    var title = document.getElementById("menu").title;
    title=="open"?openNav():closeNav();
    function openNav(){
        document.getElementById("leftMenu").style.width="150px";
        document.getElementById("main").style.marginLeft="150px";
        document.getElementById("menu").title="close";
    }
    function closeNav(){
        document.getElementById("leftMenu").style.width="0";
        document.getElementById("main").style.marginLeft="0";
        document.getElementById("menu").title="open";
    }
}