layui.define(['layer','form'], function (exports) {
    var $ = layui.jquery;

    //弹出一个窗口
    $('.layer-open').click(function(){
        var title = $(this).attr('title');
        if(!title) {
            title = $(this).html();
        }
        var width = $(this).attr('w') || '1000px';
        var height = $(this).attr('h') || '600px';
        var url = $(this).data('url');
        parent.layer.open({
            type: 2,
            title: title,
            area: [width, height], //宽高
            content: url
        });
        return false;
    });


    //删除
    $(".delete").click(function () {
        if(confirm('确定要删除该条记录吗？')) {
            $.ajax({
                url: $(this).data('url'),
                type: 'DELETE',
                dataType:'json',
                success: function(data) {
                    if(data.code === 200) {
                        layer.msg("删除成功！");
                        location.reload();
                    }else {
                        layer.msg(data.msg, {icon: 5,shift: 6});
                    }
                }
            });
        }
    });

    var mod = {};

    exports('common', mod);
});


