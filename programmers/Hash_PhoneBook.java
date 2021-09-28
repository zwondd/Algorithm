import java.util.*;

/*
    2021-09-28
    [Programmers][Hash][Lv2] 전화번호 목록

    - java HashMap 함수
*/
class Hash_PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hm = new HashMap<>();

        for(String phone : phone_book ) hm.put(phone, 0);

        for(String phone : phone_book ) {
            char[] candidate = phone.toCharArray();

            String tmp = "";
            for(int i=0; i<candidate.length-1; i++) {
                tmp += candidate[i];
                if ( hm.containsKey(tmp) ) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    /*
        다른 풀이
    */
    public boolean solution2(String[] phone_book) {
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if ( phone_book[i].startsWith(phone_book[j]) ) return false;
                if ( phone_book[j].startsWith(phone_book[i]) ) return false;
            }
        }
        return true;
    }

    public boolean solution3(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
    
}
