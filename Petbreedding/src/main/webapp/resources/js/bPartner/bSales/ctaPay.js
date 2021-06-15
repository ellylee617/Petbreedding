/**
 * 
 */

window.onload = function () {

    document.getElementById("allAgr").onclick = function () {
        for (var i = 0; i < args.length; i++) {
            if (this.checked) {
                args[i].checked = true;
            } else {
                args[i].checked = false;
            }
        };
    }

    var args = document.getElementsByName("args");
    for (var i = 0; i < args.length; i++) {
        args[i].onclick = aClick;
    }
};

function aClick() {
    var cnt = 0;
    var args = document.getElementsByName("args");
    for (var i = 0; i < args.length; i++) {
        if (args[i].checked) {
            cnt++
        }
    }
    if (cnt == args.length) {
        allAgr.checked = true;
    } else {
        allAgr.checked = false;
    }
}

