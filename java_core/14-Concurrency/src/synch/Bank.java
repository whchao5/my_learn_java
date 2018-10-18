package synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[]  accounts;
    private       Lock      banklock;
    private       Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);      // 填充
        banklock = new ReentrantLock();

        sufficientFunds = banklock.newCondition();
    }

    /**
     * 转账
     *
     * @param from   谁
     * @param to     转到 谁
     * @param amount 钱
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {

        banklock.lock();

        try {
            System.out.printf(" from %d account %10.2f -- %10.2f from to %d", from, accounts[from], amount, to);
            //            if (accounts[from] < amount)
            //                return;

            //            if (accounts[from] < amount)
            while (accounts[from] < amount) // 当 from 小于 amount 是，等待
                sufficientFunds.await();

            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {

            banklock.unlock();
        }

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
