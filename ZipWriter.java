//escreve arquivos em um arquivo .zip
package writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter {
	public static void main(String[] args) {
		String pathfile = "path.ext"; //put path here
		String outputfile = System.getProperty("user.home") + "/Desktop/" + "zip.zip"; //output in desktop with name zip.zip
		
		try {
			FileOutputStream fos = new FileOutputStream(outputfile); //create fileoutputstream and point it to Desktop
			ZipOutputStream zos = new ZipOutputStream(fos); //wrap fileoutputstream with zipoutputstream
			File filetoZip = new File(pathfile); //create File obj with path
			ZipEntry ze = new ZipEntry(filetoZip.getName()); //get path to zip entry
			zos.putNextEntry(ze); //put entry in zos
			FileInputStream fis = new FileInputStream(pathfile);
			
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = fis.read(buffer)) > 0) {
				zos.write(buffer, 0, length); //loop to write file
			}
			//close processes
			fis.close();
			zos.closeEntry();
			zos.close();
			
			System.out.println("file has been zipped.");
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
