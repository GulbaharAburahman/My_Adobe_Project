package frontendtests;

import com.unitedcoder.commonuse.BaseClass;
import com.unitedcoder.commonuse.BrowserType;
import com.unitedcoder.commonuse.FunctionLibrary;
import com.unitedcoder.frontend.PublicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutOrderFunctionalTest extends BaseClass {
PublicPage publicPage;
FunctionLibrary functionLibrary;

    @BeforeClass
    public void setup(){
       launchBrowser(BrowserType.CHROME);
       navigateToPublicPage();
       publicPage=new PublicPage(driver);
       functionLibrary=new FunctionLibrary(driver);
    }

    @Test(description = "A user can checkout his/her order as a guest")
    public void checkoutOrderAsGuest(){
        publicPage.addToCart(true,"excellent home & decor","","TITIAN RAW SILK PILLOW");
        publicPage.checkoutMyOrderWithoutLogin("register",FunctionLibrary.getFakeFirstname(),FunctionLibrary.getFakeLastname(), FunctionLibrary.getFakeEmail(),FunctionLibrary.getPassword(),"8 quay ","Auckland","New Zealand",
                "","0600",FunctionLibrary.getFakeTelNum(),"free shipping","cash on delivery",null);
        Assert.assertTrue(publicPage.isCheckoutOrderSuccessful());
        publicPage.logout();
    }

    @Test(description="A new user checkouts as register")
            public void checkoutMyOrderAndRegister(){
        publicPage.addProductToCart(false,"Excellent Home & Decor","Electronics","Madison RX3400");
        publicPage.goToCheckout();
        publicPage.selectCheckoutMethod("register");
        publicPage.checkoutMyOrderWithoutLogin("register",FunctionLibrary.getFakeFirstname(),FunctionLibrary.getFakeLastname(),
                FunctionLibrary.getFakeEmail(),FunctionLibrary.getPassword(),"8 view Rd","New York","United States","New York",
                "10003",FunctionLibrary.getFakeTelNum(),"flat rate","purchase order","SEDT88668866");
        Assert.assertTrue(publicPage.isCheckoutOrderSuccessful());
        publicPage.logout();
        }



    @Test(description = "A registered user with updated address book can check out order by retrieving info from address book")
    public void checkoutOrderAfterLogin( ) throws InterruptedException {
        publicPage.loginToAccount("timthomas@gmail.com","1234567");
        publicPage.addProductToCart(true,"excellent home & decor",null,"TITIAN RAW SILK PILLOW");
       publicPage.checkOutMyOrderAfterLogin("8 quay ","Auckland","0600",
               FunctionLibrary.getFakeTelNum(),"New Zealand","","free shipping","cash on delivery",null);
       Assert.assertTrue(publicPage.isCheckoutOrderSuccessful());
       publicPage.logout();
    }

    @Test (description = "A registered user who has not updated address book can check out order ")
    public void checkoutOrderAfterNewlyRegister() throws InterruptedException {
      publicPage.createAccount(FunctionLibrary.getFakeFirstname(),FunctionLibrary.getFakeLastname(),FunctionLibrary.getFakeEmail(),FunctionLibrary.getPassword());
      publicPage.addProductToCart(true,"excellent home & decor","Bed & Bath","TITIAN RAW SILK PILLOW");
      publicPage.goToCheckout();
      publicPage.checkOutMyOrderAfterLogin("12 Queen St","Auckland","0600","00648866888","New Zealand","","flat rate","cash on delivery",null);
      Assert.assertTrue(publicPage.isCheckoutOrderSuccessful());
    }



}