package unsynch;

import java.util.Arrays;

public class Bank {

    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);      // 填充
    }

    /**
     * 转账
     * @param from  谁
     * @param to    转到 谁
     * @param amount  钱
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount)
            return;

        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        System.out.println();

    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
