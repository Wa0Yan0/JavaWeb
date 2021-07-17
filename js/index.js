window.onload = function (){
    submit();
    check();
    createNote();
}
function submit(){
    let form = document.getElementById('form01');
    form.onsubmit = function (){
        let regExp = /^\w{5,12}$/;
        if(regExp.test(getUserName())){
            alert("用户名合法");
        }else{
            alert("用户名不合法");
            return false;
        }
    }
}
function getUserName(){
    let userInput = document.getElementById("username");
    let username =userInput.value;
    return username;
}
function check(){
    let allBtn = document.getElementById('all');
    allBtn.onclick = function (){
        let languages = document.getElementsByName("language");
        for (let i = 0; i < languages.length; i++) {
            languages[i].checked = true;
        }
    }

    let notBtn = document.getElementById('not');
    notBtn.onclick = function (){
        let languages = document.getElementsByName("language");
        for (let i = 0; i < languages.length; i++) {
            languages[i].checked = false;
        }
    }

    let fanBtn = document.getElementById('fan');
    fanBtn.onclick = function (){
        let languages = document.getElementsByName("language");
        for (let i = 0; i < languages.length; i++) {
            if(languages[i].checked){
                languages[i].checked = false;
            }else{
                languages[i].checked = true;
            }
        }
    }

}

function createNote(){
    let div = document.createElement("div");
    div.innerHTML = "王岩大帅哥";
    document.body.appendChild(div);
}