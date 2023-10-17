class Solution {
  public int solution(int[] common) {
      int n = common.length;

      // 등차수열 패턴 여부
      boolean is등차수열 = true;
      int 공차 = common[1] - common[0];
      for (int i = 2; i < n; i++) {
          if (common[i] - common[i - 1] != 공차) {
              is등차수열 = false;
              break;
          }
      }

      // 등비수열 패턴 여부
      boolean is등비수열 = true;
      int 공비 = common[1] / common[0];
      for (int i = 2; i < n; i++) {
          if (common[i] / common[i - 1] != 공비) {
              is등비수열 = false;
              break;
          }
      }

      // 다음 값을 계산
      if (is등차수열) {
          int result = common[n - 1] + 공차; // 등차수열인 경우 차이 값을 더해준다
          return result;
      } else if (is등비수열) {
          int result = common[n - 1] * 공비; // 등비수열인 경우 공비를 곱해준다
          return result;
      } else {
          // 둘 다 아니면 오류
          return -1;
      }
  }
  
    }
