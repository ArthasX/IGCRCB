/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Files Util
 * @author Rg
 *
 */
public class FilesUtil {

	public static int ioBufferSize = 16384;
	public static final String EMPTY = "";
	protected static final String PATH_MATCH = "**";
	protected static final String PATH_SEPARATORS = "/\\";
	private static final String MSG_NOT_FOUND = "Not found: ";
	private static final String MSG_NOT_A_DIRECTORY = "Not a directory: ";
	private static final String MSG_CANT_CREATE = "Can't create: ";
	
	public FilesUtil() {
	
	}

	/**
	 * get Line Number
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static int getLineNumber(File file) throws Exception {

		int lineNumber = 0;
		if (file.exists() == false) {
			throw new FileNotFoundException();
		}
		if (file.isFile() == false) {
			throw new IOException();
		}

		InputStream in = null;

		try {
			in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));

			while (br.readLine() != null) {

				lineNumber++;
			}

		} finally {
			close(in);
		}

		return lineNumber;
	}
	
	/**
	 * read Line
	 * @param file
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static String readLine(File file, int index) throws Exception {

		if (file.exists() == false) {
			throw new FileNotFoundException();
		}
		if (file.isFile() == false) {
			throw new IOException();
		}

		InputStream in = null;

		try {
			in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			String strLine;
			int i = 0;
			while ((strLine = br.readLine()) != null) {

				if (index == 0) {

					return strLine + "_" + i;

				} else if (i == index) {

					return strLine + "_" + i;
				}

				i++;
			}

		} finally {
			close(in);
		}

		return null;
	}

	/**
	 * get Dirs Map
	 * 
	 * @param dirStr
	 * @return
	 */
	public static Map<String, File> getDirsMap(String dirStr) {

		if (dirStr == null || "".equals(dirStr)) {
			return null;
		}

		Map<String, File> dirMap = null;
		File srcDir = new File(dirStr);
		File[] files = srcDir.listFiles();

		if (files == null) {
			return null;
		}

		dirMap = new HashMap<String, File>();

		for (File file : files) {
			if (file.isDirectory()) {
				dirMap.put(getBaseName(file.getName()), file);
			}
		}
		return dirMap;
	}
	
	public static String getBaseName(String filename) {
		return removeExtension(getName(filename));
	}
	
	public static String removeExtension(String filename) {
		if (filename == null) {
			return null;
		}
		int index = indexOfExtension(filename);
		if (index == -1) {
			return filename;
		} else {
			return filename.substring(0, index);
		}
	}
	
	public static String getName(String filename) {
		if (filename == null) {
			return null;
		}
		int index = indexOfLastSeparator(filename);
		return filename.substring(index + 1);
	}
	
	public static int indexOfExtension(String filename) {
		if (filename == null) {
			return -1;
		}
		int extensionPos = filename.lastIndexOf('.');
		int lastSeparator = indexOfLastSeparator(filename);
		return (lastSeparator > extensionPos ? -1 : extensionPos);
	}
	
	public static int indexOfLastSeparator(String filename) {
		if (filename == null) {
			return -1;
		}
		int lastUnixPos = filename.lastIndexOf('/');
		int lastWindowsPos = filename.lastIndexOf('\\');
		return Math.max(lastUnixPos, lastWindowsPos);
	}

	/**
	 * get Files Map
	 * 
	 * @param dirStr
	 * @return
	 */
	public static Map<String, File> getFilesMap(String dirStr) {

		if (dirStr == null || "".equals(dirStr)) {
			return null;
		}

		Map<String, File> dirMap = null;
		File srcDir = new File(dirStr);
		File[] files = srcDir.listFiles();

		if (files == null) {
			return null;
		}

		dirMap = new HashMap<String, File>();

		for (File file : files) {
			if (!file.isDirectory()) {
				dirMap.put(getBaseName(file.getName()), file);
			}
		}
		return dirMap;
	}
	
	public static boolean isOlder(String file, long timeMillis) {
		return isOlder(new File(file), timeMillis);
	}
	
	public static boolean isOlder(File file, long timeMillis) {
		if (!file.exists()) {
			return false;
		}
		return file.lastModified() < timeMillis;
	}
	
