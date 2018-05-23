<#include "../public/layout.ftl" />
<@body>
<form class="layui-form " method="post">
    <#if item??><input type="hidden" name="id" value="${item.id}"></#if>

    <div class="layui-form-item  on-selected">
        <label class="layui-form-label layui-input-required">名称</label>
        <div class="layui-input-block" style="width:50%">
            <input type="text" name="name" value="${(item.name)!}" lay-verify="required" class="layui-input form-item">
        </div>
    </div>

    <div class="layui-form-item ">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</@body>

<#include "../public/form.ftl" />


