<div>
    <form id="form_edit_recommend_hotel" class="easyui-form" method="post" data-options="novalidate:true">
        <div>
            <table cellpadding="5">
                <tr>
                    <td>
                        <div>
                            <div style="float: left">
                                <span style="margin-right: 8px;font-size: 12px">酒店名称:</span>
                                <input class="easyui-textbox" type="text"
                                       name="hotelName"
                                       data-options="required:true"
                                       value="${recommendHotel.hotelName}"
                                        />
                            </div>
                            <div style="float: left;margin-left: 5px">
                                <span>推荐标题：</span>
                                <input class="easyui-textbox" style="width: 220px" type="text"
                                       name="recommendTitle"
                                       data-options="required:true"
                                       value="${recommendHotel.recommendTitle}"
                                        /></div>
                            <div style="float: left;margin-left: 5px">
                                <span>推荐日期：</span>
                                <input type="text" class="easyui-datebox" data-options="required:true"
                                       name="recommendTime"
                                       value="${recommendHotel.recommendTime}"
                                        />
                            </div>
                            <div style="float: left;margin-left: 5px">
                                <a href="javascript:void(0)" class="easyui-linkbutton"
                                   onclick="add_edit_recommend_reason()">添加推荐理由</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <div id="edit_recommend_reasons">
        <#list recommendHotel.reasons as reason>
            <div style='margin-left: 5px'>
                <div style='margin-bottom: 5px'>
                    <span style='color: red'>推荐标签：${reason_index+1}</span>
                    <input name='reason[${reason_index}].title' type='text' class='easyui-textbox'
                           value="${reason.title}"
                           data-options='required:true'/>
                </div>
                <div><span style='color: red'>推荐描述：</span></div>
                <div style='margin-bottom: 10px'>
                    <div style='float: left;width: 500px'>
                        <textarea name='reason[${reason_index}].describe' class='easyui-textbox'
                                  style='width: 490px;height: 85px;font-size: 12px'
                                  data-options='required:true'>${reason.describe}</textarea></div>
                    <div style='clear: both'></div>
                </div>
            </div>

            <div>
                <table>
                    <tr>
                        <#list reasonImageList as image>
                            <td><input type='radio' name='reason[${reason_index}].imgId' value='${image.id}'
                                       <#if reason.imgId==image.id>checked=true </#if>
                                    /></td>
                            <td><img width='16px' height='18px' src='${image.url}'/>

                            </td>
                        </#list>
                    </tr>
                </table>
            </div>
        </#list>
        </div>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submit_recommend_hotel_edit()">修改推荐酒店</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="form_clear('form_add_recommend_hotel')">重新填写信息</a>
        </div>
    </form>
</div>

<script type="text/javascript">
    var reason_number = ${recommendHotel.reasons?size};

    function add_edit_recommend_reason() {
        $.get("/recommend/images/list", function (result) {
            var replace_reason_icon = result.replace(/rid/g, reason_number);

            var text = template.recommend_hotel_template.template_txt.replace(/{number}/g, reason_number + 1).replace(/{rid}/g, reason_number).replace(/{recommend_icon}/g, replace_reason_icon);

            $('#edit_recommend_reasons').append(text);
            reason_number += 1;
        });
    }

    function submit_recommend_hotel_edit() {
        $('#form_edit_recommend_hotel').form('submit', {
            url: constant.edit_recommend_hotel_link + constant.global_param.hotel_id,
            onSubmit: function () {
                return $(this).form('enableValidation').form('validate');
            },
            success: function (data) {
                var data_json = JSON.parse(data);
                if (data_json.result == "success") {
                    $('#recommend_hotel_window').window('close');
                    $('#recommend_hotel_list').datagrid('reload');
                    $('#recommend_hotel_list').datagrid('clearChecked');
                    $.messager.show({msg: constant.edit_recommend_hote_success_message});
                }
            }
        });
    }
</script>