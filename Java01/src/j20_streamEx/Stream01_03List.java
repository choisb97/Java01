package j20_streamEx;
import java.util.List;
import java.util.Arrays;

class Stream01_03List {
    public static void main(String[] args) {
        
    	// 배열을 이용해서 초기값을 넣은 List 생성
        List<String> list = Arrays.asList("Korea", "Robot", "AI","그린컴퓨터");
        
        // ** List interface
        // => interface 상속 계층도
        //    Iterable<E> -> Collection<E> -> List 
        // => Iterable 에도 forEach(Consumer<? Super T> action) 가 있어서 
        //    list 도 forEach() 사용가능.(결과및 기능는 동일하지만 서로 소속이 다른 메서드임) 
        // => LamdaEx01_2doubleColon.java 참고   
        System.out.println("** Iterable 의 forEach() 사용 **");
        list.forEach(s -> System.out.print(s + "\t"));
        
        System.out.println("\n** Stream 의 forEach() 사용 **");
        list.stream().forEach(s -> System.out.print(s + "\t"));
        System.out.println();
    } // main
} // class