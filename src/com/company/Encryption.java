package com.company;

import java.util.Random;
/**
 * Created by dpennebacker on 10/28/16.
 */
public class Encryption {
    /*
     * keygen returning function By default, length is 32 characters
     * Will generate "access keys" for each user
     */

    private Random rand = new Random();

    public String keygen(){ //creating the key for the user
        char a[] = new char[32];
        for(int i=0;i<32;i++){
            a[i] = (char) (rand.nextInt((90 - 48) + 1) + 48); //creating the random int key for it
        }
        return new String(a);
    }

    /*
     * Takes a string seed and runs encryption algorithm on it
     */
    public String encrypt(String seed, String key){ //runs the encryption for the user
        int count = 0;
        char a[] = new char[seed.length()];

        for(int i=0;i<seed.length();i++){
            a[i] = seed.charAt(i);
        }

        for(int i=0;i<seed.length();i++){
            if(count > 31){ //as long as count is less than 31 it keeps running through
                count = 0;
            }
            a[i] = (char) (a[i] * key.charAt(count));
            count++;
        }
        return new String(a);
    }
}
