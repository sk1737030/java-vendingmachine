package vendingmachine;

import java.util.ArrayList;
import java.util.List;

class Changes {
    private int amount;

    public Changes(int amount) {
        this.amount = amount;
    }

    public List<CoinSet> coin() {
        List<CoinSet> list = new ArrayList<>();
        for (CoinSet coin : CoinSet.highestOrder()) {
            int count = amount / coin.value;
            for (int i = 0; i < count; i++) {
                list.add(coin);
            }
            amount = amount - (count * coin.value);

        }

        return list;
    }

    private void extracted(List<CoinSet> list, CoinSet coin) {
        int count = amount / coin.value;
        if (count > 0) {
            amount = amount - (count * coin.value);
            for (int i = 0; i < count; i++) {
                list.add(coin);
            }
        }
    }

    private List<CoinSet> getCoinSets(CoinSet coin) {
        List<CoinSet> list = new ArrayList<>();
        int quantity = amount / coin.value;
        for (int i = 0; i < quantity; i++) {
            list.add(coin);
        }

        return list;
    }

}
