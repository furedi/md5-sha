package md5hash;

import java.security.MessageDigest;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;

/**
 * Create the MD5 or SHA code to file
 *  
 * @author John
 * @version 2.0
 */
public class Md5Hash {
	
	public String get(String algoritmus,String fname){
		fname = fname.replace("\\","/");
		String hashCode = new String();
		try{
			MessageDigest md = MessageDigest.getInstance(algoritmus);
			
			File f = new File(fname);
			FileInputStream fis = new FileInputStream(f);
			byte[] b = new byte[(int)Math.pow(2, 16)];
			int byteNumber = 0;
			while(( byteNumber = fis.read(b, 0, b.length))!=-1){
				md.update(b,0,byteNumber);				
			};
			fis.close();
			
			hashCode = new BigInteger(1,md.digest()).toString(16);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return hashCode;
	}
}
/**
 * Useful links:
 * 
 * [1] https://www.mkyong.com/java/java-sha-hashing-example/
 * [2] http://www.javased.com/index.php?api=java.security.MessageDigest
 * [3] https://www.flexiprovider.de/examples/ExampleDigest.html
 * 
 * Colors: https://sourceforge.net/projects/quickhash/
 */