class Bank {

    long[] balanceAmount;

    public Bank(long[] balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (
            account1 > balanceAmount.length ||
            account2 > balanceAmount.length ||
            balanceAmount[account1 - 1] < money
        ) {
            return false;
        }
        balanceAmount[account1 - 1] -= money;
        balanceAmount[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int acc, long money) {

        if (acc > balanceAmount.length) {
            return false;
        }
        balanceAmount[acc - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balanceAmount.length || balanceAmount[account - 1] < money) {
            return false;
        }
        balanceAmount[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balanceAmount);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */