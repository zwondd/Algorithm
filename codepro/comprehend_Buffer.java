/*
   2021-04-20
   LG codepro - [코드이해] 통신버퍼 설계
   10/10: success (35min)
*/
package codepro;

import java.util.*;

class PACKET{
	int packet_no;
	int prior_level;
	PACKET next;
}

public class comprehend_Buffer {

	PACKET buffer;
	PACKET last_packet;
	
	Scanner sc;
	
	boolean Put_Packet_to_Buffer(PACKET pac){
		// if ( buffer.next == null ) {
		// 		buffer.next = pac;
		//     last_packet = pac;
		// 	  return true;
		// }
		
	  PACKET cur = buffer;
		while(cur.next != null) {
			PACKET tmp;
			// System.out.println(" cur : " + cur.prior_level + " " + cur.packet_no );
			if ( cur.next.prior_level > pac.prior_level ) {
				tmp = cur.next;
				
				cur.next = pac;
				cur.next.next = tmp;
				return true;
				
			} else if ( cur.next.prior_level == pac.prior_level  ) {
				if ( cur.next.packet_no > pac.packet_no ) {
					tmp = cur.next;
				
					cur.next = pac;
					cur.next.next = tmp;
					return true;
				}
			}
			cur = cur.next;
		}
		
		cur.next = pac;
		
		return true;
	}
	
	PACKET Get_Packet_from_Buffer(){
		
		if (buffer.next == null) return null;
		PACKET pac = buffer.next;
		
		buffer.next = pac.next;
		
		return pac;
	}
	
	
	public static void main(String[] args) {
		// Main m = new Main();
        comprehend_Buffer m = new comprehend_Buffer();

		m.buffer = new PACKET();
		m.sc = new Scanner(System.in);
		m.last_packet = m.buffer;
		
		int N = m.sc.nextInt(); // 패킷의 수 입력
		// 패킷의 수신
		for(int i=0;i<N;i++){
			PACKET pac = new PACKET();
			// packet_no, prior_level 입력
			pac.packet_no = m.sc.nextInt();
			pac.prior_level = m.sc.nextInt();
			m.Put_Packet_to_Buffer(pac);
		}

		// 패킷 처리순서 출력
		PACKET process = null;
		while((process = m.Get_Packet_from_Buffer()) != null){
			System.out.print(process.packet_no + " ");
		}
		
		m.sc.close();
	}
}
