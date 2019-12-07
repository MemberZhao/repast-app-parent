package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@RestController
@Api(value = "上传图片接口",tags = "上传图片详细接口")
public class PhotoController extends BaseController {
    @Autowired
    private IRepastService iRepastService;


    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "图片上传接口",notes = "执行图片上传接口操作")
   public String uploadHead(MultipartFile file,String token){
        System.out.println( "consumer层"+file.getOriginalFilename());
        return  iRepastService.uploadHead(file,token);
    }


    @ApiOperation(value = "多图片上传接口",notes = "执行图片上传接口操作")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public String upload( MultipartFile[] file,String token){
        String path=iRepastService.upload(file,token);
        return  path;
    }


    @GetMapping(value = "/upl")
    public  ModelAndView DDD(ModelAndView  mv){
        mv.setViewName("upload_head");
        return mv;
    }


}
