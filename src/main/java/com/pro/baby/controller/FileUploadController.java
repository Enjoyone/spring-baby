package com.pro.baby.controller;


import com.pro.baby.ImgResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileUploadController {
    @SuppressWarnings("deprecation")
    @PostMapping("/articleImageUp")
    @ResponseBody
    public ImgResult upload(@RequestParam(value = "file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        String desFilePath = "";         //图片保存路径
        String oriName = "";             //原文件名
        ImgResult result = new ImgResult();
        Map<String, String> dataMap = new HashMap<>();
        ImgResult imgResult = new ImgResult();
        try {
            // 1.获取原文件名
            oriName = file.getOriginalFilename();

            // 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
            String extName = oriName.substring(oriName.lastIndexOf("."));

            // 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
            String uuid = UUID.randomUUID().toString();
            String newName = uuid + extName;

            // 4.获取要保存的路径文件夹

            String realPath = "D:\\baby\\spring-baby\\src\\main\\resources\\static\\uploadImges";
//            String realPath = "\\updateImges";

            // 5.保存图片
//            System.out.println("111111111111111111111111111111");
            desFilePath = realPath + "\\" + newName;                //保存路径
//            System.out.println("1222222222222222");
            File desFile = new File(desFilePath);                   //创建文件
//            System.out.println("333333333333333333");
            if (!desFile .getParentFile().exists()) {
                desFile .getParentFile().mkdir();
            }
            // 保存文件

            file.transferTo(desFile);

//            System.out.println("4444444444441");

            // 6.返回保存结果信息
            result.setCode(0);                                      //保存状态码 成功 0 失败 1
            dataMap = new HashMap<>();
            dataMap.put("src", "/uploadImges/" + newName); //保存真实路径
            result.setData(dataMap);                                //保存信息
            result.setMsg(oriName + "上传成功！");                  //返回提示信息
            return result;

        } catch (IllegalStateException e) {
            imgResult.setCode(1);
            System.out.println(desFilePath + "图片保存失败");
            return imgResult;
        } catch (IOException e) {
            imgResult.setCode(1);
            System.out.println(desFilePath + "图片保存失败--IO异常");
            return imgResult;
        }
    }
}
