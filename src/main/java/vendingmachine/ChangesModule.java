package vendingmachine;

public class ChangesModule {
    private int changes;

    public ChangesModule() {
        this(0);
    }

    public ChangesModule(int changes) {
        this.changes = changes;
    }

    public void put(int changes) {
        this.changes += changes;
    }

    public int getChanges() {
        return changes;
    }

    public void withdraw(int changes) {
        int result = this.changes - changes;
        if (result < 0) {
            throw new IllegalStateException("changes는 음수가 나올 수 없다.");
        }
        this.changes -= changes;
    }
}
