package com.qiatu.operate.app.web.action;

import com.qiatu.operate.app.common.AppUtils;
import com.qiatu.operate.app.common.Constant;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chechi on 15-1-20.
 */

@Controller
public class FileManagerAction extends BaseAction {

    private Logger logger = LoggerFactory.getLogger(FileManagerAction.class);

    // 文件允许格式
    private String[] allowFiles = {".rar", ".doc", ".docx", ".zip", ".pdf", ".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp"};
    // 文件大小限制，单位KB
    private Long maxSize = 30000L;
    // 输出文件地址
    private String url = "";
    // 上传文件名
    private String fileName = "";
    // 状态
    private String state = "SUCCESS";
    // 文件类型
    private String type = "";
    // 原始文件名
    private String originalName = "";

    private Long size;

    private boolean checkFileType(String fileName) {
        Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 根据字符串创建本地目录 并按照日期建立子目录返回
     *
     * @return
     */
    private String getFolder() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String path = "/" + formater.format(new Date());
        File dir = new File(this.getPhysicalPath(path));
        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                return "";
            }
        }
        return path;
    }

    /**
     * 根据传入的虚拟路径获取物理路径
     *
     * @param path
     * @return
     */
    private String getPhysicalPath(String path) {
        String servletPath = this.request.getServletPath();
        String realPath = this.request.getSession().getServletContext()
                .getRealPath(servletPath);
        return new File(realPath).getParent() + path + "/";
    }


    @ResponseBody
    @RequestMapping(value = "/file/upload/images", method = RequestMethod.POST)
    public ResponseEntity<String> imageUpload(@RequestParam MultipartFile upfile) {

        this.originalName = upfile.getOriginalFilename();

        this.type = originalName.substring
                (originalName.lastIndexOf("."));

        this.size = upfile.getSize();

        String fileKey = UUID.randomUUID().toString();

        this.fileName = fileKey + this.type;

        String fileSavePath = getPhysicalPath(this.getFolder());

        HttpHeaders headers = new HttpHeaders();

        MediaType mediaType = new MediaType("text", "html", Charset.forName("utf8"));

        headers.setContentType(mediaType);

        ResponseEntity<String> responseEntity;

        if (!checkFileType(this.originalName)) {
            this.state = "不允许的文件格式";
        }

        if (this.size > this.maxSize) {
            this.state = "文件大小超出限制";
        }

        try {
            upfile.transferTo(new File(fileSavePath + fileKey + this.type));
        } catch (IOException e) {
            logger.error(e.getMessage());
            this.state = "保存文件失败";
        }

        Mac mac = new Mac(Constant.QINIU_ACCESS_KEY, Constant.QINIU_SECRET_KEY);

        PutPolicy putPolicy = new PutPolicy(Constant.QINIU_BUCKET_NAME);

        try {
            String token = putPolicy.token(mac);
            PutExtra extra = new PutExtra();
            String key = AppUtils.sign(fileKey.toString());
            PutRet ret = IoApi.putFile(token, key, new File(fileSavePath + fileKey + this.type), extra);
            this.url = ret.getKey().toString();
        } catch (AuthException e) {
            e.printStackTrace();
            this.state = "保存文件失败";
        } catch (JSONException e) {
            e.printStackTrace();
            this.state = "保存文件失败";
        }


        //String url = "/upload" + this.getFolder() + "/" + this.fileName;

        String result = "{\"name\":\"" + this.fileName + "\", \"originalName\": \"" + this.originalName + "\", \"size\": " + this.size + ", \"state\": \"" + this.state + "\", \"type\": \"" + this.type + "\", \"url\": \"" + url + "\"}";

        responseEntity = new ResponseEntity<String>(result, headers, HttpStatus.OK);

        return responseEntity;
    }
}
