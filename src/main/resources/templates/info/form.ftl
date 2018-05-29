<#include "../public/layout.ftl" />
<@body>
<form class="layui-form " method="post">
    <#if item??><input type="hidden" name="id" value="${item.id}"></#if>

    <div class="layui-form-item ">

        <label class="layui-form-label layui-input-required">所属分类</label>
        <div class="layui-input-block" style="width:20%">
            <select name="infoCateId" lay-verify="required">
                <option value="">选择分类</option>
                <#list infoCates as infoCate>
                    <option value="${infoCate.id}" ${(item.infoCateId == infoCate.id)?string("selected","")}>${infoCate.name}</option>
                </#list>
            </select>
        </div>
    </div>

    <div class="layui-form-item  on-selected">
        <label class="layui-form-label layui-input-required">标题</label>
        <div class="layui-input-block" style="width:50%">
            <input type="text" name="title" value="${(item.title)!}" lay-verify="required" class="layui-input form-item">
        </div>
    </div>

    <div class="layui-form-item ">
        <label class="layui-form-label layui-input-required">附件</label>
        <div class="layui-input-inline" style="width: 60%;">
            <button type="button" class="layui-btn" id="upload-file">
                <i class="layui-icon">&#xe67c;</i>上传图片
            </button>
            <input type="hidden" name="file" id="file-input" value="${(item.file)!}" />
            <div id="file-path"><a href="/${(item.file)!}" target="_blank">${(item.file)!}</a></div>
        </div>
    </div>

    <div class="layui-form-item on-selected">

        <label class="layui-form-label">内容</label>
        <div class="layui-input-block"  style="width:80%">
            <textarea class="layui-textarea" name="content">${(item.content)!}</textarea>
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

<script type="text/javascript">
    layui.use(['add']);

    layui.use('upload', function(){
        var $ = layui.jquery;
        layui.upload.render({
            elem: '#upload-file' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                $("#file-input").val(res.data);
                $("#file-path").html('<a href="/'+res.data+'" target="_blank">'+res.data+'</a>')
            }
        });
    });
</script>


