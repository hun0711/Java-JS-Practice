  import java.util.PriorityQueue;

  class Scovile {
      public int solution(int[] scoville, int K) {
          int answer = 0;
      //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

      //최소값 구할 힙
          PriorityQueue<Integer> heap = new PriorityQueue<>();
          
          // 초기 스코빌 지수를 최소 힙에 추가
          for (int s : scoville) {
              heap.add(s);
          }
          //최솟값이  K보다 작으면 섞어야함
          while (heap.peek() < K) {
            
            if(heap.size() < 2){
              return -1; 
            }
                  // 가장 작은 스코빌 지수와 두 번째로 작은 스코빌 지수를 꺼내서 섞은 값을 다시 최소 힙에 추가
                  int first = heap.poll();
                  int second = heap.poll();
                  int mixed = first + (second * 2);
                  heap.add(mixed);
                  
                  answer++;
          }

        return answer;    
        }
      }