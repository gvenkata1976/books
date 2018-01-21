package com.pine.common.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

public class FileUtil {
	public static byte[] readBytes(String baseDir, String fileName) {
		BufferedInputStream bis = null;
		byte[] buff = null;
		try {
			File file = new File(baseDir, fileName);
			bis = new BufferedInputStream(new FileInputStream(file));
			buff = IOUtils.toByteArray(bis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeQueitly(bis);
		}
		return buff;
	}

	public static void write(byte[] content, String baseDir, String fileName) {
		BufferedOutputStream bos = null;
		byte[] buff = null;
		try {
			File file = new File(baseDir, fileName);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			IOUtils.write(content, bos);
			bos.write(buff);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeQueitly(bos);
		}
	}

	public static void closeQueitly(Closeable io) {
		try {
			if (io != null) {
				io.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}

}