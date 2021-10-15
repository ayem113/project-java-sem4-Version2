package com.projectjavasem4.util;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class JavaReduceEx2 {
	
	class Expense {
	    String category;
	    private double expense;
	    Expense(String _category, double _expense) {
	        this.category = _category;
	        this.expense = _expense;
	    }
	    double getExpense() {
	        return expense;
	    }
	    String getCategory() {
	        return category;
	    }
	}

    public static void main(String[] args) {
    	List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
    	Optional<String> reduce = words.stream()
    			.reduce((word1, word2)-> word1.length() > word2.length() ? word1 : word2);
    	reduce.ifPresent(System.out::println);
    }
}