//import java.util.HashMap;
//import java.util.Iterator;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class test {

    /*
    private HashMap m = new HashMap();

    public void add(int index, E element) {
	m.put(index, element);
    }
    */

    public static void main(String[] args) {
	/*
	HashMap hm = new HashMap();
	//System.out.println(hm.size());
	hm.put("map", 1);
	//System.out.println(hm.size());
	Iterator i = hm.keySet().iterator();
	while (i.hasNext()) {
	    System.out.println(i.next());
	}
	test t = new test();
	t.add(1, 10);
	t.add(2, "String");
	*/
	try {
	    //PrintWriter wipes the file and writes on a blank file everytime
	    PrintWriter printer = new PrintWriter(new File("test.txt"));
	    printer.write("Hello World");
	    printer.write(" again");
	    printer.close();
	} catch(FileNotFoundException e) {
	    System.out.println("File not found");
	}
	try {
	    Scanner sc = new Scanner(new File("test.txt"));
	    while (sc.hasNextLine()) {
		System.out.println(sc.next());
	    }
	} catch(FileNotFoundException e) {
	    System.out.println("File not found");
	}
    }
}
