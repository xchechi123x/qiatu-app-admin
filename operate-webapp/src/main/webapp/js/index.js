

function load_article_list() {

    var article_list_tab = $('#tabs').tabs('getTab', constant.tab_article.title);

    if (article_list_tab) {
        $('#tabs').tabs('select', constant.tab_article.title)
    } else {
        $('#tabs').tabs('add', {
            title: constant.tab_article.title,
            href: constant.tab_article.content_link,
            closable: true
        });

    }

}

function load_recommend_hotel_list() {
    var article_list_tab = $('#tabs').tabs('getTab', constant.tab_recommend_hotel.title);

    if (article_list_tab) {
        $('#tabs').tabs('select', constant.tab_recommend_hotel.title)
    } else {
        $('#tabs').tabs('add', {
            title: constant.tab_recommend_hotel.title,
            href: constant.tab_recommend_hotel.content_link,
            closable: true
        });

    }
}

function form_clear(form_id) {
    $('#' + form_id).form('clear');
}

alert(URL);