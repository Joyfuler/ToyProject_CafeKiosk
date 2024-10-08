package ch19.posBackup2.JavaToy_BookSearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookListGenerator {
	
	public static BookListGenerator instance = null;
	
	private BookListGenerator() {}
	
	static public BookListGenerator GetInstance() {
		if (instance == null) {
			instance = new BookListGenerator();
		}
		
		return instance;
	}
	
	public Map<Integer, Book> getBookList(){ 
		Map<Integer, Book> allBookMap = new HashMap<Integer, Book>();
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader
					("C:\\Users\\asiae\\eclipse-workspace\\com.lecture.practice\\src\\ch20\\task\\bookSearch\\Book.txt"));
			String line = null;
			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {
				String[] splitArray = line.split(";");
					Book book = null;
				if (splitArray[0].equals("교육")) {
					book = new EducationBook();
				} else if (splitArray[0].equals("수필")){
					book = new EssayBook();
				} else {
					book = new NovelBook();
				}
				book.setName(splitArray[1]);
				book.setPublisher(splitArray[2]);
				book.setReleaseDate(splitArray[3]);
				book.setPrice(Integer.parseInt(splitArray[4]));
				allBookMap.put(count, book);
				count++;
			}
			
			// System.out.println(allBookMap + "생성됨.");			
			bufferedReader.close();			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("텍스트에 입력된 값 없음.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return allBookMap;
	}	
}