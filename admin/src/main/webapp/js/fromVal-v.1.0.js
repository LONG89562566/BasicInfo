//获取指定form中的所有的<input>对象
function getElements(formId) {
    var form = document.getElementById(formId);
    var elements = new Array();
    var tagElements = form.getElementsByTagName('input');

    if(tagElements.length > 0){
        for (var j = 0; j < tagElements.length; j++){
            elements.push(tagElements[j]);
        }
    }

    var tagElementsSelect = form.getElementsByTagName('select');
    if(tagElementsSelect.length>0){
        for (var i = 0; i < tagElementsSelect.length; i++){
            elements.push(tagElementsSelect[i]);
        }
    }

    var tagElementsTextarea = form.getElementsByTagName('textarea');
    if(tagElementsTextarea.length>0){
        for (var i = 0; i < tagElementsTextarea.length; i++){
            elements.push(tagElementsTextarea[i]);
        }
    }

    return elements;
}

//获取单个input中的【name,value】数组
function inputSelector(element) {
    if (element.checked){
        return [element.name, element.value];
    }
}

function targetParams(element) {
    switch (element.type.toLowerCase()) {
        case 'submit':
        case 'hidden':
            return [element.name, element.value];
        case 'password':
            return [element.name, element.value];
        case 'text':
            return [element.name, element.value];
        case 'textarea':
            return [element.name, element.value];
        case 'checkbox':
        case 'select-one':
            return [element.name, element.value];
        case 'radio':
            return inputSelector(element);
    }
    return false;
}

//组合URL
function serializeElement(element) {
    var method = element.tagName.toLowerCase();
    var parameter = targetParams(element);

    if (parameter) {
        var key = encodeURIComponent(parameter[0]);
        if (key.length == 0) {
            return;
        }

        if (parameter[1].constructor != Array){
            parameter[1] = [parameter[1]];
        }
        var values = parameter[1];
        var results = [];
        for (var i=0; i<values.length; i++) {
            results.push(key + '=' + encodeURIComponent(values[i]));
        }
        return results.join('&');
    }
}

//调用方法
function serializeFormGet(formId) {
    return _queryComponents(formId).join('&');
}

//调用方法
function serializeFormPost(formId) {

    var queryComponents = _queryComponents(formId);

    var json = {};
    for (var i = 0; i < queryComponents.length; i++) {
        var vals = queryComponents[i].split("=");
        if (vals.length != 2 || vals[1] == '') {
            continue;
        }
        json[vals[0]] = vals[1];
    }
    return json ;
}

function _queryComponents(formId) {
    var elements = getElements(formId);
    var queryComponents = new Array();

    for (var i = 0; i < elements.length; i++) {
        var queryComponent = serializeElement(elements[i]);
        if (queryComponent) {
            queryComponents.push(queryComponent);
        }
    }
    return queryComponents;
}
