package com.projectjavasem4.controller.admin;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.util.UploadUtil;
@Controller(value = "UploadControllerOfAdmin")
@RequestMapping("/upload")

public class UploadController {
	private static final String UPLOAD_DIRECTORY ="/images";  
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	
	@PostMapping("/uploadFileTam") 
	@ResponseBody
    	private String uploadFileTam(@RequestParam("file[]") MultipartFile[] files,HttpSession session) throws IOException { 	  
		  String listfileNames="";	  
			  for (MultipartFile f : files) {
				  //fileNames += uploadTam(session,f)+",";
				  listfileNames += new UploadUtil().upload(session, f)+",";
			  }  
			  System.out.println(listfileNames);
		  return listfileNames;
		 
	  }
	
	@SuppressWarnings("unused")
		private String uploadTam(HttpSession session, MultipartFile myFile) {
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  String fileNameSub = "";
		  String stringTimestamp = format.format(timestamp);// 2021-10-14-13-41-29
		  //String stringTimestamp = String.valueOf(timestamp.getTime());// 1616574866666

			ServletContext context = session.getServletContext();
			String path = context.getRealPath("/imagesTam");

			try {
				MultipartFile multipartFile = myFile;
				String fileName = multipartFile.getOriginalFilename(); //abc.jpg
				
				fileNameSub=fileName.substring(0,fileName.indexOf("."))+"-"+stringTimestamp+fileName.substring(fileName.indexOf("."));//abc-2021-10-14-13-41-29.jpg 
				System.out.println(fileNameSub);
				File file = new File(path, fileNameSub);
				multipartFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return fileNameSub;
		} 

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
	   
	    public static void copyDirectory(File sourceLocation , File targetLocation)
			    throws IOException {

			        if (sourceLocation.isDirectory()) {
			            if (!targetLocation.exists()) {
			                targetLocation.mkdir();
			            }

			            String[] children = sourceLocation.list();
			            for (int i=0; i<children.length; i++) {
			                copyDirectory(new File(sourceLocation, children[i]),
			                        new File(targetLocation, children[i]));
			            }
			        } else {

			            InputStream in = new FileInputStream(sourceLocation);
			            OutputStream out = new FileOutputStream(targetLocation);

			            // Copy the bits from instream to outstream
			            byte[] buf = new byte[1024];
			            int len;
			            while ((len = in.read(buf)) > 0) {
			                out.write(buf, 0, len);
			            }
			            in.close();
			            out.close();
			        }
			    }

}
