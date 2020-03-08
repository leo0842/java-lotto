package lotto.view;

import lotto.domain.*;

public class OutputView {
	private static final String NEW_LINE = System.lineSeparator();

	public static void printWhenManualMoneyIsMoreThanTotalMoney() {
		System.out.println("수동으로 구입할 티켓은 구입할 수 있는 개수보다 클 수 없습니다.");
	}

	public static void printInputManualLottoNumbersMessage() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static void printCountOfLottos(LottoMoney lottoMoney) {
		System.out.println(lottoMoney.countPurchasedTickets() + "개를 구매했습니다.");
	}

	public static void printLottos(
			Lottos manual, Lottos auto) {

		System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n",
				manual.size(), auto.size());
		manual.getLottos().stream()
				.map(Lotto::sorted).forEach(System.out::println);
		auto.getLottos().stream()
				.map(Lotto::sorted).forEach(System.out::println);
	}

	public static void printLottoResult(LottoResult lottoResult) {
		System.out.println("당첨통계");
		System.out.println("----------");
		StringBuilder stringBuilder = new StringBuilder();
		for (WinningType winningType : lottoResult.getWinningKeys()) {
			stringBuilder.append(winningType.getSameNumberCount())
					.append("개 일치");
			if (winningType.isBonusTrue()) {
				stringBuilder.append(", 보너스 볼 일치");
			}
			stringBuilder.append("(")
					.append(winningType.getWinningAmount())
					.append("원)- ")
					.append(lottoResult.getLottoResult().get(winningType))
					.append("개")
					.append(NEW_LINE);
		}
		System.out.println(stringBuilder.toString());
	}

	public static void printWarningMessage(String message) {
		System.out.println(message);
	}

	public static void printEarningRate(double calculateEarningRate) {
		System.out.printf("총 수익률은 %.2f %% 입니다.\n", calculateEarningRate);
	}
}
