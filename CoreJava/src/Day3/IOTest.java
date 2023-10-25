package Day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOTest {
	public static void main(String[] args) throws IOException {
//      writeToFile();
//      readFromFile();
       // rotateAndWrite();
        rotateAndRead();
	}

	private static void rotateAndRead() throws IOException {
       Reader in=new Rot13Reader(new FileReader(new File("hello.txt")));
     char[] buffer=new char[1024];
     int bytesRead=in.read(buffer);
      
       in.close();
       System.out.println(new String(buffer,0,bytesRead));
       
	}

	private static void rotateAndWrite() throws IOException {
		Writer out=new Rot13Writer(new FileWriter(new File("hello.txt")));
		out.write("Hello World!");
		out.flush();
		out.close();
				
	}

	private static void readFromFile() throws IOException {
      FileInputStream fis=new FileInputStream(new File("hello.txt"));
      byte[] buffer=new byte[1024];
      int byteRead=fis.read(buffer);
      System.out.println("Bytes read ="+byteRead);
      System.out.println(new String(buffer,0,byteRead));
	}

	private static void writeToFile() throws IOException {
       String message="Hello World!";
       OutputStream fos=new FileOutputStream(new File("hello.txt"));
       fos.write(message.getBytes());
       fos.flush(); //write the content of the buffer to the underlying stream
       fos.close();
	}
}
