
// 时间
layui.use('laydate', function () {
  var laydate = layui.laydate;

  //前后若干天可选，这里以7天为例
  laydate.render({
    elem: '#test-limit2',
    min: 0,
    max: 7,
    range: true,
    theme: 'grid'
  });

  //限定可选时间
  laydate.render({
    elem: '#test-limit3',
    type: 'time',
    min: '09:30:00',
    max: '17:30:00',
    btns: ['clear', 'confirm']
  });

});


