<#include "../public/layout.ftl" />
<@body>
<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form">
        <div class="layui-inline">
            <a class="layui-btn btn-add btn-default layer-open"  w="500px" h="400px"  title="添加" data-url="/${base}/0"><i class="layui-icon">&#xe654;</i>添加</a>
            <a class="layui-btn btn-add btn-default " onclick="location.reload()"><i class="layui-icon">&#x1002;</i>刷新</a>
        </div>
    </form>
</blockquote>


<table class="layui-table">
    <thead>
    <tr class="table-head ">
        <th width="30">ID</th>
        <th>名称</th>
        <th width="200">创建时间</th>
        <th width="200">操作</th>
    </tr>
    </thead>
    <tbody>
    <#list page.content as item>
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.createTime}</td>
        <td>
            <a class="layui-btn  layui-btn-sm layer-open" w="500px" h="400px"  data-url="/${base}/${item.id}">编辑</a>
            <a class="layui-btn layui-btn-sm layui-btn-danger delete"  data-url="/${base}/${item.id}">删除</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<div class="adminui-page" id="page" count="${page.totalElements}"></div>

</@body>