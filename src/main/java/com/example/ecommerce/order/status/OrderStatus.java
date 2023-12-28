package com.example.ecommerce.order.status;


// enum  열거형
// enum 특성
// 1.고정된 상수 집합: Enum은 상수의 집합으로, 선언된 상수 외에 추가적인 상수를 추가할 수 없음
// 2.Instance 생성 제어: Enum은 인스턴스를 사용자가 직접 생성할 수 없으며, 런타임 시에 이미 정의된 상수들 중 하나를 선택하여 사용
// 3.강력한 타입 검사: Enum은 강력한 타입 검사를 제공, 타입 안전성을 보장
// 4.메서드 및 속성 추가 가능: Enum은 메서드나 속성을 추가하여 더 복잡한 동작도 가능
public enum OrderStatus {
    REQUEST,
    COMPLETED,
    CANCELED
    ;
}