/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Saleem Malik
 */
public class HashTable {

    private Abreviation abbreviationList[];
    private int arraySize;

    public HashTable(int s) {
        abbreviationList = new Abreviation[s * 2];
        arraySize = s * 2;
    }

    public int hashFun(int key) {
        return key % arraySize;
    }

    public void insert(String k, String d) {
        int key = 0;
        for (int i = 0; i < k.length(); i++) {

            key += (int) k.charAt(i);

        }
        int hashval = hashFun(key);

        while (abbreviationList[hashval] != null && !abbreviationList[hashval].getAbrevation().equals("Deleted")) {
            ++hashval;
            hashval %= arraySize;
        }
        abbreviationList[hashval] = new Abreviation(k, d);
        

    }

    public int delete(String k) {
        int key = 0;
        for (int i = 0; i < k.length(); i++) {

            key += (int) k.charAt(i);

        }
        int hashval = hashFun(key);

        while (abbreviationList[hashval] != null) {
            if (abbreviationList[hashval].getAbrevation().equals(k)) {
                abbreviationList[hashval] = new Abreviation("Deleted","Previous value is deleted here");

                return 1;
            } else {
                ++hashval;
                hashval %= arraySize;
            }

        }
        return 0;

    }

    public String find(String k) {
        int key = 0;

        for (int i = 0; i < k.length(); i++) {

            key += (int) k.charAt(i);

        }
        int hashval = hashFun(key);

        while (abbreviationList[hashval] != null) {
            if (abbreviationList[hashval].getAbrevation().equals(k)) {
                return abbreviationList[hashval].getMeaning();
            } else {
                hashval++;
                hashval %= arraySize;
            }
        }
        return null;

    }

}
