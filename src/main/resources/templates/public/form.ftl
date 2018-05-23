<script>
    layui.use(['layer','form'], function(){
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        form.on('submit(*)', function(data){
            $.ajax({
                url: location.href,
                type: 'PUT',
                data: data.field,
                dataType:'json',
                success: function(data) {
                    if(data.code === 200) {
                        layer.msg("保存成功！");
                        top.layui.jquery(".layui-show iframe")[0].contentWindow.location.reload();
                        top.layui.layer.closeAll();
                    }else {
                        layer.msg(data.msg, {icon: 5,shift: 6});
                    }
                }
            });
            return false;
        });
    });
</script>