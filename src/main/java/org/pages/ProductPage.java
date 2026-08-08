package org.pages;

import org.config.PageTools;

public class ProductPage extends PageTools {
    private final String name = "//h2[@class='name']";
    private final String price = "//h3[@class='price-container']";
    private final String description = "//div[@id='more-information']/p";

    public Item getDetailedItem() {
        Item item = new Item();
        item.setName(getText("xpath", name));
        item.setDescription(getText("xpath", description));
        item.setPrice(getText("xpath", price));
        return item;
    }
}
