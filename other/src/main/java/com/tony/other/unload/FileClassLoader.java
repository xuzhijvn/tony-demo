package com.tony.other.unload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class FileClassLoader extends ClassLoader {
	private String rootDir;

	public FileClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	/**
	 * 编写findClass方法的逻辑
	 * 
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// 获取类的class文件字节数组
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			// 直接生成class对象
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * 编写获取class文件并转换为字节码流的逻辑
	 * 
	 * @param className
	 * @return
	 */
	private byte[] getClassData(String className) {
		// 读取类文件的字节
		String path = classNameToPath(className);
		InputStream ins = null;
		try {
			ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			// 读取类文件的字节码
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 类文件的完全路径
	 * 
	 * @param className
	 * @return
	 */
	private String classNameToPath(String className) {
		return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
	}

	public static void main(String[] args) throws ClassNotFoundException {
		String rootDir = "C:\\Users\\GoneBoy\\Desktop\\test";
		// 创建自定义文件类加载器
		FileClassLoader loader = new FileClassLoader(rootDir);

		try {
			// 加载指定的class文件
			Class<?> object1 = loader.loadClass("com.xzj.classloader.DemoObj");
			System.out.println(object1.newInstance().toString());
			// 输出结果:I am DemoObj
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
