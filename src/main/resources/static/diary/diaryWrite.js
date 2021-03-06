// article_oprate
$(function() {
	// title 字数
	$("#diaryTitle").bind("keyup", function() {
		$(this).val($(this).val().substring(0, $(".title-max-words").text()));
		$(".title-words").html($(this).val().length);
		if ($(this).val().length >= $(".title-max-words").text()) {
			$(".title-words").css("color", "red");
		} else {
			$(".title-words").css("color", "black");
		}
	});
	// 字数 初始化
	$(".title-words").html($("#diaryTitle").val().length);

	// 初始化
	$(".article_oprate input[type=checkbox]").prop("checked", true);
	$(".article_oprate label").find("span:first-child").css("background",
			"#5FB878");
	$(".article_oprate label").find("span:last-child").css({
		"opacity" : "1",
		"border-color" : "#5FB878"
	});

	$(".article_oprate label").mouseover(function() {
		if ($(this).prev().prop("checked")) {

		} else {
			$(this).find("span:last-child").css("opacity", "0.6");
		}
	});
	$(".article_oprate label").mouseleave(function() {
		if ($(this).prev().prop("checked")) {

		} else {
			$(this).find("span:last-child").css("opacity", "0.3");
		}
	});

	$(".article_oprate input").click(
			function() {
				if ($(this).attr("id") == "public") {
					if ($(this).prop("checked")) {

					} else {
						$("#comment").prop("checked", false);
						$("#share").prop("checked", false);
					}
				} else {

					if ($("#public").prop("checked")) {
						if ($(this).prop("checked")) {
							$(this).prop("checked", true);
						} else {
							$(this).prop("checked", false);
						}
					} else {
						$("#comment").prop("checked", false);
						$("#share").prop("checked", false);
					}
				}

				// 采用循环，整体改变
				$(".article_oprate-p input[type=checkbox][checked]").each(
						function() {
							$(this).next().find("span:first-child").css(
									"background", "#5FB878");
							$(this).next().find("span:last-child").css(
									"opacity", "1");
						});
				$(".article_oprate-p input[type=checkbox]").not(":checked")
						.each(
								function() {
									$(this).next().find("span:first-child")
											.css("background", "lightgray");
									$(this).next().find("span:last-child").css(
											"opacity", "0.3");
								});
			});
});

// 新建类型

$(function() {
	var typeNum = 0;
	$('[name="diaryType"]').each(function() {
		$(this).children("option").each(function() {
			typeNum = typeNum + 1;
		});
	});
	if (typeNum > 2) {
		$('[name="diaryType"]').change(function() {
			var data = $(this).val();
			if (data === "0") {
				$(".add-articleType").show();
			}
		});
	} else {
		$(".noType").show();
		$(".add-articleType").show();
	}

	$(".close-type").click(function() {
		$(".add-articleType").hide();
	});

	$('.add-type').click(
			function() {
				var eq = false;
				var con = $('[name="new_type_name"]').val();
				$('[name="diaryType"]').each(function() {
					$(this).children("option").each(function() {
						var n = $(this).text(); // 每一个option
						if (n === con) {
							eq = true;
						} else {
						}
					});
				});

				if (eq) {
					$(".type-warning").show();
				} else {
					$(".type-warning").hide();
					$.ajax({
						type : "get",
						url : "addDiaryType",
						data : {
							diaryTypeName : con
						},
						datatype : "json",
						success : function(data) {
							console.log(data);
							var result = $(".addResult");
							if (data != "-1") {
								$(".type-warning").hide();
								result.html("已添加！");
								result.show();
								//

								$(".add-articleType").hide();
								// 刷新文章类型

								$('[name="diaryType"]').prepend(
										"<option value='" + data + "'>" + con
												+ "</option>");
								$('[name="diaryType"]').val(data);
								$(".add-articleType").hide();

							} else {
								result.html("添加失败！");
								result.show();
							}
						}
					});
				}
			});
});

// 提交验证
// 提交验证

$(function () {


	// 1. 立即提交
	$(".submit-button").click(function () {
		// console.log("11");
		// ajaxArticle("0");

		var diaryTitle = $('[name="diaryTitle"]').val();
		var diaryType = $('[name="diaryType"]').val();
		var diaryContent = $('#content').val();


		console.log(diaryTitle);
		console.log(diaryType);
		console.log(diaryContent);


		$.ajax({
			type: "post",
			url: "writeDiary",
			data: {
				diaryTitle: diaryTitle,
				diaryType: diaryType,
				diaryContent: diaryContent,
			},
			datatype: "json",
			success: function (data) {
				// -1 保存失败 1 show article 0 back userCenter
				console.log(data);
				if (data != 0 && data != -1) {
					$(".result").show();
					$(".result").html("保存成功！");
					var sec = 2;
					setInterval(function () {
						sec--;
						if (sec < 0) {
							window.location.href = "showDiary?diaryID="
								+ data;
						}
					}, 1000);

				}
				if (data == 0) {
					$(".result").show();
					$(".result").html("保存成功！");
					var sec = 2;
					setInterval(function () {
						sec--;
						if (sec < 0) {
							window.location.href = "userCenter";
						}
					}, 1000);

				}
				if (data == -1) {
					$(".result").show();
					$(".result").html("保存失败！");

					var sec = 3;
					setInterval(function () {
						sec--;
						if (sec < 0) {
							$(".result").hide();
						}
						$(this).stop();
					}, 1000);
				}

			}
		});


	});

});