/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/
public class _165_CompareVersionNumbers {
	public static void main(String[] args) {
		String version1 = "1.0";
		String version2 = "1";
		System.out.println(compareVersion(version1, version2));
	}

	public static int compareVersion(String version1, String version2) {

		version1 = version1 + ".0";
		version2 = version2 + ".0";
		String[] split1 = version1.split("\\.");
		String[] split2 = version2.split("\\.");
		int i = 0;
		return compareNum(0, split1, split2);
	}

	private static int compareNum(int i, String[] split1, String[] split2) {

		if (i < split1.length && i < split2.length) {
			if (Integer.parseInt(split1[i]) > Integer.parseInt(split2[i]))
				return 1;
			else if ((Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])))
				return -1;
			else
				return compareNum(i + 1, split1, split2);
		} else if (i == split1.length && i < split2.length
				&& Integer.parseInt(split2[i]) != 0)
			return -1;
		else if (i == split2.length && i < split1.length
				&& Integer.parseInt(split1[i]) != 0)
			return 1;
		else
			return 0;

	}
}
