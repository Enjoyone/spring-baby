// 时间
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //前后若干天可选，这里以7天为例
    laydate.render({
        elem: '#dateRange',
        min: 0,
        max: 7,
        range: true,
        theme: 'grid'
    });

    //限定可选时间
    laydate.render({
        elem: '#timeRange',
        type: 'time',
        min: '09:30:00',
        max: '17:30:00',
        btns: ['clear', 'confirm'],
        range: true,
    });

});


$(function () {
    $("form").submit(function () {

        var province = $("#province").val();
        var city = $("#city").val();
        var district = $("#district").val();
        var details = $("#details").val();
        var ps = $("#ps").val();
        // var participant = $("[name='participant']").val();

        var participant = [];

        $.each($('input[type=checkbox]:checked'), function () {
            console.log($(this).val());
            participant.push($(this).val());
        });

        var dateRange = $("#dateRange").val();
        var timeRange = $("#timeRange").val();

        // console.log(province);
        // console.log(city);
        // console.log(district);
        // console.log(details);
        // console.log(ps);
        console.log(participant);

        var startDay = dateRange.substring(0, 10);
        var stopDay = dateRange.substring(13, 24);
        var startTime = timeRange.substring(0, 8);
        var stopTime = timeRange.substring(11, 20);

        var kids=participant.toString();

        $.ajax({
            type: "post",
            url: "toSocial",
            data: {
                //地址
                province: province,
                city: city,
                district: district,
                details: details,


                //时间
                startDay:startDay,
                stopDay:stopDay,
                startTime:startTime,
                stopTime:stopTime,


                //参与者
                kids: kids,


                //    备注
                ps: ps,

            },
            datatype: "json",
            success: function (data) {
                console.log(data);
                var result = $(".addResult");
                if (data != "-1") {
                //     转页面
                        var sec = 2;
                        setInterval(function () {
                            sec--;
                            if (sec < 0) {
                                window.location.href = "socialDetail?appID="
                                    + data;
                            }
                        }, 1000);


                } else {
                    result.html("添加失败！");
                    result.show();
                }
            },
        });
        return false;

    });


});


