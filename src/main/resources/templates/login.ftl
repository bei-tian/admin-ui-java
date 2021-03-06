<#include "public/layout.ftl" />
<@body>
    <div class="login-main">
        <header class="layui-elip">后台登录</header>
        <form class="layui-form">
            <div class="layui-input-inline">
                <input type="text" name="account" required lay-verify="required" placeholder="邮箱" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline login-btn">
                <button lay-submit class="layui-btn" lay-filter="*">登录</button>
            </div>

        </form>
    </div>


<script>
    layui.use(['layer','form'], function(){
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        form.on('submit(*)', function(data){
            $.post('/login',data.field,function(data) {
                if(data.code === 200) {
                    location.href = '/';
                }else {
                    layer.msg(data.msg);
                }
            },'json');
            return false;
        });
    });
</script>
</@body>