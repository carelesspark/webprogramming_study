package fileupload;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {
	public static MultipartRequest uploadFile(HttpServletRequest req, String saveDirectory, int maxPostSize) {
		try {
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		} catch (Exception e) {
			
			return null;
		}
	}
	
	public static void deleteFile(HttpServletRequest req, String saveDirectory, String filename) {
		
		String sDirectory = req.getServletContext().getRealPath(saveDirectory);
		File file = new File(sDirectory + File.separator + filename);
		if(file.exists()) {
			file.delete();
			System.out.println("성공적으로 삭제되었습니다.");
		}
		
	}
}
