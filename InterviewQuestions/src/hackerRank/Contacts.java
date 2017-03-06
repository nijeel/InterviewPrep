package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class Contacts {
	class Trie {
		HashMap<String, Trie> children;
		boolean isEndOfWord = false;

		public void setIsEndOfWord(boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
		}

		public HashMap<String, Trie> getChildren() {
			return this.children;
		}

		public Trie getChild(String value) {
			return children.get(value);
		}

		public boolean isEndOfWord() {
			return isEndOfWord;
		}

		public Trie addChild(String value) {
			if (this.children == null) {
				this.children = new HashMap<String, Trie>();
			}
			Trie child = new Trie();
			this.children.put(value, child);
			return child;
		}

	}

	Trie contacts = new Trie();

	public void addName(Trie contacts, String contact) {
		Trie adder = contacts;
		recursiveAddContact(adder, contact);

	}

	void recursiveAddContact(Trie parent, String contact) {	boolean noSubStringFound = true;
	if (parent.getChildren() != null) {
        
        List<String> toBeRemoved = new ArrayList<String>();
        HashMap<String,Trie> toBeAdded = new HashMap<String,Trie>();
		for (String childString : parent.getChildren().keySet()) {
			int commonSubStringEndIndex = findCommonSubStringEndIndex(childString, contact);
			if (commonSubStringEndIndex < 0) {
				// no substring
				continue;
			} else if (commonSubStringEndIndex < childString.length()) {
				noSubStringFound = false;
				String newChildSubstring = childString.substring(0, commonSubStringEndIndex);
				String newGrandChildString = childString.substring(commonSubStringEndIndex);
				String remainingContact = (contact.length() > commonSubStringEndIndex)
						? contact.substring(commonSubStringEndIndex) : null;
				Trie child = parent.getChild(childString);
				// newChild.setIsEndOfWord(child.isEndOfWord);
				if (newGrandChildString != null && newGrandChildString.length() > 0) {
                    
					Trie newChild = new Trie();
                    //parent.addChild(newChildSubstring);
					Trie newGrandChild = newChild.addChild(newGrandChildString);
					newGrandChild.setIsEndOfWord(child.isEndOfWord);
					if (child.getChildren() != null) {
						newGrandChild.children = new HashMap<>();
						newGrandChild.children.putAll(child.getChildren());
					}
                    toBeAdded.put(newChildSubstring,newChild);
                    toBeRemoved.add(childString);
					//parent.getChildren().remove(childString);
					//child = newChild;
				if (remainingContact == null || remainingContact.length() == 0) {
					child.setIsEndOfWord(true);
				} else {
					recursiveAddContact(newChild, remainingContact);
				}
                }

			} else if (commonSubStringEndIndex < contact.length()) {
				noSubStringFound = false;
				String remainingSubString = contact.substring(commonSubStringEndIndex);
				Trie child = parent.getChild(childString);
				if(remainingSubString.length() > 0){
					recursiveAddContact(child,remainingSubString);
				}
//				}else{
//					
//				}
//				Trie newChild = child.addChild(remainingSubString);
//				newChild.setIsEndOfWord(true);
				return;
			} else {
				System.out.println("Invalid case");
			}
		}
        for(String remove : toBeRemoved){
            parent.getChildren().remove(remove);
        }
        
        parent.getChildren().putAll(toBeAdded);
	}

	if (noSubStringFound) {
		Trie child = parent.addChild(contact);
		child.setIsEndOfWord(true);
		return;

	}
}

	int findCommonSubStringEndIndex(String childString, String contact) {
		if (childString.length() > contact.length() && childString.substring(contact.length() - 1).equals(contact)) {
			return contact.length();
		} else if (contact.length() > childString.length()
				&& contact.substring(childString.length() - 1).equals(childString)) {
			return childString.length();
		} else {
			int index = -1;
			for (int i = 0; i < childString.length(); i++) {
				if (i < contact.length() && childString.charAt(i) == contact.charAt(i)) {
					++index;
				} else {
					break;
				}
			}
			return index >= 0 ? ++index : index;
		}
	}

	public Integer findPartial(Trie contacts, String subString) {
		int count = 0;
		// count = contacts.isEndOfWord ? count+1 : count;
		if (contacts.getChildren() != null) {
			for (String childString : contacts.getChildren().keySet()) {
				Trie child = contacts.getChild(childString);
				if (subString != null && subString.length() > 0) {
					int commonSubStringEndIndex = findCommonSubStringEndIndex(childString, subString);
					if (commonSubStringEndIndex < 0) {
						continue;
					} else if (commonSubStringEndIndex < subString.length()
							&& commonSubStringEndIndex == childString.length()) {
						count = count + findPartial(child, subString.substring(childString.length()));
						break;
					} else if (commonSubStringEndIndex <= childString.length()
							&& commonSubStringEndIndex == subString.length()) {
						count = child.isEndOfWord ? count + 1 : count;
						count = count + findPartial(child, "");
						return count;
					} else {
						return count;
					}
				} else {
					count = child.isEndOfWord() ? count + 1 : count;

					count = count + findPartial(child, "");
				}

			}

		}

		return count;

	}

	public void printTrie(Trie a) {
		if (a != null) {
			System.out.println("---Node isEOW " + a.isEndOfWord + " Children [ "
					+ (a.getChildren() != null ? a.getChildren().keySet() : 0) + " ] -------");
			if (a.getChildren() != null) {
				for (Trie child : a.getChildren().values()) {
					printTrie(child);
				}
			}

		}
	}

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		Contacts s = new Contacts();

		s.addName(s.contacts, "s");
		// s.printTrie(s.contacts);
		s.addName(s.contacts, "ss");
		// s.printTrie(s.contacts);
		s.addName(s.contacts, "sss");
		s.printTrie(s.contacts);
		System.out.println(s.findPartial(s.contacts, "s"));
		System.out.println(s.findPartial(s.contacts, "ss"));

		// for(int a0 = 0; a0 < n; a0++){
		// String op = in.next();
		// String contact = in.next();
		// if(op.equals("add")){
		// s.addName(s.contacts,contact);
		// }else if(op.equals("find")){
		// System.out.println(s.findPartial(s.contacts,contact));
		// }
		// }
	}

}
