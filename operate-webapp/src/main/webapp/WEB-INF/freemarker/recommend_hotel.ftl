<table id="recommend_hotel_list" class="easyui-datagrid" style="width:auto;height:auto"
       data-options="
                idField:'id',
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#recommend_hotel_toolbar',
				url: '/recommend/hotel/list',
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
        <th data-options="field:'hotelName',width:150,align:'center'">酒店名称</th>
        <th data-options="field:'recommendTitle',width:400,align:'center'">推荐标题</th>
        <th data-options="field:'recommendTime',width:150,align:'center'">推荐时间</th>
        <th data-options="field:'updateTime',width:150,align:'center'">更新时间</th>
        <th data-options="field:'createTime',width:150,align:'center'">创建时间</th>
        <th data-options="field:'status',width:60,align:'center'"> 预览</th>
    </tr>

    </thead>
</table>

<div id="recommend_hotel_toolbar" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       onclick="add_recommend_hotel()">添加推荐酒店</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       onclick="edit_recommend_hotel_with_id()">修改推荐酒店信息</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       onclick="del_recommend_hotel()">删除推荐酒店</a>
</div>

<div id="recommend_hotel_window"></div>

<script type="text/javascript">
    function add_recommend_hotel() {
        $('#recommend_hotel_window').window({
            title: '添加推荐酒店',
            width: 900,
            height: 600,
            modal: true,
            href: constant.win_recommend_add.content_link,
            iconCls: 'icon-add',
            collapsible: false,
            minimizable: false,
            maximizable: false,
            draggable: false
        });
    }

    function del_recommend_hotel() {
        var checkedItems = $('#recommend_hotel_list').datagrid('getChecked');
        if (checkedItems == 0) {
            $.messager.alert('注意', constant.message.delete_recommend_hotel_message);
            return;
        }
        var ids = '?';
        $.each(checkedItems, function (index, item) {
            ids += 'id=' + item.id + '&';
        });

        $.ajax({
            type: "post",
            url: constant.delete_recommend_hotel_link + ids,
            success: function (data) {
                if (data.result == "success") {
                    $('#recommend_hotel_list').datagrid('reload');
                    $.messager.show({msg: constant.delete_recommend_hotel_success_message});
                }
            }
        });
    }

    function edit_recommend_hotel_with_id() {
        var checkedItems = $('#recommend_hotel_list').datagrid('getChecked');

        if (checkedItems == 0) {
            $.messager.alert('注意', constant.message.select_recommend_hotel_message);
            return;
        }

        if (checkedItems.length > 1) {
            $.messager.alert('注意', constant.message.edit_recommend_hotel_message);
            return;
        }

        constant.global_param.hotel_id =  checkedItems[0].id
        $('#recommend_hotel_window').window({
            title: '修改推荐酒店信息',
            width: 900,
            height: 600,
            modal: true,
            href: constant.win_recommend_hotel_edit.content_link + checkedItems[0].id,
            iconCls: 'icon-add',
            collapsible: false,
            minimizable: false,
            maximizable: false,
            draggable: false
        });
    }

</script>
