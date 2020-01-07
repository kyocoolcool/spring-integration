package kyocoolcool.security.controller;

import kyocoolcool.security.bean.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @ClassName FileController
 * @Description 檔案上傳下載範例
 * @Author Chris Chen
 * @Date 2019/10/22 5:29 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    private final String folder = "/Users/chris/git/spring-integration/spring-security-fundamentals/security-demo/src/main/java/kyocoolcool/security/controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(id);
        try (FileInputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             ServletOutputStream outputStream = response.getOutputStream();) {
//            response.setContentType("application/x-download");
//            response.setHeader("Content-Disposition", "attachment,filename=test.txt");
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("test.txt", "UTF-8"));


            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        }

    }
}
