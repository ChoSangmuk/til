# Java

- Write Once, Run Anywhere

애플릿 - 새로운 형식의 프로그램  
애플릿 인터넷 상에서 전송되고, 자바를 지원하는 웹브라우저에서 실행될 수 있도록 설계된 프로그램  
자바는 사용자의 컴퓨터와 네트워크 애플리케이션 사이에 방화벽(firewall)을 제공하여 이 문제를 해결  
자바를 지원하는 웹 브라우저를 사용하면 바이러스 감염에 대한 두려움 없이 안전하게 자바 애플릿을 다운로드할 수 있다.  
자바가 사용한 방법은 자바 프로그램이 컴퓨터의 다른 부분에는 접근하지 못하게 하고, 제한된 자바 실행 환경 내에서만 접근할 수 있도록 허용하는 것이다.  
사실 클라이언트 컴퓨터에 아무런 해를 끼치지 않고 애플릿을 다운로드하는 기능은 자바의 가장 중요한 부분이다.  

Java EE 스펙에 따라 제품으로 구현한 것을 웹 애플리케이션 서버 또는 WAS라 불린다.  
현재는 Java EE의 복잡도로 인해 스프링과 같은 프레임워크를 통해 웹 애플리케이션 서버를 개발하는 추세이다.  

- 중복을 피하면서 저장
```java
import java.util.HashSet;

class Solution {
  public int solution(int[] nums) {

    HashSet<Integer> hs = new HashSet<>();
    for(int i =0; i<nums.length;i++) hs.add(nums[i]);
    if(hs.size()>nums.length/2) return nums.length/2;
    return hs.size();

    List<Integer> list = new ArrayList<Integer>();
    for(int i = 0 ; i < nums.length; i++) if(!list.contains(nums[i])) list.add(nums[i]);
    return nums.length/2 > list.size() ? list.size():nums.length/2;

    int answer = 0;
    ArrayList<Integer> array = new ArrayList<Integer>();
    for (int i = 1; i < nums.length; i++) if (!array.contains(nums[i])) array.add(nums[i]);
    answer = array.size();
    if (answer > nums.length / 2) answer = nums.length / 2;
    return answer;
  }
}
```

## Reference
- Telegram Bot Sample Code : https://idlecomputer.tistory.com/199
- htmlurl request 
  - https://goddaehee.tistory.com/161
  - https://m.blog.naver.com/PostView.nhn?blogId=javaking75&logNo=220552685641&proxyReferer=https:%2F%2Fwww.google.com%2F