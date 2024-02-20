package model;

public class Cart {
    private int cart_Id;
    private int customer_Id;
    private int mobile_Id;

    public Cart(int cart_Id,int customer_Id,int mobile_Id)
    {
        this.cart_Id=cart_Id;
        this.customer_Id=customer_Id;
        this.mobile_Id=mobile_Id;
    }
    public void setCartId(int cart_Id)
    {
        this.cart_Id=cart_Id;
    }
    public int getCartId()
    {
        return this.cart_Id;
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
