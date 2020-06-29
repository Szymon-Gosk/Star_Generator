package coordination;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import objects.Star;

public class FileManager {
	
	private PrintWriter writer;
	private Scanner scanner;
	
	private File saves;
	private File options;
	
	public FileManager() {
		saves = new File(".\\saves\\saves.txt");
		options = new File(".\\opt\\options.txt");
	}

	public void saveStar(Star star) {
		LinkedList<String> saved = loadSaves();
		saved.add(star.toString());
		try {
			writer = new PrintWriter(saves);
			for(String s : saved) {
				writer.println(s);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void removeStar(int index) {
		System.out.println();
		LinkedList<String> saved = loadSaves();
		saved.remove(index);
		System.out.println();
		try {
			writer = new PrintWriter(saves);
			for(String s : saved) {
				writer.println(s);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<String> loadSaves() {
		LinkedList<String> saved = null;
		try {
			scanner = new Scanner(saves);
			saved = new LinkedList<>();
			while(scanner.hasNextLine()) {
				saved.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return saved;
	}
	
	public void saveOptions(int radDP, int massDP, int ageDP, boolean generateInKM, boolean includeStandardDistribution) {
		try {
			writer = new PrintWriter(options);
			String tmp = radDP + "&" + massDP + "&" + ageDP + "&" + generateInKM + "&" + includeStandardDistribution;
			writer.print(tmp);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveOptions(boolean includeStandardDistribution) {
		int[] opt = loadOptions();
		boolean opt4 = (opt[3] == 1);
		saveOptions(opt[0], opt[1], opt[2], opt4, includeStandardDistribution);
	}
	
	public int[] loadOptions() {
		int[] opt = new int[5];
		try {
			scanner = new Scanner(options);
			String tmp = scanner.nextLine();
			for(int i = 0 ; ; i++) {
				if(i == 3) {
					opt[i] = Boolean.parseBoolean(tmp.substring(0, tmp.indexOf('&'))) ? 1 : 0;
				} else if(i == 4) {
					opt[i] = Boolean.parseBoolean(tmp.substring(0)) ? 1 : 0;
					break;
				} else {
					opt[i] = Integer.parseInt(tmp.substring(0, tmp.indexOf('&')));
				}
				tmp = tmp.substring(tmp.indexOf('&') + 1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return opt;
	}
	
	public ImageIcon getIcon(String starClass, int imageNumber) {
		return new ImageIcon(".\\rsc\\" + starClass.toLowerCase() + "\\" + imageNumber + ".png");
	}
	
	public ImageIcon getSmallIcon(String starClass, int imageNumber) {
		return new ImageIcon(".\\rsc\\" + starClass.toLowerCase() + "\\" + imageNumber + "s.png");
	}

	public int[] loadDefaultOptions() {
		return null;
	}
	
}
