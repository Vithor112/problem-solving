        class Solution {

            public String encode(List<String> strs) {
                StringBuilder encode = new StringBuilder();
                for (String word : strs){
                    encode.append(word.length()).append('%').append(word);
                }
                return encode.toString();
            }

            public List<String> decode(String str) {
                if (str.isBlank()){
                    return List.of();
                }
                List<String> decodeList = new ArrayList<>();
                StringBuilder lengthStr = new StringBuilder();
                int length = 0;
                boolean findingLength = true;
                StringBuilder word = new StringBuilder();
                for (Character c : str.toCharArray()){
                    if (findingLength){
                        if (c ==  '%'){
                            findingLength = false;
                            length = Integer.valueOf(lengthStr.toString());
                            lengthStr = new StringBuilder();
                        } else {
                            lengthStr.append(c);
                        }
                    } else if (length != 0) {
                        length--;
                        word.append(c);
                    } else if (length == 0) {
                        decodeList.add(word.toString());
                        word = new StringBuilder();
                        findingLength = true;
                        lengthStr.append(c);
                    }
                }
                decodeList.add(word.toString());
                return decodeList;
            }
        }