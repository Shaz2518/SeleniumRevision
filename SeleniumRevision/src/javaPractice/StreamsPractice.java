package javaPractice;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsPractice {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Jay");
		names.add("Jeet");
		names.add("Brain");
		names.add("Jim");
		
		for(String name:names)
		{
			if(name.startsWith("J"))
			{
				System.out.println(name);
			}
		}
		
		System.out.println("Streamsss");
		names.stream().filter(n->n.startsWith("J")).forEach(n->System.out.println(n));
		
		Stream.of("Apples","Mangoes","Cherries","Lemon","Guava")
		.filter(f->f.length()>5)
		.forEach(f->System.out.println(f));
	}

}
