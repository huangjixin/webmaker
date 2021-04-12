package com.hjx.webmaker.modules.art.web.admin;

import com.alibaba.fastjson.JSONObject;
import com.hjx.webmaker.modules.art.domain.Attachment;
import com.hjx.webmaker.modules.art.service.IAttachmentService;
import com.hjx.webmaker.modules.base.web.BaseController;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("admin/art/attachment")
public class AttachmentRestController extends BaseController<Attachment> {
    private static Logger logger = LoggerFactory.getLogger(AttachmentRestController.class);

    @Qualifier(value = "attachmentService")
    @Autowired
    private IAttachmentService attachmentService;

    @Value("${file.upload}")
    private String fileUpload;


    @PostMapping("upload")
    public JSONObject upload(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("err","");
        jsonObject.put("msg","");

        String currentUser = "test";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String day = sdf.format(new Date());
        String fileUploadPath = fileUpload + File.separator + currentUser + File.separator + day;
        File path = new File(fileUploadPath);
        if (!path.exists()) {
            path.mkdirs();
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();
            String originalFileName = mf.getOriginalFilename();
            String fileExt = originalFileName.substring(
                    originalFileName.lastIndexOf(".") + 1).toLowerCase();

            Random r = new Random();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date d = new Date();
            String newFileName = df.format(d) + "_"
                    + r.nextInt(100000) + "." + fileExt;
            // 是image则进入此处开始执行
            if (fileExt.equals("jpg") || fileExt.equals("png")) {
                FileOutputStream fos = new FileOutputStream(new File(path.getPath(), newFileName));
                IOUtils.copy(mf.getInputStream(), fos);

                fos.close();
            }
        }

        return jsonObject;
    }
}
