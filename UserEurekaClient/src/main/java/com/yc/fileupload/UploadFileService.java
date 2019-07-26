package com.yc.fileupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class UploadFileService implements UploadFile {
	@Override
	public void uploadFile(byte[] file, String filePath, String fileName) { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        try {
			FileOutputStream out = new FileOutputStream(filePath+fileName);
			out.write(file);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
