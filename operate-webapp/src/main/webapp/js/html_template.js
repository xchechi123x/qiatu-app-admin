/**
 * Created by chechi on 15-1-16.
 */

template = {
    recommend_hotel_template: {
        template_txt: "<div style='margin-left: 5px'>" +
        "<div style='margin-bottom: 5px'>" +
        "<span style='color: red'>推荐标签{number}：</span>" +
        "<input name='reason[{rid}].title' type='text' class='easyui-textbox' data-options='required:true'/>" +
        "</div>" +
        "<div><span style='color: red'>推荐描述：</span></div>" +
        "<div style='margin-bottom: 10px'>" +
        "<div style='float: left;width: 500px'>" +
        "<textarea name='reason[{rid}].describe' class='easyui-textbox' style='width: 490px;height: 85px;font-size: 12px' data-options='required:true'></textarea>" + "</div>" +
        "<div style='clear: both'></div>" +
        "</div>" +
        "</div>" +
        "<div>" +
        "{recommend_icon}" +
        "</div>"
    }
}


