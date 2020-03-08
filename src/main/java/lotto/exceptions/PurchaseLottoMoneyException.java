package lotto.exceptions;

public class PurchaseLottoMoneyException extends IllegalArgumentException {
	private static final String MESSAGE
			= " - 구입할 티켓의 갯수는 0보다 크거나 같아야합니다." +
			"\n - 구입 금액을 초과하는 갯수는 허용되지 않습니다.";

	public PurchaseLottoMoneyException() {
		super(MESSAGE);
	}
}
