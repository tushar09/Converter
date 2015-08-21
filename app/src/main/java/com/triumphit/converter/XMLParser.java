package com.triumphit.converter;

/**
 * Created by Tushar on 8/22/2015.
 */
public interface XMLParser {

    /*
    * please have a look at "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22USDEUR%22,%20%22USDJPY%22,%20%22USDBGN%22,%20%22USDCZK%22,%20%22USDDKK%22,%20%22USDGBP%22,%20%22USDHUF%22,%20%22USDLTL%22,%20%22USDLVL%22,%20%22USDPLN%22,%20%22USDRON%22,%20%22USDSEK%22,%20%22USDCHF%22,%20%22USDNOK%22,%20%22USDHRK%22,%20%22USDRUB%22,%20%22USDTRY%22,%20%22USDAUD%22,%20%22USDBRL%22,%20%22USDCAD%22,%20%22USDCNY%22,%20%22USDHKD%22,%20%22USDIDR%22,%20%22USDILS%22,%20%22USDINR%22,%20%22USDKRW%22,%20%22USDMXN%22,%20%22USDMYR%22,%20%22USDNZD%22,%20%22USDPHP%22,%20%22USDSGD%22,%20%22USDTHB%22,%20%22USDZAR%22,%20%22USDISK%22%29&env=store://datatables.org/alltableswithkeys"
    * We have to extract data from this xml.
    * Here each block has unique id. EG: USDINR, USDJPY etc.
    * Under every block there are 6 fields.
    * 1. Name
    * 2. Rate
    * 3. Date
    * 4. Time
    * 5. Ask
    * 6. Bid
    * We have to get the values of 6 fields by their block id.
    * */


    /**
     *
     * @param URL address of xml data.
     */
    void setUrl(String URL);

    /**
     * Returns String Array
     * ex:
     * arr[0] = name
     * arr[1] = rate
     * arr[2] = date
     * arr[3] = time
     * arr[4] = ask
     * arr[5] = bid
     * @param id an absolute string of specified block.
     * @return returns the array of strings containing those 6 values.
     */
    String[] getInfo(String id);
}
