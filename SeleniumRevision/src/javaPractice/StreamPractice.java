package javaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamPractice {

	public static void main(String[] args) {
		
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Shaziya");
		names.add("John");
		names.add("Smith");
		names.add("Steve");
		names.add("Carol");
		
		// Get names starts with S
		names.stream().filter(s->s.startsWith("S")).forEach(s->System.out.println(s));
		System.out.println("=====");
		
		names.stream().filter(s->s.endsWith("l")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("========");
		
		names.stream().sorted().forEach(s->System.out.println(s));
		System.out.println("======");
		
		Stream<String> fruits = Stream.of("Apple", "Mango", "Cherry", "Kiwi");
		
		Stream<String> finalList = Stream.concat(names.stream(), fruits);
		finalList.forEach(s->System.out.println(s));
		
		boolean flag = names.stream().anyMatch(s->s.equalsIgnoreCase("Johnny"));
		System.out.println(flag);
		System.out.println("===================");
		
		Stream<String> veggies = Stream.of("Cabbage", "Tomato", "Reddish", "Carrot", "Apple");
		veggies.sorted().collect(Collectors.toList()).forEach(s->System.out.println(s));
		System.out.println("======");
		
		Stream<Integer> values = Stream.of(4,5,5,3,6,1,3,5,4,6,7);
		values.distinct().sorted().forEach(s->System.out.println(s));
		System.out.println("===");
		
		
		
		
	}

}
