package domain;

public enum OrderStatus {
    SUCCESS,//거래 완료(성공)
    OUT_OF_STOCK,//재고부족(실패)
    NOT_ENOUGH_MONEY //입금액 부족(실패)
}
