import java.util.HashMap;
import java.util.Iterator;

/*Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  
write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;
 otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/
public class _383_RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map1 = getMap(ransomNote);
		HashMap<Character, Integer> map2 = getMap(magazine);
		System.out.println(map1);
		System.out.println(map2);
		Iterator<Character> iterator = map1.keySet().iterator();
		while (iterator.hasNext()) {
			Character key = iterator.next();
			if (!map2.containsKey(key) || map2.get(key).compareTo(map1.get(key)) < 0)
				return false;

		}
		return true;
	}

	private static HashMap<Character, Integer> getMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ransomNote = "dd";
		String magazine = "";
		System.out.println(canConstruct(ransomNote, magazine));

	}
}
