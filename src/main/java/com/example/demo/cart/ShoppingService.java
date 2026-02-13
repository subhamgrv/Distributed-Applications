package com.example.demo.cart;

import com.example.demo.products.Currency;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingService {

    private final ProductService productService;
    @Value("${app.voucher.percent}")  private  BigDecimal voucherDiscount;
    @Value("${app.currency.default}") private Currency defaultCurreny;

    @Value("${app.currency.exchange}")  private  BigDecimal currencyExchange;

    private static final Currency BASE_CURRENCY = Currency.EUR;


    private final ShoppingCart shoppingCart ;

        public ShoppingService(ProductService productService){
        this.productService=productService;
        this.shoppingCart = new ShoppingCart();
        this.shoppingCart.setItems(new HashMap<>());

        if(shoppingCart.getCurrency()==null){
            shoppingCart.setCurrency(defaultCurreny);
        }
        }


        public ShoppingCart getCart(){
            return  shoppingCart;
        }

        public void applyVoucher(){
            shoppingCart.setVoucherUsed(true);
            return ;
        }

        public void removeVoucher(){
            shoppingCart.setVoucherUsed(false);
            return ;
        }


        public ShoppingCart addProduct(int id){
            Product p = productService.getById(id);
            Map<Integer,Integer> items = shoppingCart.getItems();
            if(items==null){
                items= new HashMap<>();
                shoppingCart.setItems(items);

            }
            items.put(id,items.getOrDefault(id,0)+1);

       return shoppingCart; }




            public ShoppingCart removeProduct(int id){
                Map<Integer, Integer> items= shoppingCart.getItems();
                int qnty = items.getOrDefault(id,0);
                if(qnty<=1){
                    items.remove(id);
                }else {
                    items.put(id,qnty-1);
                }

            return  shoppingCart;}


        public  Map<Product,Integer> presentCart(){
            Map<Product,Integer> presentCart = new HashMap<>();

            for (Integer id : shoppingCart.getItems().keySet()){
                presentCart.put(productService.getById(id),shoppingCart.getItems().get(id));
            }


        return presentCart;}

    public BigDecimal currencyConversion(BigDecimal amount, Currency fromCurrency, Currency toCurrency){
        if(amount == null) return  BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        if(fromCurrency== null || toCurrency==null) return  amount.setScale(2,RoundingMode.HALF_UP);
        if(fromCurrency==toCurrency) return amount.setScale(2,RoundingMode.HALF_UP);
        if (fromCurrency == Currency.EUR && toCurrency == Currency.USD) {
            return amount.multiply(currencyExchange).setScale(2, RoundingMode.HALF_UP);
        }
        else if (fromCurrency == Currency.USD && toCurrency == Currency.EUR) {
            return amount.divide(currencyExchange, 2, RoundingMode.HALF_UP);
        }

    return amount;}



    public BigDecimal applyPercentage(BigDecimal amount){
        return amount.multiply((BigDecimal.valueOf(100).subtract(voucherDiscount)).divide(BigDecimal.valueOf(100)));
    }



    /**
     *
     * @return the total value after the calucaltion
     */

        public BigDecimal totalValue(){
            BigDecimal cartValue = BigDecimal.ZERO;
                 for(Integer id: shoppingCart.getItems().keySet()){


                    BigDecimal lineTotal = (productService.getById(id).getPrice().multiply(BigDecimal.valueOf(shoppingCart.getItems().get(id))));
                     cartValue=cartValue.add(lineTotal);

                 }


        return currencyConversion(cartValue,BASE_CURRENCY,getactiveCurreny());}

        public BigDecimal discountedPrice(Boolean discount,BigDecimal currentValue){
            if(discount) return applyPercentage(currentValue);
            else return currentValue;
        }


    public BigDecimal getVoucherDiscount() {
        return voucherDiscount;
    }

    public Currency getactiveCurreny() {
            if(shoppingCart.getCurrency()==null){
                shoppingCart.setCurrency(defaultCurreny);
                return shoppingCart.getCurrency();
            }
        return shoppingCart.getCurrency();
    }


    public void setCurrency(Currency currency){
            shoppingCart.setCurrency(currency);
        }







}
