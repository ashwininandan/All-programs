package com.file.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.file.upload.entity.repository.FileUploadRepository;



@RestController


public class FileDownloadController {
	@Autowired
	FileUploadRepository filerepo;
	
	 private static final String FILE_PATH = "C:/Users/win 10/Downloads/upload/numku.jpg";
	 
    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public @ResponseBody HttpEntity<byte[]> downloadB() throws IOException {
        File file = getFile();
        byte[] document = FileCopyUtils.copyToByteArray(file);
       
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "image"));
        header.set("Content-Disposition", "inline; filename=" + file.getName());
        
       
        header.setContentLength(document.length);
        return new HttpEntity<byte[]>(document, header);
    }
	
    private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }
}



