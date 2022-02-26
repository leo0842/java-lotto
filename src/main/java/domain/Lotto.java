package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_MAXIMUM = 45;
    public static final int LOTTO_NUMBER_MINIMUM = 1;

    private static final String DELIMITER = ", ";

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateLottoNumbers(lottoNumber);
            this.lottoNumbers.add(lottoNumber);
        }
    }

    private void validateLottoNumbers(Integer number) {
        validateNumberRange(number);
        validateDuplicatedNumber(number);
    }

    private void validateNumberRange(Integer lottoNumber) {
        if (lottoNumber > LOTTO_NUMBER_MAXIMUM || lottoNumber < LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException(String.valueOf(lottoNumber));
        }
    }

    private void validateDuplicatedNumber(Integer lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException(String.valueOf(lottoNumbers));
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    public int countSameNumbers(List<Integer> numbers) {
        return (int) lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean checkBonus(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
