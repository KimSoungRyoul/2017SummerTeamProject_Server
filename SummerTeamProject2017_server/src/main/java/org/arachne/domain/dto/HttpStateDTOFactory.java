package org.arachne.domain.dto;

import org.springframework.http.HttpStatus;

public class HttpStateDTOFactory {

	
	
	public static HttpStateDTO get200() {

		return new HttpStateDTO(HttpStatus.OK, "너의 요청을  윤허한다 .. :: 정상적으로 요청을 처리했습니다");
	}

	public static HttpStateDTO get201() {

		return new HttpStateDTO(HttpStatus.ACCEPTED, "딱히 너의 데이터를 저장해주고싶어서 하는건 아니라구 .. :: 데이터 등록 요청을 성공적으로 처리했습니다");
	}

	public static HttpStateDTO get204() {

		return new HttpStateDTO(HttpStatus.NO_CONTENT, "공허를 찾았는가 ... 찾고자하는 것은 이미 공허로 돌아갔으니... :: 정상적 요청을 처리했으나 찾고자하는 데이터가 없습니다");
	}

	public static HttpStateDTO get401() {

		return new HttpStateDTO(HttpStatus.UNAUTHORIZED, "치잇.. 결계인가? :: 해당 데이터 접근 권한이 없습니다");
	}

	public static HttpStateDTO get403() {

		return new HttpStateDTO(HttpStatus.FORBIDDEN, "어이.. 이곳은  너같은 애송이는 들어올수 없어  크큭... :: 해당 http요청이 서버관리자(김성렬~) 판단하에  금지 되어있음 ");
	}
	
	public static HttpStateDTO get400() {

		return new HttpStateDTO(HttpStatus.BAD_REQUEST, "json형식이 잘못됬거나 필요한 데이터가 null일수도 있고 ~확인해봐 병현몬~ ::처리 실패.. 요청이 형식이 잘못되었거나 중복이 발생했을가능성 있음  ");
	}

	
}
