package com.projectjavasem4.controller.web;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.projectjavasem4.dto.ProductDTO;

@Controller
public class UploadController{
	
	
	  private static final String UPLOAD_DIRECTORY ="/images";  
      
	    
	  
	  
	  
	  
	  @PostMapping("/file-upload")
	  public ResponseEntity<String> fileUpload(@RequestBody ProductDTO pro,HttpSession session) {
	      try {
	    	  MultipartFile file=pro.getFileUpload(); 
	          // upload directory - change it to your own
	          String UPLOAD_DIR = "D:/files";

	          // create a path from file name
	          Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());

	          // save the file to `UPLOAD_DIR`
	          // make sure you have permission to write
	          Files.write(path, file.getBytes());
	      }
	      catch (Exception ex) {
	          ex.printStackTrace();
	          return new ResponseEntity<>("Invalid file format!!", HttpStatus.BAD_REQUEST);
	      }

	      return new ResponseEntity<>("File uploaded!!", HttpStatus.OK);
	  }
	  
	  
	  
	  
	  
	      
	    @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public String saveimage( @RequestParam("file") CommonsMultipartFile file,   HttpSession session) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+";;;;;;;;;;; "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return "File successfully saved!";   }  
	
	    @RequestMapping(value="savefile2",method=RequestMethod.POST)  
	    public String saveimage2( @RequestParam("file") CommonsMultipartFile myFile,   HttpSession session) throws Exception{  
	    	ServletContext context = session.getServletContext();  
		    String path = context.getRealPath(UPLOAD_DIRECTORY); 
		    
		    
	    	try {
				MultipartFile multipartFile = myFile;
				String fileName = multipartFile.getOriginalFilename();
				File file = new File(path, fileName);
				multipartFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "result";   
			
	    
	    }  
	    
	
	
}