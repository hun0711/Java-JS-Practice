import java.util.HashMap;

class Prefix{
  public boolean solution(String[] phone_book) {
    HashMap<String, Boolean> prefixMap = new HashMap<>();
    for(String phoneNumber : phone_book){
      String prefix = "";
      for(int i = 0; i < phoneNumber.length(); i++){
       prefix += phoneNumber.charAt(i);
        if(prefixMap.containsKey(prefix)){
          return false;
        }
      }
      prefixMap.put(prefix, true);
    }
    return true;

  }
}

