package com.ssafy.myapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@RequiredArgsConstructor

@Data // 위 다섯개의 애노테이션을 모두 처리
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

	@NonNull
	private String name;
	private int age;
}
