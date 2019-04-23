package com.internousdev.template1.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dto.InsertItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class NewResisterItemAction extends ActionSupport implements SessionAware {
	private File file;
	private String itemname;
	private String price;
	private String stock;
	private String comment;
	public Map<String, Object> session;
	private String contentType;
	private String filename;
	private String imagename;
	private String imagepath;
	String result=SUCCESS;
	String ErrorName;

	public String execute() {
		Consumer<IOException> the=(e)->{
			ErrorName=e.toString();
			System.out.println(ErrorName);
			result="exception";
		};
		assert itemname!=null||price!=null||stock!=null||comment!=null:"Any elements which must be filled are NOT done"; //All elements must be checked by JS which is benbeded in newResisteritem.jsp.

		// Process of image and resistration of path and name onto this object
		Consumer<File> process01 = file -> {
			File MovetoDirectory = new File(
					"/Users/internousdev/Desktop/workspace/workspace-yamakawa/test/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/template1/images");
			Path p1 = Paths.get(file.getPath());
			Path p2 = Paths.get(MovetoDirectory.getAbsolutePath() + "/"+ itemname + ".jpg");
			try {
				if(Files.size(p1)>100000){ //size designed
					System.out.println("EXCEED LIMITED SIZE");
					IOException e=new IOException();
					throw e;
				}
				if(!contentType.equals("image/jpeg")){ //type designed
					System.out.println("INVALID CONTENT TYPE");
					IOException e=new IOException();
					throw e;
				}
				Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
				Files.delete(p1);
				imagename = "images"+"/"+itemname + ".jpg";
				imagepath=p2.toString();
			} catch (IOException e) {
				e.printStackTrace();
				the.accept(e);
				try{
					Files.delete(p1);

				}catch(IOException e2){
					e2.printStackTrace();
				}
			}
		};

		//Divergence
		if(file!=null){process01.accept(file);}
		else{imagename="images"+"/"+"sample" + ".jpg";}

		// resistrartion into dto
		InsertItemDTO dto = new InsertItemDTO();
		dto.setItemname(itemname);
		dto.setPrice(price);
		dto.setStock(stock);
		dto.setComment(comment);
		dto.setImagename(imagename);
		dto.setImagepath(imagepath);
		// session
		session.put("InsertItem", dto);
		return result;
	}
	//below getter and setter
	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getFile() {
		return file;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}