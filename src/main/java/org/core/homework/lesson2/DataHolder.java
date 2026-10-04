package org.core.homework.lesson2;

public class DataHolder {
    private byte depositSize;
    private short mccCode;
    private int amountOperation;
    private long totalAmountMonth;
    private float tax;
    private double yearlyInterestRate;
    private char simbol;
    private boolean isOurClient;

    private Byte size;
    private Short code;
    private Integer idForNewLimit;
    private Long total;
    private Float taxRate;
    private Double yearRate;
    private Character hexValue;
    private Boolean exclude;

    public byte getDepositSize() {
        return depositSize;
    }

    public void setDepositSize(byte depositSize) {
        this.depositSize = depositSize;
    }

    public short getMccCode() {
        return mccCode;
    }

    public void setMccCode(short mccCode) {
        this.mccCode = mccCode;
    }

    public int getAmountOperation() {
        return amountOperation;
    }

    public void setAmountOperation(int amountOperation) {
        this.amountOperation = amountOperation;
    }

    public long getTotalAmountMonth() {
        return totalAmountMonth;
    }

    public void setTotalAmountMonth(long totalAmountMonth) {
        this.totalAmountMonth = totalAmountMonth;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    public boolean getIsOurClient() {
        return isOurClient;
    }

    public void setIsOurClient(boolean isOurClient) {
        this.isOurClient = isOurClient;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public Integer getIdForNewLimit() {
        return idForNewLimit;
    }

    public void setIdForNewLimit(Integer idForNewLimit) {
        this.idForNewLimit = idForNewLimit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Double getYearRate() {
        return yearRate;
    }

    public void setYearRate(Double yearRate) {
        this.yearRate = yearRate;
    }

    public Character getHexValue() {
        return hexValue;
    }

    public void setHexValue(Character hexValue) {
        this.hexValue = hexValue;
    }

    public Boolean getExclude() {
        return exclude;
    }

    public void setExclude(Boolean exclude) {
        this.exclude = exclude;
    }
}
