package com.test.pcf.pcfcheck.lib;

import java.math.BigDecimal;

public class JDBCAccountData {

    private long accountNumber;
    private int productType;
    private BigDecimal availableBalance;

    public long getAccountNumber() { return accountNumber;}

    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber;}

    public int getProductType() {return productType;}

    public void setProductType(int productType) { this.productType = productType;}

    public BigDecimal getAvailableBalance() { return availableBalance;}

    public void setAvailableBalance(BigDecimal availableBalance) { this.availableBalance = availableBalance;}
}
