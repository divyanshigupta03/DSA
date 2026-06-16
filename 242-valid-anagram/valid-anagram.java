class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        //remove white spaces
        s = s.replace(" ","");
        t = t.replace(" ","");

        //make counts array
        int[] counts = new int[26];

        //fill counts array using 1st string
        for(int i=0; i<s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }

        //defill array using second string
        for(int i=0; i<t.length(); i++){
            counts[t.charAt(i) - 'a']--;
        }

        //check 
        for(int count : counts){
            if(count != 0) return false;
        }

        return true;
    }
}