package lesson7;

import org.config.BaseTest;
import org.pages.HomePage;
import org.pages.Item;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test
    public void checkHomeItemMatchesDetail() {
        // 1. зібрати товари з Home
        List<Item> homeItems = homePage.getItemsList();

        // 2. обрати перший товар
        Item homeItem = homeItems.get(0);

        // 3. відкрити його деталку за назвою
        homePage.openProductByName(homeItem.getName());

        Item detailItem = productPage.getDetailedItem();
        Assert.assertEquals(detailItem.getName(), homeItem.getName());

        Assert.assertTrue(
                detailItem.getPrice().contains(homeItem.getPrice()),
                "Ціна на деталці має містити ціну з головної. Home: " + homeItem.getPrice()
                        + ", Detail: " + detailItem.getPrice());

    }
}