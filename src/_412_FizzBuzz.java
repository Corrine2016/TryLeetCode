import java.util.ArrayList;
import java.util.List;

/*Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output ¡°Fizz¡± instead of the number and for the multiples of five output
¡°Buzz¡±. For numbers which are multiples of both three and five output ¡°FizzBuzz¡±.
Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]*/
public class _412_FizzBuzz {
	public static void main(String[] args) {
		System.out.println(fizzBuzz(3));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			result.add(getString(i));
		}
		return result;

	}

	private static String getString(int n) {

		if (n % 3 == 0 && n % 5 != 0)
			return "Fizz";
		else if (n % 3 != 0 && n % 5 == 0)
			return "Buzz";
		else if (n % 3 == 0 && n % 5 == 0)
			return "FizzBuzz";
		else
			return Integer.toString(n);
	}

}
