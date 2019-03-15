var inst = new mdui.Dialog('#single-chat', {
    modal: true
});


/**
 * 开始聊天
 */
function show_signle_dialog() {
    var nick_name = $('#nick_name').val();
    if (nick_name == '') {
        $('#nick_name').focus();
        mdui.snackbar({
            message: '请输入一个昵称'
        });
        return;
    }
    // 将昵称记录到cookie
    $.cookie('FC_NICKNAME', nick_name, {expires: 7});
    inst.open();
    // socket.emit('upname', nick_name);
}


/**
 * 发送消息
 */
function send_msg() {
    var msg = $('#chat_msg').val();
    var html = '<p class="mdui-m-b-3 m_mess"><span class="chat-box-pink">我 : ' + msg + '</span></p>';
    $('.mdui-dialog-content .chat-body').append(html);
    $('.mdui-dialog-content .chat-body').scrollTop($('.mdui-dialog-content .chat-body').height());
    $('#chat_msg').val('');
    $('#chat_msg').focus();
    $.get("/api?mess="+msg,function (result) {
        var msg = result;
        var html = '<p class="mdui-m-b-3"><span class="chat-box-green"> Robot: ' + msg + '</span></p>';
        $('.mdui-dialog-content .chat-body').append(html);
        $('.mdui-dialog-content .chat-body').scrollTop($('.mdui-dialog-content .chat-body').height());
    })

}

$(function () {
    window.setInterval(function(){
        $.get("/count",function(result){
            console.log(result)
            $('#current_users').html(result);
        });
    },2000);
});