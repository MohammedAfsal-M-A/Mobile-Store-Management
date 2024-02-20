package model;

public class Transaction {
    private int transaction_Id;
    private int customer_Id;
    private int mobile_Id;

    public Transaction(int transaction_Id,int customer_Id,int mobile_Id)
    {
        this.transaction_Id=transaction_Id;
        this.customer_Id=customer_Id;
        this.mobile_Id=mobile_Id;
    }
    public void setTransactionId(int transaction_Id)
    {
        this.transaction_Id=transaction_Id;
    }
    public int getTransactionId()
    {
        return this.transaction_Id;
    }
    public void setCustomerId(int customer_Id)
    {
        this.customer_Id=customer_Id;
    }
    public int getCustomerId()
    {
        return this.customer_Id;
    }
    public void setMobileId(int mobile_Id)
    {
        this.mobile_Id=mobile_Id;
    }
    public int getMobileId()
    {
        return this.mobile_Id;
    }
}
