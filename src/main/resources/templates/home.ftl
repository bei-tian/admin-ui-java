<#include "public/layout.ftl" />
<@body>
<!-- layout admin -->
<div class="layui-layout layui-layout-admin">
    <!-- header -->
    <div class="layui-header my-header">
        <a href="index.html">
            <!--<img class="my-header-logo" src="" alt="logo">-->
            <div class="my-header-logo">admin-ui</div>
        </a>
        <div class="my-header-btn">
            <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe65f;</i></button>
        </div>

        <!-- 顶部导航 -->
        <ul class="layui-nav admin-top-nav" lay-filter="admin-top-nav">
        </ul>



        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon">&#xe629;</i>主题</a>
                <dl class="layui-nav-child">
                    <dd data-theme="default"><a href="javascript:;">默认</a></dd>
                    <dd data-theme="blue"><a href="javascript:;">蓝白</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"> Admin </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" data-href="pages/login.html"><i class="layui-icon">&#xe621;</i>登录页</a></dd>
                    <dd><a href="javascript:;" data-href="pages/map.html"><i class="layui-icon">&#xe621;</i>图表</a></dd>
                    <dd><a href="/"><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side">
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree admin-ui-menu" lay-filter="side-main">
                <!--<li class="layui-nav-item layui-nav-itemed">-->
                <!--<a href="javascript:;"><i class="layui-icon">&#xe620;</i>基础</a>-->
                <!--<dl class="layui-nav-child">-->
                <!--<dd><a href="javascript:;" data-href="pages/btn.html"><i class="layui-icon">&#xe621;</i>按钮</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/form.html"><i class="layui-icon">&#xe621;</i>表单</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/table.html"><i class="layui-icon">&#xe621;</i>表格</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/tab-card.html"><i class="layui-icon">&#xe621;</i>选项卡</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/progress-bar.html"><i class="layui-icon">&#xe621;</i>进度条</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/folding-panel.html"><i class="layui-icon">&#xe621;</i>折叠面板</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/auxiliar.html"><i class="layui-icon">&#xe621;</i>辅助元素</a></dd>-->
                <!--</dl>-->
                <!--</li>-->
                <!--<li class="layui-nav-item">-->
                <!--<a href="javascript:;"><i class="layui-icon">&#xe628;</i>扩展</a>-->
                <!--<dl class="layui-nav-child">-->
                <!--<dd><a href="javascript:;" data-href="pages/login.html"><i class="layui-icon">&#xe621;</i>登录页</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/register.html"><i class="layui-icon">&#xe621;</i>注册页</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/login2.html"><i class="layui-icon">&#xe621;</i>登录页2</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/map.html"><i class="layui-icon">&#xe621;</i>图表</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/add-edit.html"><i class="layui-icon">&#xe621;</i>添加-修改</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/data-table.html"><i class="layui-icon">&#xe621;</i>data-table 表格页</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/tree-table.html"><i class="layui-icon">&#xe621;</i>Tree table树表格页</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/404.html"><i class="layui-icon">&#xe621;</i>404页</a></dd>-->
                <!--<dd><a href="javascript:;" data-href="pages/tips.html"><i class="layui-icon">&#xe621;</i>提示页</a></dd>-->
                <!--</dl>-->
                <!--</li>-->

            </ul>

        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="1"><span><i class="layui-icon">&#xe638;</i>欢迎页</span></li>
            </ul>
            <div class="layui-tab-content admin-tabsbody">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src="/html/welcome.html" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- 右键菜单 -->
<div class="my-dblclick-box none">
    <table class="layui-tab dblclick-tab">
        <tr class="card-refresh">
            <td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
        </tr>
    </table>
</div>

<script type="text/javascript" src="/lib/adminui/adminui.js"></script>
<script type="text/javascript">
    layui.use(['adminui-nav'], function () {
        layui['adminui-nav'].init('/home/nav');//导航数据api接口
    });
</script>
</@body>