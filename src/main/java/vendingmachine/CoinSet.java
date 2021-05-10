package vendingmachine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum CoinSet {
    _500_COIN(500), _100_COIN(100), _50_COIN(50), _10_COIN(10);

    int value;

    CoinSet(int value) {
        this.value = value;
    }

    public static CoinSet valueOf(int amount) {
        return Arrays.stream((values()))
                .filter(coin -> coin.value == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(amount + "원의 동전은 존재하지 않습니다."));
    }


    public static List<CoinSet> highestOrder() {
        return Arrays.stream(values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                ;
    }
}
