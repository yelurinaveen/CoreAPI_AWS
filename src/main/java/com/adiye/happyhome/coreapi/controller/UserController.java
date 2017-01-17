package com.adiye.happyhome.coreapi.controller;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.adiye.happyhome.coreapi.model.User;
import com.adiye.happyhome.coreapi.service.file.FileService;
import com.adiye.happyhome.coreapi.service.users.UserService;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

/**
 * Created by nyeluri on 11/15/16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Qualifier("S3FileService")
    @Autowired
    private FileService fileService;

    @Qualifier("UserServiceImpl")
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
        @RequestBody User user){

        userService.createUser(user);
    }

    @RequestMapping(path="/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getUser(
        @PathVariable(value = "userId") Long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(path="/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(
        @PathVariable(value = "userId") Long userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(path="/{userId}/profilepic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadProfilePic(
        @PathVariable(value = "userId") Long userId,
        @RequestParam(value="profilepic",required=true)MultipartFile image){

        //Check if user exists
        userService.getUser(userId);

        fileService.uploadProfilePic(String.valueOf(userId),image);
    }

    @RequestMapping(path="/{userId}/profilepic", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<InputStream> getProfilePic(@PathVariable(value = "userId") Long userId,
        HttpServletResponse response){

        //Check if user exists
        userService.getUser(userId);

        InputStream picStream = fileService.loadProfilePic(String.valueOf(userId));
        InputStreamResource io = new InputStreamResource(picStream);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity(io,httpHeaders,HttpStatus.OK);
    }

    @RequestMapping(path="/{userId}/profilepic", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProfilePic(@PathVariable(value = "userId") Long userId){

        //Check if user exists
        userService.getUser(userId);

        fileService.deleteProfilePic(String.valueOf(userId));
    }
}
