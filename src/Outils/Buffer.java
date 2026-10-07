package Outils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Character-level view of the source file, backed by a {@link RandomAccessFile}
 * so the lexer can step back one character when a token ends on a look-ahead.
 *
 * <p>The accumulated characters of the token being recognised are kept in
 * {@code buffer}, which final states read and then clear.
 *
 * <p>Everything here is static, so a single source file can be analysed per JVM
 * run. Note also that the file is opened read-write: a source file that does not
 * end with a newline gets one appended on disk.
 */
public class Buffer {
    private static RandomAccessFile file;
    private static long currentPosition;
    private static int numLigne=1;
    private static ArrayList<Character> buffer = new ArrayList<Character>();

    public Buffer(String filePath) throws IOException {
        this.file = new RandomAccessFile(new File(filePath), "rw"); 
        this.currentPosition = 0;
        
        addNewlineIfMissing();
    }
    
    public static void addNewlineIfMissing() throws IOException {
        // Only append when the file does not already end with a newline.
        if (!hasNewlineAtEnd()) {
            file.seek(file.length());  // move to the end of the file
            file.writeBytes(System.lineSeparator());
        }
        resetPosition();
    }
    
    public static void afficherFichier() throws IOException {
        while (!endOfFile()) {  
        	char character = readChar();
            if (character == '\r') {
                System.out.print("\\r");  
            } else if (character == '\n') {
                System.out.print("\\n"); 
            } else {
                System.out.print(character); 
            } 
        }
    }

    public static char readChar() throws IOException {
        char charData = (char) file.read(); 
        if (charData != -1) { // guard kept from the original reader
            currentPosition = file.getFilePointer();
        }
        return charData;
    }

    public static void moveBack() throws IOException {
        if (currentPosition > 0) {
            currentPosition--;
            file.seek(currentPosition);
        }
    }

    public static void resetPosition()  throws IOException {
        file.seek(0);            
        currentPosition = 0;     
    }
    
	public static void incNumLigne() {
    	Buffer.numLigne++;
    }
	public static ArrayList<Character> getBuffer() throws IOException {
		return buffer;
	}
	
	public static char getAvantDernier() {
		return buffer.get(buffer.size() - 2);
	}
	
	public static boolean hasNewlineAtEnd() throws IOException {
	    long fileLength = file.length();
	    if (fileLength == 0) {
	        return false;
	    }
	    
	    file.seek(fileLength - 1); 
	    char lastChar = (char) file.read();
	    
	    if (lastChar == '\n') {
	        return true; 
	    }
	    
	    if (lastChar == '\r' && fileLength > 1) {
	        file.seek(fileLength - 2); 
	        char secondLastChar = (char) file.read();
	        return secondLastChar == '\n';
	    }
	    
	    return false;
	}

	
	public static void removeLast() {
		buffer.remove(buffer.size() - 1);
	}
	
	public static String bufferToString() {
		String str = "";
		for (Character c : buffer) {
			str += c;
		}
		return str;
	}
	
	
	public static void clearBuffer() {
		buffer.clear();
	}
	
	public static boolean endOfFile() throws IOException {
		return file.getFilePointer() == file.length();
	}
	

    public static void close() throws IOException {
        file.close();
    }
    
	public static int getNumLigne() {
		return numLigne;
	}
	
	public static void setNumLigne(int numLigne) {
		Buffer.numLigne = numLigne;
	}
}
