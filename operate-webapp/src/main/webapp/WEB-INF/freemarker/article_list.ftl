<table id="article_list" class="easyui-datagrid" style="width:auto;height:auto"
       data-options="
                idField:'id',
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#article_list_toolbar',
				url: '/article/list',
				method: 'get',
				singleSelect:true,
				pagination:true,
				rownumbers:true,
				checkbox:true,
				singleSelect: false,
                selectOnCheck: true,
                checkOnSelect: true
			">
    <thead>
    <tr>
        <th data-options="field:'title',width:150,align:'center'">文章标题</th>
        <th data-options="field:'subTitle',width:150,align:'center'">文章子标题</th>
        <th data-options="field:'textBody',width:400,align:'center'">文章内容</th>
        <th data-options="field:'praiseCount',width:50,align:'center'">点击率</th>
        <th data-options="field:'updateTime',width:150,align:'center'">更新时间</th>
        <th data-options="field:'createTime',width:150,align:'center'">创建时间</th>
        <th data-options="field:'status',width:60,align:'center'"> 预览</th>
    </tr>

    </thead>
</table>

<div id="article_list_toolbar" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       onclick="open_add_article()">添加文章</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       onclick="edit_article_with_id()">修改</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       onclick="del_articles_with_ids()">删除</a>
</div>
<div id="add_article_window"></div>
<div id="edit_article_window"></div>

<script type="text/javascript">

    function open_add_article() {
        $('#add_article_window').window({
            title: '添加新文章',
            width: 600,
            height: 600,
            modal: true,
            href: constant.win_article_add.content_link,
            iconCls: 'icon-add',
            collapsible: false,
            minimizable: false,
            maximizable: false,
            draggable: false
        });

        $('#add_article_window').window({
            onBeforeClose:function(){

            }
        });

    }

    function del_articles_with_ids() {
        var checkedItems = $('#article_list').datagrid('getChecked');
        if (checkedItems == 0) {
            $.messager.alert('注意', constant.message.delete_article_message);
            return;
        }
        var ids = '?';
        $.each(checkedItems, function (index, item) {
            ids += 'id=' + item.id + '&';
        });

        $.ajax({
            type: "post",
            url: constant.delete_article_link + ids,
            success: function (data) {
                console.debug(data)
                if (data.result == "success") {
                    $('#article_list').datagrid('reload');
                    $.messager.show({msg: constant.delete_article_success_message});
                }
            }
        });

    }

    function edit_article_with_id() {
        var checkedItems = $('#article_list').datagrid('getChecked');

        if (checkedItems == 0) {
            $.messager.alert('注意', constant.message.select_article_message);
            return;
        }

        if (checkedItems.length > 1) {
            $.messager.alert('注意', constant.message.edit_article_message);
            return;
        }

        constant.global_param.article_id = checkedItems[0].id;
        $('#edit_article_window').window({
            title: '修改文章',
            width: 600,
            height: 600,
            modal: true,
            href: constant.win_article_edit.content_link,
            iconCls: 'icon-add',
            collapsible: false,
            minimizable: false,
            maximizable: false,
            draggable: false
        });
    }
</script>