	public static void deleteFile(String dest) throws IOException {
		deleteFile(new File(dest));
	}

	public static void deleteFile(File dest) throws IOException {
		if (dest.exists() == false) {
			throw new FileNotFoundException(dest.getName());
		}
		if (dest.isFile() == false) {
			throw new IOException(dest.getName());
		}
		if (dest.delete() == false) {
			throw new IOException(dest.getName());
		}
	}
	
	public static String[] readLines(String file) throws IOException {
		return readLines(new File(file));
	}

	public static String[] readLines(File file) throws IOException {
		if (file.exists() == false) {
			throw new FileNotFoundException(file.getName());
		}
		if (file.isFile() == false) {
			throw new IOException(file.getName());
		}
		List<String> list = new ArrayList<String>();

		InputStream in = null;
		try {
			in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				list.add(strLine);
			}
		} finally {
			close(in);
		}
		return list.toArray(new String[list.size()]);
	}
	
	public static void close(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException ioex) {
				// ignore
			}
		}
	}
	
	public static void close(OutputStream out) {
		if (out != null) {
			try {
				out.flush();
			} catch (IOException ioex) {
				// ignore
			}
			try {
				out.close();
			} catch (IOException ioex) {
				// ignore
			}
		}
	}
	
	public static void unzip(String zipFile, String destDir, String... patterns) throws IOException {
		unzip(new File(zipFile), new File(destDir), patterns);
	}
	
	@SuppressWarnings("rawtypes")
	public static void unzip(File zipFile, File destDir, String... patterns) throws IOException {
		ZipFile zip = new ZipFile(zipFile);
		Enumeration zipEntries = zip.entries();

		while (zipEntries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) zipEntries.nextElement();
			String entryName = entry.getName();

			if (patterns != null && patterns.length > 0) {
				if (FilesUtil.matchPathOne(entryName, patterns) == -1) {
					continue;
				}
			}

			File file = (destDir != null) ? new File(destDir, entryName) : new File(entryName);
			if (entry.isDirectory()) {
				if (!file.mkdirs()) {
					if (file.isDirectory() == false) {
						throw new IOException("Error creating directory: " + file);
					}
				}
			} else {
				File parent = file.getParentFile();
				if (parent != null && !parent.exists()) {
					if (!parent.mkdirs()) {
						if (file.isDirectory() == false) {
							throw new IOException("Error creating directory: " + parent);
						}
					}
				}

				InputStream in = zip.getInputStream(entry);
				OutputStream out = null;
				try {
					out = new FileOutputStream(file);
					FilesUtil.copy(in, out);
				} finally {
					FilesUtil.close(out);
					FilesUtil.close(in);
				}
			}
		}

		close(zip);
	}
	
	public static int copy(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[ioBufferSize];
		int count = 0;
		int read;
		while (true) {
			read = input.read(buffer, 0, ioBufferSize);
			if (read == -1) {
				break;
			}
			output.write(buffer, 0, read);
			count += read;
		}
		return count;
	}
	
	public static void close(ZipFile zipFile) {
		if (zipFile != null) {
			try {
				zipFile.close();
			} catch (IOException ioex) {
				// ignore
			}
		}
	}
	
	public static int matchPathOne(String path, String[] patterns) {
		for (int i = 0; i < patterns.length; i++) {
			if (matchPath(path, patterns[i]) == true) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean matchPath(String path, String pattern) {
		String[] pathElements = FilesUtil.splitc(path, PATH_SEPARATORS);
		String[] patternElements = FilesUtil.splitc(pattern, PATH_SEPARATORS);
		return matchTokens(pathElements, patternElements);
	}
	
	public static String[] splitc(String src, String d) {
		if ((d.length() == 0) || (src.length() == 0) ) {
			return new String[] {src};
		}
		char[] delimiters = d.toCharArray();
		char[] srcc = src.toCharArray();

		int maxparts = srcc.length + 1;
		int[] start = new int[maxparts];
		int[] end = new int[maxparts];

		int count = 0;

		start[0] = 0;
		int s = 0, e;
		if (FilesUtil.equalsOne(srcc[0], delimiters) == true) {	// string starts with delimiter
			end[0] = 0;
			count++;
			s = FilesUtil.findFirstDiff(srcc, 1, delimiters);
			if (s == -1) {							// nothing after delimiters
				return new String[] {EMPTY, EMPTY};
			}
			start[1] = s;							// new start
		}
		while (true) {
			// find new end
			e = FilesUtil.findFirstEqual(srcc, s, delimiters);
			if (e == -1) {
				end[count] = srcc.length;
				break;
			}
			end[count] = e;

			// find new start
			count++;
			s = FilesUtil.findFirstDiff(srcc, e, delimiters);
			if (s == -1) {
				start[count] = end[count] = srcc.length;
				break;
			}
			start[count] = s;
		}
		count++;
		String[] result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = src.substring(start[i], end[i]);
		}
		return result;
	}
	
	public static int findFirstDiff(char[] source, int index, char[] match) {
		for (int i = index; i < source.length; i++) {
			if (equalsOne(source[i], match) == false) {
				return i;
			}
		}
		return -1;
	}
	
	public static int findFirstEqual(char[] source, int index, char[] match) {
		for (int i = index; i < source.length; i++) {
			if (equalsOne(source[i], match) == true) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean equalsOne(char c, char[] match) {
		for (char aMatch : match) {
			if (c == aMatch) {
				return true;
			}
		}
		return false;
	}
	
	protected static boolean matchTokens(String[] tokens, String[] patterns) {
		int patNdxStart = 0;
		int patNdxEnd = patterns.length - 1;
		int tokNdxStart = 0;
		int tokNdxEnd = tokens.length - 1;

		while ((patNdxStart <= patNdxEnd) && (tokNdxStart <= tokNdxEnd)) {	// find first **
			String patDir = patterns[patNdxStart];
			if (patDir.equals(PATH_MATCH)) {
				break;
			}
			if (!match(tokens[tokNdxStart], patDir)) {
				return false;
			}
			patNdxStart++;
			tokNdxStart++;
		}
		if (tokNdxStart > tokNdxEnd) {
			for (int i = patNdxStart; i <= patNdxEnd; i++) {	// string is finished
				if (!patterns[i].equals(PATH_MATCH)) {
					return false;
				}
			}
			return true;
		}
		if (patNdxStart > patNdxEnd) {
			return false;	// string is not finished, but pattern is
		}

		while ((patNdxStart <= patNdxEnd) && (tokNdxStart <= tokNdxEnd)) {	// to the last **
			String patDir = patterns[patNdxEnd];
			if (patDir.equals(PATH_MATCH)) {
				break;
			}
			if (!match(tokens[tokNdxEnd], patDir)) {
				return false;
			}
			patNdxEnd--;
			tokNdxEnd--;
		}
		if (tokNdxStart > tokNdxEnd) {
			for (int i = patNdxStart; i <= patNdxEnd; i++) {	// string is finished
				if (!patterns[i].equals(PATH_MATCH)) {
					return false;
				}
			}
			return true;
		}

		while ((patNdxStart != patNdxEnd) && (tokNdxStart <= tokNdxEnd)) {
			int patIdxTmp = -1;
			for (int i = patNdxStart + 1; i <= patNdxEnd; i++) {
				if (patterns[i].equals(PATH_MATCH)) {
					patIdxTmp = i;
					break;
				}
			}
			if (patIdxTmp == patNdxStart + 1) {
				patNdxStart++;	// skip **/** situation
				continue;
			}
			// find the pattern between padIdxStart & padIdxTmp in str between strIdxStart & strIdxEnd
			int patLength = (patIdxTmp - patNdxStart - 1);
			int strLength = (tokNdxEnd - tokNdxStart + 1);
			int ndx = -1;
			strLoop:
			for (int i = 0; i <= strLength - patLength; i++) {
				for (int j = 0; j < patLength; j++) {
					String subPat = patterns[patNdxStart + j + 1];
					String subStr = tokens[tokNdxStart + i + j];
					if (!match(subStr, subPat)) {
						continue strLoop;
					}
				}

				ndx = tokNdxStart + i;
				break;
			}

			if (ndx == -1) {
				return false;
			}

			patNdxStart = patIdxTmp;
			tokNdxStart = ndx + patLength;
		}

		for (int i = patNdxStart; i <= patNdxEnd; i++) {
			if (!patterns[i].equals(PATH_MATCH)) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean match(String string, String pattern) {
		return match(string, pattern, 0, 0);
	}
	
	private static boolean match(String string, String pattern, int sNdx, int pNdx) {
		int pLen = pattern.length();
		if (pLen == 1) {
			if (pattern.charAt(0) == '*') {     // speed-up
				return true;
			}
		}
		int sLen = string.length();
		boolean nextIsNotWildcard = false;

		while (true) {

			// check if end of string and/or pattern occurred
			if ((sNdx >= sLen) == true) {		// end of string still may have pending '*' in pattern
				while ((pNdx < pLen) && (pattern.charAt(pNdx) == '*')) {
					pNdx++;
				}
				return pNdx >= pLen;
			}
			if (pNdx >= pLen) {					// end of pattern, but not end of the string
				return false;
			}
			char p = pattern.charAt(pNdx);		// pattern char

			// perform logic
			if (nextIsNotWildcard == false) {

				if (p == '\\') {
					pNdx++;
					nextIsNotWildcard =  true;
					continue;
				}
				if (p == '?') {
					sNdx++; pNdx++;
					continue;
				}
				if (p == '*') {
					char pNext = 0;						// next pattern char
					if (pNdx + 1 < pLen) {
						pNext = pattern.charAt(pNdx + 1);
					}
					if (pNext == '*') {					// double '*' have the same effect as one '*'
						pNdx++;
						continue;
					}
					int i;
					pNdx++;

					// find recursively if there is any substring from the end of the
					// line that matches the rest of the pattern !!!
					for (i = string.length(); i >= sNdx; i--) {
						if (match(string, pattern, i, pNdx) == true) {
							return true;
						}
					}
					return false;
				}
			} else {
				nextIsNotWildcard = false;
			}

			// check if pattern char and string char are equals
			if (p != string.charAt(sNdx)) {
				return false;
			}

			// everything matches for now, continue
			sNdx++; pNdx++;
		}
	}
	public static void moveDir(String srcDir, String destDir) throws IOException {
		moveDir(new File(srcDir), new File(destDir));
	}

	public static void moveDir(File srcDir, File destDir) throws IOException {
		checkDirCopy(srcDir, destDir);
		doMoveDirectory(srcDir, destDir);
	}

	private static void doMoveDirectory(File src, File dest) throws IOException {
		if (dest.exists()) {
			if (dest.isDirectory() == false) {
				throw new IOException(MSG_NOT_A_DIRECTORY + dest);
			}
			dest = new File(dest, dest.getName());
			dest.mkdir();
		}

		if (src.renameTo(dest) == false) {
			throw new IOException("Move failed: '" + src + "' to '" + dest + '\'');
		}
	}
	private static void checkDirCopy(File srcDir, File destDir) throws IOException {
		if (srcDir.exists() == false) {
			throw new FileNotFoundException(MSG_NOT_FOUND + srcDir);
		}
		if (srcDir.isDirectory() == false) {
			throw new IOException(MSG_NOT_A_DIRECTORY + srcDir);
		}
		if (equals(srcDir, destDir) == true) {
			throw new IOException("Source '" + srcDir + "' and destination '" + destDir + "' are equal");
		}
	}
	public static boolean equals(String file1, String file2) {
		return equals(new File(file1), new File(file2));
	}
	public static boolean equals(File file1, File file2) {
		try {
			file1 = file1.getCanonicalFile();
			file2 = file2.getCanonicalFile();
		} catch (IOException ignore) {
			return false;
		}
		return file1.equals(file2);
	}
	
	public static void mkdir(String dir) throws IOException {
		mkdir(new File(dir));
	}
	/**
	 * Creates single folders.
	 */
	public static void mkdir(File dir) throws IOException {
		if (dir.exists()) {
			if (dir.isDirectory() == false) {
				throw new IOException(MSG_NOT_A_DIRECTORY + dir);
			}
			return;
		}
		if (dir.mkdir() == false) {
			throw new IOException(MSG_CANT_CREATE + dir);
		}
	}
}
