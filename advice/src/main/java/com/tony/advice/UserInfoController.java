 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.advice;

 import lombok.extern.slf4j.Slf4j;
 import org.springframework.web.bind.annotation.*;

 /**
  * @author tony121.xu@huolala.cn
  * @create 2021-05-24
  * @description:
  */
 @RestController
 @RequestMapping("user-info")
 @Slf4j
 public class UserInfoController {

     /**
      * 添加用户实现返回值加密
      *
      * @param userInfo
      * @return
      */
     @PostMapping("add")
     @Encrypt
     @ResponseBody
     public UserInfo add(@RequestBody UserInfo userInfo) {
         log.info("添加新用户:[{}]", userInfo);
         return userInfo;
     }
     /**
      * 对照组
      *
      * @param userInfo
      * @return
      */
     @PostMapping("add2")
     @ResponseBody
     public UserInfo add2(@RequestBody UserInfo userInfo) {
         log.info("添加新用户:[{}]", userInfo);
         return userInfo;
     }

     /**
      * 修改实现获取的参数进行解密
      *
      * @param userInfo
      * @return
      */
     @PostMapping("update")
     public UserInfo update(@Encrypt @RequestBody UserInfo userInfo) {
         log.info("修改用户信息:[{}]", userInfo);
         return userInfo;
     }

     /**
      * 对照组
      *
      * @param userInfo
      * @return
      */
     @PostMapping("update2")
     public UserInfo update2(@RequestBody UserInfo userInfo) {
         log.info("修改用户信息:[{}]", userInfo);
         return userInfo;
     }
 }