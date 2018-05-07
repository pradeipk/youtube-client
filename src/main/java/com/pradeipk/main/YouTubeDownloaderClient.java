package com.pradeipk.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.axet.vget.VGet;

/**
 *
 * @author pradeipk
 */
public class YouTubeDownloaderClient {
	static String VIDEO_DOWN_LIST = "youTybeDownloadList.txt";
	static String path = "F:\\Youtube\\";

	public static void main(String[] args) {
		int i = 0;
		int count = publishUrls().size();
		for (String url : publishUrls()) {
			System.out.println(++i + "/" + count + " Download start : " + url);
			download(url);
			System.out.println("Download complete....");
			if (i == count)
				System.out.println("All downloads finished, Thankyou");
		}

	}

	public static void download(String url) {
		try {
			String path = "F:\\Youtube\\";
			
			VGet v = new VGet(new URL(url), new File(path));
			v.download();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<String> publishUrls() {
		Scanner scan = null;
		File file = new File(path + VIDEO_DOWN_LIST);
		List<String> list = new ArrayList<String>();
		try {
			scan = new Scanner(file);

			while (scan.hasNextLine()) {
				list.add(scan.nextLine());

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
			System.out.println("Closing the scaning..., returning the list");
		}
		return list;
	}

}