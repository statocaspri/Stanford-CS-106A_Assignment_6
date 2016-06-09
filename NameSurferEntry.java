/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*; 

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {

		StringTokenizer tokenizer = new StringTokenizer(line);
		for (int i = 0; i <= NDECADES ; i++) {
			nameAndRank[i] = tokenizer.nextToken();
		}

	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		return nameAndRank[0];

	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {

		int y = decade;
		int x = -1;
		switch (y) {
			case 1900:
				x = Integer.parseInt(nameAndRank[1]);
				break;
			case 1910:
				x = Integer.parseInt(nameAndRank[2]);
				break;
			case 1920:
				x = Integer.parseInt(nameAndRank[3]);
				break;
			case 1930:
				x = Integer.parseInt(nameAndRank[4]);
				break;
			case 1940:
				x = Integer.parseInt(nameAndRank[5]);
				break;
			case 1950:
				x = Integer.parseInt(nameAndRank[6]);
				break;
			case 1960:
				x = Integer.parseInt(nameAndRank[7]);
				break;
			case 1970:
				x = Integer.parseInt(nameAndRank[8]);
				break;
			case 1980:
				x = Integer.parseInt(nameAndRank[9]);
				break;
			case 1990:
				x = Integer.parseInt(nameAndRank[10]);
				break;
			case 2000:
				x = Integer.parseInt(nameAndRank[11]);
				break;
		}
		return x;

	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {

		return ("[" + nameAndRank[0] + "] " + nameAndRank[1] + " " +
				nameAndRank[2] + " " + nameAndRank[3] + " " +
				nameAndRank[4] + " " + nameAndRank[5] + " " +
				nameAndRank[6] + " " + nameAndRank[7] + " " +
				nameAndRank[8] + " " + nameAndRank[9] + " " +
				nameAndRank[10] + " " + nameAndRank[11]);

	}
	
	//private instance variable to store name and popularity rank
	private String[] nameAndRank = new String[NDECADES + 1];
}

