package org.core.homework.lesson2;

public class Main {
    private static int limit;
    private static long monthSent;
    private static boolean vipClient;

    private static Integer limitAccount;
    private static Long monthTotal;
    private static Boolean vipInclude;

    public static void main(String[] args) {
        int sum = 150;
        long yearSum = 200000000L;
        boolean adult = true;

        Integer sumCounter = 2000;
        Long yearTotal = 23000000000L;
        Boolean access = true;

        System.out.println("sum = " + sum);
        System.out.println("yearSum = " + yearSum);
        System.out.println("adult = " + adult);
        System.out.println("sumCounter = " + sumCounter);
        System.out.println("yearTotal = " + yearTotal);
        System.out.println("access = " + access);

        DataHolder holder = new DataHolder();
        holder.setDepositSize((byte) 15);
        holder.setCode((short) 9);
        holder.setAmountOperation(1000);
        holder.setTotalAmountMonth(2500000000000000000L);
        holder.setTax(1.3f);
        holder.setYearlyInterestRate(4.0);
        holder.setSimbol('C');
        holder.setIsOurClient(true);

        System.out.println("DataHolder.depositSize = " + holder.getDepositSize());
        System.out.println("DataHolder.mccCode = " + holder.getMccCode());
        System.out.println("DataHolder.amountOperation = " + holder.getAmountOperation());
        System.out.println("DataHolder.totalAmountMonth = " + holder.getTotalAmountMonth());
        System.out.println("DataHolder.tax = " + holder.getTax());
        System.out.println("DataHolder.yearlyInterestRate = " + holder.getYearlyInterestRate());
        System.out.println("DataHolder.simbol = " + holder.getSimbol());
        System.out.println("DataHolder.isOurClient = " + holder.getIsOurClient());

        holder.setSize((byte) 2);
        holder.setCode((short) 8);
        holder.setIdForNewLimit(1500);
        holder.setTotal(280000000000000000L);
        holder.setTaxRate(0.6f);
        holder.setYearRate(15.5);
        holder.setHexValue('D');
        holder.setExclude(true);

        System.out.println("DataHolder.size = " + holder.getSize());
        System.out.println("DataHolder.code = " + holder.getCode());
        System.out.println("DataHolder.idForNewLimit = " + holder.getIdForNewLimit());
        System.out.println("DataHolder.total = " + holder.getTotal());
        System.out.println("DataHolder.taxRate = " + holder.getTaxRate());
        System.out.println("DataHolder.yearRate = " + holder.getYearRate());
        System.out.println("DataHolder.hexValue = " + holder.getHexValue());
        System.out.println("DataHolder.exclude = " + holder.getExclude());

        limit = holder.getAmountOperation();
        monthSent = holder.getTotalAmountMonth();
        vipClient = holder.getIsOurClient();

        limitAccount = holder.getIdForNewLimit();
        monthTotal = holder.getTotal();
        vipInclude = holder.getExclude();

        System.out.println("limit = " + limit);
        System.out.println("monthSent = " + monthSent);
        System.out.println("vipClient = " + vipClient);
        System.out.println("limitAccount = " + limitAccount);
        System.out.println("monthTotal = " + monthTotal);
        System.out.println("vipInclude = " + vipInclude);

        wideningImplicitConversion();
        narrowingExplicitConversion();
        autoboxing();
        comparisonWrappers();
        nullTrap(); //последним пойдет иначе после него уже ничего не проверить
    }

    private static void wideningImplicitConversion() {
        byte b = 10;
        int i = b;        // byte → int: 10
        long l = i;       // int → long: 10
        double d = l;     // long → double: 10
    }

    private static void narrowingExplicitConversion() {
        double d = 9.99;
        int i = (int) d;  // 9 — дробная часть отбрасывается i: 9

        long big = 300L;
        byte small = (byte) big;  // переполнение small: 44
    }

    private static void autoboxing() {
        Integer boxed = 100;      // autoboxing: int → Integer
        int unboxed = boxed;      // unboxing:  Integer → int unboxed: 100
    }

    private static void nullTrap() {
        Integer nullable = null;
        int x = nullable;         // ❌ NullPointerException во время выполнения Exception in thread "main" java.lang.NullPointerException:
        // Cannot invoke "java.lang.Integer.intValue()" because "nullable" is null
    }

    private static void comparisonWrappers() {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);        // false (разные объекты) Number objects are compared using '==', not 'equals()'
        System.out.println(a.equals(b));   // true  (сравнение значений) Result of 'a.equals(b)' is always 'true'
    }
}
