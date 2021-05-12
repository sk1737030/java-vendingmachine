package vendingmachine;

import java.util.ArrayList;
import java.util.List;

class Changes {
    private int amount;

    public Changes(int amount) {
        this.amount = amount;
    }

    public List<CoinSet> returnChanges() {
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

}
