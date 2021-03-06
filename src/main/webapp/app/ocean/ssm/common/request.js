Ext.define('app.ocean.ssm.common.request', {
    singleton: true,
    context: null,
    url: function (url) {
        if (!this.context) {
            var context = document.location.pathname;
            this.context = context.substr(0, context.lastIndexOf('/'));
        }
        return this.context + url;
    },
    request: function (params, url) {
        if (!url || typeof(url) == 'undefined') {
            return;
        }
        var message = null;
        var exceptionStr = "服务器异常,请稍后重试!";
        var responseData = null;
        var status = false;
        Ext.Ajax.request({
            url: this.url(url),
            method: "post",
            params: params,
            async: false,
            success: function (response) {
                if (response.status != 200) {
                    message = exceptionStr;
                    return;
                }
                var data = JSON.parse(response.responseText);
                if (data.status) {
                    status = true;
                    responseData = data.resultData;
                } else {
                    //区分业务异常和系统异常
                    message = data.statusCode == '300' ? data.message : exceptionStr;
                }
            },
            failure: function () {
                message = exceptionStr;
            }
        });
        if (!status) {
            throw new BizException(message, '');
        }
        return responseData;
    }
});

function BizException(message, result) {
    var data = {message: null, result: null};
    data.message = message;
    data.result = result;
    return data;
}